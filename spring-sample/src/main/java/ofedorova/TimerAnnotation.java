package ofedorova;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TimerAnnotation {

    @Scheduled(fixedDelay = 15000)
    public void excute(){
        System.out.println("timer2: " + new Date());
    }
}
