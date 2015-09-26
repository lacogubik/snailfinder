(ns snailfinder.data
  (:require [om.core :as om :include-macros true]))

(def app-state (atom {:current {:page     :home
                                    :question :c1}}))

(defn app-state-cursor
  []
  (om/ref-cursor (om/root-cursor app-state)))