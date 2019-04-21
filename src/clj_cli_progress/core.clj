(ns clj-cli-progress.core
  (:import [me.tongfei.progressbar ProgressBar ProgressBarBuilder ProgressBarStyle]))


(defprotocol PProgressBarBuilder
  (with-initial-max [self n])
  (with-print-stream [self stream])
  (with-style [self style])
  (with-task-name [self task-name])
  (with-unit [self unit-name unit-size])
  (with-update-interval-millis [self millis])
  (enable-show-speed [self])
  (build [self]))

(extend-protocol PProgressBarBuilder
  ProgressBarBuilder
  (with-initial-max [self n] (-> self (.setInitialMax n)))
  (with-print-stream [self stream] (-> self (.setPrintStream stream)))
  (with-style [self style] (-> self (.setStyle style)))
  (with-task-name [self task-name] (-> self (.setTaskName task-name)))
  (with-unit [self unit-name unit-size] (-> self (.setUnit unit-name unit-size)))
  (with-update-interval-millis [self millis] (-> self (.setUpdateIntervalMillis millis)))
  (enable-show-speed [self] (-> self (.showSpeed)))
  (build [self] (.build self)))


(defn progress-bar-builder [] (ProgressBarBuilder.))
(defn progress-bar-wrapped-collection [coll task-name]
  (ProgressBar/wrap coll task-name))
