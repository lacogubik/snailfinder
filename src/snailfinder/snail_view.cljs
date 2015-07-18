(ns ^:figwheel-always snailfinder.snail-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [snailfinder.key :refer [snail-key-flat]]
           [snailfinder.snail :refer [snails]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn snail-component
  [snail cursor _]
  (om/component
    (dom/div nil
      (dom/div nil "back button")
      (dom/div nil (:name snail))
      (dom/div nil "image")
      (println "snail:" snail))))


(defn snail-view
  [cursor _]
  (om/component
    (dom/div #js {:className "snails-key"}
      (let [snail (snails (get-in cursor [:current :question]))]
        (om/build (partial snail-component snail) cursor)))))
