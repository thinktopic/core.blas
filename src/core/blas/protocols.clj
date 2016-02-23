(ns core.blas.protocols)



(defprotocol PBLASBase
  "Base blas support.  Note that the largest differences
from the C blas functions is that the return value is provided
first so that the protocol machinery can work (as opposed to alpha, which
would often be a numeric base type)."
  (supports-blas? [c])
  (gemm! [c trans-a? trans-b? alpha a b beta])
  (gemv! [c trans-a? alpha a b beta]))
