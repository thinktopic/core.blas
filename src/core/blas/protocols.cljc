(ns core.blas.protocols)


(defmacro error
  "Throws an error with the provided message(s)"
  ([& vals]
   `(throw (ex-info (str ~@vals) {}))))


(defprotocol PBLASBase
  "Base blas support.  Note that the largest differences
from the C blas functions is that the return value is provided
first so that the protocol machinery can work (as opposed to alpha, which
would often be a numeric base type)."
  (supports-blas? [c])
  (gemm! [c trans-a? trans-b? alpha a b beta])
  (gemv! [c trans-a? alpha a b beta]))


(extend-protocol PBLASBase
  #?(:clj Object :cljs object)
  (supports-blas? [c] false)
  (gemm! [c trans-a? trans-b? alpha a b beta] (error "Unimplemented"))
  (gemv! [c trans-a? alpha a b beta] (error "Unimplemented")))
