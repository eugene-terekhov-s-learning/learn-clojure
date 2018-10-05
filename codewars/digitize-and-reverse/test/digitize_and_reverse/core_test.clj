(ns digitize-and-reverse.core-test
  (:require [clojure.test :refer :all]
            [digitize-and-reverse.core :refer :all]))

(defn- digitize-solution [n]
  (->> n
       str
       reverse
       (map #(Character/digit % 10))))
       
(deftest basic-tests
  (is (= (digitize 35231) [1 3 2 5 3]))
  (is (= (digitize 23582357) [7,5,3,2,8,5,3,2]))
  (is (= (digitize 984764738) [8,3,7,4,6,7,4,8,9]))
  (is (= (digitize 45762893920) [0,2,9,3,9,8,2,6,7,5,4]))
  (is (= (digitize 548702838394) [4,9,3,8,3,8,2,0,7,8,4,5])))
  
(deftest random-tests
  (dotimes [_ 20]
    (let [n (rand-int Integer/MAX_VALUE)]
      (is (= (digitize n) (digitize-solution n))))))
