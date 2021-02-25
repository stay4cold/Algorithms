package com.evan.algorithms.stack

import java.util.*


/**
 * @author:  Evan
 * Date:    2021-02-25
 * Description:
 */
class DSListStack<T> : DSStack<T> {

    private val list = LinkedList<T>()

    override fun size(): Int = list.size

    override fun isEmpty(): Boolean = list.isEmpty()

    override fun push(elm: T?) = list.addLast(elm)

    override fun pop(): T? = list.removeLast()

    override fun peek(): T? = list.peekLast()

    override fun search(elm: T?): Int = list.lastIndexOf(elm)

    override fun iterator(): Iterator<T> = list.iterator()

}