# AsyncLogger
The idea behind this logger is that the main code must not wait for the logging event to be completed.
As they say "the show must go on", this logger does the same.

The architecture of the logger is such that we create the logs and they are retained in memory, then there is a dedicated thread to sync these messages to the type of log file we want.

Currently supported types of logging are :

  0 : stdout

  1 : Logging to a file

  2 : Logging to a db server that has a JDBC driver.
