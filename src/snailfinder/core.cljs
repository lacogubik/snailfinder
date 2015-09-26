(ns ^:figwheel-always snailfinder.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [snailfinder.data :refer [app-state]]
            [snailfinder.key-views :refer [snail-key-view]]
            [snailfinder.snail-view :refer [snail-view]]
            [snailfinder.snails :refer [snails-component]]
            [snailfinder.family-view :refer [family-view]]
            [snailfinder.map :refer [map-view]]
            [snailfinder.routes :as routes]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defn header
  [cursor _]
  (om/component
    (html
      [:header.snail-finder__header
        [:a {:href "/#"}
        [:img.snail-finder__logo {:src "/images/logo-snail-finder.v1.png"}]]]
      )
  ))

(defn home-component
  [cursor _]
  (om/component
    (dom/div #js {:className ""}
      (dom/div #js {:className ""}
        ;(dom/h2 nil "Find your snail")

        (html
          [:div.mdl-grid.home-grid
          [:div.mdl-cell.mdl-cell--2-col.home-grid__panel.home__snail-key
           [:a {:href      "#/snail-key/c1"
                    :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"} "I found a snail! What is it?"]]

          [:div.mdl-cell.mdl-cell--2-col.home-grid__panel.home__snail-map
          [:a {:href "#/map"
               :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"} "Snail Map"]]

          [:div.mdl-cell.mdl-cell--2-col.home-grid__panel.home__snails-list
            [:a {:href "#/snails"
                 :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"} "All Snails"]]

          [:div.mdl-cell.mdl-cell--2-col.home-grid__panel.home__snail-families
            [:a {:href "#/family/ce9"
                 :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"} "Family page"]]


           [:a {:href "#/family/ce9"
                :className "home-grid__roundel mdl-button mdl-js-button mdl-button--raised mdl-button--colored"} "Snail page"]

          ])
        ))))


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
            :family (om/build family-view cursor)
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