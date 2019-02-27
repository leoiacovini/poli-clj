(defn all-bills [account as-of db http rollout routes]
  (let [[latest & historical] (latest+historical-bills account as-of db http)
        open-bill             (open-bill-w-cache account as-of db http)
        future-bills          (->> (future-bills account as-of db http)
                                   :bills
                                   (time/sort-latest-first :bill/due-date))
        card-interests        (c-acc/all-card-interests (:account/id account) http)
        future+open           (conj (vec future-bills) (:bill open-bill))
        future+open-wire      (mapv #(a-bill/bill->full-preview-wire % account card-interests routes) future+open)
        historical-wire       (mapv #(a-bill/bill->full-preview-wire % account card-interests routes) historical)]
    (if latest
      (let [financing-info (http/financing-info latest account http)
            latest-wire    (a-bill/latest-bill->full-preview-wire latest account card-interests financing-info (:line-items open-bill) routes)]
        (into (conj future+open-wire latest-wire) historical-wire))
      (into future+open-wire historical-wire))))
