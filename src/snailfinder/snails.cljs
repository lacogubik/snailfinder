(ns snailfinder.snails
  (:require [clojure.string :refer [lower-case]]
            [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [snailfinder.snail :refer [snails]]
            [sablono.core :as html :refer-macros [html]]))


(defn subsumes [main sub]
  (some
    (partial = (seq sub))
    (partition (count sub) 1 main)))


(defn snails-component
  [app owner]
  (reify
    om/IWillMount
    (will-mount [this]
      (om/update! app [:snails :query] nil))
    om/IDidMount
    (did-mount [this]
      (.upgradeElement js/componentHandler (om/get-node owner "snails-query")))
    om/IRender
    (render [this]
      (html (let [query (get-in app [:snails :query])
                  result (filter (fn [[key value]]
                                   (or (= query nil)
                                       (= query "")
                                       (subsumes (lower-case (:name value)) (lower-case query)))) snails)]
              [:div.mdl-grid
               [:div.mdl-cell.mdl-cell--12-col
                [:div.mdl-textfield.mdl-js-textfield.mdl-textfield--floating-label {:ref "snails-query"}
                 [:input.mdl-textfield__input {:value     (get-in app [:snails :query])
                                               :on-change (fn [e]
                                                            (om/update! app [:snails :query] (.. e -target -value)))}]
                 [:label.mdl-textfield__label "Search"]]
                [:table {:className "mdl-data-table mdl-js-data-table mdl-shadow--2dp"}
                 (into [:tbody] (map (fn [[key snail]]
                                       [:tr

                                        [:td [:a {:href (str "#/snail/" (name key))} [:img {:src    (str "images/endpoint/" (:image snail))
                                                                                            :height "50px"}]]]
                                        [:td {:className "mdl-data-table__cell--non-numeric"}
                                         [:a {:href (str "#/snail/" (name key))}
                                          [:span (str (:name snail))]
                                          [:br]
                                          [:span [:i (str (:common-name snail))]]]]]) result))]]])))))