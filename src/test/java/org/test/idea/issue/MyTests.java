package org.test.idea.issue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyTests {

    protected static Stream<Arguments> allJdks() {
        return IntStream.of(8, 11,17).mapToObj(Arguments::of);
    }

    @ParameterizedTest(name = "jdk {0}")
    @MethodSource("allJdks")
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface TestAllJdks {
    }


    @TestAllJdks
    public void test(int jdk){
        System.out.println("testing with "+jdk);
    }


}
