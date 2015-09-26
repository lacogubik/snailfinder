(ns ^:figwheel-always snailfinder.map
  (:require [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)


(defn get-map-img
  [latitude longitude]
  (str "https://maps.googleapis.com/maps/api/staticmap?center=" latitude "," longitude "&zoom=13&size=300x300&sensor=false"))

(defn geolocation
  [position]
  (let [lat (-> position .-coords .-latitude)
        long (-> position .-coords .-longitude)]
    (om/update! (app-state-cursor) [:location] {:long long :lat lat})))

(defn map-view
  [cursor _]
  (om/component
    (let []
      (html [:div
             [:button {:onClick   #(.getCurrentPosition js/navigator.geolocation geolocation)
                       :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"}
              "Get location"]
             (when (:location @cursor)
               [:img {:src (get-map-img (-> @cursor :location :lat) (-> @cursor :location :long))}])

             ]))))

