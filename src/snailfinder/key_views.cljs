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
            [:div.mdl-cell.mdl-cell--5-col
             [:p.text-center
              [:strong (:text child)]]]
            [:div.mdl-cell.mdl-cell--5-col.mdl-typography--text-center
             [:a {:on-click #(om/update! (app-state-cursor) [:current :question] (first child))}
              [:img.img-responsive {:src (str "images/key/" (get-in child [1 :image]))}]
              [:button.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored (get-in child [1 :answer])]]]))))


(defn key-question
  [cursor _]
  (om/component
    (html [:div.mdl-grid
           [:div.mdl-cell.mdl-cell--12-col
            [:h4 (:question cursor)]]])))


(defn snail-key-view
  [cursor _]
  (om/component
    (let [question (get-in cursor [:current :question])
          q-data (get snail-key-flat question)]
      (html [:div
             (if (= :question (:type q-data))
               [:div
                (om/build key-question q-data)
                [:div.mdl-grid (for [answer (:children q-data)]
                                       (om/build key-answer answer))]]
               [:p (:answer q-data)])]))))
