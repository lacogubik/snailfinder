(ns ^:figwheel-always snailfinder.map
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)


(defn get-map-img-by-long-lat
  [latitude longitude]
  (str "https://maps.googleapis.com/maps/api/staticmap?center=" latitude "," longitude "&zoom=13&size=400x400&sensor=false"))


;TODO URL encode
(defn get-coords-for-address
  [address]
  (go (let [response (<! (http/get "https://maps.googleapis.com/maps/api/geocode/json"
                                   {:with-credentials? false
                                    :query-params {"address" address}}))]
        ;(print (get-in response [:body :results 0 :geometry :location]))
        (let [location (get-in response [:body :results 0 :geometry :location])]
          (om/update! (app-state-cursor) [:location :coords] {:long (:lng location) :lat (:lat location)})))))


(defn geolocation
  [position]
  (let [lat (-> position .-coords .-latitude)
        long (-> position .-coords .-longitude)]
    (om/update! (app-state-cursor) [:location :coords] {:long long :lat lat})))


(defn map-view
  [cursor _]
  (om/component
    (let []
      (html [:div
             [:button {:onClick   #(.getCurrentPosition js/navigator.geolocation geolocation)
                       :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"}
              "Get my location"]
             [:input.mdl-textfield__input {:value     (get-in cursor [:location :query])
                                           :on-change (fn [e]
                                                        (om/update! cursor [:location :query] (.. e -target -value)))}]
             [:button {:onClick   #(get-coords-for-address (get-in cursor [:location :query]))
                       :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"}
              "Find address"]
             (when (-> @cursor :location :coords)
               [:img {:src (get-map-img-by-long-lat (-> @cursor :location :coords :lat) (-> @cursor :location :coords :long))}])

             ]))))

