package com.hafizdwp.test_export_sqlite_excel.ktor

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

/**
 * @author hafizdwp
 * 20/05/2021
 **/

val ktorHttpClient by lazy {

    HttpClient(OkHttp) {

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

//        install(Logging) {
//            logger = object : Logger {
//                override fun log(message: String) {
//                    log("KTOR: $message")
//                }
//            }
//
//            level = LogLevel.ALL
//        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }

//        install(DefaultRequest) {
//            header(HttpHeaders.ContentType, ContentType.Application.Json)
//        }
    }
}
