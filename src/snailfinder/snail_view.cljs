(ns ^:figwheel-always snailfinder.snail-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [sablono.core :as html :refer-macros [html]]
           [snailfinder.snail :refer [snails]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn snail-component
  [snail cursor _]
  (om/component
    (html
      [:div
       [:a {:href "#/"} "back button"]
       (print snail)
       [:div " "(:name snail)]
       [:div [:img {:src (str "images/key" (:image snail))
                    :alt (str (:name snail))}]]])))


(defn snail-view
  [cursor _]
  (om/component
    (html
      [:div.snails-key
     (let [snail (snails (get-in cursor [:current :question]))]
       (om/build (partial snail-component snail) cursor))])))
