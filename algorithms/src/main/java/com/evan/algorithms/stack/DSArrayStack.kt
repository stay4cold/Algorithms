package com.evan.algorithms.stack

import java.util.*

/**
 * @author:  Evan
 * Date:    2021-02-25
 * Description:
 */
class DSArrayStack<T>(private var capacity:Int = 16) : DSStack<T> {

    private var size = 0
    private var arr = arrayOfNulls<Any?>(capacity) as Array<T?>

    init {
        require(capacity > 0) { "Illegal capacity: $capacity" }
        if (capacity == 0) capacity = 1
    }

    override fun size(): Int = size

    override fun isEmpty(): Boolean = size == 0

    private fun increaseCapacity() {
        capacity *= 2
        arr = arr.copyOf(capacity)
    }

    override fun push(elm: T?) {
        if (size == capacity) {
            increaseCapacity()
        }
        arr[size++] = elm
    }

    override fun pop(): T? {
        if (isEmpty()) throw EmptyStackException()
        return arr[--size]
    }

    override fun peek(): T? {
        if (isEmpty()) throw EmptyStackException()
        return arr[size - 1]
    }

    override fun search(elm: T?): Int = arr.indexOf(elm)

    override fun iterator(): Iterator<T?> = object : Iterator<T?> {
        private var index = 0
        override fun hasNext(): Boolean = index < size

        override fun next(): T? = arr[index++]
    }
}