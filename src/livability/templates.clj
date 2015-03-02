(ns livability.templates
  (:require [net.cgrand.enlive-html :as el]))

(defn render-template [template & args]
  (apply str (apply template args)))

(el/defsnippet head "templates/head.html"
               [[:head]]
               [page-title]
               [:script] (el/set-attr :data-main (str "/js/" page-title)))

(el/defsnippet table-cell-first "templates/weights.html"
  [[:tbody] [:tr el/first-child] [:td el/first-child]]
  [value]
  [:td] (el/content value))

(el/defsnippet table-cell-second "templates/weights.html"
  [[:tbody] [:tr el/first-child] [:td (el/nth-child 2)]]
  [value]
  [:td] (el/html-content value))

(el/defsnippet table-cell-rest "templates/weights.html"
  [[:tbody] [:tr el/first-child] [:td (el/nth-child 3)]]
  [value]
  [:td] (el/content value))

(defn fillrow [values]
  (el/content
    (table-cell-first values)
    (table-cell-second "<input type='range'  min='0' max='100' />")
    (table-cell-rest "Very important")))
    ; (map #(table-cell-rest %) "Very important")))

(el/defsnippet table-row "templates/weights.html"
  [[:tbody] [:tr el/first-child]]
  [values]
  [:tr] (fillrow values))

(el/defsnippet rows "templates/result.html"
               [[:tbody] [:tr el/first-child]]
  				[value]
  				[:td] (el/content value))

; -----------------------------------------------------------------


(el/deftemplate index "templates/index.html"
                []
                [:header] (el/content (str "Home | Back | Blah"))
                [:h1](el/content (str "Livability")))

(el/deftemplate result "templates/result.html"
                [boroughs]
                [:header] (el/content (str "Home | Back | Blah"))
                [:h1](el/content (str "Your top boroughs"))
                [:th](el/content (str "Boroughs"))
                [:tbody](el/content (map #(rows %) (keys boroughs))))

(el/deftemplate weights "templates/weights.html"
                [scores]
                [:header] (el/content (str "Home | Back | Blah"))
                [:h1](el/content (str "Categories"))
                [:h2](el/content (str "How important are the following to you?"))
                [:tbody](el/content (map #(table-row %) (rest (first scores))))
                [:head] (el/content (head "weightings")))
                
