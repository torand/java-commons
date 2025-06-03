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

import java.util.Optional;
import java.util.function.Function;

/**
 * General purpose utilities for optionals.
 */
public final class Optionals {
    private Optionals() {}

    /**
     * Executes the specified mapping function on the value if it is not null.
     * Returns null if it is.
     * @param value the value to map.
     * @param mapper the mapper function.
     * @return the mapped value if not null.
     * @param <T> the type to map from.
     * @param <U> the type to map to.
     */
    public static <T, U> U mapSafely(T value, Function<T, U> mapper) {
        return Optional.ofNullable(value).map(mapper).orElse(null);
    }
}
