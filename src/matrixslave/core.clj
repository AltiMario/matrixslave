(ns matrixslave.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [matrixslave.util :as ut]
            [ring.util.response :refer [response redirect content-type]]))


(defn multiply-arrays
  "function to multiply 2 arrays"
  [coll1 coll2]
  (into [] (map * coll1 coll2)))


(defn calculate-rxc
  "sum of row * column"
  [row column]
  (reduce + (multiply-arrays row column)))


(defn elaborate-request
  "elaborate the request and return the values as JSON response"
  [request]
  (ut/header
    (let [row (get-in request [:body :row])
          column (get-in request [:body :column])]

      ;to simulate an elaboration latency I can increase the random number (it's in millisecond)
      (Thread/sleep (+ 500 (rand-int 5000)))

      {:result (calculate-rxc row column)})))

(defroutes service
           (context "/v1/slave" []
             (GET "/health-check" [] (ut/header {:message "I'm live"}))
             (POST "/elaborate" [] elaborate-request))
           (route/not-found (ut/bad-request {:message "Service not found"})))
