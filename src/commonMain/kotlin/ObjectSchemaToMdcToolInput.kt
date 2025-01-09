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

import com.xemantic.ai.tool.schema.ObjectSchema
import com.xemantic.ai.tool.schema.generator.jsonSchemaOf
import io.modelcontextprotocol.kotlin.sdk.Tool.Input
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

public fun ObjectSchema.toMdcToolInput(): Input =
    Json.encodeToJsonElement(this).jsonObject.run {
        Input(
            properties = get("properties")!!.jsonObject,
            required = get("required")?.jsonArray?.map {
                it.jsonPrimitive.content
            }
        )
    }

public inline fun <reified T> Any.mdcToolInput(): Input =
    (jsonSchemaOf<T>() as ObjectSchema).toMdcToolInput()
