(ns ^:figwheel-always snailfinder.family-view
  (:require[om.core :as om :include-macros true]
           [om.dom :as dom :include-macros true]
           [snailfinder.family :refer [families]]
           [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)


(defn family-component
  [family cursor _]
  (om/component
    (dom/div nil
      (dom/div nil "back button")
      (dom/div nil (:name family))
      (apply dom/div nil (map #(dom/li nil %) (:images family)) )
      (println "snail: " family)
      (dom/div nil (str "description: " (:description family))))))


(defn family-view
  [cursor _]
  (om/component
    (dom/div #js {:className "snails-key"}
      (let [family (families (get-in cursor [:current :question]))]
        (om/build (partial family-component family) cursor)))))
