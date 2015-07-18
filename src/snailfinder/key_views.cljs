(ns ^:figwheel-always snailfinder.key-views
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
                         :onClick #(om/update!  (app-state-cursor) [:current :question] (first child))}
                    (dom/img #js {:className "key-figure" :src (str "images/key/" (get-in child [1 :image])) })
                    (dom/span nil (get-in child [1 :answer])))))

(defn key-question
      [cursor _]
      (om/component
        (dom/div #js {:className "snails-key__question"}
          (dom/p nil (:question cursor))
                 )))

(defn snail-key-view
  [cursor _]
    (om/component
      (let [question (get-in cursor [:current :question])
            q-data (get snail-key-flat question)
            ]
           (if (= :answer (:type q-data))
             (dom/p nil (:answer q-data))
             (dom/div #js {:className "snails-key"}
               (om/build key-question q-data)
                      (apply dom/div nil
                      (om/build-all key-answer (:children q-data))))))))