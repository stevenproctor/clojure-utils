(ns proctor.utils.core)

(use '[clojure.string :only (join split)])

(defn split-lines [s]
  (clojure.string/split s #"\n"))

(defn slurp-lines [file-name]
  "reads a file in and returns a the lines
   in the file delimited by a newline"
  (split-lines (slurp file-name)))

(defn plot-line [[name n]]
  (str name \tab (apply str (repeat n "*"))))

(defn text-histogram [freqs]
  "creates a textual histogram for the results of a
   call to frequencies, where the name is the key followed
   by an * for the value of the occurances"
  (println (clojure.string/join \newline (map plot-line freqs))))

(defn csv-frequencies [freqs]
  "print out frequencies results style structure
   to a format consumable in CSV files"
  (println (join \newline (map #(join "," %) freqs))))
