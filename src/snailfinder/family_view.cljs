(ns ^:figwheel-always snailfinder.family-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [sablono.core :as html :refer-macros [html]]
           [snailfinder.family :refer [families]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn family-component
  [family cursor _]
  (om/component
    (html
      [:div
       [:a {:href "#/"} "back button"]
       [:div (:name family)]
       [:img {:src (str "images/key/" (first (:images family)))
              :alt (str (:name family))}]
       [:div (str "description: " (:description family))]
       (for [species (:endpoint family)]
         [:li [:img {:src (str "images/key" :image species)
                     :alt (str (:name species))}]])])))


(defn family-view
  [cursor _]
  (om/component
    (html
      [:div.snails-key
       (let [family (families (get-in cursor [:current :question]))]
         (om/build (partial family-component family) cursor))])))
