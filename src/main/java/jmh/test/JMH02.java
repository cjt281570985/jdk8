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
 * @Date: Created 2018-12-22 21:00
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JMH02 {

  @Benchmark //微基准测试
  public String appendString() {

    String s = "";
    for (int i = 0; i < 100; i++) {
      s = s + i;
    }
    return s;
  }

  @Benchmark
  public StringBuffer appendStringBuffer() {

    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 100; i++) {
      buffer.append(i);
    }
    return buffer;
  }

  @Benchmark
  public StringBuilder appendStringBuilder() {

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      builder.append(i);
    }
    return builder;
  }


  public static void main(String[] args) throws RunnerException {

    Options options = new OptionsBuilder().include(JMH02.class.getSimpleName())
        .forks(1)
        .measurementIterations(10)
        .warmupIterations(10)
        .build();
    new Runner(options).run();


  }

}
