package ofedorova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service("carService")
public class CarServiceimpl {

    final Logger logger = LoggerFactory.getLogger(CarServiceimpl.class);

    public void updateCarAgeJoЬ() {
        System.out.println("timer1: " + new Date());
    }
}
