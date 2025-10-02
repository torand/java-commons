/*
 * Copyright (c) 2025 Tore Eide Andersen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.torand.javacommons.stream;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Objects.isNull;

/**
 * Helper functions for streams
 */
public final class StreamHelper {
    private StreamHelper() {}

    /**
     * Creates a stream from the elements in the specified iterable. If the iterable is null or contains no elements, an empty stream is returned.
     * @param iterable the iterable.
     * @return the stream.
     * @param <T> the element type.
     */
    public static <T> Stream<T> streamSafely(Iterable<T> iterable) {
        if (isNull(iterable)) {
            return Stream.empty();
        } else {
            return StreamSupport.stream(iterable.spliterator(), false);
        }
    }

    /**
     * Creates a stream from the elements in the specified iterator. If the iterator is null or contains no elements, an empty stream is returned.
     * @param iterator the iterator.
     * @return the stream.
     * @param <T> the element type.
     */
    public static <T> Stream<T> streamSafely(Iterator<T> iterator) {
        if (isNull(iterator)) {
            return Stream.empty();
        } else {
            return streamSafely(() -> iterator);
        }
    }

    /**
     * Creates a stream from the elements in the specified array. If the array is null or contains no elements, an empty stream is returned.
     * @param items the items.
     * @return the stream.
     * @param <T> the item type.
     */
    @SafeVarargs
    public static <T> Stream<T> streamSafely(T... items) {
        if (isNull(items)) {
            return Stream.empty();
        } else {
            return Stream.of(items);
        }
    }

    /**
     * Creates a concatenated stream from the elements in the specified iterables.
     * @param first the first iterable.
     * @param second the second iterable.
     * @return the stream.
     * @param <T> the element type.
     */
    public static <T> Stream<T> concatAndStream(Iterable<T> first, Iterable<T> second) {
        return Stream.concat(streamSafely(first), streamSafely(second));
    }

    /**
     * Concatenates an arbitrary number of streams.
     * @param streams the streams to concatenate.
     * @return the concatenates streams.
     * @param <T> the stream value type.
     */
    public static <T> Stream<T> concatStreams(Stream<T>... streams) {
        return Stream.of(streams).flatMap(Function.identity());
    }

    /**
     * Returns a {@link Collector} producing a list with elements in reversed order.
     * @return the {@link Collector} object.
     * @param <T> the value type.
     */
    public static <T> Collector<T, ?, List<T>> toReversedList() {
        return Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list); return list;});
    }
}
