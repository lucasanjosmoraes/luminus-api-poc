(ns luminus-api-poc.env
  (:require
   [selmer.parser :as parser]
   [clojure.tools.logging :as log]
   [luminus-api-poc.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-api-poc started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-api-poc has shut down successfully]=-"))
   :middleware wrap-dev})
