(ns snailfinder.snails
  (:require [clojure.string :refer [lower-case]]
            [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [snailfinder.snail :refer [snails]]
            [sablono.core :as html :refer-macros [html]]))


(defn subsumes [main sub]
  (some
    (partial = (seq sub))
    (partition (count sub) 1 main)))


(defn snails-component
  [app owner]
  (reify
    om/IWillMount
    (will-mount [this]
      (om/update! app [:snails :query] nil))
    om/IRender
    (render [this]
      (html (let [query (get-in app [:snails :query])
                  result (filter (fn [[key value]]
                                   (or (= query nil)
                                       (= query "")
                                       (subsumes (lower-case (:name value)) (lower-case query)))) snails)]
              [:div [:h1 "Snails"]
               [:div "Search: " [:input {:value     (get-in app [:snails :query])
                                         :on-change (fn [e]
                                                      (om/update! app [:snails :query] (.. e -target -value)))}]]
               (into [:div] (map (fn [[key snail]]
                                   [:div (str (:name snail))]) result))])))))