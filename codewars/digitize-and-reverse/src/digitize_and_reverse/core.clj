(ns digitize-and-reverse.core
  (:gen-class))

(defn digitize [n]
  (loop [rem n
         reverse-digits []]
    (if (<= rem 9)
      (into reverse-digits [rem])
      (recur (quot rem 10) (into reverse-digits [(mod rem 10)])))))
    
(defn better-digitize [n]
  (->> n
       str
       reverse
       (map #(Character/digit % 10))))

