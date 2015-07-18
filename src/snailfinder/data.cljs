(ns snailfinder.data
  (:require [om.core :as om :include-macros true]))

(defonce app-state (atom {:current {
                                    :page :home
                                    }}))

(defn app-state-cursor
      []
      (om/ref-cursor (om/root-cursor app-state)))