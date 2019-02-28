(ns playground.ledger)

(def events
  [{:account-number 10
    :value 32.4M
    :operation :transfer-in}
   {:account-number 11
    :value 1024.0M
    :operation :transfer-in}
   {:account-number 11
    :value 100.0M
    :operation :transfer-out}])


(defn get-diff-value [{:keys [operation value]}]
  (if (= operation :transfer-in)
    value
    (* -1 value)))

(defn get-balance
  [account-number events]
  (reduce + 0
          (map get-diff-value
               (filter #(= account-number (get % :account-number)) events))))

(defn get-balance-thread [account-number events]
  (->> events
       (filter #(= account-number (:account-number %)))
       (map get-diff-value)
       (reduce + 0)))

(get-balance-thread 11 events)

(defn get-all-account-balances [events]
  (->> events
       (group-by :account-number)
       (map (fn [[num e]] [num (get-balance-thread num e)]))
       (into {})))

(get-all-account-balances events)

(defn new-event
  [{:keys [account-number value operation] :as new-event} events]
  (if (and (= operation :transfer-out)
           (> value (get-balance account-number events)))
    events
    (conj events new-event)))

(new-event {:account-number 10 :value 1000M :operation :transfer-out} events)
