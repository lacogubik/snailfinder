(ns snailfinder.core-test
  (:require [cljs.test :refer-macros [deftest testing is run-tests]]))


(deftest test-test
  (is (= 1 2)))

(defn ^:export run []
  (.log js/console "Example test started.")
  (run-tests))
