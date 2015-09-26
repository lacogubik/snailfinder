(ns snailfinder.snails
  (:require [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [snailfinder.snail :refer [snails]]
            [sablono.core :as html :refer-macros [html]]))


(defn snails-component
  [_ owner]
  (om/component
    (html (let []
            [:div [:h1 "Snails"]
             [:div "Search: " [:input {}]]
             (into [:div] (map (fn [[key snail]]
                                 [:div (str (:name snail))]) snails))]))))