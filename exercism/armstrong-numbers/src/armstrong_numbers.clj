(ns armstrong-numbers)

(defn power
  "Calculates power of a given number"
  [num power]
  (reduce * (take power (repeat num))))
  

(defn armstrong
  "Calculates armstrong number"
  [num]
  (let [num-as-string (str num)
        count (count num-as-string)]
    (reduce +
      (map #(power % count) 
        (map #(Integer/parseInt %) (map str (seq num-as-string)))))))
    
  

(defn armstrong? [num]
  (let [count 1]
    (=
       num
       (armstrong num))))
    
  
