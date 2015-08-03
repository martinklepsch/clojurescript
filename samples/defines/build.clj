(require 'cljs.build.api)

(cljs.build.api/build "samples/defines/src"
  {:main            'hello-world.core
   :output-to       "samples/defines/out/main.js"
   :output-dir      "samples/defines/out"
   :optimizations   :simple
   :closure-defines {"hello_world.core.DBG" false}})

(cljs.build.api/build "samples/defines/src"
  {:main            'hello-world.core
   :output-to       "samples/defines/out/main.js"
   :output-dir      "samples/defines/out"
   :asset-path      "out"
   :optimizations   :none
   :closure-defines {"hello_world.core.DBG" false}})
