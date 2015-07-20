(ns ^:figwheel-always snailfinder.key-views
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]))

(enable-console-print!)

(defn key-answer
  [child _]
  (om/component
    (dom/div #js{:className "col-sm-12 col-md-6"}
             (dom/a #js {:className "img-thumbnail"
                         :onClick   #(om/update! (app-state-cursor) [:current :question] (first child))}
                    (dom/img #js {:className "img-responsive"
                                  :src       (str "images/key/" (get-in child [1 :image]))})
                    (dom/h4 #js{:className "text-center"}
                            (get-in child [1 :answer]))))))

(defn key-question
  [cursor _]
  (om/component
    (dom/div #js{:className "row"}
             (dom/div #js {:className "col-sm-12"}
                      (dom/h4 nil (:question cursor))))))


(defn snail-key-view
  [cursor _]
  (om/component
    (let [question (get-in cursor [:current :question])
          q-data (get snail-key-flat question)]
      (dom/div #js{:className "row"}
               (if (= :question (:type q-data))
                 (dom/div nil
                          (om/build key-question q-data)
                          (apply dom/div #js{:className "row"}
                                 (om/build-all key-answer (:children q-data))))
                 (dom/p nil (:answer q-data)))))))
