(ns snailfinder.routes
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [secretary.core :as secretary :refer-macros [defroute]]
            [snailfinder.group :refer [groups]]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :as data])
  (:import goog.History))


(secretary/set-config! :prefix "#")


(def default-page-title "Snail Finder")


(defn set-current-page!
  [page]
  (om/update! (data/app-state-cursor) [:current :page] page))


(defn set-current-question!
  [question]
  (om/update! (data/app-state-cursor) [:current :question] question))


(defn set-page-title!
  [title]
    (aset js/document "title" (str default-page-title " > " title)))


(defn reset-page-title!
  []
  (aset js/document "title" default-page-title))


(defroute home-path "/" [] (set-current-page! :home))


(defroute snail-key-default-path "/snail-key" []
  (set-current-page! :snail-key)
  (reset-page-title!))

(defroute snail-key-default-path "/map" []
  (set-current-page! :map))


(defroute snail-key-path "/snail-key/:key" [key]
  (set-current-page! :snail-key)
  (set-current-question! (keyword key))
  (let [new-title (str (get-in snail-key-flat [(keyword key) :question]))]
    (set-page-title! new-title)))


(defroute snail-path "/snail/:key" [key]
  (set-current-page! :snail)
  (set-current-question! (keyword key))
  (reset-page-title!))

(defroute snails-path "/snails" []
  (set-current-page! :snails)
  (reset-page-title!))



(defroute group-path "/group/:key" [key]
  (set-current-page! :group)
  (set-current-question! (keyword key))
  (set-page-title! (str "Group: " (get-in groups [(keyword key) :name]))))


(defroute "*" []
  (set-current-page! :home)
  (reset-page-title!))


(defroute about-path "/about" []
  (set-current-page! :about)
  (set-page-title! "About"))


;; Quick and dirty history configuration.
(let [h (History.)]
  (events/listen h EventType/NAVIGATE (fn [%]
                                        ;(println "TOKEN:" (str (.-token %)))
                                        (secretary/dispatch! (.-token %))))
  (doto h (.setEnabled true)))
