(ns livability.handler
  (:require [livability.templates :as templates]
            [clojure.java.io :as io]
            [clojure-csv.core :as csv]
            [livability.calculations :as calculations]))

(defn csv-handler []
	(csv/parse-csv (slurp "boroughScores.csv")))

(defn index-handler []
  (templates/render-template templates/index))

(defn result-handler [weights]
  (templates/render-template templates/result (calculations/rank-boroughs (rest (csv-handler)) weights)))

(defn weights-handler []
	(templates/render-template templates/weights (csv-handler)))