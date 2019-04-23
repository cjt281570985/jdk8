package jmh.test;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-12-22 21:30
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMH03 {

  /*@Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @Warmup(iterations = 5)
  @Measurement(iterations = 5)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public void testAverageTime() throws InterruptedException {

    TimeUnit.MILLISECONDS.sleep(10);
  }
*/
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5)
  @Measurement(iterations = 5)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void testThroughput() throws InterruptedException {

    TimeUnit.MILLISECONDS.sleep(10);
  }

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().include(JMH03.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(options).run();
  }



}
