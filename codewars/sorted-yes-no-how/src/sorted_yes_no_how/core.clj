(ns sorted-yes-no-how.core
  (:gen-class))

(defn analyze-sort-type
  [sq]
  (loop [remaining-numbers sq
         analysis-result []]
    (if (empty? remaining-numbers)
      (reduce + analysis-result)
      (recur (rest remaining-numbers)
        (conj analysis-result 
          (compare (first remaining-numbers) (second remaining-numbers)))))))

        

(defn sorted-and-how? 
  [sq]
  (let [sort-type (analyze-sort-type sq)]
    (println (format "Sort-type: %d, num count: %d" sort-type (count sq)))
    (if (= sort-type (count sq))
      "yes, ascending"
      (if (= sort-type (* (count sq) -1))
        "yes, descending"
        "no"))))
  
