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
package io.github.torand.javacommons.functional;

import java.util.function.Predicate;

/**
 * General purpose predicates for streams.
 */
public final class Predicates {
    private Predicates() {}

    /**
     * Creates a predicate testing whether an object is an instance of a specified class.
     * @param clazz the class to test instance on.
     * @return the predicate.
     * @param <T> the class type.
     */
    public static <T> Predicate<? super T> instanceOf(Class<? extends T> clazz) {
        return clazz::isInstance;
    }
}
