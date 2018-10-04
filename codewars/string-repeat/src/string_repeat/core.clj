(ns string-repeat.core
  (:gen-class))

(defn repeat-str [n strng]
  (reduce #(format "%s%s" %1 %2) (repeat n strng)))

(defn better-repeat-str [n strng]
  (apply str (repeat n strng)))
