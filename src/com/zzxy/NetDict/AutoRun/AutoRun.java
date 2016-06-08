/**
 * 
 */
package com.zzxy.NetDict.AutoRun;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.time.DateUtils;



/**
 * @author 张须高
 */
public class AutoRun implements ServletContextListener{

	
    //每天的毫秒数 
    public static final long PERIOD_DAY = DateUtils.MILLIS_PER_DAY; 
    //一周的毫秒数 
    public static final long PERIOD_WEEK = PERIOD_DAY * 7; 
    //无延迟 
    public static final long NO_DELAY = 0; 
    //定时器
    private Timer timer; 

    
    /** *
     *  在Web应用结束时停止任务 
     *  */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        timer.cancel();//定时器销毁 
    }

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(false);
      System.out.println("计时器");
      //要进行的task，延迟时间，多久后再次执行
      timer.scheduleAtFixedRate(new AutoIndex(), NO_DELAY,10000);
	}

}




