(ns user
  "Userspace functions you can run by default in your local REPL."
  (:require
   [luminus-api-poc.config :refer [env]]
   [clojure.pprint]
   [clojure.spec.alpha :as s]
   [expound.alpha :as expound]
   [mount.core :as mount]
   [luminus-api-poc.core :refer [start-app]]
   [luminus-api-poc.db.core]
   [conman.core :as conman]
   [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(add-tap (bound-fn* clojure.pprint/pprint))

(defn start
  "Starts application.
  You'll usually want to run this on startup."
  []
  (mount/start-without #'luminus-api-poc.core/repl-server))

(defn stop
  "Stops application."
  []
  (mount/stop-except #'luminus-api-poc.core/repl-server))

(defn restart
  "Restarts application."
  []
  (stop)
  (start))

(defn restart-db
  "Restarts database."
  []
  (mount/stop #'luminus-api-poc.db.core/*db*)
  (mount/start #'luminus-api-poc.db.core/*db*)
  (binding [*ns* (the-ns 'luminus-api-poc.db.core)]
    (conman/bind-connection luminus-api-poc.db.core/*db* "sql/queries.sql")))

(defn reset-db
  "Resets database."
  []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate
  "Migrates database up for all outstanding migrations."
  []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback
  "Rollback latest database migration."
  []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration
  "Create a new up and down migration file with a generated timestamp and `name`."
  [name]
  (migrations/create name (select-keys env [:database-url])))


