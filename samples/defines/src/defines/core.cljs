(ns defines.core)
  
(enable-console-print!)

(define DEBUG false)

(println js/CLOSURE_DEFINES)
(println js/goog.global.CLOSURE_DEFINES)

(if DEBUG
  (println "Debugging enabled")
  (println "Debugging disabled"))

(println "Hello world!")

;; http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l147
