package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");

        Thread threadB = new Thread(userB);
        threadB.setName("threadB");


        threadA.start();
        sleep(2000);
        threadB.start();
        sleep(2000);
        log.info("main end");
    }

    @Test
    void field_error() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");

        Thread threadB = new Thread(userB);
        threadB.setName("threadB");


        threadA.start();
        sleep(100);
        threadB.start();
        sleep(2000);
        log.info("main end");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
