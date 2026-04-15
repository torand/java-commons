/*
 * Copyright (c) 2025-2026 Tore Eide Andersen
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

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A custom spliterator keeping track of the index of each element in a stream.
 * @param <T> the element type
 */
public class IndexingSpliterator<T> implements Spliterator<IndexedValue<T>> {
    private final Spliterator<T> source;
    private int index = 0;

    /**
     * Creates an {@link IndexingSpliterator} object
     * @param source the regular spliterator to be wrapped
     */
    public IndexingSpliterator(Spliterator<T> source) {
        this.source = source;
    }

    @Override
    public boolean tryAdvance(Consumer<? super IndexedValue<T>> action) {
        return source.tryAdvance(item ->
            action.accept(new IndexedValue<>(item, index++)));
    }

    @Override
    public long estimateSize() {
        return source.estimateSize();
    }

    @Override
    public int characteristics() {
        return source.characteristics();
    }

    @Override
    public Spliterator<IndexedValue<T>> trySplit() {
        throw new UnsupportedOperationException("Parallel processing not supported");
    }
}