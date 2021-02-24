package com.evan.algorithms.array

/**
 * @author:  Evan
 * Date:    2021-02-24
 * Description:
 */
class DSDynamicArray<T> @JvmOverloads constructor(private var capacity: Int = DEFAULT_CAP) :
    DSArray<T> {

    private var arr: Array<T?>
    private var len = 0

    init {
        require(capacity >= 0) { "Illegal Capacity: $capacity" }
        arr = arrayOfNulls<Any>(capacity) as Array<T?>
    }

    override fun size(): Int = len

    override fun isEmpty(): Boolean = size() == 0

    override fun get(index: Int): T? {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        return arr[index]
    }

    override fun set(index: Int, value: T?) {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        arr[index] = value
    }

    override fun clear() {
        for (i in 0 until len) {
            arr[i] = null
        }
        len = 0
    }

    override fun add(elm: T?) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1
            else capacity *= 2
            arr.copyOf(capacity)
        }
        arr[len++] = elm
    }

    override fun removeAt(index: Int): T? {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        val data = arr[index]
        arr.copyInto(arr, index, index + 1, len)
        len--
        return data
    }

    override fun remove(elm: Any?): Boolean {
        val index = indexOf(elm)
        if (index != -1) {
            removeAt(index)
            return true
        }
        return false
    }

    override fun indexOf(elm: Any?): Int {
        for ((index, value) in arr.withIndex()) {
            if (value == elm) return index
        }
        return -1
    }

    override fun contains(elm: Any?): Boolean = indexOf(elm) != -1

    override fun toString(): String {
        return if (len == 0) "[]"
        else {
            val sb = StringBuilder("[")
            for (i in 0 until len - 1) {
                sb.append("${arr[i]}, ")
            }
            sb.append("${arr[len - 1]}]")
            sb.toString()
        }
    }

    override fun iterator(): MutableIterator<T?> = object : MutableIterator<T?> {
        private var index = 0

        override fun hasNext(): Boolean = index < len

        override fun next(): T? = arr[index++]

        override fun remove() = throw UnsupportedOperationException()

    }

    companion object {
        private const val DEFAULT_CAP = 1 shl 4

        @JvmStatic
        fun main(args: Array<String>) {
            val ar = DSDynamicArray<String>(10)
            ar.add("123")
            ar.add("456")
            ar.add("789")
            println(ar)
            ar.removeAt(1)
            println(ar)
            ar.remove("123")
            println(ar)
            ar.clear()
            println(ar)
        }
    }
}