## Custom Defines in `:none`

See [CLJS-1389](http://dev.clojure.org/jira/browse/CLJS-1389).

Most straightforward solution would be to prepend
`CLOSURE_UNCOMPILED_DEFINES` or `CLOSURE_DEFINES` to the main file as
done in
[`9962889`](https://github.com/martinklepsch/clojurescript/commit/99628896cf39b7c797c9e75b2207d3cc9af0acef). Unfortunately
this won't work.  Values in these globals are only looked up at
runtime when something has been defined with
```js
/** @define {boolean} */
goog.define('my.thing.DEBUG', false)
```
See [source of goog.define](http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l157).
In comparison defining something through CLJS will result in the following
```clj
(def ^{:jsdoc ["@define {boolean}"]}
  DEBUG true)
```
compiles to:
```js
/**
 * @define {boolean}
 */
my.thing.DEBUG = true;
```
The `@define` JSDoc tag is appropriately set but since there is no runtime lookup
no values from `CLOSURE_DEFINES` or `CLOSURE_UNCOMPILED_DEFINES` will be used.
In comparison `goog.define` does
[the runtime lookup](http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l157).

Docstrings for [`CLOSURE_DEFINES`](http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l70)
and [`CLOSURE_UNCOMPILED_DEFINES`](http://google.github.io/closure-library/api/source/closure/goog/base.js.src.html#l51)
are also interesting.

#### Possible solution

Using `goog.define` instead of just the `:jsdoc` metadata would allow
overriding in all optimization modes. Emitting `goog.define` properly without
causing warnings or errors requires the following:

1. The `goog.define` call needs to be annotated with the JSDoc `@define` tag.
2. We need to declare the var defined, otherwise there will be undeclared Var warnings

There's a macro in `samples/defines/src/hello_world/core.clj` that I
wrote while experimenting what's required to make this work.




