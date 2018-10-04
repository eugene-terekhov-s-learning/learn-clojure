(ns digitize-and-reverse.core-test
  (:require [clojure.test :refer :all]
            [digitize-and-reverse.core :refer :all]))

(deftest basic-tests
  (is (= (digitize 35231) [1 3 2 5 3])))
