(ns luminus-api-poc.db.core-test
  (:require
   [luminus-api-poc.db.core :refer [*db*] :as db]
   [java-time.pre-java8]
   [luminus-migrations.core :as migrations]
   [clojure.test :refer :all]
   [next.jdbc :as jdbc]
   [luminus-api-poc.config :refer [env]]
   [mount.core :as mount])
  (:import (java.time LocalDateTime)))

(use-fixtures
  :once
  (fn [f]
    (mount/start
      #'luminus-api-poc.config/env
      #'luminus-api-poc.db.core/*db*)
    (migrations/migrate ["migrate"] (select-keys env [:database-url]))
    (migrations/migrate ["reset"] (select-keys env [:database-url]))
    (f)))

(deftest test-message
  (jdbc/with-transaction [t-conn *db*]
    (let [timestamp (LocalDateTime/now)]
      (is (= 1 (db/save-message!
                 t-conn
                 {:name      "Bob"
                  :message   "Hello, World"
                  :timestamp timestamp}
                 {:connection t-conn})))
      (is (=
            {:name      "Bob"
             :message   "Hello, World"
             :timestamp timestamp}
            (-> (db/get-messages t-conn {})
              (first)
              (select-keys [:name :message :timestamp])))))))
