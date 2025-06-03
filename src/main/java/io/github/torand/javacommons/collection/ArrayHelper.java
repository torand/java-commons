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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Helper functions for arrays
 */
public final class ArrayHelper {
    private ArrayHelper() {}

    /**
     * Returns whether the specified 'int' array is null or contains no elements.
     * @param array the array.
     * @return true if the array is null or contains no elements; else false.
     */
    public static boolean isEmpty(int[] array) {
        return isNull(array) || array.length == 0;
    }

    /**
     * Returns whether the specified 'long' array is null or contains no elements.
     * @param array the array.
     * @return true if the array is null or contains no elements; else false.
     */
    public static boolean isEmpty(long[] array) {
        return isNull(array) || array.length == 0;
    }

    /**
     * Returns whether the specified object array is null or contains no elements.
     * @param array the array.
     * @return true if the array is null or contains no elements; else false.
     * @param <T> the object type.
     */
    public static <T> boolean isEmpty(T[] array) {
        return isNull(array) || array.length == 0;
    }

    /**
     * Returns whether the specified 'int' array contains at least one element.
     * @param array the array.
     * @return true if the array contains at least one element; else false.
     */
    public static boolean nonEmpty(int[] array) {
        return nonNull(array) && array.length > 0;
    }

    /**
     * Returns whether the specified 'long' array contains at least one element.
     * @param array the array.
     * @return true if the array contains at least one element; else false.
     */
    public static boolean nonEmpty(long[] array) {
        return nonNull(array) && array.length > 0;
    }

    /**
     * Returns whether the specified object array contains at least one element.
     * @param array the array.
     * @return true if the array contains at least one element; else false.
     * @param <T> the object type.
     */
    public static <T> boolean nonEmpty(T[] array) {
        return nonNull(array) && array.length > 0;
    }
}
