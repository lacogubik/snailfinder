(ns ^:figwheel-always snailfinder.group-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [sablono.core :as html :refer-macros [html]]
           [snailfinder.snail :refer [snails]]
           [snailfinder.key :refer [snail-key-flat]]
           [snailfinder.key-views :refer [snail-key-view]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn group-list-component
  [group cursor _]
  (om/component
    (html
      [:div
       [:a {:href "#/"} "back button"]
       [:h4 "Your snail could be one of these:"]
       (for [snail-id (:endpoints group)]
         [:div.result-list__item
          [:a {:href (str "#/snail/" (name snail-id))}
           [:img {:src (str "images/endpoint/" (get-in snails [snail-id :image]))
                     :alt (str (get-in snails [snail-id :name]))}]
          [:span (str (get-in snails [snail-id :name]))]]])])))


(defn group-view
  [cursor _]
  (om/component
    (html
      [:div.snails-key
       (let [group (snail-key-flat (get-in cursor [:current :question]))]
         (om/build (partial group-list-component group) cursor))])))
