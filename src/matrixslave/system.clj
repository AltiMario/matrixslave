(ns matrixslave.system
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [clojure.edn :as edn]
            [matrixslave.core :as core])
  (:gen-class))


(defn start-service!
  "start a server web on a specific port, waiting for JSON connections"
  [config]
  (as-> #'core/service $
        (wrap-json-response $ {:pretty false})
        (wrap-json-body $ {:keywords? true :bigdecimals? true})
        (jetty/run-jetty $ {:port (get-in config [:slave :port]) :join? false})))


(defn -main
  []
  (let [config (edn/read-string (slurp "config/config.edn"))]
    (start-service! config)
    @(promise)))

(comment
  (-main ))
