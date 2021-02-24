package com.evan.algorithms.array

/**
 * @author:  Evan
 * Date:    2021-02-24
 * Description:
 */
interface DSArray<T> : Iterable<T?> {

    fun size(): Int

    fun isEmpty(): Boolean

    operator fun get(index: Int): T?

    operator fun set(index: Int, value: T?)

    fun clear()

    fun add(elm: T?)

    fun removeAt(index: Int): T?

    fun remove(elm: Any?): Boolean

    fun indexOf(elm: Any?): Int

    fun contains(elm: Any?): Boolean

    override fun toString(): String
}