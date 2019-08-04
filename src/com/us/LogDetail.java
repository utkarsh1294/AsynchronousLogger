package com.us;

public class LogDetail {

	String logMessage="";
	String messageCode="";
	String threadName="";
	int loggerID=0;
	
	public String getLogMessage() {
		return logMessage;
	}
	
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
	
	public String getMessageCode() {
		if(messageCode.isEmpty())
		{
			messageCode="MSG_101";
		}
		
		return messageCode;
	}
	
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	public String getThreadName() {
		return threadName;
	}
	
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	public int getLoggerID() {
		return loggerID;
	}
	
	public void setLoggerID(int loggerID) {
		this.loggerID = loggerID;
	}
	
}
