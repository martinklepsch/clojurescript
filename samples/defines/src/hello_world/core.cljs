(ns hello-world.core
  (:require-macros hello-world.core))

(enable-console-print!)

(def ^{:jsdoc ["@define {boolean}"]}
  DBG true)

(if DBG
  (println "Debugging enabled")
  (println "Debugging disabled"))

(println "Hello world!")

;; http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l147
