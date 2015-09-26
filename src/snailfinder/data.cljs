(ns snailfinder.data
  (:require [om.core :as om :include-macros true]))

(def app-state (atom {:current {:page     :home
                                :question :c1}
                      :snails  {:query nil}}))


(defn app-state-cursor
  []
  (om/ref-cursor (om/root-cursor app-state)))