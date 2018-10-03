(ns sorted-yes-no-how.core-test
  (:require [clojure.test :refer :all]
            [sorted-yes-no-how.core :refer :all])
  (use [sorted-yes-no-how.core :rename {sorted-and-how? solution}]))

(deftest sample-tests
  (are [inp exp] (= exp (solution inp))
       [1 2] "yes, ascending"
       [15 7 3 -8] "yes, descending"
       [4 2 30] "no"))
