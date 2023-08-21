//@file:JsModule("@cloudflare/workers-types")
//@file:JsNonModule()
@file:Suppress(
    "NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE",
)

package com.cloudflare.workers.types

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.ArrayBufferView
import org.khronos.webgl.Uint8Array
import org.w3c.dom.events.EventTarget
import org.w3c.fetch.*
import org.w3c.workers.ServiceWorkerGlobalScope
import kotlin.js.Date
import kotlin.js.Promise

external interface Record<K, V> {
    operator fun get(key: K): V?
}

/**
 * declare function fetch(
 *   input: RequestInfo,
 *   init?: RequestInit<RequestInitCfProperties>
 * ): Promise<Response>;
 */
external fun fetch(
    input: RequestInfo,
    init: RequestInit? = definedExternally,
):Promise<Response>
external fun fetch(
    input: String,
    init: RequestInit? = definedExternally,
):Promise<Response>
external fun fetch(
    input: URL,
    init: RequestInit? = definedExternally,
):Promise<Response>
//external fun fetch(
//    input: RequestInfo,
//    init: dynamic? = definedExternally,
//):Promise<Response>

/*! *****************************************************************************
Copyright (c) Cloudflare. All rights reserved.
Copyright (c) Microsoft Corporation. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at http://www.apache.org/licenses/LICENSE-2.0
THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.
See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */
/* eslint-disable */
// noinspection JSUnusedGlobalSymbols

//external class DOMException : Error {
//    constructor (message: String = definedExternally, name: String = definedExternally)
//
//    override val message: String
//    val name: String
//    val code: Double
//    val stack: Any?
//
//    companion object {
//        val INDEX_SIZE_ERR: Double
//        val DOMSTRING_SIZE_ERR: Double
//        val HIERARCHY_REQUEST_ERR: Double
//        val WRONG_DOCUMENT_ERR: Double
//        val INVALID_CHARACTER_ERR: Double
//        val NO_DATA_ALLOWED_ERR: Double
//        val NO_MODIFICATION_ALLOWED_ERR: Double
//        val NOT_FOUND_ERR: Double
//        val NOT_SUPPORTED_ERR: Double
//        val INUSE_ATTRIBUTE_ERR: Double
//        val INVALID_STATE_ERR: Double
//        val SYNTAX_ERR: Double
//        val INVALID_MODIFICATION_ERR: Double
//        val NAMESPACE_ERR: Double
//        val INVALID_ACCESS_ERR: Double
//        val VALIDATION_ERR: Double
//        val TYPE_MISMATCH_ERR: Double
//        val SECURITY_ERR: Double
//        val NETWORK_ERR: Double
//        val ABORT_ERR: Double
//        val URL_MISMATCH_ERR: Double
//        val QUOTA_EXCEEDED_ERR: Double
//        val TIMEOUT_ERR: Double
//        val INVALID_NODE_TYPE_ERR: Double
//        val DATA_CLONE_ERR: Double
//    }
//
//}


external interface WorkerGlobalScopeEventMap {
    var fetch: FetchEvent
    var scheduled: ScheduledEvent
    //    var queue: QueueEvent
    var unhandledrejection: PromiseRejectionEvent
    var rejectionhandled: PromiseRejectionEvent
}


//external abstract class  WorkerGlobalScope : EventTarget<WorkerGlobalScopeEventMap> {
//    var EventTarget: Any?
//}


external interface Console {
    fun String /* "assert" */(condition: Boolean = definedExternally, vararg data: Any?): Unit
    fun clear(): Unit
    fun count(label: String = definedExternally): Unit
    fun countReset(label: String = definedExternally): Unit
    fun debug(vararg data: Any?): Unit
    fun dir(item: Any? = definedExternally, options: Any? = definedExternally): Unit
    fun dirxml(vararg data: Any?): Unit
    fun error(vararg data: Any?): Unit
    fun group(vararg data: Any?): Unit
    fun groupCollapsed(vararg data: Any?): Unit
    fun groupEnd(): Unit
    fun info(vararg data: Any?): Unit
    fun log(vararg data: Any?): Unit
    fun table(tabularData: Any? = definedExternally, properties: Array<String> = definedExternally): Unit
    fun time(label: String = definedExternally): Unit
    fun timeEnd(label: String = definedExternally): Unit
    fun timeLog(label: String = definedExternally, vararg data: Any?): Unit
    fun timeStamp(label: String = definedExternally): Unit
    fun trace(vararg data: Any?): Unit
    fun warn(vararg data: Any?): Unit
}


external val console: Console

typealias BufferSource = Any /* ArrayBufferView | ArrayBuffer */


//external object WebAssembly {
//
//    external class CompileError : Error {
//        constructor (message: String = definedExternally)
//    }
//
//
//    external class RuntimeError : Error {
//        constructor (message: String = definedExternally)
//    }
//
//
//    @Suppress(
//        "NAME_CONTAINS_ILLEGAL_CHARS",
//        "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
//    )
//    @JsName("""(/*union*/{anyfunc: 'anyfunc', externref: 'externref', f32: 'f32', f64: 'f64', i32: 'i32', i64: 'i64', v128: 'v128'}/*union*/)""")
//    sealed external interface ValueType {
//        companion object {
//            val anyfunc: ValueType
//            val externref: ValueType
//            val f32: ValueType
//            val f64: ValueType
//            val i32: ValueType
//            val i64: ValueType
//            val v128: ValueType
//        }
//    }
//
//
//    external interface GlobalDescriptor {
//        var value: ValueType
//        var mutable: Boolean?
//    }
//
//
//    external class Global {
//        constructor (descriptor: GlobalDescriptor, value: Any? = definedExternally)
//
//        var value: Any?
//        fun valueOf(): Any?
//    }
//
//    typealias ImportValue = Any /* ExportValue | number */
//    typealias ModuleImports = Record<String, ImportValue>
//    typealias Imports = Record<String, ModuleImports>
//    typealias ExportValue = Any /* Function | Global | Memory | Table */
//    typealias Exports = Record<String, ExportValue>
//
//    external class Instance {
//        constructor (module: Module, imports: Imports = definedExternally)
//
//        val exports: Exports
//    }
//
//
//    external interface MemoryDescriptor {
//        var initial: Double
//        var maximum: Double?
//        var shared: Boolean?
//    }
//
//
//    external class Memory {
//        constructor (descriptor: MemoryDescriptor)
//
//        val buffer: ArrayBuffer
//        fun grow(delta: Double): Double
//    }
//
//
//    @Suppress(
//        "NAME_CONTAINS_ILLEGAL_CHARS",
//        "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
//    )
//    @JsName("""(/*union*/{function: 'function', global: 'global', memory: 'memory', table: 'table'}/*union*/)""")
//    sealed external interface ImportExportKind {
//        companion object {
//            val function: ImportExportKind
//            val global: ImportExportKind
//            val memory: ImportExportKind
//            val table: ImportExportKind
//        }
//    }
//
//
//    external interface ModuleExportDescriptor {
//        var kind: ImportExportKind
//        var name: String
//    }
//
//
//    external interface ModuleImportDescriptor {
//        var kind: ImportExportKind
//        var module: String
//        var name: String
//    }
//
//
//    external class Module {
//
//
//        companion object {
//            fun customSections(module: Module, sectionName: String): Array<ArrayBuffer>
//            fun exports(module: Module): Array<ModuleExportDescriptor>
//            fun imports(module: Module): Array<ModuleImportDescriptor>
//        }
//
//    }
//
//
//    @Suppress(
//        "NAME_CONTAINS_ILLEGAL_CHARS",
//        "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
//    )
//    @JsName("""(/*union*/{anyfunc: 'anyfunc', externref: 'externref'}/*union*/)""")
//    sealed external interface TableKind {
//        companion object {
//            val anyfunc: TableKind
//            val externref: TableKind
//        }
//    }
//
//
//    external interface TableDescriptor {
//        var element: TableKind
//        var initial: Double
//        var maximum: Double?
//    }
//
//
//    external class Table {
//        constructor (descriptor: TableDescriptor, value: Any? = definedExternally)
//
//        val length: Double
//        fun get(index: Double): Any?
//        fun grow(delta: Double, value: Any? = definedExternally): Double
//        fun set(index: Double, value: Any? = definedExternally): Unit
//    }
//
//    external fun instantiate(module: Module, imports: Imports = definedExternally): Promise<Instance>
//    external fun validate(bytes: BufferSource): Boolean
//}


/** This ServiceWorker API interface represents the global execution context of a service worker. */

//external interface ServiceWorkerGlobalScope : WorkerGlobalScope {
//    var DOMException: Any?
//    var WorkerGlobalScope: Any?
//    fun btoa(data: String): String
//    fun atob(data: String): String
//    fun setTimeout(callback: Function<Any?> /* (...args: any[]) => void */, msDelay: Double = definedExternally): Double
//    fun <Args : Array<Any?>> setTimeout(
//        callback: Function<Any?> /* (...args: Args) => void */,
//        msDelay: Double = definedExternally,
//        vararg args: Any? /* Args */
//    ): Double
//
//    fun clearTimeout(timeoutId: Double?): Unit
//    fun setInterval(
//        callback: Function<Any?> /* (...args: any[]) => void */,
//        msDelay: Double = definedExternally
//    ): Double
//
//    fun <Args : Array<Any?>> setInterval(
//        callback: Function<Any?> /* (...args: Args) => void */,
//        msDelay: Double = definedExternally,
//        vararg args: Any? /* Args */
//    ): Double
//
//    fun clearInterval(timeoutId: Double?): Unit
//    fun queueMicrotask(task: Function): Unit
//    fun <T> structuredClone(value: T, options: StructuredSerializeOptions = definedExternally): T
//    fun fetch(input: RequestInfo, init: RequestInit<RequestInitCfProperties> = definedExternally): Promise<Response>
//    var self: ServiceWorkerGlobalScope
//    var crypto: Crypto
//    var caches: CacheStorage
//    var scheduler: Scheduler
//    var performance: Performance
//    val origin: String
//    var Event: Any?
//    var ExtendableEvent: Any?
//    var PromiseRejectionEvent: Any?
//    var FetchEvent: Any?
//    var TailEvent: Any?
//    var TraceEvent: Any?
//    var ScheduledEvent: Any?
//    var MessageEvent: Any?
//    var CloseEvent: Any?
//    var ReadableStreamDefaultReader: Any?
//    var ReadableStreamBYOBReader: Any?
////    var ReadableStream: Temp0
//    var WritableStream: Any?
//    var WritableStreamDefaultWriter: Any?
//    var TransformStream: Any?
//    var ByteLengthQueuingStrategy: Any?
//    var CountQueuingStrategy: Any?
//    var CompressionStream: Any?
//    var DecompressionStream: Any?
//    var TextEncoderStream: Any?
//    var TextDecoderStream: Any?
//    var Headers: Any?
//    var Body: Any?
//    var Request: Any?
//    var Response: Any?
//    var WebSocket: Any?
//    var WebSocketPair:()->Pair<WebSocket,WebSocket> /* new () => { 0: WebSocket; 1: WebSocket; } */
//    var WebSocketRequestResponsePair: Any?
//    var AbortController: Any?
//    var AbortSignal: Any?
//    var TextDecoder: Any?
//    var TextEncoder: Any?
//    var URL: Any?
//    var URLSearchParams: Any?
//    var URLPattern: Any?
//    var Blob: Any?
//    var File: Any?
//    var FormData: Any?
//    var Crypto: Any?
//    var SubtleCrypto: Any?
//    var CryptoKey: Any?
//    var CacheStorage: Any?
//    var Cache: Any?
//    var FixedLengthStream: Any?
//    var IdentityTransformStream: Any?
//    var HTMLRewriter: Any?
//}

//
//external fun <Type : /* keyof WorkerGlobalScopeEventMap */> addEventListener(
//    type: Type,
//    handler: EventListenerOrEventListenerObject<Any?>,
//    options: EventTargetAddEventListenerOptions = definedExternally
//): Unit
//
//external fun <Type : /* keyof WorkerGlobalScopeEventMap */> addEventListener(
//    type: Type,
//    handler: EventListenerOrEventListenerObject<Any?>,
//    options: Boolean = definedExternally
//): Unit
//
//external fun <Type : /* keyof WorkerGlobalScopeEventMap */> removeEventListener(
//    type: Type,
//    handler: EventListenerOrEventListenerObject<Any?>,
//    options: EventTargetEventListenerOptions = definedExternally
//): Unit
//
//external fun <Type : /* keyof WorkerGlobalScopeEventMap */> removeEventListener(
//    type: Type,
//    handler: EventListenerOrEventListenerObject<Any?>,
//    options: Boolean = definedExternally
//): Unit

/** Dispatches a synthetic event event to target and returns true if either event's cancelable attribute value is false or its preventDefault() method was not invoked, and false otherwise. */
external fun dispatchEvent(event: Any /* FetchEvent | ScheduledEvent | QueueEvent<unknown> | PromiseRejectionEvent */): Boolean

external fun btoa(data: String): String

external fun atob(data: String): String

external fun setTimeout(
    callback: Function<Any?> /* (...args: any[]) => void */,
    msDelay: Double = definedExternally
): Double

external fun <Args : Array<Any?>> setTimeout(
    callback: Function<Any?> /* (...args: Args) => void */,
    msDelay: Double = definedExternally,
    vararg args: Any? /* Args */
): Double

external fun clearTimeout(timeoutId: Double?): Unit

external fun setInterval(
    callback: Function<Any?> /* (...args: any[]) => void */,
    msDelay: Double = definedExternally
): Double

external fun <Args : Array<Any?>> setInterval(
    callback: Function<Any?> /* (...args: Args) => void */,
    msDelay: Double = definedExternally,
    vararg args: Any? /* Args */
): Double

external fun clearInterval(timeoutId: Double?): Unit

//external fun queueMicrotask(task: Function): Unit

external fun <T> structuredClone(value: T, options: StructuredSerializeOptions = definedExternally): T


external val self: ServiceWorkerGlobalScope

external val crypto: Crypto

external val caches: CacheStorage

external val scheduler: Scheduler

external val performance: Performance

external val origin: String


external interface TestController {

}


external class ExecutionContext {
    fun waitUntil(promise: Promise<Any?>): Unit
    fun passThroughOnException(): Unit
}


//typealias ExportedHandlerFetchHandler<Env /* default is Any? */, CfHostMetadata /* default is Any? */> = (request: Request<CfHostMetadata, IncomingRequestCfProperties<CfHostMetadata>>, env: Env, ctx: ExecutionContext) -> Any /* Response | Promise<Response> */

