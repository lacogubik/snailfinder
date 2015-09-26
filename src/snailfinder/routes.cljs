(ns snailfinder.routes
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [secretary.core :as secretary :refer-macros [defroute]]
            [snailfinder.data :as data])
  (:import goog.History))


(secretary/set-config! :prefix "#")


(defn set-current-page!
  [page]
  (om/update! (data/app-state-cursor) [:current :page] page))

(defn set-current-question!
  [question]
  (om/update! (data/app-state-cursor) [:current :question] question))


(defroute home-path "/" [] (set-current-page! :home))


(defroute snail-key-default-path "/snail-key" []
  (set-current-page! :snail-key))


(defroute snail-key-path "/snail-key/:key" [key]
  (set-current-page! :snail-key)
  (set-current-question! (keyword key)))


(defroute snail-path "/snail/:key" [key]
  (set-current-page! :snail)
  (set-current-question! (keyword key)))

(defroute family-path "/family/:key" [key]
  (set-current-page! :family)
  (set-current-question! (keyword key)))



(defroute about-path "/about" [] (set-current-page! :about))


;; Quick and dirty history configuration.
(let [h (History.)]
  (events/listen h EventType/NAVIGATE (fn [%]
                                        ;(println "TOKEN:" (str (.-token %)))
                                        (secretary/dispatch! (.-token %))))
  (doto h (.setEnabled true)))
