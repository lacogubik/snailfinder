(ns ^:figwheel-always snailfinder.core
    (:require[om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

;; Example interaction
;; (dom/button #js {:onClick #(js/alert "hello") } "Snail Key"))

(defonce app-state (atom {:snails ["Columella aspera", "Columella edentula"]}))

(defn main-component
  [cursor _]
    (om/component
      (dom/div nil
        (dom/button #js {:onClick #(js/alert "hello") } "Snail Key"))))

(om/root
  (fn [data owner]
    (om/component
      (om/build main-component nil)))
  app-state
  {:target (. js/document (getElementById "app"))})


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)