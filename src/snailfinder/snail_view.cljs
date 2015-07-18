(ns ^:figwheel-always snailfinder.snail-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [snailfinder.key :refer [snail-key-flat]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn snail-component
  [snail cursor _]
  (om/component
    (dom/div nil
      (dom/div nil "back button")
      (dom/div nil "title")
      (dom/div nil "image")
      (println "snail:" snail)
      (dom/div nil (str "description:" (:answer snail))))))


(defn snail-view
  [cursor _]
  (om/component
    (dom/div #js {:className "snails-key"}
      (let [snail (snail-key-flat (get-in cursor [:current :question]))]
        (om/build (partial snail-component snail) cursor)))))
