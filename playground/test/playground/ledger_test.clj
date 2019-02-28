(ns playground.ledger-test
  (:require [clojure.test :refer :all]
            [playground.ledger :as ledger]))

(deftest get-balance-test
  (testing "Should get balance of an account"
    (is (= (ledger/get-balance 10 ledger/events) 32.4M))))

(deftest get-account-balances
  (testing "Should get all account balances"
    (is (= (ledger/get-all-account-balances ledger/events) {10 32.4M 11 924M}))))

(deftest new-event-test
  (testing "Should return events when new-event is invalid"
    (is (= (ledger/new-event {:account-number 10 :value 1000M :operation :transfer-out} ledger/events)
           ledger/events)))

  (testing "Should return new event lsit when new-event is valid"
    (is (= (ledger/new-event {:account-number 11 :value 900M :operation :transfer-out} ledger/events)
           (conj ledger/events {:account-number 11 :value 900M :operation :transfer-out})))))