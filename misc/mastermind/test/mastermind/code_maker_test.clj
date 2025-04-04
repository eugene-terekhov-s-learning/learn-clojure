(ns mastermind.code-maker-test
  (:use midje.sweet)
  (:require [mastermind.code-maker :refer :all]))

(facts "Code maker"
       (fact "Score guess with no matches"
             (score [0 0 0 0] [1 1 1 1]) => 0)
       (fact "Score guess with one correct digit"
             (score [0 0 0 0] [0 1 1 1]) => 1)
       (fact "Score guess with two correct digits"
             (score [0 0 0 0] [0 0 1 1]) => 2)
)