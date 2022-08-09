package org;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class CustomEx extends RuntimeException {
    public CustomEx() {
        super("hello", null, true, true);
    }
}

public class BenchTest {

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void test(Blackhole blackhole) {
        var err = new CustomEx();
        blackhole.consume(err);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void setUp(Blackhole blackhole) {
        var date = new Date();
        blackhole.consume(date);
    }


    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}