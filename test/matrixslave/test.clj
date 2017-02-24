(ns matrixslave.test
  (:require [matrixslave.core :as core]
            [matrixslave.util :as ut])
  (:use midje.sweet))

(def m1 [[11 12] [14 15] [16 17]])
(def m2 [[21 22 23] [24 25 26]])

(facts "About array and matrix operations"
       (fact "multiply 2 columns"
             (core/multiply-arrays (first m1) (second m2)) => [264 300]
             (core/multiply-arrays (second m1) (first m2)) => [294 330]
             (core/multiply-arrays m1 nil) => [])
       (fact "sum of row * column"
             (core/calculate-rxc (first m1) (second m2)) => 564
             (core/calculate-rxc (second m1) (first m2)) => 624
             (core/multiply-arrays m1 nil) => []))
