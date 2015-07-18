(ns ^:figwheel-always snailfinder.key-views
    (:require[om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn snail-key-view
  [cursor _]
    (om/component
      (dom/div nil
        (dom/h2 nil "Snail Key"))))
