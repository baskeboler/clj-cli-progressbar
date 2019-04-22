(ns clj-cli-progress.core-test
  (:require [clojure.test :refer :all]
            [clj-cli-progress.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1)))
  (testing "wrapped collection"
    (let [col (range 10000)
          w (progress-bar-wrapped-collection col "mytask")]
      (doseq [a w]
        (inc a))
      (is true)))
  (testing "reducttion"
    (let [col (repeat 10000 1)
          w (progress-bar-wrapped-collection col "ones")
          res (reduce + 0 w)]
      (is (= res 10000)))))
