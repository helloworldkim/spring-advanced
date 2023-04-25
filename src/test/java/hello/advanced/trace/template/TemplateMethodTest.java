package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubLogic1;
import hello.advanced.trace.template.code.SubLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {

        logic1();
        logic2();

    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 수행
        log.info("비즈니스 로직1 수행");
        //비즈니스 로직 수행종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 수행
        log.info("비즈니스 로직2 수행");
        //비즈니스 로직 수행종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }

    @Test
    void templateMethodV1() {
        AbstractTemplate subLogic1 = new SubLogic1();
        subLogic1.execute();

        AbstractTemplate subLogic2 = new SubLogic2();
        subLogic2.execute();

    }

    @Test
    void templateMethodV2() {
        AbstractTemplate subLogic1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 수행");
            }
        };
        subLogic1.execute();

        AbstractTemplate subLogic2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 수행");
            }
        };
        subLogic2.execute();
    }


}
