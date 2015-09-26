(ns ^:figwheel-always snailfinder.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [snailfinder.data :refer [app-state]]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.key-views :refer [snail-key-view]]
            [snailfinder.snail-view :refer [snail-view]]
            [snailfinder.snails :refer [snails-component]]
            [snailfinder.group-view :refer [group-view]]
            [snailfinder.map :refer [map-view]]
            [snailfinder.routes :as routes]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defn header
  [cursor _]
  (om/component
    (dom/header #js{:className "mdl-layout__header"}
      (dom/div #js{:className "mdl-layout__drawer-button"}
        (dom/i #js{:className "material-icons"} "menu"))
      (dom/div #js{:className "mdl-layout__header-row"}
        (dom/a #js{:className "mdl-layout-title"
                   :href      "#/"} "Snail Finder")))))


(defn home-component
  [cursor _]
  (om/component
    (html
      [:div.mdl-grid
       [:div.mdl-cell.mdl-cell--12-col
        [:h2 "Find your snail"]
        [:a.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored
         {:href "#/snail-key/c1"} "Let's get started!"]
        [:br]
        [:a.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored
         {:href "#/snail/s1"
             :on-click #(do
                          (om/update! cursor [:current :page] :snail)
                          (om/update! cursor [:current :answer] :s1))} "Snail Page"]
        [:br]
        [:a.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored 
         {:href "#/group/ce8"
             :on-click #(do
                          (om/update! cursor [:current :page] :group)
                          (om/update! cursor [:current :answer] :ce8))} "Group Page"]
      [:br]
      [:a.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored
       {:href "#/snails"} "Snails"]
      [:br]
      [:a.mdl-button.mdl-js-button.mdl-button--raised.mdl-button--colored
       {:href "#/map"} "Map"]]]
      )))


(defn about-component
  [cursor owner]
  (om/component
    (html [:div [:h1 "About"]])))


(defn main-component
  [cursor _]
  (reify
    om/IRender
    (render [this]
      (dom/div
      #js{:className "mdl-layout__content"}
      (dom/div #js{:className ""}
        (dom/div #js{:className ""}
          (case (get-in cursor [:current :page])
            :about (om/build about-component cursor)
            :home (om/build home-component cursor)
            :snail-key (om/build snail-key-view cursor)
            :snail (om/build snail-view cursor)
            :snails (om/build snails-component cursor)
            :group (om/build group-view cursor)
            :map (om/build map-view cursor)
            (om/build home-component cursor))))))))

(om/root
  (fn [data owner]
    (om/component
      (dom/div #js{:className "mdl-layout mdl-js-layout mdl-layout--fixed-header"}
        (om/build header data)
        (om/build main-component data)
        )))
  app-state
  {:target (. js/document (getElementById "app"))})


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )