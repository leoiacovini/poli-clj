(loop [value 0]
  (if (< value 10)
    (recur (inc value))
    (println "Done")))