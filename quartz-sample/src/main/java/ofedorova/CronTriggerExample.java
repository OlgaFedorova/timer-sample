package ofedorova;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {

    public static void main( String[] args ) throws Exception
    {
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("dummyJobName", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        //schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}
