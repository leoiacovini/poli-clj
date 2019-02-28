(ns playground.core
  (:require [clojure.pprint :as pprint]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

#_(loop [a 10]
    (println a)
    (if (> a 0)
      (recur (dec a))
      (println "DONE")))


(def account1 "12345")

(def account2 "67890")

(def transactions [{:amount  100M
                    :account account1}
                   {:amount  -30M
                    :account account1}
                   {:amount  80M
                    :account account1}
                   {:amount  100M
                    :account account2}
                   {:amount  -120M
                    :account account2}])

#_(pprint/pprint (filter #(= account1 (:account %)) transactions))

(def state-machine1
  {:initial-state :a
   :accept-states #{:d}
   :transitions   {:a {"0" :b
                       "1" :c}
                   :b {"0" :c}
                   :c {"0" :c
                       "1" :d}
                   :d {}}})

(def sequence1 ["0" "0" "1"])

(defn next-state [{:keys [transitions]} current-state input]
  (get-in transitions [current-state input]))

(defn accept? [state-mach sequence]
  (->> (reduce (partial next-state state-mach) (:initial-state state-mach) sequence)
       (contains? (:accept-states state-mach))))





