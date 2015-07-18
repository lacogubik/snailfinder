(ns ^:figwheel-always snailfinder.family-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [snailfinder.key :refer [snail-key-flat]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)

(defn key-answer
  [child _]
  (println "child" child)
  (om/component
    (dom/button #js {:type "button"
                     :className "btn btn-default snails-key__answer"
                     :onClick #(om/update!  (app-state-cursor) [:current :question] (first child))} (get-in child [1 :answer]))))


(defn family-component
  [family cursor _]
  (om/component
    (dom/div nil
      (dom/div nil "back button")
      (dom/div nil "title")
        (apply dom/div nil (map #(dom/li nil %) (:images family)) )
      (println "snail:" family)
      (dom/div nil (str "description:" (:answer family))))))


(defn family-view
  [cursor _]
  (om/component
    (dom/div #js {:className "snails-key"}
      (let [family (snail-key (get-in cursor [:current :question]))]
        (om/build (partial family-component family) cursor)))))
