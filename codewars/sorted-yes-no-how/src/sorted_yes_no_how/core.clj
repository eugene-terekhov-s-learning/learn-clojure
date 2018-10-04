(ns sorted-yes-no-how.core
  (:gen-class))

(defn sorted-and-how? 
  [sq]
  (let [initial-number-array (seq sq)]
    (if (= (count (set sq)) (count sq))
      (if (= (sort sq) initial-number-array)
        "yes, ascending"
        (if (= (sort-by - sq) initial-number-array)
          "yes, descending"
          "no"))
      "no")))

(defn better-sorted-and-how?
  [sq]
  (cond
    (apply < sq) "yes, ascending"
    (apply > sq) "yes, descending"
    :else "no"))
  
