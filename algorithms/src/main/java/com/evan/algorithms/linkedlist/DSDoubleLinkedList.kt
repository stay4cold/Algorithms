package com.evan.algorithms.linkedlist

/**
 * @author:  Evan
 * Date:    2021-02-24
 * Description:
 */
class DSDoubleLinkedList<T> : Iterable<T?> {

    private var len = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun clear() {
        while (head != null) {
            val next = head!!.next
            head!!.prev = null
            head!!.next = null
            head!!.data = null
            head = next
        }
        head = null
        tail = null
        len = 0
    }

    fun size(): Int = len

    fun isEmpty(): Boolean = len == 0

    fun add(elm: T?) = addLast(elm)

    fun addFirst(elm: T?) {
        if (isEmpty()) {
            head = Node(elm, null, null)
            tail = head
        } else {
            Node(elm, null, head).also {
                head!!.prev = it
                head = it
            }
        }
        len++
    }

    fun addLast(elm: T?) {
        if (isEmpty()) {
            head = Node(elm, null, null)
            tail = head
        } else {
            Node(elm, tail, null).also {
                tail!!.next = it
                tail = it
            }
        }
        len++
    }

    fun addAt(index: Int, elm: T?) {
        if (index < 0 || index > len) throw IndexOutOfBoundsException()
        when (index) {
            0 -> {
                addFirst(elm)
                return
            }
            len -> {
                addLast(elm)
                return
            }
            else -> {
                var tmp = head
                for (i in 0 until index - 1) {
                    tmp = tmp!!.next
                }
                Node(elm, tmp, tmp!!.next).also {
                    tmp!!.next!!.prev = it
                    tmp.next = it
                }
                len++
            }
        }
    }

    fun peekFist(): T? {
        if (isEmpty()) throw RuntimeException("Empty List")
        return head!!.data
    }

    fun peekLast(): T? {
        if (isEmpty()) throw RuntimeException("Empty List")
        return tail!!.data
    }

    fun removeFirst(): T? {
        if (isEmpty()) throw RuntimeException("Empty List")
        val tmp = head
        if (tmp!!.next == null) {
            head = null
            tail = null
        } else {
            head = tmp.next
            head!!.prev = null
        }
        len--
        return tmp.data
    }

    fun removeLast(): T? {
        if (isEmpty()) throw RuntimeException("Empty List")
        val tmp = tail
        if (tmp!!.prev == null) {
            head = null
            tail = null
        } else {
            tail = tmp.prev
            tail!!.next = null
        }
        len--
        return tmp.data
    }

    fun removeAt(index: Int): T? {
        if (isEmpty()) throw RuntimeException("Empty List")
        if (index < 0 || index > len - 1) throw IndexOutOfBoundsException()
        when (index) {
            0 -> {
                return removeFirst()
            }
            len - 1 -> {
                return removeLast()
            }
            else -> {
                var tmp = head
                for (i in 0 until index) {
                    tmp = tmp!!.next
                }
                tmp!!.prev!!.next = tmp.next
                tmp.next!!.prev = tmp.prev
                len--
                return tmp.data
            }
        }
    }

    fun remove(obj: Any?): Boolean {
        val index = indexOf(obj)
        if (index != -1) {
            removeAt(index)
            return true
        }
        return false
    }

    fun indexOf(obj: Any?): Int {
        var index = 0
        var tmp = head
        while (tmp != null) {
            if (tmp.data == obj) {
                return index
            }
            tmp = tmp.next
            index++
        }
        return -1
    }

    fun contains(obj: Any?): Boolean = indexOf(obj) != -1

    override fun toString(): String {
        return super.toString()
    }


    override fun iterator(): Iterator<T?> = object : MutableIterator<T?> {
        private var tmp = head
        override fun hasNext(): Boolean = tmp != null

        override fun next(): T? {
            val data = tmp!!.data
            tmp = tmp!!.next
            return data
        }

        override fun remove() {
            TODO("Not yet implemented")
        }

    }

    private class Node<T>(
        var data: T?,
        var prev: Node<T>?,
        var next: Node<T>?
    ) {
        override fun toString(): String = data.toString()
    }
}