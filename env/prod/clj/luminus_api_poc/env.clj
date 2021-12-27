(ns luminus-api-poc.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-api-poc started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-api-poc has shut down successfully]=-"))
   :middleware identity})
