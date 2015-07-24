(ns ^:figwheel-always snailfinder.key-views
  (:require [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)

(defn key-answer
  [child _]
  (om/component
    (html (if (= :separator (:type child))
            [:div.col-sm-10.col-sm-offset-1.col-md-1
             [:p.text-center
              [:strong (:text child)]]]
            [:div.col-sm-10.col-sm-offset-1.col-md-4.col-md-offset-1
             [:a.img-thumbnail {:on-click #(om/update! (app-state-cursor) [:current :question] (first child))}
              [:img.img-responsive {:src (str "images/key/" (get-in child [1 :image]))}]
              [:h4.text-center (get-in child [1 :answer])]]]))))


(defn key-question
  [cursor _]
  (om/component
    (html [:div.row
           [:div.col-sm-12
            [:h4 (:question cursor)]]])))


(defn snail-key-view
  [cursor _]
  (om/component
    (let [question (get-in cursor [:current :question])
          q-data (get snail-key-flat question)]
      (html [:div.row
             (if (= :question (:type q-data))
               [:div
                (om/build key-question q-data)
                [:div.row (for [answer (interpose {:type :separator :text "OR"} (:children q-data))]
                                       (om/build key-answer answer))]]
               [:p (:answer q-data)])]))))
