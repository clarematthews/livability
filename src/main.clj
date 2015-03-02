(ns main
  (:use [livability.routes :only [app]]
        [org.httpkit.server :only [run-server]]))

(defonce server (atom nil))

(defn -main [& args]
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (reset! server (run-server (app) {:port port}))
    (println "Running server on port" port)))

(defn stop-server []
  (when-not (nil? @server)
    (@server)
    (reset! server nil)))

(defn start-server []
  (reset! server (run-server (app) {:port 8080})))

(defn restart-server []
  (stop-server)
  (require 'livability.templates :reload-all)
  (start-server))
