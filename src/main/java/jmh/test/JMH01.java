package jmh.test;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-12-21 0:54
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMH01 {

  @Benchmark //微基准测试
  public void hello() throws InterruptedException {

    TimeUnit.MILLISECONDS.sleep(1);
  }

  public static void main(String[] args) throws RunnerException {
    //1个进程 度量5次
    Options build = new OptionsBuilder().include(JMH01.class.getSimpleName())
        .forks(1)
        .measurementIterations(5)
        .warmupIterations(10)
        .build();

    new Runner(build).run();
  }

}
