package com.us;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public interface LoggerInterface {
	
	int type = 0;	//log type 0 means stdout writer.
	//the type will range from 0 to 2.
	// 0 stdout
	// 1 file
	// 2 RDMS
	// Anything out of this range is considered 0 (info).

	String connectJDBCString = ""; // Will be needed if there is a JDBC Logger in use.
	
	String configXML = "uslogging.xml"; // The default name of the config file is this, to use another use the flag.
										// -DUSLoggerConfig="Fully Qualified Path with file name"
	
//	/**
//	 * The list of Loggers, if none specified then the first one i.e.stdout is used
//	 * Each Logger has a reference to all the list of all loggers as this list is static
//	 * If a logger object is destructed this list element will be removed.
//	 */
//	static ArrayList<LoggerInterface> loggers = new ArrayList<LoggerInterface>();
	
	/**
	 * This map contains all the log events and the logger thread will pick these messages and generate the logs.
	 * Key is the epoch time when the log was generated
	 */
	static ConcurrentHashMap<Long, LogDetail> logQueue = new ConcurrentHashMap<>();

	//
	/**
	 * @param threadName		Pass the current thread name and the epoch time
	 * @param epoch
	 * @return
	 */
	//add these entries to the hashMap logQueue
	boolean log(String threadName, long epoch , String message);
	boolean log(String threadName, long epoch , LogDetail message);
	void log(String message);
	
	/**
	 * @param type
	 *            Initialize the logger with the type (File/Console/JDBC)
	 * @return
	 */
	boolean init(int type);
	
	void deQueue();
	
}
