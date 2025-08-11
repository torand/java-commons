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
package io.github.torand.javacommons.lang;

import java.util.List;

import static io.github.torand.javacommons.stream.StreamHelper.streamSafely;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * Provides general purpose string utilities.
 */
public final class StringHelper {
    private StringHelper() {}

    /**
     * Tests whether the specified string is not null and contains at least one character.
     * @param string the string to test.
     * @return true if the string is not null and contains at least one character; else false.
     */
    public static boolean nonBlank(String string) {
        return nonNull(string) && !string.isEmpty();
    }

    /**
     * Tests whether the specified string is null or contains no characters.
     * @param string the string to test.
     * @return true if the string is null or contains no characters; else false.
     */
    public static boolean isBlank(String string) {
        return isNull(string) || string.isEmpty();
    }

    /**
     * Creates a string by concatenating a substring multiple times.
     * @param string the substring.
     * @param count the number of repetitions.
     * @return the generated string.
     */
    public static String generate(String string, int count) {
        requireNonNull(string, "string is null");
        return string.repeat(count);
    }

    /**
     * Creates a string by concatenating a substring multiple times delimited by a delimiter substring.
     * @param string the substring.
     * @param count the number of repetitions.
     * @param delimiter the delimiter.
     * @return the generated string.
     */
    public static String generate(String string, int count, String delimiter) {
        requireNonNull(string, "string is null");
        requireNonNull(delimiter, "delimiter is null");

        StringBuilder b = new StringBuilder();
        for (int t = 0; t < count; t++) {
            if (t != 0) {
                b.append(delimiter);
            }
            b.append(string);
        }

        return b.toString();
    }

    /**
     * Returns the specified string enclosed by double quotes.
     * @param string the string.
     * @return the quoted string.
     */
    public static String quote(String string) {
        if (isNull(string)) {
            return null;
        }

        return "\"" + string + "\"";
    }

    /**
     * If the specified object is a string, returns it enclosed by double quotes.
     * @param object the object, which might be a string.
     * @return the quoted string or unmodified object.
     */
    public static Object quoteIfString(Object object) {
        if (object instanceof String string) {
            return quote(string);
        }

        return object;
    }

    /**
     * Returns specified list with all strings quoted.
     * @param strings the list.
     * @return the list of quoted strings.
     */
    public static List<String> quoteAll(List<String> strings) {
        return streamSafely(strings).map(StringHelper::quote).toList();
    }

    /**
     * Removes a specific number of leading characters from a string.
     * @param string the string.
     * @param count the number of characters to remove.
     * @return the stripped string.
     */
    public static String stripHead(String string, int count) {
        if (isBlank(string)) {
            return string;
        }

        return string.substring(count);
    }

    /**
     * Removes a specific number of trailing characters from a string.
     * @param string the string.
     * @param count the number of characters to remove.
     * @return the stripped string.
     */
    public static String stripTail(String string, int count) {
        if (isBlank(string)) {
            return string;
        }

        return string.substring(0, Math.max(0, string.length()-count));
    }

    /**
     * Returns specified string with upper case first letter.
     * @param string the string.
     * @return the capitalized string.
     */
    public static String capitalize(String string) {
        if (isBlank(string)) {
            return string;
        }

        return string.substring(0,1).toUpperCase() + string.substring(1);
    }

    /**
     * Returns specified string with lower case first letter.
     * @param string the string.
     * @return the uncapitalized string.
     */
    public static String uncapitalize(String string) {
        if (isBlank(string)) {
            return string;
        }

        return string.substring(0,1).toLowerCase() + string.substring(1);
    }
}
