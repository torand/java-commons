package io.github.torand.javacommons.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static io.github.torand.javacommons.stream.StreamHelper.toReversedList;
import static org.assertj.core.api.Assertions.assertThat;

class StreamHelperTest {

    @Test
    void toReversedList_shouldCollectInReverseOrder() {
        Stream<String> stream = Stream.of("a", "b", "c");
        assertThat(stream.collect(toReversedList())).containsExactly("c", "b", "a");
    }
}