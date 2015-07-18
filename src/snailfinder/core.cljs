(ns ^:figwheel-always snailfinder.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [snailfinder.data :refer [app-state]]
            [snailfinder.key-views :refer [snail-key-view]]
            [snailfinder.snail-view :refer [snail-view]]
            ))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defn header
  [cursor _]
  (om/component
    (dom/nav #js{:className "navbar navbar-default"}
      (dom/div #js{:className "container-fluid"}
        (dom/div #js{:className "navbar-header"}
          (dom/div #js{:className "navbar-brand"
                       :onClick   #(do
                                    (om/update! cursor [:current :page] :home)
                                    (om/update! cursor [:current :question] :c1))} "Snail Finder"))))))


(defn home-component
  [cursor _]
  (om/component
    (dom/div nil
      (dom/a #js {:onClick #(om/update! cursor [:current :page] :snail-key)} "Find a snail")
      (dom/br nil)
      (dom/a #js{:onClick   #(do
                              (om/update! cursor [:current :page] :snail)
                              (om/update! cursor [:current :question] :ae2))} "Snail Page"))))

(defn main-component
  [cursor _]
  (om/component
    (dom/div
      #js{:className "container"}

      ;(om/component
      (dom/div
        #js{:className "container"}
        (dom/div
          #js{:className "row"}
          (dom/div #js{:className "col-sm-12"}
            (case (get-in cursor [:current :page])
              :home (om/build home-component cursor)
              :snail-key (om/build snail-key-view cursor)
              :snail (om/build snail-view cursor)
              (om/build home-component cursor)))))
      ;)
      )))

(om/root
  (fn [data owner]
    (om/component

      (dom/div nil
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