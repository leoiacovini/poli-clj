(defn f [a] (+ a 1)))
(defn g [a] (* a 2))
(def fg (comp f g)) ;; => (fg a) === (f (g a))
(fg 10) ;; => 21
