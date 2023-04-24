package hello.advanced.trace.v1;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraceV1Test {

    @Test
    void begin_end() {
        TraceV1 trace = new TraceV1();
        TraceStatus status = trace.begin("hello");

        trace.end(status);
    }

    @Test
    void begin_exception() {
        TraceV1 trace = new TraceV1();
        TraceStatus status = trace.begin("hello");

        trace.exception(status, new IllegalArgumentException());

    }

}