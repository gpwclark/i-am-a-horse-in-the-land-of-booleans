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
    true))

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
  (not (teen? age)))


(defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x) nil
    (list? x) (* 2 (count x))
    (vector? x) (* 2 (count x))
    :else true))

(defn leap-year? [year]
  (let [four (divides? 4 year) onehundred (divides? 100 year) fourhundred (divides? 400 year)] 
   (cond
    fourhundred true
    (and four (not onehundred)) true
    :else false)))

; '_______'
