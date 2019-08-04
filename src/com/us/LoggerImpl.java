package com.us;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author utkarshsrivastava
 *
 */
public class LoggerImpl implements LoggerInterface {

	int loggerID=0;
	static int defaultLoggerType = 0;
	static LoggerThread th;
	
	
	public LoggerImpl()
	{
		th.start();
	}
	
	
	public LoggerImpl(String instance)
	{
		
	}
	
	@Override
	public boolean init(int type) {
		// TODO Auto-generated method stub

		return false;
	}

	private void initFile() {
		// TODO Auto-generated method stub
		
	}

	
	//pops the objects from HashMap and puts in the log file
	@Override
	public void deQueue() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean log(String threadName, long epoch, LogDetail message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void log(String message)
	{
		Date d = new Date();
		log(Thread.currentThread().getName(),d.getTime(),message);
	}
	
	@Override
	public boolean log(String threadName,long epoch,String message) {
		
		LogDetail ld = new LogDetail();
		ld.setLogMessage(message);
		ld.setThreadName(threadName);
		logQueue.put(epoch, ld);
		
		return false;
	}
	
	class LoggerThread extends Thread
	{
		public void run()
		{
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(logQueue.size() > 0)
				{
					while(logQueue.size()>0)
					{
						ArrayList<Long> al = Collections.list(logQueue.keys());
						
						for(long i : al )
							{
								LogDetail ld=logQueue.get(i);
								
								int type= ld.getLoggerID();
								switch(type)
								{
								case 0:
									System.out.println(formatMessage (ld,i));
								}
								
								logQueue.remove(i);
							};
					}
				}
			
		}
	}

	public String formatMessage(LogDetail logMessage,long epoch) {
		// TODO Auto-generated method stub
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		
        String formattedTime = format.format(epoch);
		
        System.out.println(formattedTime+" "+logMessage.getMessageCode()+" "+logMessage.getLogMessage());
        
		return null;
	}
	
}
