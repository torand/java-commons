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

import java.util.function.Supplier;

import static io.github.torand.javacommons.contract.Requires.requireNonBlank;

/**
 * Provides factory methods to create exception objects with customized messages.
 */
public final class Exceptions {
    private Exceptions() {}

    /**
     * Creates a supplier of IllegalStateException with a customized message.
     * @param message the message.
     * @param args the message parameters.
     * @return the supplier.
     */
    public static Supplier<IllegalStateException> illegalStateException(String message, Object... args) {
        requireNonBlank(message, "message is blank");
        return () -> new IllegalStateException(message.formatted(args));
    }

    /**
     * Creates a supplier of IllegalArgumentException with a customized message.
     * @param message the message.
     * @param args the message parameters.
     * @return the supplier.
     */
    public static Supplier<IllegalArgumentException> illegalArgumentException(String message, Object... args) {
        requireNonBlank(message, "message is blank");
        return () -> new IllegalArgumentException(message.formatted(args));
    }

    /**
     * Creates a supplier of RuntimeException with a customized message.
     * @param message the message.
     * @param args the message parameters.
     * @return the supplier.
     */
    public static Supplier<RuntimeException> runtimeException(String message, Object... args) {
        requireNonBlank(message, "message is blank");
        return () -> new RuntimeException(message.formatted(args));
    }
}
