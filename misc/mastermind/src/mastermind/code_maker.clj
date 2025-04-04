(ns mastermind.code-maker)

(defn score [guess code]
  "Scores a guess against the secret code"
  (count
    (filter some? (map #(if (= %1 %2) 1) guess code))
    )
  )