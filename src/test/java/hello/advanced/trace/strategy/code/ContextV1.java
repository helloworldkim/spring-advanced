package hello.advanced.trace.strategy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ContextV1 {

    private final Strategy strategy;

    public void execute() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 수행
        strategy.call(); //위임
        //비즈니스 로직 수행종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

}
