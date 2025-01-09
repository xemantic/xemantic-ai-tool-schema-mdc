/*
 * Copyright 2024-2025 Kazimierz Pogoda / Xemantic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xemantic.ai.tool.schema.mdc

import com.xemantic.kotlin.test.be
import com.xemantic.kotlin.test.have
import com.xemantic.kotlin.test.should
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test

class ObjectSchemaToMdcToolInputTest {

    @Serializable
    private data class Foo(
        val bar: String
    )

    @Test
    fun `Should convert class to MDC Tool Input`() {
        val input = mdcToolInput<Foo>()
        input should {
            properties should {
                have(size == 1)
                this["bar"] should {
                    be<JsonObject>()
                    have(size == 1)
                    this["type"] should {
                        be<JsonPrimitive>()
                        have(content == "string")
                    }
                }
            }
            have(required == listOf("bar"))
        }
    }

}
