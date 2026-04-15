package io.github.torand.javacommons.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static io.github.torand.javacommons.stream.StreamHelper.streamSafelyWithIndex;
import static io.github.torand.javacommons.stream.StreamHelper.toReversedList;
import static org.assertj.core.api.Assertions.assertThat;

class StreamHelperTest {

    @Test
    void toReversedList_shouldCollectInReverseOrder() {
        Stream<String> stream = Stream.of("a", "b", "c");
        assertThat(stream.collect(toReversedList())).containsExactly("c", "b", "a");
    }

    @Test
    void streamSafelyWithIndex_shouldProvideZeroBasedElementIndex() {
        String[] elements = {"a", "b", "c"};

        List<Integer> indices = streamSafelyWithIndex(elements).map(e -> e.index()).toList();
        List<String> values = streamSafelyWithIndex(elements).map(e -> e.value()).toList();

        assertThat(indices).containsExactly(0, 1, 2);
        assertThat(values).containsExactly(elements);
    }
}