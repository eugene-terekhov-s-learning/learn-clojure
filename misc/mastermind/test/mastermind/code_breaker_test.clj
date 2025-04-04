(ns mastermind.code-breaker-test
  (:use midje.sweet)
  (:require [mastermind.code-breaker :refer :all]))

(facts "Code breaker"
       (fact "Initial guess"
             (break-code []) => [0 0 0 0]))