typealias ExportedHandlerTailHandler<Env /* default is Any? */> = (events: Array<TraceItem>, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */

typealias ExportedHandlerTraceHandler<Env /* default is Any? */> = (traces: Array<TraceItem>, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */

typealias ExportedHandlerScheduledHandler<Env /* default is Any? */> = (controller: ScheduledController, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */

typealias ExportedHandlerQueueHandler<Env /* default is Any? */, Message /* default is Any? */> = (batch: MessageBatch<Message>, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */

typealias ExportedHandlerTestHandler<Env /* default is Any? */> = (controller: TestController, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */


external interface ExportedHandler<Env /* default is Any? */, QueueHandlerMessage /* default is Any? */, CfHostMetadata /* default is Any? */> {
//    var fetch: ExportedHandlerFetchHandler<Env, CfHostMetadata>?
    var tail: ExportedHandlerTailHandler<Env>?
    var trace: ExportedHandlerTraceHandler<Env>?
    var scheduled: ExportedHandlerScheduledHandler<Env>?
    var test: ExportedHandlerTestHandler<Env>?
    var email: EmailExportedHandler<Env>?
    var queue: ExportedHandlerQueueHandler<Env, QueueHandlerMessage>?
}


external interface StructuredSerializeOptions {
    var transfer: Array<Any?>?
}


abstract external class PromiseRejectionEvent : Event {
    val promise: Promise<Any?>
    val reason: Any?
}


/** Provides access to performance-related information for the current page. It's part of the High Resolution Time API, but is enhanced by the Performance Timeline API, the Navigation Timing API, the User Timing API, and the Resource Timing API. */

external interface Performance {
    val timeOrigin: Double
    fun now(): Double
}


external interface DurableObject {
    fun fetch(request: Request): Any /* Response | Promise<Response> */
    fun alarm(): Any /* void | Promise<void> */
    fun webSocketMessage(ws: WebSocket, message: String): Any /* void | Promise<void> */

    fun webSocketMessage(ws: WebSocket, message: ArrayBuffer): Any /* void | Promise<void> */
    fun webSocketClose(ws: WebSocket, code: Double, reason: String, wasClean: Boolean): Any /* void | Promise<void> */
    fun webSocketError(ws: WebSocket, error: Any?): Any /* void | Promise<void> */
}


//external interface DurableObjectStub : Fetcher {
//    val id: DurableObjectId
//    val name: String?
//}
//
//
//external interface DurableObjectId {
//    fun toString(): String
//    fun equals(other: DurableObjectId): Boolean
//    val name: String?
//}


//external interface DurableObjectNamespace {
//    fun newUniqueId(options: DurableObjectNamespaceNewUniqueIdOptions = definedExternally): DurableObjectId
//    fun idFromName(name: String): DurableObjectId
//    fun idFromString(id: String): DurableObjectId
//    fun get(
//        id: DurableObjectId,
//        options: DurableObjectNamespaceGetDurableObjectOptions = definedExternally
//    ): DurableObjectStub
//
//    fun jurisdiction(jurisdiction: DurableObjectJurisdiction): DurableObjectNamespace
//}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{eu: 'eu', fedramp: 'fedramp'}/*union*/)""")
sealed external interface DurableObjectJurisdiction {
    companion object {
        val eu: DurableObjectJurisdiction
        val fedramp: DurableObjectJurisdiction
    }
}


external interface DurableObjectNamespaceNewUniqueIdOptions {
    var jurisdiction: DurableObjectJurisdiction?
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{wnam: 'wnam', enam: 'enam', sam: 'sam', weur: 'weur', eeur: 'eeur', apac: 'apac', oc: 'oc', afr: 'afr', me: 'me'}/*union*/)""")
sealed external interface DurableObjectLocationHint {
    companion object {
        val wnam: DurableObjectLocationHint
        val enam: DurableObjectLocationHint
        val sam: DurableObjectLocationHint
        val weur: DurableObjectLocationHint
        val eeur: DurableObjectLocationHint
        val apac: DurableObjectLocationHint
        val oc: DurableObjectLocationHint
        val afr: DurableObjectLocationHint
        val me: DurableObjectLocationHint
    }
}


external interface DurableObjectNamespaceGetDurableObjectOptions {
    var locationHint: DurableObjectLocationHint?
}


external interface DurableObjectState {
    fun waitUntil(promise: Promise<Any?>): Unit
//    val id: DurableObjectId
    val storage: DurableObjectStorage
    fun <T> blockConcurrencyWhile(callback: () -> Promise<T>): Promise<T>
    fun acceptWebSocket(ws: WebSocket, tags: Array<String> = definedExternally): Unit
    fun getWebSockets(tag: String = definedExternally): Array<WebSocket>
    fun setWebSocketAutoResponse(maybeReqResp: WebSocketRequestResponsePair = definedExternally): Unit
    fun getWebSocketAutoResponse(): WebSocketRequestResponsePair?
    fun getWebSocketAutoResponseTimestamp(ws: WebSocket): Date?
}


external interface DurableObjectTransaction {
    fun <T /* default is Any? */> get(key: String, options: DurableObjectGetOptions = definedExternally): Promise<T?>
    fun <T /* default is Any? */> get(
        keys: Array<String>,
        options: DurableObjectGetOptions = definedExternally
    ): Promise<Map<String, T>>

    fun <T /* default is Any? */> list(options: DurableObjectListOptions = definedExternally): Promise<Map<String, T>>
    fun <T> put(key: String, value: T, options: DurableObjectPutOptions = definedExternally): Promise<Unit>
    fun <T> put(entries: Record<String, T>, options: DurableObjectPutOptions = definedExternally): Promise<Unit>
    fun delete(key: String, options: DurableObjectPutOptions = definedExternally): Promise<Boolean>
    fun delete(keys: Array<String>, options: DurableObjectPutOptions = definedExternally): Promise<Double>
    fun rollback(): Unit
    fun getAlarm(options: DurableObjectGetAlarmOptions = definedExternally): Promise<Double?>
    fun setAlarm(scheduledTime: Double, options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>

    fun setAlarm(scheduledTime: Date, options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>
    fun deleteAlarm(options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>
}


external interface DurableObjectStorage {
    fun <T /* default is Any? */> get(key: String, options: DurableObjectGetOptions = definedExternally): Promise<T?>
    fun <T /* default is Any? */> get(
        keys: Array<String>,
        options: DurableObjectGetOptions = definedExternally
    ): Promise<Map<String, T>>

    fun <T /* default is Any? */> list(options: DurableObjectListOptions = definedExternally): Promise<Map<String, T>>
    fun <T> put(key: String, value: T, options: DurableObjectPutOptions = definedExternally): Promise<Unit>
    fun <T> put(entries: Record<String, T>, options: DurableObjectPutOptions = definedExternally): Promise<Unit>
    fun delete(key: String, options: DurableObjectPutOptions = definedExternally): Promise<Boolean>
    fun delete(keys: Array<String>, options: DurableObjectPutOptions = definedExternally): Promise<Double>
    fun deleteAll(options: DurableObjectPutOptions = definedExternally): Promise<Unit>
    fun <T> transaction(closure: (txn: DurableObjectTransaction) -> Promise<T>): Promise<T>
    fun getAlarm(options: DurableObjectGetAlarmOptions = definedExternally): Promise<Double?>
    fun setAlarm(scheduledTime: Double, options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>

    fun setAlarm(scheduledTime: Date, options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>
    fun deleteAlarm(options: DurableObjectSetAlarmOptions = definedExternally): Promise<Unit>
    fun sync(): Promise<Unit>
    fun <T> transactionSync(closure: () -> T): T
}


external interface DurableObjectListOptions {
    var start: String?
    var startAfter: String?
    var end: String?
    var prefix: String?
    var reverse: Boolean?
    var limit: Double?
    var allowConcurrency: Boolean?
    var noCache: Boolean?
}


external interface DurableObjectGetOptions {
    var allowConcurrency: Boolean?
    var noCache: Boolean?
}


external interface DurableObjectGetAlarmOptions {
    var allowConcurrency: Boolean?
}


external interface DurableObjectPutOptions {
    var allowConcurrency: Boolean?
    var allowUnconfirmed: Boolean?
    var noCache: Boolean?
}


external interface DurableObjectSetAlarmOptions {
    var allowConcurrency: Boolean?
    var allowUnconfirmed: Boolean?
}


external class WebSocketRequestResponsePair {
    constructor (request: String, response: String)

    val request: String


    val response: String

}


external interface AnalyticsEngineDataset {
    fun writeDataPoint(event: AnalyticsEngineDataPoint = definedExternally): Unit
}


external interface AnalyticsEngineDataPoint {
    var indexes: Array<((Any /* (ArrayBuffer | string) | null */)?)>?
    var doubles: Array<Double>?
    var blobs: Array<((Any /* (ArrayBuffer | string) | null */)?)>?
}


external interface Event {
//    constructor (type: String, init: EventInit = definedExternally)

    /** Returns the type of event, e.g. "click", "hashchange", or "submit". */
    val type: String

    /** Returns the event's phase, which is one of NONE, CAPTURING_PHASE, AT_TARGET, and BUBBLING_PHASE. */
    val eventPhase: Double

    /** Returns true or false depending on how event was initialized. True if event invokes listeners past a ShadowRoot node that is the root of its target, and false otherwise. */
    val composed: Boolean

    /** Returns true or false depending on how event was initialized. True if event goes through its target's ancestors in reverse tree order, and false otherwise. */
    val bubbles: Boolean

    /** Returns true or false depending on how event was initialized. Its return value does not always carry meaning, but true can indicate that part of the operation during which event was dispatched, can be canceled by invoking the preventDefault() method. */
    val cancelable: Boolean

    /** Returns true if preventDefault() was invoked successfully to indicate cancelation, and false otherwise. */
    val defaultPrevented: Boolean

    /** @deprecated */
    val returnValue: Boolean

    /** Returns the object whose event listener's callback is currently being invoked. */
    val currentTarget: EventTarget?

    /** @deprecated */
    val srcElement: EventTarget?

    /** Returns the event's timestamp as the number of milliseconds measured relative to the time origin. */
    val timeStamp: Double

    /** Returns true if event was dispatched by the user agent, and false otherwise. */
    val isTrusted: Boolean
    var cancelBubble: Boolean
    fun stopImmediatePropagation(): Unit
    fun preventDefault(): Unit
    fun stopPropagation(): Unit
    fun composedPath(): Array<EventTarget>

//    companion object {
//        val NONE: Double
//        val CAPTURING_PHASE: Double
//        val AT_TARGET: Double
//        val BUBBLING_PHASE: Double
//    }

}


external interface EventInit {
    var bubbles: Boolean?
    var cancelable: Boolean?
    var composed: Boolean?
}


typealias EventListener = (event: Event) -> Unit


external interface EventListenerObject<EventType : Event /* default is Event */> {
    fun handleEvent(event: EventType): Unit
}


//typealias EventListenerOrEventListenerObject<EventType : Event /* default is Event */> = Any /* EventListener<EventType> | EventListenerObject<EventType> */


//open external class EventTarget<EventMap : Record<String, Event> /* default is Record<String, Event> */> {
//    constructor ()
//
//    fun <Type : /* keyof EventMap */> addEventListener(
//        type: Type,
//        handler: EventListenerOrEventListenerObject<Any?>,
//        options: EventTargetAddEventListenerOptions = definedExternally
//    ): Unit
//
//    fun <Type : /* keyof EventMap */> addEventListener(
//        type: Type,
//        handler: EventListenerOrEventListenerObject<Any?>,
//        options: Boolean = definedExternally
//    ): Unit
//
//    fun <Type : /* keyof EventMap */> removeEventListener(
//        type: Type,
//        handler: EventListenerOrEventListenerObject<Any?>,
//        options: EventTargetEventListenerOptions = definedExternally
//    ): Unit
//
//    fun <Type : /* keyof EventMap */> removeEventListener(
//        type: Type,
//        handler: EventListenerOrEventListenerObject<Any?>,
//        options: Boolean = definedExternally
//    ): Unit
//
//    fun dispatchEvent(event: Any?): Boolean
//}


external interface EventTargetEventListenerOptions {
    var capture: Boolean?
}


external interface EventTargetAddEventListenerOptions {
    var capture: Boolean?
    var passive: Boolean?
    var once: Boolean?
    var signal: AbortSignal?
}


external interface EventTargetHandlerObject {
    var handleEvent: (event: Event) -> Any??
}


external class AbortController {
    constructor ()

    /** Returns the AbortSignal object associated with this object. */
    val signal: AbortSignal
    fun abort(reason: Any? = definedExternally): Unit
}


external class AbortSignal : EventTarget {
    /** Returns true if this AbortSignal's AbortController has signaled to abort, and false otherwise. */
    val aborted: Boolean
    val reason: Any?
    fun throwIfAborted(): Unit

    companion object {
        fun abort(reason: Any? = definedExternally): AbortSignal
        fun timeout(delay: Double): AbortSignal
        fun any(signals: Array<AbortSignal>): AbortSignal
    }

}


external interface Scheduler {
    fun wait(delay: Double, maybeOptions: SchedulerWaitOptions = definedExternally): Promise<Unit>
}


external interface SchedulerWaitOptions {
    var signal: AbortSignal?
}


external interface ExtendableEvent : Event {
    fun waitUntil(promise: Promise<Any?>): Unit
}


open external class Blob {
    constructor (
        bits: Array<(Any /* (ArrayBuffer | ArrayBufferView) | string | Blob */)> = definedExternally,
        options: BlobOptions = definedExternally
    )

    val size: Double
    val type: String
    fun slice(
        start: Double = definedExternally,
        end: Double = definedExternally,
        type: String = definedExternally
    ): Blob

    fun arrayBuffer(): Promise<ArrayBuffer>
    fun text(): Promise<String>
    fun stream(): ReadableStream<Any>
}


external interface BlobOptions {
    var type: String?
}


external class File : Blob {
    constructor (
        bits: Array<(Any /* (ArrayBuffer | ArrayBufferView) | string | Blob */)>?,
        name: String,
        options: FileOptions = definedExternally
    )

    val name: String
    val lastModified: Double
}


external interface FileOptions {
    var type: String?
    var lastModified: Double?
}


external class CacheStorage {
    fun open(cacheName: String): Promise<Cache>
    val default: Cache
}


external class Cache {
    fun delete(request: RequestInfo, options: CacheQueryOptions = definedExternally): Promise<Boolean>
    fun match(request: RequestInfo, options: CacheQueryOptions = definedExternally): Promise<Response?>
    fun put(request: RequestInfo, response: Response): Promise<Unit>
}


external interface CacheQueryOptions {
    var ignoreMethod: Boolean?
}


external class Crypto {
    /** Available only in secure contexts. */
    val subtle: SubtleCrypto
    fun <T : Any /* Int8Array | Uint8Array | Int16Array | Uint16Array | Int32Array | Uint32Array | BigInt64Array | BigUint64Array */> getRandomValues(
        buffer: T
    ): T

    fun randomUUID(): String
    var DigestStream: Any?
}


external class SubtleCrypto {
    fun encrypt(algorithm: String, key: CryptoKey, plainText: ArrayBuffer): Promise<ArrayBuffer>

    fun encrypt(algorithm: String, key: CryptoKey, plainText: ArrayBufferView): Promise<ArrayBuffer>

    fun encrypt(algorithm: SubtleCryptoEncryptAlgorithm, key: CryptoKey, plainText: ArrayBuffer): Promise<ArrayBuffer>

    fun encrypt(
        algorithm: SubtleCryptoEncryptAlgorithm,
        key: CryptoKey,
        plainText: ArrayBufferView
    ): Promise<ArrayBuffer>

    fun decrypt(algorithm: String, key: CryptoKey, cipherText: ArrayBuffer): Promise<ArrayBuffer>

    fun decrypt(algorithm: String, key: CryptoKey, cipherText: ArrayBufferView): Promise<ArrayBuffer>

    fun decrypt(algorithm: SubtleCryptoEncryptAlgorithm, key: CryptoKey, cipherText: ArrayBuffer): Promise<ArrayBuffer>

    fun decrypt(
        algorithm: SubtleCryptoEncryptAlgorithm,
        key: CryptoKey,
        cipherText: ArrayBufferView
    ): Promise<ArrayBuffer>

    fun sign(algorithm: String, key: CryptoKey, data: ArrayBuffer): Promise<ArrayBuffer>

    fun sign(algorithm: String, key: CryptoKey, data: ArrayBufferView): Promise<ArrayBuffer>

    fun sign(algorithm: SubtleCryptoSignAlgorithm, key: CryptoKey, data: ArrayBuffer): Promise<ArrayBuffer>

    fun sign(algorithm: SubtleCryptoSignAlgorithm, key: CryptoKey, data: ArrayBufferView): Promise<ArrayBuffer>
    fun verify(algorithm: String, key: CryptoKey, signature: ArrayBuffer, data: ArrayBuffer): Promise<Boolean>

    fun verify(algorithm: String, key: CryptoKey, signature: ArrayBuffer, data: ArrayBufferView): Promise<Boolean>

    fun verify(algorithm: String, key: CryptoKey, signature: ArrayBufferView, data: ArrayBuffer): Promise<Boolean>

    fun verify(algorithm: String, key: CryptoKey, signature: ArrayBufferView, data: ArrayBufferView): Promise<Boolean>

    fun verify(
        algorithm: SubtleCryptoSignAlgorithm,
        key: CryptoKey,
        signature: ArrayBuffer,
        data: ArrayBuffer
    ): Promise<Boolean>

    fun verify(
        algorithm: SubtleCryptoSignAlgorithm,
        key: CryptoKey,
        signature: ArrayBuffer,
        data: ArrayBufferView
    ): Promise<Boolean>

    fun verify(
        algorithm: SubtleCryptoSignAlgorithm,
        key: CryptoKey,
        signature: ArrayBufferView,
        data: ArrayBuffer
    ): Promise<Boolean>

    fun verify(
        algorithm: SubtleCryptoSignAlgorithm,
        key: CryptoKey,
        signature: ArrayBufferView,
        data: ArrayBufferView
    ): Promise<Boolean>

    fun digest(algorithm: String, data: ArrayBuffer): Promise<ArrayBuffer>

    fun digest(algorithm: String, data: ArrayBufferView): Promise<ArrayBuffer>

    fun digest(algorithm: SubtleCryptoHashAlgorithm, data: ArrayBuffer): Promise<ArrayBuffer>

    fun digest(algorithm: SubtleCryptoHashAlgorithm, data: ArrayBufferView): Promise<ArrayBuffer>
    fun generateKey(
        algorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<Any /* CryptoKey | CryptoKeyPair */>

    fun generateKey(
        algorithm: SubtleCryptoGenerateKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<Any /* CryptoKey | CryptoKeyPair */>

    fun deriveKey(
        algorithm: String,
        baseKey: CryptoKey,
        derivedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun deriveKey(
        algorithm: String,
        baseKey: CryptoKey,
        derivedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun deriveKey(
        algorithm: SubtleCryptoDeriveKeyAlgorithm,
        baseKey: CryptoKey,
        derivedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun deriveKey(
        algorithm: SubtleCryptoDeriveKeyAlgorithm,
        baseKey: CryptoKey,
        derivedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun deriveBits(algorithm: String, baseKey: CryptoKey, length: Double?): Promise<ArrayBuffer>

    fun deriveBits(algorithm: SubtleCryptoDeriveKeyAlgorithm, baseKey: CryptoKey, length: Double?): Promise<ArrayBuffer>
    fun importKey(
        format: String,
        keyData: ArrayBuffer,
        algorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun importKey(
        format: String,
        keyData: ArrayBuffer,
        algorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun importKey(
        format: String,
        keyData: ArrayBufferView,
        algorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun importKey(
        format: String,
        keyData: ArrayBufferView,
        algorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun importKey(
        format: String,
        keyData: JsonWebKey,
        algorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun importKey(
        format: String,
        keyData: JsonWebKey,
        algorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun exportKey(format: String, key: CryptoKey): Promise<Any /* ArrayBuffer | JsonWebKey */>
    fun wrapKey(format: String, key: CryptoKey, wrappingKey: CryptoKey, wrapAlgorithm: String): Promise<ArrayBuffer>

    fun wrapKey(
        format: String,
        key: CryptoKey,
        wrappingKey: CryptoKey,
        wrapAlgorithm: SubtleCryptoEncryptAlgorithm
    ): Promise<ArrayBuffer>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBuffer,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: String,
        unwrappedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBuffer,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: String,
        unwrappedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBuffer,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: SubtleCryptoEncryptAlgorithm,
        unwrappedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBuffer,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: SubtleCryptoEncryptAlgorithm,
        unwrappedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBufferView,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: String,
        unwrappedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBufferView,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: String,
        unwrappedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBufferView,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: SubtleCryptoEncryptAlgorithm,
        unwrappedKeyAlgorithm: String,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun unwrapKey(
        format: String,
        wrappedKey: ArrayBufferView,
        unwrappingKey: CryptoKey,
        unwrapAlgorithm: SubtleCryptoEncryptAlgorithm,
        unwrappedKeyAlgorithm: SubtleCryptoImportKeyAlgorithm,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<CryptoKey>

    fun timingSafeEqual(a: ArrayBuffer, b: ArrayBuffer): Boolean

    fun timingSafeEqual(a: ArrayBuffer, b: ArrayBufferView): Boolean

    fun timingSafeEqual(a: ArrayBufferView, b: ArrayBuffer): Boolean

    fun timingSafeEqual(a: ArrayBufferView, b: ArrayBufferView): Boolean
}


external class CryptoKey {
    val type: String
    val extractable: Boolean
    val algorithm: Any /* CryptoKeyKeyAlgorithm | CryptoKeyAesKeyAlgorithm | CryptoKeyHmacKeyAlgorithm | CryptoKeyRsaKeyAlgorithm | CryptoKeyEllipticKeyAlgorithm | CryptoKeyArbitraryKeyAlgorithm */
    val usages: Array<String>
}


external interface CryptoKeyPair {
    var publicKey: CryptoKey
    var privateKey: CryptoKey
}


external interface JsonWebKey {
    var kty: String
    var use: String?
    var key_ops: Array<String>?
    var alg: String?
    var ext: Boolean?
    var crv: String?
    var x: String?
    var y: String?
    var d: String?
    var n: String?
    var e: String?
    var p: String?
    var q: String?
    var dp: String?
    var dq: String?
    var qi: String?
    var oth: Array<RsaOtherPrimesInfo>?
    var k: String?
}


external interface RsaOtherPrimesInfo {
    var r: String?
    var d: String?
    var t: String?
}


external interface SubtleCryptoDeriveKeyAlgorithm {
    var name: String
    var salt: ArrayBuffer?
    var iterations: Double?
    var hash: (Any /* string | SubtleCryptoHashAlgorithm */)?
    var `public`: CryptoKey?
    var info: ArrayBuffer?
}


external interface SubtleCryptoEncryptAlgorithm {
    var name: String
    var iv: ArrayBuffer?
    var additionalData: ArrayBuffer?
    var tagLength: Double?
    var counter: ArrayBuffer?
    var length: Double?
    var label: ArrayBuffer?
}


external interface SubtleCryptoGenerateKeyAlgorithm {
    var name: String
    var hash: (Any /* string | SubtleCryptoHashAlgorithm */)?
    var modulusLength: Double?
    var publicExponent: ArrayBuffer?
    var length: Double?
    var namedCurve: String?
}


external interface SubtleCryptoHashAlgorithm {
    var name: String
}


external interface SubtleCryptoImportKeyAlgorithm {
    var name: String
    var hash: (Any /* string | SubtleCryptoHashAlgorithm */)?
    var length: Double?
    var namedCurve: String?
    var compressed: Boolean?
}


external interface SubtleCryptoSignAlgorithm {
    var name: String
    var hash: (Any /* string | SubtleCryptoHashAlgorithm */)?
    var dataLength: Double?
    var saltLength: Double?
}


external interface CryptoKeyKeyAlgorithm {
    var name: String
}


external interface CryptoKeyAesKeyAlgorithm {
    var name: String
    var length: Double
}


external interface CryptoKeyHmacKeyAlgorithm {
    var name: String
    var hash: CryptoKeyKeyAlgorithm
    var length: Double
}


external interface CryptoKeyRsaKeyAlgorithm {
    var name: String
    var modulusLength: Double
    var publicExponent: ArrayBuffer
    var hash: CryptoKeyKeyAlgorithm?
}


external interface CryptoKeyEllipticKeyAlgorithm {
    var name: String
    var namedCurve: String
}


external interface CryptoKeyArbitraryKeyAlgorithm {
    var name: String
    var hash: CryptoKeyKeyAlgorithm?
    var namedCurve: String?
    var length: Double?
}


external class DigestStream : WritableStream<Any /* ArrayBuffer | ArrayBufferView */> {
    constructor (algorithm: String)

    constructor (algorithm: SubtleCryptoHashAlgorithm)

    val digest: Promise<ArrayBuffer>
}


external class TextDecoder {
    constructor (decoder: String = definedExternally, options: TextDecoderConstructorOptions = definedExternally)

    fun decode(input: ArrayBuffer = definedExternally, options: TextDecoderDecodeOptions = definedExternally): String

    fun decode(
        input: ArrayBufferView = definedExternally,
        options: TextDecoderDecodeOptions = definedExternally
    ): String

    val encoding: String
    val fatal: Boolean
    val ignoreBOM: Boolean
}


external class TextEncoder {
    constructor ()

    fun encode(input: String = definedExternally): Uint8Array
    fun encodeInto(input: String, buffer: Uint8Array): TextEncoderEncodeIntoResult
    val encoding: String
}


external interface TextDecoderConstructorOptions {
    var fatal: Boolean
    var ignoreBOM: Boolean
}


external interface TextDecoderDecodeOptions {
    var stream: Boolean
}


external interface TextEncoderEncodeIntoResult {
    var read: Double
    var written: Double
}


external class FormData {
    constructor ()

    fun append(name: String, value: String): Unit
    fun append(name: String, value: Blob, filename: String = definedExternally): Unit
    fun delete(name: String): Unit
    fun get(name: String): String?
    fun getAll(name: String): Array<String>
    fun has(name: String): Boolean
    fun set(name: String, value: String): Unit
    fun set(name: String, value: Blob, filename: String = definedExternally): Unit
//    fun entries(): IterableIterator</* [
//    key: string,
//    value: string
//] */>

    //    fun keys(): IterableIterator<String>
//    fun values(): IterableIterator<Any /* File | string */>
    fun <This /* default is Any? */> forEach(
        callback: (`this`: This, value: String, key: String, parent: FormData) -> Unit,
        thisArg: This = definedExternally
    ): Unit
}


external interface ContentOptions {
    var html: Boolean?
}


external class HTMLRewriter {
    constructor ()

    fun on(selector: String, handlers: HTMLRewriterElementContentHandlers): HTMLRewriter
    fun onDocument(handlers: HTMLRewriterDocumentContentHandlers): HTMLRewriter
    fun transform(response: Response): Response
}


external interface HTMLRewriterElementContentHandlers {
    fun element(element: Element): Any /* void | Promise<void> */
    fun comments(comment: Comment): Any /* void | Promise<void> */
    fun text(element: Text): Any /* void | Promise<void> */
}


external interface HTMLRewriterDocumentContentHandlers {
    fun doctype(doctype: Doctype): Any /* void | Promise<void> */
    fun comments(comment: Comment): Any /* void | Promise<void> */
    fun text(text: Text): Any /* void | Promise<void> */
    fun end(end: DocumentEnd): Any /* void | Promise<void> */
}


external interface Doctype {
    val name: String?
    val publicId: String?
    val systemId: String?
}


external interface Element {
    var tagName: String
    val attributes: IterableIterator<Array<String>>
    val removed: Boolean
    val namespaceURI: String
    fun getAttribute(name: String): String?
    fun hasAttribute(name: String): Boolean
    fun setAttribute(name: String, value: String): Element
    fun removeAttribute(name: String): Element
    fun before(content: String, options: ContentOptions = definedExternally): Element
    fun after(content: String, options: ContentOptions = definedExternally): Element
    fun prepend(content: String, options: ContentOptions = definedExternally): Element
    fun append(content: String, options: ContentOptions = definedExternally): Element
    fun replace(content: String, options: ContentOptions = definedExternally): Element
    fun remove(): Element
    fun removeAndKeepContent(): Element
    fun setInnerContent(content: String, options: ContentOptions = definedExternally): Element
    fun onEndTag(handler: (tag: EndTag) -> Any /* void | Promise<void> */): Unit
}


external interface EndTag {
    var name: String
    fun before(content: String, options: ContentOptions = definedExternally): EndTag
    fun after(content: String, options: ContentOptions = definedExternally): EndTag
    fun remove(): EndTag
}


external interface Comment {
    var text: String
    val removed: Boolean
    fun before(content: String, options: ContentOptions = definedExternally): Comment
    fun after(content: String, options: ContentOptions = definedExternally): Comment
    fun replace(content: String, options: ContentOptions = definedExternally): Comment
    fun remove(): Comment
}


external interface Text {
    val text: String
    val lastInTextNode: Boolean
    val removed: Boolean
    fun before(content: String, options: ContentOptions = definedExternally): Text
    fun after(content: String, options: ContentOptions = definedExternally): Text
    fun replace(content: String, options: ContentOptions = definedExternally): Text
    fun remove(): Text
}


external interface DocumentEnd {
    fun append(content: String, options: ContentOptions = definedExternally): DocumentEnd
}


abstract external class FetchEvent : ExtendableEvent {
    val request: Request
    fun respondWith(promise: Response): Unit

    fun respondWith(promise: Promise<Response>): Unit
    fun passThroughOnException(): Unit
}


typealias HeadersInit = Any /* Headers | Iterable<Iterable<string>> | Record<string, string> */

typealias IterableIterator<T> = Collection<T>

//external class Headers {
//    constructor (init: HeadersInit = definedExternally)
//
//    fun get(name: String): String?
//    fun getAll(name: String): Array<String>
//    fun has(name: String): Boolean
//    fun set(name: String, value: String): Unit
//    fun append(name: String, value: String): Unit
//    fun delete(name: String): Unit
//    fun <This /* default is Any? */> forEach(
//        callback: (`this`: This, value: String, key: String, parent: Headers) -> Unit,
//        thisArg: This = definedExternally
//    ): Unit
////
////    fun entries(): IterableIterator<></* [
////    key: string,
////    value: string
////] */>
//
//    fun keys(): IterableIterator<String>
//    fun values(): IterableIterator<String>
//}


typealias BodyInit = Any /* ReadableStream<Uint8Array> | string | ArrayBuffer | ArrayBufferView | Blob | URLSearchParams | FormData */


external interface Body {
    val body: ReadableStream<Uint8Array>?
    val bodyUsed: Boolean
    fun arrayBuffer(): Promise<ArrayBuffer>
    fun text(): Promise<String>
    fun <T> json(): Promise<T>
    fun formData(): Promise<FormData>
    fun blob(): Promise<Blob>
}


//abstract external class Response(body: BodyInit? = definedExternally, init: ResponseInit = definedExternally) : Body {
//
//    fun clone(): Response
//    val status: Double
//    val statusText: String
//    val headers: Headers
//    val ok: Boolean
//    val redirected: Boolean
//    val url: String
//    val webSocket: WebSocket?
//    val cf: Any?
//
//    companion object {
//        fun redirect(url: String, status: Double = definedExternally): Response
//        fun json(any: Any?, maybeInit: ResponseInit = definedExternally): Response
//
//        fun json(any: Any?, maybeInit: Response = definedExternally): Response
//    }
//
//}


external interface ResponseInit {
    var status: Double?
    var statusText: String?
    var headers: HeadersInit?
    var cf: Any?
    var webSocket: WebSocket?
    var encodeBody: (ResponseInitEncodeBody)?
}

//
//typealias RequestInfo = Request /* Request<CfHostMetadata, Cf> | string | URL */
//
//
//abstract external class Request : Body {
//    constructor (input: Request, init: RequestInit<dynamic> = definedExternally)
//
//    fun clone(): Request<dynamic, dynamic>
//
//    /** Returns request's HTTP method, which is "GET" by default. */
//    val method: String
//
//    /** Returns the URL of request as a string. */
//    val url: String
//
//    /** Returns a Headers object consisting of the headers associated with request. Note that headers added in the network layer by the user agent will not be accounted for in this object, e.g., the "Host" header. */
//    val headers: Headers
//
//    /** Returns the redirect mode associated with request, which is a string indicating how redirects for the request will be handled during fetching. A request will follow redirects by default. */
//    val redirect: String
//    val fetcher: Fetcher?
//
//    /** Returns the signal associated with request, which is an AbortSignal object indicating whether or not request has been aborted, and its abort event handler. */
//    val signal: AbortSignal
////    val cf: Cf?
//
//    /** Returns request's subresource integrity metadata, which is a cryptographic hash of the resource being fetched. Its value consists of multiple hashes separated by whitespace. [SRI] */
//    val integrity: String
//
//    /** Returns a boolean indicating whether or not request can outlive the global in which it was created. */
//    val keepalive: Boolean
//}
//
//
//external interface RequestInit<Cf /* default is CfProperties */> {
//    /** A string to set request's method. */
//    var method: String?
//
//    /** A Headers object, an object literal, or an array of two-item arrays to set request's headers. */
//    var headers: HeadersInit?
//
//    /** A BodyInit object or null to set request's body. */
//    var body: BodyInit?
//
//    /** A string indicating whether request follows redirects, results in an error upon encountering a redirect, or returns the redirect (in an opaque fashion). Sets request's redirect. */
//    var redirect: String?
//    var fetcher: Fetcher?
//    var cf: Cf?
//
//    /** A cryptographic hash of the resource to be fetched by request. Sets request's integrity. */
//    var integrity: String?
//
//    /** An AbortSignal to set request's signal. */
//    var signal: AbortSignal?
//}

typealias RequestInfo = Request

open external class Fetcher {
    fun fetch(input: RequestInfo, init: RequestInit = definedExternally): Promise<Response>
    fun connect(address: SocketAddress, options: SocketOptions = definedExternally): Socket

    fun connect(address: String, options: SocketOptions = definedExternally): Socket
}


external interface FetcherPutOptions {
    var expiration: Double?
    var expirationTtl: Double?
}


external interface KVNamespaceListKey<Metadata  /* default is String */> {
    var name: String
    var expiration: Double?
    var metadata: Metadata?
}


typealias KVNamespaceListResult<Metadata, Key /* default is String */> = Any /* {
    list_complete: false;
    keys: KVNamespaceListKey<Metadata, Key>[];
    cursor: string;
    cacheStatus: string | null;
} | {
    list_complete: true;
    keys: KVNamespaceListKey<Metadata, Key>[];
    cacheStatus: string | null;
} */


//external interface KVNamespace<Key /* default is String */> {
////    fun get(key: Key, options: Partial<KVNamespaceGetOptions<Nothing?>> = definedExternally): Promise<String?>
//    fun get(key: Key, type: String /* "text" */): Promise<String?>
//    fun <ExpectedValue /* default is Any? */> get(key: Key, type: String /* "json" */): Promise<ExpectedValue?>
//    fun get(key: Key, type: String /* "arrayBuffer" */): Promise<ArrayBuffer?>
//    fun get(key: Key, type: String /* "stream" */): Promise<ReadableStream?>
//    fun get(
//        key: Key,
//        options: KVNamespaceGetOptions<String /* "stream" */> = definedExternally
//    ): Promise<ReadableStream?>
//
//    fun <Metadata /* default is Any? */> list(options: KVNamespaceListOptions = definedExternally): Promise<KVNamespaceListResult<Metadata, Key>>
//    fun put(key: Key, value: String, options: KVNamespacePutOptions = definedExternally): Promise<Unit>
//
//    fun put(key: Key, value: ArrayBuffer, options: KVNamespacePutOptions = definedExternally): Promise<Unit>
//
//    fun put(key: Key, value: ArrayBufferView, options: KVNamespacePutOptions = definedExternally): Promise<Unit>
//
//    fun put(key: Key, value: ReadableStream, options: KVNamespacePutOptions = definedExternally): Promise<Unit>
//    fun <Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        options: Partial<KVNamespaceGetOptions<Nothing?>> = definedExternally
//    ): Promise<KVNamespaceGetWithMetadataResult<String, Metadata>>
//
//    fun <Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        type: String /* "text" */
//    ): Promise<KVNamespaceGetWithMetadataResult<String, Metadata>>
//
//    fun <ExpectedValue /* default is Any? */, Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        type: String /* "json" */
//    ): Promise<KVNamespaceGetWithMetadataResult<ExpectedValue, Metadata>>
//
//    fun <Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        type: String /* "arrayBuffer" */
//    ): Promise<KVNamespaceGetWithMetadataResult<ArrayBuffer, Metadata>>
//
//    fun <Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        type: String /* "stream" */
//    ): Promise<KVNamespaceGetWithMetadataResult<ReadableStream, Metadata>>
//
//    fun <Metadata /* default is Any? */> getWithMetadata(
//        key: Key,
//        options: KVNamespaceGetOptions<String /* "stream" */>
//    ): Promise<KVNamespaceGetWithMetadataResult<ReadableStream, Metadata>>
//
//    fun delete(key: Key): Promise<Unit>
//}


external interface KVNamespaceListOptions {
    var limit: Double?
    var prefix: String?
    var cursor: String?
}


external interface KVNamespaceGetOptions<Type> {
    var type: Type
    var cacheTtl: Double?
}


external interface KVNamespacePutOptions {
    var expiration: Double?
    var expirationTtl: Double?
    var metadata: Any??
}


external interface KVNamespaceGetWithMetadataResult<Value, Metadata> {
    var value: Value?
    var metadata: Metadata?
    var cacheStatus: String?
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{text: 'text', bytes: 'bytes', json: 'json', v8: 'v8'}/*union*/)""")
sealed external interface QueueContentType {
    companion object {
        val text: QueueContentType
        val bytes: QueueContentType
        val json: QueueContentType
        val v8: QueueContentType
    }
}


external interface Queue<Body /* default is Any? */> {
    fun send(message: Body, options: QueueSendOptions = definedExternally): Promise<Unit>
    fun sendBatch(messages: Iterable<MessageSendRequest<Body>>): Promise<Unit>
}


external interface QueueSendOptions {
    var contentType: QueueContentType?
}


external interface MessageSendRequest<Body /* default is Any? */> {
    var body: Body
    var contentType: QueueContentType?
}


external interface Message<Body /* default is Any? */> {
    val id: String
    val timestamp: Date
    val body: Body
    fun retry(): Unit
    fun ack(): Unit
}


external interface QueueEvent<Body /* default is Any? */> : ExtendableEvent {
    val messages: Array<out Message<Body>>
    val queue: String
    fun retryAll(): Unit
    fun ackAll(): Unit
}


external interface MessageBatch<Body /* default is Any? */> {
    val messages: Array<out Message<Body>>
    val queue: String
    fun retryAll(): Unit
    fun ackAll(): Unit
}

//region R2
//external class R2Error : Error {
//    val name: String
//    val code: Double
//    override val message: kotlin.String?
//    val action: String
//    val stack: Any?
//}
//
//
//external interface R2ListOptions {
//    var limit: Double?
//    var prefix: String?
//    var cursor: String?
//    var delimiter: String?
//    var startAfter: String?
//}
//
//
//external class R2Bucket {
//    fun head(key: String): Promise<R2Object?>
//    fun get(
//        key: String, options: Any /* R2GetOptions & {
//    onlyIf: R2Conditional | Headers;
//} */
//    ): Promise<(Any /* R2ObjectBody | R2Object | null */)?>
//
//    fun get(key: String, options: R2GetOptions = definedExternally): Promise<R2ObjectBody?>
//    fun put(key: String, value: ReadableStream?, options: R2PutOptions = definedExternally): Promise<R2Object>
//
//    fun put(key: String, value: ArrayBuffer?, options: R2PutOptions = definedExternally): Promise<R2Object>
//
//    fun put(key: String, value: ArrayBufferView?, options: R2PutOptions = definedExternally): Promise<R2Object>
//
//    fun put(key: String, value: String?, options: R2PutOptions = definedExternally): Promise<R2Object>
//
//    fun put(key: String, value: Blob?, options: R2PutOptions = definedExternally): Promise<R2Object>
//    fun put(
//        key: String, value: ReadableStream?, options: Any /* R2PutOptions & {
//    onlyIf: R2Conditional | Headers;
//} */ = definedExternally
//    ): Promise<R2Object?>
//
//    fun put(
//        key: String, value: ArrayBuffer?, options: Any /* R2PutOptions & {
//    onlyIf: R2Conditional | Headers;
//} */ = definedExternally
//    ): Promise<R2Object?>
//
//    fun put(
//        key: String, value: ArrayBufferView?, options: Any /* R2PutOptions & {
//    onlyIf: R2Conditional | Headers;
//} */ = definedExternally
//    ): Promise<R2Object?>
//
//    fun put(
//        key: String, value: String?, options: Any /* R2PutOptions & {
//    onlyIf: R2Conditional | Headers;
//} */ = definedExternally
//    ): Promise<R2Object?>
//
//    fun put(
//        key: String, value: Blob?, options: Any /* R2PutOptions & {
//    onlyIf: R2Conditional | Headers;
//} */ = definedExternally
//    ): Promise<R2Object?>
//
//    fun createMultipartUpload(key: String, options: R2MultipartOptions = definedExternally): Promise<R2MultipartUpload>
//    fun resumeMultipartUpload(key: String, uploadId: String): R2MultipartUpload
//    fun delete(keys: String): Promise<Unit>
//
//    fun delete(keys: Array<String>): Promise<Unit>
//    fun list(options: R2ListOptions = definedExternally): Promise<R2Objects>
//}
//
//
//external interface R2MultipartUpload {
//    val key: String
//    val uploadId: String
//    fun uploadPart(partNumber: Double, value: ReadableStream): Promise<R2UploadedPart>
//
//    fun uploadPart(partNumber: Double, value: ArrayBuffer): Promise<R2UploadedPart>
//
//    fun uploadPart(partNumber: Double, value: ArrayBufferView): Promise<R2UploadedPart>
//
//    fun uploadPart(partNumber: Double, value: String): Promise<R2UploadedPart>
//
//    fun uploadPart(partNumber: Double, value: Blob): Promise<R2UploadedPart>
//    fun abort(): Promise<Unit>
//    fun complete(uploadedParts: Array<R2UploadedPart>): Promise<R2Object>
//}
//
//
//external interface R2UploadedPart {
//    var partNumber: Double
//    var etag: String
//}
//
//
//open external class R2Object {
//    val key: String
//    val version: String
//    val size: Double
//    val etag: String
//    val httpEtag: String
//    val checksums: R2Checksums
//    val uploaded: Date
//    val httpMetadata: R2HTTPMetadata?
//    val customMetadata: Record<String, String>?
//    val range: R2Range?
//    fun writeHttpMetadata(headers: Headers): Unit
//}
//
//
//external interface R2ObjectBody : R2Object {
//
//    val body: ReadableStream
//
//
//    val bodyUsed: Boolean
//
//    fun arrayBuffer(): Promise<ArrayBuffer>
//    fun text(): Promise<String>
//    fun <T> json(): Promise<T>
//    fun blob(): Promise<Blob>
//}
//
//
//typealias R2Range = Any /* {
//    offset: number;
//    length?: number;
//} | {
//    offset?: number;
//    length: number;
//} | {
//    suffix: number;
//} */
//
//
//
//external interface R2Conditional {
//    var etagMatches: String?
//    var etagDoesNotMatch: String?
//    var uploadedBefore: Date?
//    var uploadedAfter: Date?
//    var secondsGranularity: Boolean?
//}
//
//
//external interface R2GetOptions {
//    var onlyIf: (Any /* R2Conditional | Headers */)?
//    var range: (Any /* R2Range | Headers */)?
//}
//
//
//external interface R2PutOptions {
//    var onlyIf: (Any /* R2Conditional | Headers */)?
//    var httpMetadata: (Any /* R2HTTPMetadata | Headers */)?
//    var customMetadata: Record<String, String>?
//    var md5: (Any /* ArrayBuffer | string */)?
//    var sha1: (Any /* ArrayBuffer | string */)?
//    var sha256: (Any /* ArrayBuffer | string */)?
//    var sha384: (Any /* ArrayBuffer | string */)?
//    var sha512: (Any /* ArrayBuffer | string */)?
//}
//
//
//external interface R2MultipartOptions {
//    var httpMetadata: (Any /* R2HTTPMetadata | Headers */)?
//    var customMetadata: Record<String, String>?
//}
//
//
//external interface R2Checksums {
//    val md5: ArrayBuffer?
//    val sha1: ArrayBuffer?
//    val sha256: ArrayBuffer?
//    val sha384: ArrayBuffer?
//    val sha512: ArrayBuffer?
//    fun toJSON(): R2StringChecksums
//}
//
//
//external interface R2StringChecksums {
//    var md5: String?
//    var sha1: String?
//    var sha256: String?
//    var sha384: String?
//    var sha512: String?
//}
//
//
//external interface R2HTTPMetadata {
//    var contentType: String?
//    var contentLanguage: String?
//    var contentDisposition: String?
//    var contentEncoding: String?
//    var cacheControl: String?
//    var cacheExpiry: Date?
//}
//
//
//typealias R2Objects = Any /* {
//    objects: R2Object[];
//    delimitedPrefixes: string[];
//} & ({
//    truncated: true;
//    cursor: string;
//} | {
//    truncated: false;
//}) */

//endregion

abstract external class ScheduledEvent : ExtendableEvent {
    val scheduledTime: Double
    val cron: String
    fun noRetry(): Unit
}


external interface ScheduledController {
    val scheduledTime: Double
    val cron: String
    fun noRetry(): Unit
}


external interface QueuingStrategy<T /* default is Any? */> {
    var highWaterMark: (Any /* number | bigint */)?
    var size: ((chunk: T) -> Any /* number | bigint */)?
}


external interface UnderlyingSink<W /* default is Any? */> {
    var type: String?
    var start: ((controller: WritableStreamDefaultController) -> Any /* void | Promise<void> */)?
    var write: ((chunk: W, controller: WritableStreamDefaultController) -> Any /* void | Promise<void> */)?
    var abort: ((reason: Any?) -> Any /* void | Promise<void> */)?
    var close: (() -> Any /* void | Promise<void> */)?
}


external interface UnderlyingByteSource {
    var type: String /* "bytes" */
    var autoAllocateChunkSize: Double?
    var start: ((controller: ReadableByteStreamController) -> Any /* void | Promise<void> */)?
    var pull: ((controller: ReadableByteStreamController) -> Any /* void | Promise<void> */)?
    var cancel: ((reason: Any?) -> Any /* void | Promise<void> */)?
}


external interface UnderlyingSource<R /* default is Any? */> {
    var type: UnderlyingSourceType?
    var start: ((controller: ReadableStreamDefaultController<R>) -> Any /* void | Promise<void> */)?
    var pull: ((controller: ReadableStreamDefaultController<R>) -> Any /* void | Promise<void> */)?
    var cancel: ((reason: Any?) -> Any /* void | Promise<void> */)?
}


external interface Transformer<I /* default is Any? */, O /* default is Any? */> {
    var readableType: String?
    var writableType: String?
    var start: ((controller: TransformStreamDefaultController<O>) -> Any /* void | Promise<void> */)?
    var transform: ((chunk: I, controller: TransformStreamDefaultController<O>) -> Any /* void | Promise<void> */)?
    var flush: ((controller: TransformStreamDefaultController<O>) -> Any /* void | Promise<void> */)?
}


external interface StreamPipeOptions {
    /**
     * Pipes this readable stream to a given writable stream destination. The way in which the piping process behaves under various error conditions can be customized with a number of passed options. It returns a promise that fulfills when the piping process completes successfully, or rejects if any errors were encountered.
     *
     * Piping a stream will lock it for the duration of the pipe, preventing any other consumer from acquiring a reader.
     *
     * Errors and closures of the source and destination streams propagate as follows:
     *
     * An error in this source readable stream will abort destination, unless preventAbort is truthy. The returned promise will be rejected with the source's error, or with any error that occurs during aborting the destination.
     *
     * An error in destination will cancel this source readable stream, unless preventCancel is truthy. The returned promise will be rejected with the destination's error, or with any error that occurs during canceling the source.
     *
     * When this source readable stream closes, destination will be closed, unless preventClose is truthy. The returned promise will be fulfilled once this process completes, unless an error is encountered while closing the destination, in which case it will be rejected with that error.
     *
     * If destination starts out closed or closing, this source readable stream will be canceled, unless preventCancel is true. The returned promise will be rejected with an error indicating piping to a closed stream failed, or with any error that occurs during canceling the source.
     *
     * The signal option can be set to an AbortSignal to allow aborting an ongoing pipe operation via the corresponding AbortController. In this case, this source readable stream will be canceled, and destination aborted, unless the respective options preventCancel or preventAbort are set.
     */
    var preventClose: Boolean?
    var preventAbort: Boolean?
    var preventCancel: Boolean?
    var signal: AbortSignal?
}


typealias ReadableStreamReadResult<R /* default is Any? */> = Any /* {
    done: false;
    value: R;
} | {
    done: true;
    value?: undefined;
} */

/** This Streams API interface represents a readable stream of byte data. The Fetch API offers a concrete instance of a ReadableStream through the body property of a Response object. */

external interface ReadableStream<R /* default is Any? */> {
    val locked: Boolean
    fun cancel(reason: Any? = definedExternally): Promise<Unit>
    fun getReader(): ReadableStreamDefaultReader<R>
    fun getReader(options: ReadableStreamGetReaderOptions): ReadableStreamBYOBReader
    fun <T> pipeThrough(
        transform: ReadableWritablePair<T, R>,
        options: StreamPipeOptions = definedExternally
    ): ReadableStream<T>

    fun pipeTo(destination: WritableStream<R>, options: StreamPipeOptions = definedExternally): Promise<Unit>
    fun tee(): Array<ReadableStream<R>> /* [
    ReadableStream<R>,
    ReadableStream<R>
] */

//    fun values(options: ReadableStreamValuesOptions = definedExternally): AsyncIterableIterator<R>
}


//external val ReadableStream: Temp1<R, R, R, R>


external class ReadableStreamDefaultReader<R /* default is Any? */> {
    constructor (stream: ReadableStream<R>)

    val closed: Promise<Unit>
    fun cancel(reason: Any? = definedExternally): Promise<Unit>
    fun read(): Promise<ReadableStreamReadResult<R>>
    fun releaseLock(): Unit
}


external class ReadableStreamBYOBReader {
    constructor (stream: ReadableStream<Any>)

    val closed: Promise<Unit>
    fun cancel(reason: Any? = definedExternally): Promise<Unit>
    fun <T : ArrayBufferView> read(view: T): Promise<ReadableStreamReadResult<T>>
    fun releaseLock(): Unit
    fun <T : ArrayBufferView> readAtLeast(minElements: Double, view: T): Promise<ReadableStreamReadResult<T>>
}


external interface ReadableStreamGetReaderOptions {
    var mode: String /* "byob" */
}


external interface ReadableStreamBYOBRequest {
    val view: Uint8Array?
    fun respond(bytesWritten: Double): Unit
    fun respondWithNewView(view: ArrayBuffer): Unit

    fun respondWithNewView(view: ArrayBufferView): Unit
    val atLeast: Double?
}


external interface ReadableStreamDefaultController<R /* default is Any? */> {
    val desiredSize: Double?
    fun close(): Unit
    fun enqueue(chunk: R = definedExternally): Unit
    fun error(reason: Any?): Unit
}


external interface ReadableByteStreamController {
    val byobRequest: ReadableStreamBYOBRequest?
    val desiredSize: Double?
    fun close(): Unit
    fun enqueue(chunk: ArrayBuffer): Unit

    fun enqueue(chunk: ArrayBufferView): Unit
    fun error(reason: Any?): Unit
}


/** This Streams API interface represents a controller allowing control of a WritableStream's state. When constructing a WritableStream, the underlying sink is given a corresponding WritableStreamDefaultController instance to manipulate. */

external interface WritableStreamDefaultController {
    val signal: AbortSignal
    fun error(reason: Any? = definedExternally): Unit
}


external interface TransformStreamDefaultController<O /* default is Any? */> {

    val desiredSize: Double?

    fun enqueue(chunk: O = definedExternally): Unit
    fun error(reason: Any?): Unit
    fun terminate(): Unit
}


external interface ReadableWritablePair<R /* default is Any? */, W /* default is Any? */> {
    /**
     * Provides a convenient, chainable way of piping this readable stream through a transform stream (or any other { writable, readable } pair). It simply pipes the stream into the writable side of the supplied pair, and returns the readable side for further use.
     *
     * Piping a stream will lock it for the duration of the pipe, preventing any other consumer from acquiring a reader.
     */
    var writable: WritableStream<W>
    var readable: ReadableStream<R>
}


open external class WritableStream<W /* default is Any? */> {
    constructor (
        underlyingSink: UnderlyingSink<W> = definedExternally,
        queuingStrategy: QueuingStrategy<W> = definedExternally
    )

    val locked: Boolean
    fun abort(reason: Any? = definedExternally): Promise<Unit>
    fun close(): Promise<Unit>
    fun getWriter(): WritableStreamDefaultWriter<W>
}


external class WritableStreamDefaultWriter<W /* default is Any? */> {
    constructor (stream: WritableStream<W>)

    val closed: Promise<Unit>
    val ready: Promise<Unit>
    val desiredSize: Double?
    fun abort(reason: Any? = definedExternally): Promise<Unit>
    fun close(): Promise<Unit>
    fun write(chunk: W = definedExternally): Promise<Unit>
    fun releaseLock(): Unit
}


open external class TransformStream<I /* default is Any? */, O /* default is Any? */> {
    constructor (
        transformer: Transformer<I, O> = definedExternally,
        writableStrategy: QueuingStrategy<I> = definedExternally,
        readableStrategy: QueuingStrategy<O> = definedExternally
    )

    val readable: ReadableStream<O>
    val writable: WritableStream<I>
}


external class FixedLengthStream : IdentityTransformStream {
    constructor (expectedLength: Double, queuingStrategy: IdentityTransformStreamQueuingStrategy = definedExternally)

    constructor (
        expectedLength:Long /* bigint */,
        queuingStrategy: IdentityTransformStreamQueuingStrategy = definedExternally
    )
}


open external class IdentityTransformStream : TransformStream<Any /* ArrayBuffer | ArrayBufferView */, Uint8Array> {
    constructor (queuingStrategy: IdentityTransformStreamQueuingStrategy = definedExternally)
}


external interface IdentityTransformStreamQueuingStrategy {
    var highWaterMark: (Any /* number | bigint */)?
}


external interface ReadableStreamValuesOptions {
    var preventCancel: Boolean?
}


external class CompressionStream : TransformStream<Any /* ArrayBuffer | ArrayBufferView */, Uint8Array> {
    constructor (format: CompressionStreamFormat)
}


external class DecompressionStream : TransformStream<Any /* ArrayBuffer | ArrayBufferView */, Uint8Array> {
    constructor (format: DecompressionStreamFormat)
}


external class TextEncoderStream : TransformStream<String, Uint8Array> {
    constructor ()
}


external class TextDecoderStream : TransformStream<Any /* ArrayBuffer | ArrayBufferView */, String> {
    constructor (label: String = definedExternally, options: TextDecoderStreamTextDecoderStreamInit = definedExternally)
}


external interface TextDecoderStreamTextDecoderStreamInit {
    var fatal: Boolean?
}


external class ByteLengthQueuingStrategy : QueuingStrategy<ArrayBufferView> {
    constructor (init: QueuingStrategyInit)

    override var highWaterMark: Any?


    override var size: ((ArrayBufferView) -> Any)?

}


//external class CountQueuingStrategy : QueuingStrategy {
//    constructor (init: QueuingStrategyInit)
//
//    val highWaterMark: Double
//
//
//    val size: (chunk: Any? /* use undefined for default */) -> Double
//
//}


external interface QueuingStrategyInit {
    /**
     * Creates a new ByteLengthQueuingStrategy with the provided high water mark.
     *
     * Note that the provided high water mark will not be validated ahead of time. Instead, if it is negative, NaN, or not a number, the resulting ByteLengthQueuingStrategy will cause the corresponding stream constructor to throw.
     */
    var highWaterMark: Double
}


abstract external class TailEvent : ExtendableEvent {
    val events: Array<TraceItem>
    val traces: Array<TraceItem>
}


external interface TraceItem {
    val event: (Any /* (TraceItemFetchEventInfo | TraceItemScheduledEventInfo | TraceItemAlarmEventInfo | TraceItemQueueEventInfo | TraceItemEmailEventInfo | TraceItemCustomEventInfo) | null */)?
    val eventTimestamp: Double?
    val logs: Array<TraceLog>
    val exceptions: Array<TraceException>
    val diagnosticsChannelEvents: Array<TraceDiagnosticChannelEvent>
    val scriptName: String?
    val dispatchNamespace: String?
    val scriptTags: Array<String>?
    val outcome: String
}


external interface TraceItemAlarmEventInfo {
    val scheduledTime: Date
}


external interface TraceItemCustomEventInfo {

}


external interface TraceItemScheduledEventInfo {
    val scheduledTime: Double
    val cron: String
}


external interface TraceItemQueueEventInfo {
    val queue: String
    val batchSize: Double
}


external interface TraceItemEmailEventInfo {
    val mailFrom: String
    val rcptTo: String
    val rawSize: Double
}


external interface TraceItemFetchEventInfo {
    val response: TraceItemFetchEventInfoResponse?
    val request: TraceItemFetchEventInfoRequest
}


external interface TraceItemFetchEventInfoRequest {
    val cf: Any?
    val headers: Record<String, String>
    val method: String
    val url: String
    fun getUnredacted(): TraceItemFetchEventInfoRequest
}


external interface TraceItemFetchEventInfoResponse {
    val status: Double
}


external interface TraceLog {
    val timestamp: Double
    val level: String
    val message: Any?
}


external interface TraceException {
    val timestamp: Double
    val message: String
    val name: String
}


external interface TraceDiagnosticChannelEvent {
    val timestamp: Double
    val channel: String
    val message: Any?
}


external interface TraceMetrics {
    val cpuTime: Double
    val wallTime: Double
}


external interface UnsafeTraceMetrics {
    fun fromTrace(item: TraceItem): TraceMetrics
}


external class URL {
    constructor (url: String, base: String = definedExternally)

//    constructor (url: String, base: URL = definedExternally)

    constructor (url: URL, base: String = definedExternally)

    constructor (url: URL, base: URL = definedExternally)

    var href: String
    val origin: String
    var protocol: String
    var username: String
    var password: String
    var host: String
    var hostname: String
    var port: String
    var pathname: String
    var search: String
    val searchParams: URLSearchParams
    var hash: String
    fun toJSON(): String
}


external class URLSearchParams {
    constructor (init: URLSearchParams = definedExternally)

    constructor (init: String = definedExternally)

    constructor (init: Record<String, String> = definedExternally)

//    constructor (
//        init: Array</* [
//    key: string,
//    value: string
//] */> = definedExternally
//    )

    val size: Double

    fun append(name: String, value: String): Unit
    fun delete(name: String): Unit
    fun get(name: String): String?
    fun getAll(name: String): Array<String>
    fun has(name: String): Boolean
    fun set(name: String, value: String): Unit
    fun sort(): Unit
//    fun entries(): IterableIterator</* [
//    key: string,
//    value: string
//] */>

    fun keys(): IterableIterator<String>
    fun values(): IterableIterator<String>
    fun <This /* default is Any? */> forEach(
        callback: (`this`: This, value: String, key: String, parent: URLSearchParams) -> Unit,
        thisArg: This = definedExternally
    ): Unit

//    fun toString(): String
}


external class URLPattern {
    constructor (input: String = definedExternally, baseURL: String = definedExternally)

    constructor (input: URLPatternURLPatternInit = definedExternally, baseURL: String = definedExternally)

    val protocol: String


    val username: String


    val password: String


    val hostname: String


    val port: String


    val pathname: String


    val search: String


    val hash: String

    fun test(input: String = definedExternally, baseURL: String = definedExternally): Boolean

    fun test(input: URLPatternURLPatternInit = definedExternally, baseURL: String = definedExternally): Boolean
    fun exec(input: String = definedExternally, baseURL: String = definedExternally): URLPatternURLPatternResult?

    fun exec(
        input: URLPatternURLPatternInit = definedExternally,
        baseURL: String = definedExternally
    ): URLPatternURLPatternResult?
}


external interface URLPatternURLPatternInit {
    var protocol: String?
    var username: String?
    var password: String?
    var hostname: String?
    var port: String?
    var pathname: String?
    var search: String?
    var hash: String?
    var baseURL: String?
}


external interface URLPatternURLPatternComponentResult {
    var input: String
    var groups: Record<String, String>
}


external interface URLPatternURLPatternResult {
    var inputs: Array<(Any /* string | URLPatternURLPatternInit */)>
    var protocol: URLPatternURLPatternComponentResult
    var username: URLPatternURLPatternComponentResult
    var password: URLPatternURLPatternComponentResult
    var hostname: URLPatternURLPatternComponentResult
    var port: URLPatternURLPatternComponentResult
    var pathname: URLPatternURLPatternComponentResult
    var search: URLPatternURLPatternComponentResult
    var hash: URLPatternURLPatternComponentResult
}


abstract external class CloseEvent : Event {
    constructor (type: String, initializer: CloseEventInit)

    /** Returns the WebSocket connection close code provided by the server. */
    val code: Double

    /** Returns the WebSocket connection close reason provided by the server. */
    val reason: String

    /** Returns true if the connection closed cleanly; false otherwise. */
    val wasClean: Boolean
}


external interface CloseEventInit {
    var code: Double?
    var reason: String?
    var wasClean: Boolean?
}


abstract external class MessageEvent : Event {
    constructor (type: String, initializer: MessageEventInit)

    val data: Any /* ArrayBuffer | string */
}


external interface MessageEventInit {
    var data: Any /* ArrayBuffer | string */
}


/** Events providing information related to errors in scripts or in files. */

external interface ErrorEvent : Event {
    val filename: String
    val message: String
    val lineno: Double
    val colno: Double
    val error: Any?
}


external interface WebSocketEventMap {
    var close: CloseEvent
    var message: MessageEvent
    var open: Event
    var error: ErrorEvent
}


external class WebSocket : EventTarget {
    constructor (url: String, protocols: Array<String> = definedExternally)

    constructor (url: String, protocols: String = definedExternally)

    fun accept(): Unit
    fun send(message: ArrayBuffer): Unit

    fun send(message: ArrayBufferView): Unit

    fun send(message: String): Unit
    fun close(code: Double = definedExternally, reason: String = definedExternally): Unit
    fun serializeAttachment(attachment: Any?): Unit
    fun deserializeAttachment(): Any??

    /** Returns the state of the WebSocket object's connection. It can have the values described below. */
    val readyState: Double

    /** Returns the URL that was used to establish the WebSocket connection. */
    val url: String?

    /** Returns the subprotocol selected by the server, if any. It can be used in conjunction with the array form of the constructor's second argument to perform subprotocol negotiation. */
    val protocol: String?

    /** Returns the extensions selected by the server, if any. */
    val extensions: String?

    companion object {
        val READY_STATE_CONNECTING: Double
        val READY_STATE_OPEN: Double
        val READY_STATE_CLOSING: Double
        val READY_STATE_CLOSED: Double
    }

}


external val WebSocketPair: Temp2


external interface Socket {

    val readable: ReadableStream<Int>


    val writable: WritableStream<Int>


    val closed: Promise<Unit>

    fun close(): Promise<Unit>
    fun startTls(options: TlsOptions = definedExternally): Socket
}


external interface SocketOptions {
    var secureTransport: String?
    var allowHalfOpen: Boolean
}


external interface SocketAddress {
    var hostname: String
    var port: Double
}


external interface TlsOptions {
    var expectedServerHostname: String?
}


external interface BasicImageTransformations {
    /**
     * Maximum width in image pixels. The value must be an integer.
     */
    var width: Double?

    /**
     * Maximum height in image pixels. The value must be an integer.
     */
    var height: Double?

    /**
     * Resizing mode as a string. It affects interpretation of width and height
     * options:
     *  - scale-down: Similar to contain, but the image is never enlarged. If
     *    the image is larger than given width or height, it will be resized.
     *    Otherwise its original size will be kept.
     *  - contain: Resizes to maximum size that fits within the given width and
     *    height. If only a single dimension is given (e.g. only width), the
     *    image will be shrunk or enlarged to exactly match that dimension.
     *    Aspect ratio is always preserved.
     *  - cover: Resizes (shrinks or enlarges) to fill the entire area of width
     *    and height. If the image has an aspect ratio different from the ratio
     *    of width and height, it will be cropped to fit.
     *  - crop: The image will be shrunk and cropped to fit within the area
     *    specified by width and height. The image will not be enlarged. For images
     *    smaller than the given dimensions it's the same as scale-down. For
     *    images larger than the given dimensions, it's the same as cover.
     *    See also trim.
     *  - pad: Resizes to the maximum size that fits within the given width and
     *    height, and then fills the remaining area with a background color
     *    (white by default). Use of this mode is not recommended, as the same
     *    effect can be more efficiently achieved with the contain mode and the
     *    CSS object-fit: contain property.
     */
    var fit: (BasicImageTransformationsFit)?

    /**
     * When cropping with fit: "cover", this defines the side or point that should
     * be left uncropped. The value is either a string
     * "left", "right", "top", "bottom", "auto", or "center" (the default),
     * or an object {x, y} containing focal point coordinates in the original
     * image expressed as fractions ranging from 0.0 (top or left) to 1.0
     * (bottom or right), 0.5 being the center. {fit: "cover", gravity: "top"} will
     * crop bottom or left and right sides as necessary, but won’t crop anything
     * from the top. {fit: "cover", gravity: {x:0.5, y:0.2}} will crop each side to
     * preserve as much as possible around a point at 20% of the height of the
     * source image.
     */
    var gravity: (Any /* "left" | "right" | "top" | "bottom" | "center" | "auto" | BasicImageTransformationsGravityCoordinates */)?

    /**
     * Background color to add underneath the image. Applies only to images with
     * transparency (such as PNG). Accepts any CSS color (#RRGGBB, rgba(…),
     * hsl(…), etc.)
     */
    var background: String?

    /**
     * Number of degrees (90, 180, 270) to rotate the image by. width and height
     * options refer to axes after rotation.
     */
    var rotate: (Any /* 0 | 90 | 180 | 270 | 360 */)?
}


external interface BasicImageTransformationsGravityCoordinates {
    var x: Double
    var y: Double
}


/**
 * In addition to the properties you can set in the RequestInit dict
 * that you pass as an argument to the Request constructor, you can
 * set certain properties of a `cf` object to control how Cloudflare
 * features are applied to that new Request.
 *
 * Note: Currently, these properties cannot be tested in the
 * playground.
 */

external interface RequestInitCfProperties : Record<String, Any?> {
    var cacheEverything: Boolean?

    /**
     * A request's cache key is what determines if two requests are
     * "the same" for caching purposes. If a request has the same cache key
     * as some previous request, then we can serve the same cached response for
     * both. (e.g. 'some-key')
     *
     * Only available for Enterprise customers.
     */
    var cacheKey: String?

    /**
     * This allows you to append additional Cache-Tag response headers
     * to the origin response without modifications to the origin server.
     * This will allow for greater control over the Purge by Cache Tag feature
     * utilizing changes only in the Workers process.
     *
     * Only available for Enterprise customers.
     */
    var cacheTags: Array<String>?

    /**
     * Force response to be cached for a given number of seconds. (e.g. 300)
     */
    var cacheTtl: Double?

    /**
     * Force response to be cached for a given number of seconds based on the Origin status code.
     * (e.g. { '200-299': 86400, '404': 1, '500-599': 0 })
     */
    var cacheTtlByStatus: Record<String, Double>?
    var scrapeShield: Boolean?
    var apps: Boolean?
    var image: RequestInitCfPropertiesImage?
    var minify: RequestInitCfPropertiesImageMinify?
    var mirage: Boolean?
    var polish: (RequestInitCfPropertiesPolish)?

    /**
     * Redirects the request to an alternate origin server. You can use this,
     * for example, to implement load balancing across several origins.
     * (e.g.us-east.example.com)
     *
     * Note - For security reasons, the hostname set in resolveOverride must
     * be proxied on the same Cloudflare zone of the incoming request.
     * Otherwise, the setting is ignored. CNAME hosts are allowed, so to
     * resolve to a host under a different domain or a DNS only domain first
     * declare a CNAME record within your own zone’s DNS mapping to the
     * external hostname, set proxy on Cloudflare, then set resolveOverride
     * to point to that CNAME record.
     */
    var resolveOverride: String?
}


external interface RequestInitCfPropertiesImageDraw : BasicImageTransformations {
    /**
     * Absolute URL of the image file to use for the drawing. It can be any of
     * the supported file formats. For drawing of watermarks or non-rectangular
     * overlays we recommend using PNG or WebP images.
     */
    var url: String

    /**
     * Floating-point number between 0 (transparent) and 1 (opaque).
     * For example, opacity: 0.5 makes overlay semitransparent.
     */
    var opacity: Double?

    /**
     * - If set to true, the overlay image will be tiled to cover the entire
     *   area. This is useful for stock-photo-like watermarks.
     * - If set to "x", the overlay image will be tiled horizontally only
     *   (form a line).
     * - If set to "y", the overlay image will be tiled vertically only
     *   (form a line).
     */
    var repeat: (Any /* true | "x" | "y" */)?

    /**
     * Position of the overlay image relative to a given edge. Each property is
     * an offset in pixels. 0 aligns exactly to the edge. For example, left: 10
     * positions left side of the overlay 10 pixels from the left edge of the
     * image it's drawn over. bottom: 0 aligns bottom of the overlay with bottom
     * of the background image.
     *
     * Setting both left & right, or both top & bottom is an error.
     *
     * If no position is specified, the image will be centered.
     */
    var top: Double?
    var left: Double?
    var bottom: Double?
    var right: Double?
}


external interface RequestInitCfPropertiesImage : BasicImageTransformations {
    /**
     * Device Pixel Ratio. Default 1. Multiplier for width/height that makes it
     * easier to specify higher-DPI sizes in <img srcset>.
     */
    var dpr: Double?

    /**
     * An object with four properties {left, top, right, bottom} that specify
     * a number of pixels to cut off on each side. Allows removal of borders
     * or cutting out a specific fragment of an image. Trimming is performed
     * before resizing or rotation. Takes dpr into account.
     */
    var trim: (RequestInitCfPropertiesImageTrim)?

    /**
     * Quality setting from 1-100 (useful values are in 60-90 range). Lower values
     * make images look worse, but load faster. The default is 85. It applies only
     * to JPEG and WebP images. It doesn’t have any effect on PNG.
     */
    var quality: Double?

    /**
     * Output format to generate. It can be:
     *  - avif: generate images in AVIF format.
     *  - webp: generate images in Google WebP format. Set quality to 100 to get
     *    the WebP-lossless format.
     *  - json: instead of generating an image, outputs information about the
     *    image, in JSON format. The JSON object will contain image size
     *    (before and after resizing), source image’s MIME type, file size, etc.
     * - jpeg: generate images in JPEG format.
     * - png: generate images in PNG format.
     */
    var format: (RequestInitCfPropertiesImageFormat)?

    /**
     * Whether to preserve animation frames from input files. Default is true.
     * Setting it to false reduces animations to still images. This setting is
     * recommended when enlarging images or processing arbitrary user content,
     * because large GIF animations can weigh tens or even hundreds of megabytes.
     * It is also useful to set anim:false when using format:"json" to get the
     * response quicker without the number of frames.
     */
    var anim: Boolean?

    /**
     * What EXIF data should be preserved in the output image. Note that EXIF
     * rotation and embedded color profiles are always applied ("baked in" into
     * the image), and aren't affected by this option. Note that if the Polish
     * feature is enabled, all metadata may have been removed already and this
     * option may have no effect.
     *  - keep: Preserve most of EXIF metadata, including GPS location if there's
     *    any.
     *  - copyright: Only keep the copyright tag, and discard everything else.
     *    This is the default behavior for JPEG files.
     *  - none: Discard all invisible EXIF metadata. Currently WebP and PNG
     *    output formats always discard metadata.
     */
    var metadata: (RequestInitCfPropertiesImageMetadata)?

    /**
     * Strength of sharpening filter to apply to the image. Floating-point
     * number between 0 (no sharpening, default) and 10 (maximum). 1.0 is a
     * recommended value for downscaled images.
     */
    var sharpen: Double?

    /**
     * Radius of a blur filter (approximate gaussian). Maximum supported radius
     * is 250.
     */
    var blur: Double?

    /**
     * Overlays are drawn in the order they appear in the array (last array
     * entry is the topmost layer).
     */
    var draw: Array<RequestInitCfPropertiesImageDraw>?
    /**
     * Fetching image from authenticated origin. Setting this property will
     * pass authentication headers (Authorization, Cookie, etc.) through to
     * the origin.
     */
    /* "origin-auth"?: "share-publicly"; */
    /**
     * Adds a border around the image. The border is added after resizing. Border
     * width takes dpr into account, and can be specified either using a single
     * width property, or individually for each side.
     */
    var border: (Any /* {
    color: string;
    width: number;
} | {
    color: string;
    top: number;
    right: number;
    bottom: number;
    left: number;
} */)?

    /**
     * Increase brightness by a factor. A value of 1.0 equals no change, a value
     * of 0.5 equals half brightness, and a value of 2.0 equals twice as bright.
     * 0 is ignored.
     */
    var brightness: Double?

    /**
     * Increase contrast by a factor. A value of 1.0 equals no change, a value of
     * 0.5 equals low contrast, and a value of 2.0 equals high contrast. 0 is
     * ignored.
     */
    var contrast: Double?

    /**
     * Increase exposure by a factor. A value of 1.0 equals no change, a value of
     * 0.5 darkens the image, and a value of 2.0 lightens the image. 0 is ignored.
     */
    var gamma: Double?

    /**
     * Slightly reduces latency on a cache miss by selecting a
     * quickest-to-compress file format, at a cost of increased file size and
     * lower image quality. It will usually override the format option and choose
     * JPEG over WebP or AVIF. We do not recommend using this option, except in
     * unusual circumstances like resizing uncacheable dynamically-generated
     * images.
     */
    var compression: String /* "fast" */?
}


external interface RequestInitCfPropertiesImageMinify {
    var javascript: Boolean?
    var css: Boolean?
    var html: Boolean?
}


/**
 * Request metadata provided by Cloudflare's edge.
 */

external interface IncomingRequestCfProperties<HostMetadata /* default is Any? */> : IncomingRequestCfPropertiesBase,
    IncomingRequestCfPropertiesBotManagementEnterprise,
    IncomingRequestCfPropertiesCloudflareForSaaSEnterprise<HostMetadata>,
    IncomingRequestCfPropertiesGeographicInformation, IncomingRequestCfPropertiesCloudflareAccessOrApiShield {

}


external interface IncomingRequestCfPropertiesBase : Record<String, Any?> {
    /**
     * [ASN](https://www.iana.org/assignments/as-numbers/as-numbers.xhtml) of the incoming request.
     *
     * @example 395747
     */
    var asn: Double

    /**
     * The organization which owns the ASN of the incoming request.
     *
     * @example "Google Cloud"
     */
    var asOrganization: String

    /**
     * The original value of the `Accept-Encoding` header if Cloudflare modified it.
     *
     * @example "gzip, deflate, br"
     */
    var clientAcceptEncoding: String?

    /**
     * The number of milliseconds it took for the request to reach your worker.
     *
     * @example 22
     */
    var clientTcpRtt: Double?

    /**
     * The three-letter [IATA](https://en.wikipedia.org/wiki/IATA_airport_code)
     * airport code of the data center that the request hit.
     *
     * @example "DFW"
     */
    var colo: String

    /**
     * Represents the upstream's response to a
     * [TCP `keepalive` message](https://tldp.org/HOWTO/TCP-Keepalive-HOWTO/overview.html)
     * from cloudflare.
     *
     * For workers with no upstream, this will always be `1`.
     *
     * @example 3
     */
    var edgeRequestKeepAliveStatus: IncomingRequestCfPropertiesEdgeRequestKeepAliveStatus

    /**
     * The HTTP Protocol the request used.
     *
     * @example "HTTP/2"
     */
    var httpProtocol: String

    /**
     * The browser-requested prioritization information in the request object.
     *
     * If no information was set, defaults to the empty string `""`
     *
     * @example "weight=192;exclusive=0;group=3;group-weight=127"
     * @default ""
     */
    var requestPriority: String

    /**
     * The TLS version of the connection to Cloudflare.
     * In requests served over plaintext (without TLS), this property is the empty string `""`.
     *
     * @example "TLSv1.3"
     */
    var tlsVersion: String

    /**
     * The cipher for the connection to Cloudflare.
     * In requests served over plaintext (without TLS), this property is the empty string `""`.
     *
     * @example "AEAD-AES128-GCM-SHA256"
     */
    var tlsCipher: String

    /**
     * Metadata containing the [`HELLO`](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.1.2) and [`FINISHED`](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.9) messages from this request's TLS handshake.
     *
     * If the incoming request was served over plaintext (without TLS) this field is undefined.
     */
    var tlsExportedAuthenticator: IncomingRequestCfPropertiesExportedAuthenticatorMetadata?
}


external interface IncomingRequestCfPropertiesBotManagementBase {
    /**
     * Cloudflare’s [level of certainty](https://developers.cloudflare.com/bots/concepts/bot-score/) that a request comes from a bot,
     * represented as an integer percentage between `1` (almost certainly a bot) and `99` (almost certainly human).
     *
     * @example 54
     */
    var score: Double

    /**
     * A boolean value that is true if the request comes from a good bot, like Google or Bing.
     * Most customers choose to allow this traffic. For more details, see [Traffic from known bots](https://developers.cloudflare.com/firewall/known-issues-and-faq/#how-does-firewall-rules-handle-traffic-from-known-bots).
     */
    var verifiedBot: Boolean

    /**
     * A boolean value that is true if the request originates from a
     * Cloudflare-verified proxy service.
     */
    var corporateProxy: Boolean

    /**
     * A boolean value that's true if the request matches [file extensions](https://developers.cloudflare.com/bots/reference/static-resources/) for many types of static resources.
     */
    var staticResource: Boolean

    /**
     * List of IDs that correlate to the Bot Management heuristic detections made on a request (you can have multiple heuristic detections on the same request).
     */
    var detectionIds: Array<Double>
}


external interface IncomingRequestCfPropertiesBotManagement {
    /**
     * Results of Cloudflare's Bot Management analysis
     */
    var botManagement: IncomingRequestCfPropertiesBotManagementBase

    /**
     * Duplicate of `botManagement.score`.
     *
     * @deprecated
     */
    var clientTrustScore: Double
}


external interface IncomingRequestCfPropertiesBotManagementEnterprise : IncomingRequestCfPropertiesBotManagement {
    /**
     * Results of Cloudflare's Bot Management analysis
     */
//    var botManagement: Any /* IncomingRequestCfPropertiesBotManagementBase & {
//    ja3Hash: string;
//} */
}


external interface IncomingRequestCfPropertiesCloudflareForSaaSEnterprise<HostMetadata> {
    /**
     * Custom metadata set per-host in [Cloudflare for SaaS](https://developers.cloudflare.com/cloudflare-for-platforms/cloudflare-for-saas/).
     *
     * This field is only present if you have Cloudflare for SaaS enabled on your account
     * and you have followed the [required steps to enable it]((https://developers.cloudflare.com/cloudflare-for-platforms/cloudflare-for-saas/domain-support/custom-metadata/)).
     */
    var hostMetadata: HostMetadata
}


external interface IncomingRequestCfPropertiesCloudflareAccessOrApiShield {
    /**
     * Information about the client certificate presented to Cloudflare.
     *
     * This is populated when the incoming request is served over TLS using
     * either Cloudflare Access or API Shield (mTLS)
     * and the presented SSL certificate has a valid
     * [Certificate Serial Number](https://ldapwiki.com/wiki/Certificate%20Serial%20Number)
     * (i.e., not `null` or `""`).
     *
     * Otherwise, a set of placeholder values are used.
     *
     * The property `certPresented` will be set to `"1"` when
     * the object is populated (i.e. the above conditions were met).
     */
    var tlsClientAuth: Any /* IncomingRequestCfPropertiesTLSClientAuth | IncomingRequestCfPropertiesTLSClientAuthPlaceholder */
}


/**
 * Metadata about the request's TLS handshake
 */

external interface IncomingRequestCfPropertiesExportedAuthenticatorMetadata {
    /**
     * The client's [`HELLO` message](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.1.2), encoded in hexadecimal
     *
     * @example "44372ba35fa1270921d318f34c12f155dc87b682cf36a790cfaa3ba8737a1b5d"
     */
    var clientHandshake: String

    /**
     * The server's [`HELLO` message](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.1.2), encoded in hexadecimal
     *
     * @example "44372ba35fa1270921d318f34c12f155dc87b682cf36a790cfaa3ba8737a1b5d"
     */
    var serverHandshake: String

    /**
     * The client's [`FINISHED` message](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.9), encoded in hexadecimal
     *
     * @example "084ee802fe1348f688220e2a6040a05b2199a761f33cf753abb1b006792d3f8b"
     */
    var clientFinished: String

    /**
     * The server's [`FINISHED` message](https://www.rfc-editor.org/rfc/rfc5246#section-7.4.9), encoded in hexadecimal
     *
     * @example "084ee802fe1348f688220e2a6040a05b2199a761f33cf753abb1b006792d3f8b"
     */
    var serverFinished: String
}


/**
 * Geographic data about the request's origin.
 */

external interface IncomingRequestCfPropertiesGeographicInformation {
    /**
     * The [ISO 3166-1 Alpha 2](https://www.iso.org/iso-3166-country-codes.html) country code the request originated from.
     *
     * If your worker is [configured to accept TOR connections](https://support.cloudflare.com/hc/en-us/articles/203306930-Understanding-Cloudflare-Tor-support-and-Onion-Routing), this may also be `"T1"`, indicating a request that originated over TOR.
     *
     * If Cloudflare is unable to determine where the request originated this property is omitted.
     *
     * The country code `"T1"` is used for requests originating on TOR.
     *
     * @example "GB"
     */
    var country: (Any /* Iso3166Alpha2Code | "T1" */)?

    /**
     * If present, this property indicates that the request originated in the EU
     *
     * @example "1"
     */
    var isEUCountry: String /* "1" */?

    /**
     * A two-letter code indicating the continent the request originated from.
     *
     * @example "AN"
     */
    var continent: ContinentCode?

    /**
     * The city the request originated from
     *
     * @example "Austin"
     */
    var city: String?

    /**
     * Postal code of the incoming request
     *
     * @example "78701"
     */
    var postalCode: String?

    /**
     * Latitude of the incoming request
     *
     * @example "30.27130"
     */
    var latitude: String?

    /**
     * Longitude of the incoming request
     *
     * @example "-97.74260"
     */
    var longitude: String?

    /**
     * Timezone of the incoming request
     *
     * @example "America/Chicago"
     */
    var timezone: String?

    /**
     * If known, the ISO 3166-2 name for the first level region associated with
     * the IP address of the incoming request
     *
     * @example "Texas"
     */
    var region: String?

    /**
     * If known, the ISO 3166-2 code for the first-level region associated with
     * the IP address of the incoming request
     *
     * @example "TX"
     */
    var regionCode: String?

    /**
     * Metro code (DMA) of the incoming request
     *
     * @example "635"
     */
    var metroCode: String?
}


/** Data about the incoming request's TLS certificate */

external interface IncomingRequestCfPropertiesTLSClientAuth {
    /** Always `"1"`, indicating that the certificate was presented */
    var certPresented: String /* "1" */

    /**
     * Result of certificate verification.
     *
     * @example "FAILED:self signed certificate"
     */
//    var certVerified: Exclude<CertVerificationStatus, String /* "NONE" */>

    /** The presented certificate's revokation status.
     *
     * - A value of `"1"` indicates the certificate has been revoked
     * - A value of `"0"` indicates the certificate has not been revoked
     */
    var certRevoked: IncomingRequestCfPropertiesTLSClientAuthCertRevoked

    /**
     * The certificate issuer's [distinguished name](https://knowledge.digicert.com/generalinformation/INFO1745.html)
     *
     * @example "CN=cloudflareaccess.com, C=US, ST=Texas, L=Austin, O=Cloudflare"
     */
    var certIssuerDN: String

    /**
     * The certificate subject's [distinguished name](https://knowledge.digicert.com/generalinformation/INFO1745.html)
     *
     * @example "CN=*.cloudflareaccess.com, C=US, ST=Texas, L=Austin, O=Cloudflare"
     */
    var certSubjectDN: String

    /**
     * The certificate issuer's [distinguished name](https://knowledge.digicert.com/generalinformation/INFO1745.html) ([RFC 2253](https://www.rfc-editor.org/rfc/rfc2253.html) formatted)
     *
     * @example "CN=cloudflareaccess.com, C=US, ST=Texas, L=Austin, O=Cloudflare"
     */
    var certIssuerDNRFC2253: String

    /**
     * The certificate subject's [distinguished name](https://knowledge.digicert.com/generalinformation/INFO1745.html) ([RFC 2253](https://www.rfc-editor.org/rfc/rfc2253.html) formatted)
     *
     * @example "CN=*.cloudflareaccess.com, C=US, ST=Texas, L=Austin, O=Cloudflare"
     */
    var certSubjectDNRFC2253: String

    /** The certificate issuer's distinguished name (legacy policies) */
    var certIssuerDNLegacy: String

    /** The certificate subject's distinguished name (legacy policies) */
    var certSubjectDNLegacy: String

    /**
     * The certificate's serial number
     *
     * @example "00936EACBE07F201DF"
     */
    var certSerial: String

    /**
     * The certificate issuer's serial number
     *
     * @example "2489002934BDFEA34"
     */
    var certIssuerSerial: String

    /**
     * The certificate's Subject Key Identifier
     *
     * @example "BB:AF:7E:02:3D:FA:A6:F1:3C:84:8E:AD:EE:38:98:EC:D9:32:32:D4"
     */
    var certSKI: String

    /**
     * The certificate issuer's Subject Key Identifier
     *
     * @example "BB:AF:7E:02:3D:FA:A6:F1:3C:84:8E:AD:EE:38:98:EC:D9:32:32:D4"
     */
    var certIssuerSKI: String

    /**
     * The certificate's SHA-1 fingerprint
     *
     * @example "6b9109f323999e52259cda7373ff0b4d26bd232e"
     */
    var certFingerprintSHA1: String

    /**
     * The certificate's SHA-256 fingerprint
     *
     * @example "acf77cf37b4156a2708e34c4eb755f9b5dbbe5ebb55adfec8f11493438d19e6ad3f157f81fa3b98278453d5652b0c1fd1d71e5695ae4d709803a4d3f39de9dea"
     */
    var certFingerprintSHA256: String

    /**
     * The effective starting date of the certificate
     *
     * @example "Dec 22 19:39:00 2018 GMT"
     */
    var certNotBefore: String

    /**
     * The effective expiration date of the certificate
     *
     * @example "Dec 22 19:39:00 2018 GMT"
     */
    var certNotAfter: String
}


/** Placeholder values for TLS Client Authorization */

external interface IncomingRequestCfPropertiesTLSClientAuthPlaceholder {
    var certPresented: String /* "0" */
    var certVerified: String /* "NONE" */
    var certRevoked: String /* "0" */
    var certIssuerDN: String /* "" */
    var certSubjectDN: String /* "" */
    var certIssuerDNRFC2253: String /* "" */
    var certSubjectDNRFC2253: String /* "" */
    var certIssuerDNLegacy: String /* "" */
    var certSubjectDNLegacy: String /* "" */
    var certSerial: String /* "" */
    var certIssuerSerial: String /* "" */
    var certSKI: String /* "" */
    var certIssuerSKI: String /* "" */
    var certFingerprintSHA1: String /* "" */
    var certFingerprintSHA256: String /* "" */
    var certNotBefore: String /* "" */
    var certNotAfter: String /* "" */
}


/** Possible outcomes of TLS verification */

@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{SUCCESS: 'SUCCESS', NONE: 'NONE', FAILEDSelfSignedCertificate: 'FAILED:self signed certificate', FAILEDUnableToVerifyTheFirstCertificate: 'FAILED:unable to verify the first certificate', FAILEDCertificateIsNotYetValid: 'FAILED:certificate is not yet valid', FAILEDCertificateHasExpired: 'FAILED:certificate has expired', FAILED: 'FAILED'}/*union*/)""")
sealed external interface CertVerificationStatus {
    companion object {
        val SUCCESS: CertVerificationStatus
        val NONE: CertVerificationStatus
        val FAILEDSelfSignedCertificate: CertVerificationStatus
        val FAILEDUnableToVerifyTheFirstCertificate: CertVerificationStatus
        val FAILEDCertificateIsNotYetValid: CertVerificationStatus
        val FAILEDCertificateHasExpired: CertVerificationStatus
        val FAILED: CertVerificationStatus
    }
}


/**
 * An upstream endpoint's response to a TCP `keepalive` message from Cloudflare.
 */
typealias IncomingRequestCfPropertiesEdgeRequestKeepAliveStatus = Any /* 0 | 1 | 2 | 3 | 4 | 5 */
/** connection re-use, accepted by the origin server */

/** ISO 3166-1 Alpha-2 codes */

@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName(
    """(/*union*/{AD: 'AD', AE: 'AE', AF: 'AF', AG: 'AG', AI: 'AI', AL: 'AL', AM: 'AM', AO: 'AO', AQ: 'AQ', AR: 'AR', AS: 'AS', AT: 'AT', AU: 'AU', AW: 'AW', AX: 'AX', AZ: 'AZ', BA: 'BA', BB: 'BB', BD: 'BD', BE: 'BE', BF: 'BF', BG: 'BG', BH: 'BH', BI: 'BI', BJ: 'BJ', BL: 'BL', BM: 'BM', BN: 'BN', BO: 'BO', BQ: 'BQ', BR: 'BR', BS: 'BS', BT: 'BT', BV: 'BV', BW: 'BW', BY: 'BY', BZ: 'BZ', CA: 'CA', CC: 'CC', CD: 'CD', CF: 'CF', CG: 'CG', CH: 'CH', CI: 'CI', CK: 'CK', CL: 'CL', CM: 'CM', CN: 'CN', CO: 'CO', CR: 'CR', CU: 'CU', CV: 'CV', CW: 'CW', CX: 'CX', CY: 'CY', CZ: 'CZ', DE: 'DE', DJ: 'DJ', DK: 'DK', DM: 'DM', DO: 'DO', DZ: 'DZ', EC: 'EC', EE: 'EE', EG: 'EG', EH: 'EH', ER: 'ER', ES: 'ES', ET: 'ET', FI: 'FI', FJ: 'FJ', FK: 'FK', FM: 'FM', FO: 'FO', FR: 'FR', GA: 'GA', GB: 'GB', GD: 'GD', GE: 'GE', GF: 'GF', GG: 'GG', GH: 'GH', GI: 'GI', GL: 'GL', GM: 'GM', GN: 'GN', GP: 'GP', GQ: 'GQ', GR: 'GR', GS: 'GS', GT: 'GT', GU: 'GU', GW: 'GW', GY: 'GY', HK: 'HK', HM: 'HM', HN: 'HN', HR: 'HR', HT: 'HT', HU: 'HU', ID: 'ID', IE: 'IE', IL: 'IL', IM: 'IM', IN: 'IN', IO: 'IO', IQ: 'IQ', IR: 'IR', IS: 'IS', IT: 'IT', JE: 'JE', JM: 'JM', JO: 'JO', JP: 'JP', KE: 'KE', KG: 'KG', KH: 'KH', KI: 'KI', KM: 'KM', KN: 'KN', KP: 'KP', KR: 'KR', KW: 'KW', KY: 'KY', KZ: 'KZ', LA: 'LA', LB: 'LB', LC: 'LC', LI: 'LI', LK: 'LK', LR: 'LR', LS: 'LS', LT: 'LT', LU: 'LU', LV: 'LV', LY: 'LY', MA: 'MA', MC: 'MC', MD: 'MD', ME: 'ME', MF: 'MF', MG: 'MG', MH: 'MH', MK: 'MK', ML: 'ML', MM: 'MM', MN: 'MN', MO: 'MO', MP: 'MP', MQ: 'MQ', MR: 'MR', MS: 'MS', MT: 'MT', MU: 'MU', MV: 'MV', MW: 'MW', MX: 'MX', MY: 'MY', MZ: 'MZ', NA: 'NA', NC: 'NC', NE: 'NE', NF: 'NF', NG: 'NG', NI: 'NI', NL: 'NL', NO: 'NO', NP: 'NP', NR: 'NR', NU: 'NU', NZ: 'NZ', OM: 'OM', PA: 'PA', PE: 'PE', PF: 'PF', PG: 'PG', PH: 'PH', PK: 'PK', PL: 'PL', PM: 'PM', PN: 'PN', PR: 'PR', PS: 'PS', PT: 'PT', PW: 'PW', PY: 'PY', QA: 'QA', RE: 'RE', RO: 'RO', RS: 'RS', RU: 'RU', RW: 'RW', SA: 'SA', SB: 'SB', SC: 'SC', SD: 'SD', SE: 'SE', SG: 'SG', SH: 'SH', SI: 'SI', SJ: 'SJ', SK: 'SK', SL: 'SL', SM: 'SM', SN: 'SN', SO: 'SO', SR: 'SR', SS: 'SS', ST: 'ST', SV: 'SV', SX: 'SX', SY: 'SY', SZ: 'SZ', TC: 'TC', TD: 'TD', TF: 'TF', TG: 'TG', TH: 'TH', TJ: 'TJ', TK: 'TK', TL: 'TL', TM: 'TM', TN: 'TN', TO: 'TO', TR: 'TR', TT: 'TT', TV: 'TV', TW: 'TW', TZ: 'TZ', UA: 'UA', UG: 'UG', UM: 'UM', US: 'US', UY: 'UY', UZ: 'UZ', VA: 'VA', VC: 'VC', VE: 'VE', VG: 'VG', VI: 'VI', VN: 'VN', VU: 'VU', WF: 'WF', WS: 'WS', YE: 'YE', YT: 'YT', ZA: 'ZA', ZM: 'ZM', ZW: 'ZW'}/*union*/)"""
)
sealed external interface Iso3166Alpha2Code {
    companion object {
        val AD: Iso3166Alpha2Code
        val AE: Iso3166Alpha2Code
        val AF: Iso3166Alpha2Code
        val AG: Iso3166Alpha2Code
        val AI: Iso3166Alpha2Code
        val AL: Iso3166Alpha2Code
        val AM: Iso3166Alpha2Code
        val AO: Iso3166Alpha2Code
        val AQ: Iso3166Alpha2Code
        val AR: Iso3166Alpha2Code
        val AS: Iso3166Alpha2Code
        val AT: Iso3166Alpha2Code
        val AU: Iso3166Alpha2Code
        val AW: Iso3166Alpha2Code
        val AX: Iso3166Alpha2Code
        val AZ: Iso3166Alpha2Code
        val BA: Iso3166Alpha2Code
        val BB: Iso3166Alpha2Code
        val BD: Iso3166Alpha2Code
        val BE: Iso3166Alpha2Code
        val BF: Iso3166Alpha2Code
        val BG: Iso3166Alpha2Code
        val BH: Iso3166Alpha2Code
        val BI: Iso3166Alpha2Code
        val BJ: Iso3166Alpha2Code
        val BL: Iso3166Alpha2Code
        val BM: Iso3166Alpha2Code
        val BN: Iso3166Alpha2Code
        val BO: Iso3166Alpha2Code
        val BQ: Iso3166Alpha2Code
        val BR: Iso3166Alpha2Code
        val BS: Iso3166Alpha2Code
        val BT: Iso3166Alpha2Code
        val BV: Iso3166Alpha2Code
        val BW: Iso3166Alpha2Code
        val BY: Iso3166Alpha2Code
        val BZ: Iso3166Alpha2Code
        val CA: Iso3166Alpha2Code
        val CC: Iso3166Alpha2Code
        val CD: Iso3166Alpha2Code
        val CF: Iso3166Alpha2Code
        val CG: Iso3166Alpha2Code
        val CH: Iso3166Alpha2Code
        val CI: Iso3166Alpha2Code
        val CK: Iso3166Alpha2Code
        val CL: Iso3166Alpha2Code
        val CM: Iso3166Alpha2Code
        val CN: Iso3166Alpha2Code
        val CO: Iso3166Alpha2Code
        val CR: Iso3166Alpha2Code
        val CU: Iso3166Alpha2Code
        val CV: Iso3166Alpha2Code
        val CW: Iso3166Alpha2Code
        val CX: Iso3166Alpha2Code
        val CY: Iso3166Alpha2Code
        val CZ: Iso3166Alpha2Code
        val DE: Iso3166Alpha2Code
        val DJ: Iso3166Alpha2Code
        val DK: Iso3166Alpha2Code
        val DM: Iso3166Alpha2Code
        val DO: Iso3166Alpha2Code
        val DZ: Iso3166Alpha2Code
        val EC: Iso3166Alpha2Code
        val EE: Iso3166Alpha2Code
        val EG: Iso3166Alpha2Code
        val EH: Iso3166Alpha2Code
        val ER: Iso3166Alpha2Code
        val ES: Iso3166Alpha2Code
        val ET: Iso3166Alpha2Code
        val FI: Iso3166Alpha2Code
        val FJ: Iso3166Alpha2Code
        val FK: Iso3166Alpha2Code
        val FM: Iso3166Alpha2Code
        val FO: Iso3166Alpha2Code
        val FR: Iso3166Alpha2Code
        val GA: Iso3166Alpha2Code
        val GB: Iso3166Alpha2Code
        val GD: Iso3166Alpha2Code
        val GE: Iso3166Alpha2Code
        val GF: Iso3166Alpha2Code
        val GG: Iso3166Alpha2Code
        val GH: Iso3166Alpha2Code
        val GI: Iso3166Alpha2Code
        val GL: Iso3166Alpha2Code
        val GM: Iso3166Alpha2Code
        val GN: Iso3166Alpha2Code
        val GP: Iso3166Alpha2Code
        val GQ: Iso3166Alpha2Code
        val GR: Iso3166Alpha2Code
        val GS: Iso3166Alpha2Code
        val GT: Iso3166Alpha2Code
        val GU: Iso3166Alpha2Code
        val GW: Iso3166Alpha2Code
        val GY: Iso3166Alpha2Code
        val HK: Iso3166Alpha2Code
        val HM: Iso3166Alpha2Code
        val HN: Iso3166Alpha2Code
        val HR: Iso3166Alpha2Code
        val HT: Iso3166Alpha2Code
        val HU: Iso3166Alpha2Code
        val ID: Iso3166Alpha2Code
        val IE: Iso3166Alpha2Code
        val IL: Iso3166Alpha2Code
        val IM: Iso3166Alpha2Code
        val IN: Iso3166Alpha2Code
        val IO: Iso3166Alpha2Code
        val IQ: Iso3166Alpha2Code
        val IR: Iso3166Alpha2Code
        val IS: Iso3166Alpha2Code
        val IT: Iso3166Alpha2Code
        val JE: Iso3166Alpha2Code
        val JM: Iso3166Alpha2Code
        val JO: Iso3166Alpha2Code
        val JP: Iso3166Alpha2Code
        val KE: Iso3166Alpha2Code
        val KG: Iso3166Alpha2Code
        val KH: Iso3166Alpha2Code
        val KI: Iso3166Alpha2Code
        val KM: Iso3166Alpha2Code
        val KN: Iso3166Alpha2Code
        val KP: Iso3166Alpha2Code
        val KR: Iso3166Alpha2Code
        val KW: Iso3166Alpha2Code
        val KY: Iso3166Alpha2Code
        val KZ: Iso3166Alpha2Code
        val LA: Iso3166Alpha2Code
        val LB: Iso3166Alpha2Code
        val LC: Iso3166Alpha2Code
        val LI: Iso3166Alpha2Code
        val LK: Iso3166Alpha2Code
        val LR: Iso3166Alpha2Code
        val LS: Iso3166Alpha2Code
        val LT: Iso3166Alpha2Code
        val LU: Iso3166Alpha2Code
        val LV: Iso3166Alpha2Code
        val LY: Iso3166Alpha2Code
        val MA: Iso3166Alpha2Code
        val MC: Iso3166Alpha2Code
        val MD: Iso3166Alpha2Code
        val ME: Iso3166Alpha2Code
        val MF: Iso3166Alpha2Code
        val MG: Iso3166Alpha2Code
        val MH: Iso3166Alpha2Code
        val MK: Iso3166Alpha2Code
        val ML: Iso3166Alpha2Code
        val MM: Iso3166Alpha2Code
        val MN: Iso3166Alpha2Code
        val MO: Iso3166Alpha2Code
        val MP: Iso3166Alpha2Code
        val MQ: Iso3166Alpha2Code
        val MR: Iso3166Alpha2Code
        val MS: Iso3166Alpha2Code
        val MT: Iso3166Alpha2Code
        val MU: Iso3166Alpha2Code
        val MV: Iso3166Alpha2Code
        val MW: Iso3166Alpha2Code
        val MX: Iso3166Alpha2Code
        val MY: Iso3166Alpha2Code
        val MZ: Iso3166Alpha2Code
        val NA: Iso3166Alpha2Code
        val NC: Iso3166Alpha2Code
        val NE: Iso3166Alpha2Code
        val NF: Iso3166Alpha2Code
        val NG: Iso3166Alpha2Code
        val NI: Iso3166Alpha2Code
        val NL: Iso3166Alpha2Code
        val NO: Iso3166Alpha2Code
        val NP: Iso3166Alpha2Code
        val NR: Iso3166Alpha2Code
        val NU: Iso3166Alpha2Code
        val NZ: Iso3166Alpha2Code
        val OM: Iso3166Alpha2Code
        val PA: Iso3166Alpha2Code
        val PE: Iso3166Alpha2Code
        val PF: Iso3166Alpha2Code
        val PG: Iso3166Alpha2Code
        val PH: Iso3166Alpha2Code
        val PK: Iso3166Alpha2Code
        val PL: Iso3166Alpha2Code
        val PM: Iso3166Alpha2Code
        val PN: Iso3166Alpha2Code
        val PR: Iso3166Alpha2Code
        val PS: Iso3166Alpha2Code
        val PT: Iso3166Alpha2Code
        val PW: Iso3166Alpha2Code
        val PY: Iso3166Alpha2Code
        val QA: Iso3166Alpha2Code
        val RE: Iso3166Alpha2Code
        val RO: Iso3166Alpha2Code
        val RS: Iso3166Alpha2Code
        val RU: Iso3166Alpha2Code
        val RW: Iso3166Alpha2Code
        val SA: Iso3166Alpha2Code
        val SB: Iso3166Alpha2Code
        val SC: Iso3166Alpha2Code
        val SD: Iso3166Alpha2Code
        val SE: Iso3166Alpha2Code
        val SG: Iso3166Alpha2Code
        val SH: Iso3166Alpha2Code
        val SI: Iso3166Alpha2Code
        val SJ: Iso3166Alpha2Code
        val SK: Iso3166Alpha2Code
        val SL: Iso3166Alpha2Code
        val SM: Iso3166Alpha2Code
        val SN: Iso3166Alpha2Code
        val SO: Iso3166Alpha2Code
        val SR: Iso3166Alpha2Code
        val SS: Iso3166Alpha2Code
        val ST: Iso3166Alpha2Code
        val SV: Iso3166Alpha2Code
        val SX: Iso3166Alpha2Code
        val SY: Iso3166Alpha2Code
        val SZ: Iso3166Alpha2Code
        val TC: Iso3166Alpha2Code
        val TD: Iso3166Alpha2Code
        val TF: Iso3166Alpha2Code
        val TG: Iso3166Alpha2Code
        val TH: Iso3166Alpha2Code
        val TJ: Iso3166Alpha2Code
        val TK: Iso3166Alpha2Code
        val TL: Iso3166Alpha2Code
        val TM: Iso3166Alpha2Code
        val TN: Iso3166Alpha2Code
        val TO: Iso3166Alpha2Code
        val TR: Iso3166Alpha2Code
        val TT: Iso3166Alpha2Code
        val TV: Iso3166Alpha2Code
        val TW: Iso3166Alpha2Code
        val TZ: Iso3166Alpha2Code
        val UA: Iso3166Alpha2Code
        val UG: Iso3166Alpha2Code
        val UM: Iso3166Alpha2Code
        val US: Iso3166Alpha2Code
        val UY: Iso3166Alpha2Code
        val UZ: Iso3166Alpha2Code
        val VA: Iso3166Alpha2Code
        val VC: Iso3166Alpha2Code
        val VE: Iso3166Alpha2Code
        val VG: Iso3166Alpha2Code
        val VI: Iso3166Alpha2Code
        val VN: Iso3166Alpha2Code
        val VU: Iso3166Alpha2Code
        val WF: Iso3166Alpha2Code
        val WS: Iso3166Alpha2Code
        val YE: Iso3166Alpha2Code
        val YT: Iso3166Alpha2Code
        val ZA: Iso3166Alpha2Code
        val ZM: Iso3166Alpha2Code
        val ZW: Iso3166Alpha2Code
    }
}


/** The 2-letter continent codes Cloudflare uses */

@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{AF: 'AF', AN: 'AN', AS: 'AS', EU: 'EU', NA: 'NA', OC: 'OC', SA: 'SA'}/*union*/)""")
sealed external interface ContinentCode {
    companion object {
        val AF: ContinentCode
        val AN: ContinentCode
        val AS: ContinentCode
        val EU: ContinentCode
        val NA: ContinentCode
        val OC: ContinentCode
        val SA: ContinentCode
    }
}


typealias CfProperties<HostMetadata /* default is Any? */> = Any /* IncomingRequestCfProperties<HostMetadata> | RequestInitCfProperties */

// Copyright (c) 2022-2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0

external interface D1Result<T /* default is Any? */> {
    var results: Array<T>
    var success: Boolean
    var meta: Any?
    var error: Nothing?
}


external interface D1ExecResult {
    var count: Double
    var duration: Double
}


external class D1Database {
    fun prepare(query: String): D1PreparedStatement
    fun dump(): Promise<ArrayBuffer>
    fun <T /* default is Any? */> batch(statements: Array<D1PreparedStatement>): Promise<Array<D1Result<T>>>
    fun exec(query: String): Promise<D1ExecResult>
}


external class D1PreparedStatement {
    fun bind(vararg values: Any?): D1PreparedStatement
    fun <T /* default is Record<String, Any?> */> first(): Promise<T?>
    fun <T /* default is Any? */> first(colName: String): Promise<T?>
    fun <T /* default is Record<String, Any?> */> run(): Promise<D1Result<T>>
    fun <T /* default is Record<String, Any?> */> all(): Promise<D1Result<T>>
    fun <T /* default is Array<Any?> */> raw(): Promise<Array<T>>
}


// Copyright (c) 2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0
/**
 * An email message that can be sent from a Worker.
 */

external interface EmailMessage {
    /**
     * Envelope From attribute of the email message.
     */
    val from: String

    /**
     * Envelope To attribute of the email message.
     */
    val to: String
}


/**
 * An email message that is sent to a consumer Worker and can be rejected/forwarded.
 */

external interface ForwardableEmailMessage : EmailMessage {
    /**
     * Stream of the email message content.
     */
    val raw: ReadableStream<Any>

    /**
     * An [Headers object](https://developer.mozilla.org/en-US/docs/Web/API/Headers).
     */
    val headers: Headers

    /**
     * Size of the email message content.
     */
    val rawSize: Double

    /**
     * Reject this email message by returning a permanent SMTP error back to the connecting client including the given reason.
     * @param reason The reject reason.
     * @returns void
     */
    fun setReject(reason: String): Unit

    /**
     * Forward this email message to a verified destination address of the account.
     * @param rcptTo Verified destination address.
     * @param headers A [Headers object](https://developer.mozilla.org/en-US/docs/Web/API/Headers).
     * @returns A promise that resolves when the email message is forwarded.
     */
    fun forward(rcptTo: String, headers: Headers = definedExternally): Promise<Unit>
}


/**
 * A binding that allows a Worker to send email messages.
 */

external interface SendEmail {
    fun send(message: EmailMessage): Promise<Unit>
}


abstract external class EmailEvent : ExtendableEvent {
    val message: ForwardableEmailMessage
}


typealias EmailExportedHandler<Env /* default is Any? */> = (message: ForwardableEmailMessage, env: Env, ctx: ExecutionContext) -> Any /* void | Promise<void> */


//external object String /* "cloudflare:email" */ {
//    external var _EmailMessage: Temp3
//    /* export { _EmailMessage as EmailMessage }; */
//}


// Copyright (c) 2022-2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0
typealias Params<T> = Record<String, Any /* string | string[] */>


external interface EventContext<Env, P : String, Data> {
    var request: Request
    var functionPath: String
    var waitUntil: (promise: Promise<Any?>) -> Unit
    var passThroughOnException: () -> Unit
    var next: (input: (Any /* Request | string */)? /* use undefined for default */, init: RequestInit? /* use undefined for default */) -> Promise<Response>
    var env: Any /* Env & {
    ASSETS: {
        fetch: typeof fetch;
    };
} */
    var params: Params<P>
    var data: Data
}


//typealias PagesFunction<Env /* default is Any? */, Params : String /* default is Any? */, Data : Record<String, Any?> /* default is Record<String, Any?> */> = (context: EventContext<Env, Params, Data>) -> Any /* Response | Promise<Response> */


external interface EventPluginContext<Env, P : String, Data, PluginArgs> {
    var request: Request
    var functionPath: String
    var waitUntil: (promise: Promise<Any?>) -> Unit
    var passThroughOnException: () -> Unit
    var next: (input: (Any /* Request | string */)? /* use undefined for default */, init: RequestInit? /* use undefined for default */) -> Promise<Response>
    var env: Any /* Env & {
    ASSETS: {
        fetch: typeof fetch;
    };
} */
    var params: Params<P>
    var data: Data
    var pluginArgs: PluginArgs
}


//typealias PagesPluginFunction<Env /* default is Any? */, Params : String /* default is Any? */, Data : Record<String, Any?> /* default is Record<String, Any?> */, PluginArgs /* default is Any? */> = (context: EventPluginContext<Env, Params, Data, PluginArgs>) -> Any /* Response | Promise<Response> */


//external object String /* "assets:*" */ {
//    external val onRequest: PagesFunction
//}


// Copyright (c) 2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0
// https://developers.cloudflare.com/pub-sub/
// PubSubMessage represents an incoming PubSub message.
// The message includes metadata about the broker, the client, and the payload
// itself.

external interface PubSubMessage {
    // Message ID
    val mid: Double

    // MQTT broker FQDN in the form mqtts://BROKER.NAMESPACE.cloudflarepubsub.com:PORT
    val broker: String

    // The MQTT topic the message was sent on.
    val topic: String

    // The client ID of the client that published this message.
    val clientId: String

    // The unique identifier (JWT ID) used by the client to authenticate, if token
// auth was used.
    val jti: String?

    // A Unix timestamp (seconds from Jan 1, 1970), set when the Pub/Sub Broker
// received the message from the client.
    val receivedAt: Double

    // An (optional) string with the MIME type of the payload, if set by the
// client.
    val contentType: String

    // Set to 1 when the payload is a UTF-8 string
// https://docs.oasis-open.org/mqtt/mqtt/v5.0/os/mqtt-v5.0-os.html#_Toc3901063
    val payloadFormatIndicator: Double

    // Pub/Sub (MQTT) payloads can be UTF-8 strings, or byte arrays.
// You can use payloadFormatIndicator to inspect this before decoding.
    var payload: Any /* string | Uint8Array */
}


// JsonWebKey extended by kid parameter

external interface JsonWebKeyWithKid : JsonWebKey {
    // Key Identifier of the JWK
    val kid: String
}


// Copyright (c) 2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0

//external object String /* "cloudflare:sockets" */ {
//    external fun _connect(address: String, options: SocketOptions = definedExternally): Socket
//
//    external fun _connect(address: SocketAddress, options: SocketOptions = definedExternally): Socket
//    /* export { _connect as connect }; */
//}


// Copyright (c) 2023 Cloudflare, Inc.
// Licensed under the Apache 2.0 license found in the LICENSE file or at:
//     https://opensource.org/licenses/Apache-2.0
// https://developers.cloudflare.com/cloudflare-for-platforms/workers-for-platforms/

external interface DynamicDispatchLimits {
    /**
     * Limit CPU time in milliseconds.
     */
    var cpuMs: Double?

    /**
     * Limit number of subrequests.
     */
    var subRequests: Double?
}


external interface DynamicDispatchOptions {
    /**
     * Limit resources of invoked Worker script.
     */
    var limits: DynamicDispatchLimits?

    /**
     * Arguments for outbound Worker script, if configured.
     */
    var outbound: (DynamicDispatchOptionsOutbound)?
}


external interface DispatchNamespace {
    /**
     * @param name Name of the Worker script.
     * @param args Arguments to Worker script.
     * @param options Options for Dynamic Dispatch invocation.
     * @returns A Fetcher object that allows you to send requests to the Worker script.
     * @throws If the Worker script does not exist in this dispatch namespace, an error will be thrown.
     */
    fun get(
        name: String,
        args: DispatchNamespaceGetArgs = definedExternally,
        options: DynamicDispatchOptions = definedExternally
    ): Fetcher
}


//external interface Temp1<R, R, R, R> {
//    var prototype: ReadableStream
//    /* new (underlyingSource: UnderlyingByteSource, strategy?: QueuingStrategy<Uint8Array>): ReadableStream<Uint8Array>; */
//    /* new <R = any>(underlyingSource?: UnderlyingSource<R>, strategy?: QueuingStrategy<R>): ReadableStream<R>; */
//}


external interface Temp2 {
    /* new (): {
        0: WebSocket;
        1: WebSocket;
    }; */
}


external interface RequestInitCfPropertiesImageTrim {
    var left: Double?
    var top: Double?
    var right: Double?
    var bottom: Double?
}


external interface Temp3 {
    var prototype: EmailMessage
    /* new (from: string, to: string, raw: ReadableStream | string): EmailMessage; */
}


external interface DynamicDispatchOptionsOutbound {


    @Suppress(
        "DEPRECATION",
        "NATIVE_INDEXER_KEY_SHOULD_BE_STRING_OR_NUMBER",
    )
    @nativeGetter
    operator fun get(key: String): Any?


    @Suppress(
        "DEPRECATION",
        "NATIVE_INDEXER_KEY_SHOULD_BE_STRING_OR_NUMBER",
    )
    @nativeSetter
    operator fun set(key: String, value: Any?)


}


external interface DispatchNamespaceGetArgs {


    @Suppress(
        "DEPRECATION",
        "NATIVE_INDEXER_KEY_SHOULD_BE_STRING_OR_NUMBER",
    )
    @nativeGetter
    operator fun get(key: String): Any?


    @Suppress(
        "DEPRECATION",
        "NATIVE_INDEXER_KEY_SHOULD_BE_STRING_OR_NUMBER",
    )
    @nativeSetter
    operator fun set(key: String, value: Any?)


}

@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{automatic: 'automatic', manual: 'manual'}/*union*/)""")
sealed external interface ResponseInitEncodeBody {
    companion object {
        val automatic: ResponseInitEncodeBody
        val manual: ResponseInitEncodeBody
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{: ''}/*union*/)""")
sealed external interface UnderlyingSourceType {
//    companion object {
//        val : UnderlyingSourceType
//    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{gzip: 'gzip', deflate: 'deflate', deflateRaw: 'deflate-raw'}/*union*/)""")
sealed external interface CompressionStreamFormat {
    companion object {
        val gzip: CompressionStreamFormat
        val deflate: CompressionStreamFormat
        val deflateRaw: CompressionStreamFormat
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{gzip: 'gzip', deflate: 'deflate', deflateRaw: 'deflate-raw'}/*union*/)""")
sealed external interface DecompressionStreamFormat {
    companion object {
        val gzip: DecompressionStreamFormat
        val deflate: DecompressionStreamFormat
        val deflateRaw: DecompressionStreamFormat
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{scaleDown: 'scale-down', contain: 'contain', cover: 'cover', crop: 'crop', pad: 'pad'}/*union*/)""")
sealed external interface BasicImageTransformationsFit {
    companion object {
        val scaleDown: BasicImageTransformationsFit
        val contain: BasicImageTransformationsFit
        val cover: BasicImageTransformationsFit
        val crop: BasicImageTransformationsFit
        val pad: BasicImageTransformationsFit
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{lossy: 'lossy', lossless: 'lossless', off: 'off'}/*union*/)""")
sealed external interface RequestInitCfPropertiesPolish {
    companion object {
        val lossy: RequestInitCfPropertiesPolish
        val lossless: RequestInitCfPropertiesPolish
        val off: RequestInitCfPropertiesPolish
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{avif: 'avif', webp: 'webp', json: 'json', jpeg: 'jpeg', png: 'png'}/*union*/)""")
sealed external interface RequestInitCfPropertiesImageFormat {
    companion object {
        val avif: RequestInitCfPropertiesImageFormat
        val webp: RequestInitCfPropertiesImageFormat
        val json: RequestInitCfPropertiesImageFormat
        val jpeg: RequestInitCfPropertiesImageFormat
        val png: RequestInitCfPropertiesImageFormat
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{keep: 'keep', copyright: 'copyright', none: 'none'}/*union*/)""")
sealed external interface RequestInitCfPropertiesImageMetadata {
    companion object {
        val keep: RequestInitCfPropertiesImageMetadata
        val copyright: RequestInitCfPropertiesImageMetadata
        val none: RequestInitCfPropertiesImageMetadata
    }
}


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
@JsName("""(/*union*/{`1`: '1', `0`: '0'}/*union*/)""")
sealed external interface IncomingRequestCfPropertiesTLSClientAuthCertRevoked {
    companion object {
        val `1`: IncomingRequestCfPropertiesTLSClientAuthCertRevoked
        val `0`: IncomingRequestCfPropertiesTLSClientAuthCertRevoked
    }
}
    