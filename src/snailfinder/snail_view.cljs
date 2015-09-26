(ns ^:figwheel-always snailfinder.snail-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [sablono.core :as html :refer-macros [html]]
           [snailfinder.key :refer [snail-key-flat]]
           [snailfinder.snail :refer [snails]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn snail-component
  [snail cursor _]
  (om/component
    (html
      [:div
       [:div "back button"]
       [:div "key snail name: " (:answer snail)]
       [:div "key snail image: " (:image snail)]]
      )
;    (dom/div nil
;      (dom/div nil "back button")
;
;            (dom/div nil "mock snail name: " (:name snail))
;      (dom/div nil "key snail name: " (:answer snail))
;            (dom/div nil "image")
;;      (dom/div nil (:image snail))
;      (println "snail:" snail))

    ))


(defn snail-view
  [cursor _]
  (om/component
    (dom/div #js {:className "snails-key"}
      (let [snail (snails (get-in cursor [:current :question]))]
        (om/build (partial snail-component snail) cursor)))))
