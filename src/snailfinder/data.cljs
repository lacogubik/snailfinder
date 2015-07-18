(ns snailfinder.data
  (:require [om.core :as om :include-macros true]))

(defonce app-state (atom {:current {:page     :home
                                    :question :c1}}))

(defn app-state-cursor
  []
  (om/root-cursor app-state))