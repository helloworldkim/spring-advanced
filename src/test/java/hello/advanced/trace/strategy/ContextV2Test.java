package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.*;
import hello.advanced.trace.template.code.SubLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV2() {

        ContextV2 contextV2 = new ContextV2();
        Strategy strategy = new StrategyLogic1();
        contextV2.execute(strategy);
        contextV2.execute(() -> log.info("비즈니스 로직2 수행"));

    }

}
