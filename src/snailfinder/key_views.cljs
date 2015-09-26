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
            [:div.mdl-cell.mdl-cell--2-col-phone.mdl-typography--text-center
             [:a {:href (str "#/snail-key/" (name (first child)))}
              [:img.img-responsive {:src (str "images/key/" (get-in child [1 :image]))}]
              [:span.button-primary (get-in child [1 :answer])]]]))))


(defn breadcrumbs-component
  [{:keys [path] :as q-data} _]
  (om/component
    (html [:div (into [:div] (interpose [:span " > "] (map (fn [path-key]
                               (let [key-name (name path-key)]
                                 [:a {:href (str "#/snail-key/" key-name)} key-name])) path)))])))


(defn back-component
  [{:keys [path] :as q-data} _]
  (om/component
    (html (if-let [last-path-key (last path)]
            [:a {:href (str "#/snail-key/" (name last-path-key))} "Previous question"]
            [:div]))))


(defn key-question
  [cursor _]
  (om/component
    (html [:div.mdl-grid
           [:div.mdl-cell.mdl-cell--12-col
            [:p.key__question (:question cursor)]]])))


(defn snail-key-view
  [cursor _]
  (om/component
    (let [question (get-in cursor [:current :question])
          q-data (get snail-key-flat question)]
      (html [:div
             (if (= :question (:type q-data))
               [:div
                (om/build back-component q-data)
                (om/build breadcrumbs-component q-data)
                (om/build key-question q-data)
                [:div.mdl-grid (for [answer (:children q-data)]
                                       (om/build key-answer answer))]]
               [:p (:answer q-data)])]))))
