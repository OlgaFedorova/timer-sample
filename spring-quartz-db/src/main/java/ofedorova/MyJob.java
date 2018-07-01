package ofedorova;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.File;
import java.io.IOException;

public class MyJob extends QuartzJobBean {
	private static int count;

	@Override
	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		createNewFile();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("MyJob start: " + jobContext.getFireTime());
		JobDetail jobDetail = jobContext.getJobDetail();
		MyJobHelper jobHelper = (MyJobHelper) jobDetail.getJobDataMap().get("jobState");
		System.out.println("Example name is: " + jobHelper.getSomeStr());		
		System.out.println("MyJob end: " + jobContext.getJobRunTime() + ", key: " + jobDetail.getKey());
		System.out.println("MyJob next scheduled time: " + jobContext.getNextFireTime());
		System.out.println("--------------------------------------------------------------------");
		
		count++;
		System.out.println("Job count " + count);
	}

	private void createNewFile() {
		String path = "D:\\" + count + ".txt";
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
