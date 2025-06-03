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
package io.github.torand.javacommons.contract;

import io.github.torand.javacommons.collection.ArrayHelper;
import io.github.torand.javacommons.collection.CollectionHelper;

import java.util.Collection;
import java.util.Optional;

import static io.github.torand.javacommons.lang.StringHelper.nonBlank;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * Provides factory methods to test the state of variables.
 */
public final class Requires {

    private Requires() {}

    /**
     * Checks that the specified 'int' array is not null and contains at least one element.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param array the array to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the array if not null or empty.
     */
    public static int[] requireNonEmpty(int[] array, String msg, Object... args) {
        requireNonNull(array, String.format(msg, args));
        require(() -> ArrayHelper.nonEmpty(array), msg, args);
        return array;
    }

    /**
     * Checks that the specified 'long' array is not null and contains at least one element.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param array the array to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the array if not null or empty.
     */
    public static long[] requireNonEmpty(long[] array, String msg, Object... args) {
        requireNonNull(array, String.format(msg, args));
        require(() -> ArrayHelper.nonEmpty(array), msg, args);
        return array;
    }

    /**
     * Checks that the specified object array is not null and contains at least one element.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param array the array to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the array if not null or empty.
     * @param <T> the object type.
     */
    public static <T> T[] requireNonEmpty(T[] array, String msg, Object... args) {
        requireNonNull(array, String.format(msg, args));
        require(() -> ArrayHelper.nonEmpty(array), msg, args);
        return array;
    }

    /**
     * Checks that the specified object collection is not null and contains at least one element.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param collection the collection to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the collection if not null or empty.
     * @param <T> the object type.
     */
    public static <T extends Collection<?>> T requireNonEmpty(T collection, String msg, Object... args) {
        requireNonNull(collection, String.format(msg, args));
        require(() -> CollectionHelper.nonEmpty(collection), msg, args);
        return collection;
    }

    /**
     * Checks that the specified string is not null and contains at least one character.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param string the string to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the string if not null or blank.
     */
    public static String requireNonBlank(String string, String msg, Object... args) {
        requireNonNull(string, String.format(msg, args));
        require(() -> nonBlank(string), msg, args);
        return string;
    }

    /**
     * Checks that the specified optional object is not null and is not empty.
     * Throws a customized NullPointerException or IllegalArgumentException if it is.
     * @param optional the optional to check.
     * @param msg the exception message.
     * @param args the exception message parameters.
     * @return the optional if not null or empty.
     * @param <T> the object type.
     */
    public static <T> Optional<T> requireNonEmpty(Optional<T> optional, String msg, Object... args) {
        require(() -> nonNull(optional) && optional.isPresent(), msg, args);
        return optional;
    }

    /**
     * Checks that the specified requirement is fulfilled.
     * Throws a customized IllegalArgumentException if it is.
     * @param requirement the requirement.
     * @param msg the exception message.
     * @param args the exception message parameters.
     */
    public static void require(Requirement requirement, String msg, Object... args) {
        if (!requirement.test()) {
            throw new IllegalArgumentException(String.format(msg, args));
        }
    }

    /**
     * Checks that the specified requirement is fulfilled.
     * Throws a customized IllegalStateException if it is.
     * @param requirement the requirement.
     * @param msg the exception message.
     * @param args the exception message parameters.
     */
    public static void precondition(Requirement requirement, String msg, Object... args) {
        if (!requirement.test()) {
            throw new IllegalStateException(String.format(msg, args));
        }
    }
}
