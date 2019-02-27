(def a 2)
(def incrementa (fn [a] (+ a 1)))
(defn incrementa [a] (+ a 1))

(if (pos? age)
  :verdade
  :falso) ;; :verdade

(let [a 10
      b (+ a 10)]     ;; => b = 20
  (+ (incrementa a)
     (incrementa b))) ;; => 32
