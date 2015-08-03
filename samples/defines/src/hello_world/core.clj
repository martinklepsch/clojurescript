(ns hello-world.core)

#_(defmacro define!
  [sym default]
  (let [defname (-> (str *ns* "." (name (symbol sym)))
                    (clojure.string/replace "-" "_"))
        goog-define (str "/** @define {boolean} */"
                         "goog.define('" defname "', " default")")]
    (list 'do
          (list 'declare (symbol sym))
          (list 'js* goog-define))))

#_(macroexpand-1 '(define! test false))
