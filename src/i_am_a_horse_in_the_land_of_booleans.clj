(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
  (if x true false))

(defn abs [x]
  (if (> x 0)
    x
    (* -1 x)))

(defn divides? [divisor n]
  (if (> (mod n divisor) 0)
    false
    true
    ))

(defn fizzbuzz [n]
  (let  [three (divides? 3 n) five (divides? 5 n)]
  (cond
   (and three five) "gotcha!"
   three "fizz"
   five "buzz"
   :else "")))

(defn teen? [age]
  (if (and (> age 12) (< age 20))
    true
    false)
  )


(defn not-teen? [age]
  ":(")

(defn generic-doublificate [x]
  ":(")

(defn leap-year? [year]
  ":(")

; '_______'
