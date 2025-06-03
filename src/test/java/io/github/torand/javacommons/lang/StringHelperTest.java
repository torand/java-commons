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

import org.junit.jupiter.api.Test;

import static io.github.torand.javacommons.lang.StringHelper.capitalize;
import static io.github.torand.javacommons.lang.StringHelper.generate;
import static io.github.torand.javacommons.lang.StringHelper.isBlank;
import static io.github.torand.javacommons.lang.StringHelper.nonBlank;
import static io.github.torand.javacommons.lang.StringHelper.quote;
import static io.github.torand.javacommons.lang.StringHelper.uncapitalize;
import static org.assertj.core.api.Assertions.assertThat;

class StringHelperTest {

    @Test
    void quote_shouldEncloseInQuotes() {
        assertThat(quote("hello")).isEqualTo("\"hello\"");
        assertThat(quote(null)).isNull();
    }

    @Test
    void capitalize_shouldMakeFirstLetterUpperCase() {
        assertThat(capitalize("hello")).isEqualTo("Hello");
        assertThat(capitalize(null)).isNull();
    }

    @Test
    void uncapitalize_shouldMakeFirstLetterLowerCase() {
        assertThat(uncapitalize("HELLO")).isEqualTo("hELLO");
        assertThat(uncapitalize(null)).isNull();
    }

    @Test
    void nonBlank_shouldReturnTrueOnlyWhenStringIsNotBlank() {
        assertThat(nonBlank(" ")).isTrue();
        assertThat(nonBlank("abc ")).isTrue();
        assertThat(nonBlank(" abc")).isTrue();
        assertThat(nonBlank("")).isFalse();
        assertThat(nonBlank(null)).isFalse();
    }

    @Test
    void isBlank_shouldReturnTrueOnlyWhenStringIsBlank() {
        assertThat(isBlank(" ")).isFalse();
        assertThat(isBlank("abc ")).isFalse();
        assertThat(isBlank(" abc")).isFalse();
        assertThat(isBlank("")).isTrue();
        assertThat(isBlank(null)).isTrue();
    }

    @Test
    void generate_shouldReturnRepeatedSubstring() {
        assertThat(generate("x", 4)).isEqualTo("xxxx");
    }

    @Test
    void generate_shouldReturnRepeatedSubstringwithDelimiter() {
        assertThat(generate("x", 4, ",")).isEqualTo("x,x,x,x");
    }
}
