(require 'cljs.build.api)

(cljs.build.api/build "samples/defines/src"
  {:main            'defines.core
   :output-to       "samples/defines/out/main.js"
   :output-dir      "samples/defines/out"
   :optimizations   :simple
   :closure-defines {"defines.core.DEBUG" true}})

(cljs.build.api/build "samples/defines/src"
  {:main            'defines.core
   :output-to       "samples/defines/out/main.js"
   :output-dir      "samples/defines/out"
   :asset-path      "out"
   :optimizations   :none
   :closure-defines {"hello_world.core.DEBUG" true}})

(cljs.build.api/build "samples/defines/src"
  {:main            'defines.core
   :output-to       "samples/defines/out/main.js"
   :output-dir      "samples/defines/out"
   :asset-path      "out"
   :target          :nodejs
   :optimizations   :none
   :closure-defines {"defines.core.DEBUG" true}})
