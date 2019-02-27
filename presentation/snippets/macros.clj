(->> [1 2 3]
     (map inc)
     (filter even?)) ;; => (filter even? (map inc [1 2 3]))
