(ns sorted-yes-no-how.core-test
  (:require [clojure.test :refer :all]
            [sorted-yes-no-how.core :refer :all])
  (use [sorted-yes-no-how.core :rename {sorted-and-how? solution}]))

(declare rand-input
  rand-int-array
  rand-sample
  master-solution)

(deftest basic-tests
  (are [inp exp] (= exp (solution inp))
       [1 2] "yes, ascending"
       [15 7 3 -8] "yes, descending"
       [4 2 30] "no"))

(deftest random-tests
  (let [rand-test-count 32]
       (dotimes [_n rand-test-count]
                (let [input    (rand-input)
                      actual   (solution input)
                      expected (master-solution input)]
                     (do (println "Input: " input)
                         (println (str "Expected: \"" expected "\""))
                         (println (str "Actual:   \"" actual "\""))
                         (is (= actual expected)))))))

(defn- rand-input []
  (let [ary (rand-int-array)]
       (if (= 1 (count (distinct ary))) (rand-input)
           (let [mutate (rand-sample [identity sort (comp reverse sort)])]
                (mutate ary)))))

(defn- rand-int-array []
  (let [max-cnt 16
        max-val 255
        cnt     (max 2 (rand-int (inc max-cnt)))]
       (->> (repeatedly #(rand-int (inc max-val)))
            (take cnt))))

(defn- rand-sample [sq]
  (let [idx (rand-int (count sq))]
       (nth sq idx)))

(defn- master-solution [sq]
  (let [pairs (partition 2 1 sq)]
       (cond (every? (fn [[x y]] (> x y)) pairs) "yes, descending"
             (every? (fn [[x y]] (< x y)) pairs) "yes, ascending"
             :else "no")))
