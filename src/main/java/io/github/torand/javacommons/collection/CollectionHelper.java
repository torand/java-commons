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
package io.github.torand.javacommons.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static io.github.torand.javacommons.contract.Requires.requireNonEmpty;
import static io.github.torand.javacommons.lang.Exceptions.illegalArgumentException;
import static io.github.torand.javacommons.stream.StreamHelper.concatAndStream;
import static io.github.torand.javacommons.stream.StreamHelper.streamSafely;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * Helper functions for collections
 */
public final class CollectionHelper {
    private CollectionHelper() {}

    /**
     * Creates a list of specified iterable items.
     * @param items the item iterable.
     * @return the list.
     * @param <T> the item type.
     */
    public static <T> List<T> asList(Iterable<T> items) {
        return streamSafely(items).toList();
    }

    /**
     * Creates a list of specified item array.
     * @param items the item array.
     * @return the list.
     * @param <T> the item type.
     */
    @SafeVarargs
    public static <T> List<T> asList(T... items) {
        return streamSafely(items).toList();
    }

    /**
     * Creates a list of at least one, possibly multiple items.
     * @param first the first item, which cannot be null.
     * @param others the additional items, which can be null or empty.
     * @return the list.
     * @param <T> the item type.
     */
    @SafeVarargs
    public static <T> List<T> asNonEmptyList(T first, T... others) {
        requireNonNull(first, "first can not be null");
        return Stream.concat(Stream.of(first), streamSafely(others)).toList();
    }

    /**
     * Returns whether the specified collection is null or contains no elements.
     * @param collection the collection.
     * @return true if the collection is null or contains no elements; else false.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return isNull(collection) || collection.isEmpty();
    }

    /**
     * Returns whether the specified map is null or contains no elements.
     * @param map the map.
     * @return true if the map is null or contains no elements; else false.
     */
    public static boolean isEmpty(Map<?,?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * Returns whether the specified collection contains at least one element.
     * @param collection the collection.
     * @return true if the collection contains at least one element; else false.
     */
    public static boolean nonEmpty(Collection<?> collection) {
        return nonNull(collection) && !collection.isEmpty();
    }

    /**
     * Returns whether the specified map contains at least one element.
     * @param map the map.
     * @return true if the map contains at least one element; else false.
     */
    public static boolean nonEmpty(Map<?,?> map) {
        return nonNull(map) && !map.isEmpty();
    }

    /**
     * Concatenates the specified iterables into a single list.
     * @param first the first iterable.
     * @param second the second iterable.
     * @return the list.
     * @param <T> the element type.
     */
    public static <T> List<T> concat(Iterable<T> first, Iterable<T> second) {
        return concatAndStream(first, second).toList();
    }

    /**
     * Concatenates the elements of the specified iterable and array into a single list.
     * @param first the iterable.
     * @param second the array.
     * @return the list.
     * @param <T> the element type.
     */
    @SafeVarargs
    public static <T> List<T> concat(Iterable<T> first, T... second) {
        return Stream.concat(streamSafely(first), streamSafely(second)).toList();
    }

    /**
     * Returns the first element of the specified iterable.
     * @param iterable the iterable.
     * @return the first element of the iterable.
     * @param <T> the element type.
     */
    public static <T> T headOf(Iterable<T> iterable) {
        return streamSafely(iterable).findFirst()
            .orElseThrow(illegalArgumentException("iterable is empty"));
    }

    /**
     * Returns the last element of the specified iterable.
     * @param iterable the iterable.
     * @return the lastelement of the iterable.
     * @param <T> the element type.
     */
    public static <T> T tailOf(Iterable<T> iterable) {
        return streamSafely(iterable).reduce((first, second) -> second)
            .orElseThrow(illegalArgumentException("iterable is empty"));
    }

    /**
     * Tests whether the specified iterable contains an element satisfying a predicate.
     * @param iterable the iterable.
     * @param predicate the predicate.
     * @return true if the iterable contains an element satisfying the predicate; else false.
     * @param <T> the element type.
     */
    public static <T> boolean containsAny(Iterable<T> iterable, Predicate<T> predicate) {
        requireNonNull(predicate, "predicate is null");
        return streamSafely(iterable).anyMatch(predicate);
    }

    /**
     * Tests whether the specified iterable contains one of the specified items.
     * @param iterable the iterable.
     * @param items the items to look for.
     * @return true if the iterable contains one of the specified items; else false.
     * @param <T> the element type.
     */
    public static <T> boolean containsOneOf(Iterable<T> iterable, T... items) {
        requireNonEmpty(items, "No items specified");
        return containsAny(iterable, currentValue -> Stream.of(items).anyMatch(currentValue::equals));
    }

    /**
     * Returns a new list with elements of specified collection in reversed order.
     * @param collection the collection
     * @return the reversed list.
     * @param <T> the element type.
     */
    public static <T> List<T> reverse(Collection<T> collection) {
        List<T> list = new ArrayList<>(collection);
        Collections.reverse(list);
        return list;
    }
}
