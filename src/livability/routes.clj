(ns livability.routes
  (:use [livability.handler])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))



(defn app-routes []
  (routes
    (GET "/" [] (index-handler))
    (GET "/result" [] (result-handler (repeat 1)))
    (POST "/" [] (weights-handler))
    (POST "/weights" [] (result-handler (repeat 1)))
    ))

(defn app []
  (handler/site (app-routes)))
