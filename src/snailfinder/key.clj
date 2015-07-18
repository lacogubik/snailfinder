(ns snailfinder.key)


(def key
  {:q1 {:question "Q1"
        :image    ""
        :q2       {:question "Q2" ;; node with options
                   :image    ""
                   :q4       {:description "" ;; endpoint
                              :image ""
                              :path [:q1 :q4]}
                   :q5       {:description "Q5" ;; endpoint
                              :image ""
                              :path [:q1 :q5]}
                   :path [:q1]
                   }
        :q3       {:question "Q3"
                   :image    ""
                   :q6       {:description "Q6" ;; endpoint
                              :image ""
                              :path [:q1 :q3]}
                   :q7       {:description ""
                              :image "Q7"
                              :path [:q1 :q3]}
                   :path [:q1]}}})



 ;; todo
(defn get-node
  [path])


(defn create-path
  [path id]
  (concat path id))



