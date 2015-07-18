(ns ^:figwheel-always snailfinder.key-views
    (:require[om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn key-answer
      [cursor _]
      (om/component
        (dom/button #js {:type "button" :className "btn btn-default snails-key__answer"} "ANSWER")))

(defn key-question
      [cursor _]
      (om/component
        (dom/div #js {:className "snails-key__question"}
          (dom/p nil "This is going to be a question")
          (om/build key-answer cursor)
          (om/build key-answer cursor))))

(defn snail-key-view
  [cursor _]
    (om/component
      (dom/div #js {:className "snails-key"}
               (om/build key-question cursor))))