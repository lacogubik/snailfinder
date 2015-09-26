(ns ^:figwheel-always snailfinder.snail-view
  (:require [clojure.string :refer [capitalize replace]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [snailfinder.snail :refer [snails]]
            [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)

(defn format-key
  [key]
  (->
    (replace (str key) ":" "")
    (replace "-" " ")
    (capitalize)))

(defn snail-component
  [snail cursor _]
  (om/component
    (html
      [:div
       [:a {:href "#/"} "back button"]
       [:h3 (:common-name snail)]
       [:div
        [:img.img-responsive {:src (str "images/endpoint/" (:image snail))
                              :alt (str (:common-name snail))}]]
       (for [description-item (dissoc snail :common-name :image :map-image :notes)]
         ^{:key (key description-item)}
         [:div
          [:span.snail-detail-title (format-key (str (key description-item)))]
          [:p ((key description-item) snail)]])])))


(defn snail-view
  [cursor _]
  (om/component
    (html
      [:div.snails-key
       (let [snail (snails (get-in cursor [:current :question]))]
         (om/build (partial snail-component snail) cursor))])))
