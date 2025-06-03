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

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.torand.javacommons.collection.CollectionHelper.containsOneOf;
import static io.github.torand.javacommons.collection.CollectionHelper.headOf;
import static io.github.torand.javacommons.collection.CollectionHelper.tailOf;
import static org.assertj.core.api.Assertions.assertThat;

class CollectionHelperTest {

    @Test
    void headOf_shouldReturnFirstElement() {
        List<Integer> iterable = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(headOf(iterable)).isEqualTo(1);
    }

    @Test
    void tailOf_shouldReturnLastElement() {
        List<Integer> iterable = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(tailOf(iterable)).isEqualTo(10);
    }

    @Test
    void containsOneOf_shouldReturnTrueOnlyWhenOneValueMatches() {
        List<Integer> iterable = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(containsOneOf(iterable, 11, 5, 12)).isTrue();
        assertThat(containsOneOf(iterable, 13)).isFalse();
    }
}