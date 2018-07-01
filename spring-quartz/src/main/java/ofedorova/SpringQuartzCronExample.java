package ofedorova;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzCronExample {
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"springQuartzSchedulerCronContext.xml");
		try {
		Thread.sleep(16000);
		} finally {
			context.close();
		}
	}
}
