(defn factorial [n]
  (if (= n 0)
    1
    (* n (factorial (dec n)))))

(defn tail-recur [sum cnt]
   (if (= cnt 0)
      sum
      (recur (+ cnt sum) (dec cnt))))
