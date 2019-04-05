(defproject matrixslave "1.0"
  :description "matrixslave"
  :main matrixslave.system
  :dependencies [[org.clojure/clojure "1.10.0" :scope "provided"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.1"]
                 [com.taoensso/timbre "4.10.0"]
                 [clj-http "3.9.1"]]
  :profiles {:uberjar {:aot :all :uberjar-name "matrixslave.jar"}
             :dev     {:dependencies [[midje "1.9.7"]]
                       :plugins      [[lein-midje "3.2.1"]]}})
