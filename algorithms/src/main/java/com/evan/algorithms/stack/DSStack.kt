package com.evan.algorithms.stack

/**
 * @author:  Evan
 * Date:    2021-02-25
 * Description:
 */
interface DSStack<T> : Iterable<T?> {
    fun size(): Int

    fun isEmpty(): Boolean

    fun push(elm: T?)

    fun pop(): T?

    fun peek(): T?

    fun search(elm: T?): Int
}