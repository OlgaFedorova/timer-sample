/*
 * Created on Sep 21, 2006
 * 
 * This class is to run a scheduler with CronTrigger
 */
package ofedorova;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 */
public class CronTriggerRunner {

    public void task() throws SchedulerException
    {
        // Initiate a Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        // current time
        long ctime = System.currentTimeMillis(); 
        
        // Initiate JobDetail with job name, job group, and executable job class
        JobDetail jobDetail = new JobDetail("jobDetail2", "jobDetailGroup2", SimpleQuartzJob.class);
        // Initiate CronTrigger with its name and group name
        CronTrigger cronTrigger = new CronTrigger("cronTrigger", "triggerGroup2");
        try {
            // setup CronExpression
            CronExpression cexp = new CronExpression("0/5 * * * * ?");
            // Assign the CronExpression to CronTrigger
            cronTrigger.setCronExpression(cexp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // schedule a job with JobDetail and Trigger
        scheduler.scheduleJob(jobDetail, cronTrigger);
        
        // start the scheduler
        scheduler.start();
    }
    
    public static void main (String args[]) 
    {
        try {
            CronTriggerRunner qRunner = new CronTriggerRunner();
            qRunner.task();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
