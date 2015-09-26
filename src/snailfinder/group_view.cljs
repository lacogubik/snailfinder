(ns ^:figwheel-always snailfinder.group-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [sablono.core :as html :refer-macros [html]]
           [snailfinder.group :refer [groups]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn group-list-component
  [group cursor _]
  (om/component
    (html
      [:div
       [:a {:href "#/"} "back button"]
       [:div (:name group)]
       [:img {:src (str "images/endpoint/" (first (:images group)))
              :alt (str (:name group))}]
       [:div (str "description: " (:description group))]
       (for [species (:endpoint group)]
         [:li [:img {:src (str "images/endpoint/" :image species)
                     :alt (str (:name species))}]])])))


(defn group-view
  [cursor _]
  (om/component
    (html
      [:div.snails-key
       (let [group (groups (get-in cursor [:current :question]))]
         (om/build (partial group-list-component group) cursor))])))
