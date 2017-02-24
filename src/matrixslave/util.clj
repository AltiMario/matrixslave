(ns matrixslave.util)

;;; HTTP HEADER ;;;

(def ctype
  {"Content-type" "application/json"})

(defn ok
  "return the right status number and the body in case of success"
  [d]
  {:headers ctype
   :status  200
   :body    d})

(defn bad-request
  "return the right status number and the body in case of error"
  [d]
  {:headers ctype
   :status  400
   :body    d})

(defn header
  "the output values returned are incapsulates into an header"
  [result]
  (if result
    (ok result)
    (bad-request {:message "No data to display"})))
