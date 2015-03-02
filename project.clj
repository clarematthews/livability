(defproject example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :plugins []
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.9"]
                 [http-kit "2.1.5"]
                 [enlive "1.1.5"]
                 [sonian/carica "1.1.0"]
                 [ring/ring-json "0.3.1"]
                 [clojure-csv/clojure-csv "2.0.1"]]
  :main main
  :profiles {:dev
              {:dependencies [[javax.servlet/servlet-api "2.5"]]}
             :production
              {:dependencies [[javax.servlet/servlet-api "2.5"]]}})