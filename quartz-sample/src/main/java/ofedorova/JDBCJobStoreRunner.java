/*
 * Created on Sep 21, 2006
 * 
 * This class is to run triggers which has already registered on scheduler.
 * Using JDBCJobStore, it will retrieve data from database and run
 */
package ofedorova;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

/**
 */
public class JDBCJobStoreRunner {

    public void task() throws SchedulerException
    {
        // Initiate a Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        List<String> triggerGroups;
        List<String> triggers;

        triggerGroups = scheduler.getTriggerGroupNames();
        for (int i = 0; i < triggerGroups.size(); i++) {
           triggers = scheduler.getTriggerNames(triggerGroups[i]);
           for (int j = 0; j < triggers.length; j++) {
              Trigger tg = scheduler.getTrigger(triggers[j], triggerGroups[i]);
              
              if (tg instanceof SimpleTrigger && tg.getName().equals("simpleTrigger")) {
                  ((SimpleTrigger)tg).setRepeatCount(100);
                  // reschdule the job
                  scheduler.rescheduleJob(triggers[j], triggerGroups[i], tg);
                  // unschedule the job
                  //scheduler.unscheduleJob(triggersInGroup[j], triggerGroups[i]);
              }
           }
        }        

        // start the scheduler
        scheduler.start();
    }
    
    public static void main (String args[]) 
    {
        try {
            JDBCJobStoreRunner qRunner = new JDBCJobStoreRunner();
            qRunner.task();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
