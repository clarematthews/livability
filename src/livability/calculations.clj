(ns livability.calculations)

(defn to-num[score]
	(read-string score))

(defn borough-score[values weights]
	(reduce + (map * (map to-num (rest values)) weights)))

(defn rank-boroughs [data weights]
	(sort-by val > (zipmap (map first data) (map borough-score data (repeat weights)))))