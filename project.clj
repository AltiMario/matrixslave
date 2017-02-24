(defproject matrixslave "1.0"
  :description "matrixslave"
  :main matrixslave.system
  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.4.0"]
                 [com.taoensso/timbre "4.1.4"]
                 [clj-http "3.3.0"]]
  :profiles {:uberjar {:aot :all :uberjar-name "matrixslave.jar"}
             :dev     {:dependencies [[midje "1.8.3"]]
                       :plugins      [[lein-midje "3.2"]]}})
