(ns ^:figwheel-always snailfinder.map
  (:require [om.core :as om :include-macros true]
            [snailfinder.key :refer [snail-key-flat]]
            [snailfinder.data :refer [app-state-cursor]]
            [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)



(def urls (array "http://a.tile.openstreetmap.org/${z}/${x}/${y}.png"
                 "http://b.tile.openstreetmap.org/${z}/${x}/${y}.png"
                 "http://c.tile.openstreetmap.org/${z}/${x}/${y}.png"))

;(def OSM (js/OpenLayers.Layer.XYZ. "OSM (with buffer)" urls (extend-object! (js-obj) {"transitionEffect" "resize"
;                                                                                      "buffer" 2
;                                                                                      "wrapDateLine" true
;                                                                                      "sphericalMercator" true})))
;
;(def plot (js/OpenLayers.Map. (extend-object! (js-obj) {"div" "plot"
;                                                        "layers" (array OSM)
;                                                        "center" (array 0 0)
;                                                        "zoom" 3
;                                                        "controls" (array (js/OpenLayers.Control.Navigation. (extend-object! (js-obj) {"dragPanOptions" (extend-object! (js-obj) {"enableKinetic" true})}))
;                                                                          (js/OpenLayers.Control.PanZoom.)
;                                                                          (js/OpenLayers.Control.LayerSwitcher.))})))

;; Geolocation
;(defn geolocation [position]
;  (def longitude (.-longitude js/position.coords))
;  (def latitude (.-latitude js/position.coords))
;  (def projection (js/OpenLayers.Projection. "EPSG:4326"))
;  (def center (.transform (js/OpenLayers.LonLat. longitude latitude) projection (.getProjectionObject plot)))
;  (.setCenter plot center 18))
;
;(.getCurrentPosition js/navigator.geolocation. geolocation)

(def location (atom nil))

(defn get-map-img
  [latitude longitude]
  (str "https://maps.googleapis.com/maps/api/staticmap?center=" latitude "," longitude "&zoom=13&size=300x300&sensor=false"))

(defn geolocation
  [position]
  (let [lat (-> position .-coords .-latitude)
        long (-> position .-coords .-longitude)]
    (reset! location {:long long :lat lat})))

(defn map-view
  [cursor _]
  (om/component
    (let []
      (html [:div
             [:a {:onClick #(.getCurrentPosition js/navigator.geolocation geolocation)
                  :className "mdl-button mdl-js-button mdl-button--raised mdl-button--colored"}
              "Get location"]
             (when @location
               [:img {:src (get-map-img (:lat @location) (:long @location))}])

             ]))))

