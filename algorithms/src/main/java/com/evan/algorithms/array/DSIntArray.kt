package com.evan.algorithms.array


/**
 * @author:  Evan
 * Date:    2021-02-24
 * Description:
 */
class DSIntArray @JvmOverloads constructor(private var capacity: Int = DEFAULT_CAP) : DSArray<Int> {

    private var arr: IntArray
    private var len = 0

    init {
        require(capacity >= 0) { "Illegal Capacity: $capacity" }
        arr = IntArray(capacity)
    }

    override fun size(): Int = len

    override fun isEmpty(): Boolean = size() == 0

    override fun get(index: Int): Int {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        return arr[index]
    }

    override fun set(index: Int, value: Int?) {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        arr[index] = value!!
    }

    override fun clear() {
        for (i in 0 until len) arr[i] = 0
        len = 0
    }

    override fun add(elm: Int) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1
            else capacity *= 2
            arr = arr.copyOf(capacity)
        }
        arr[len++] = elm
    }

    override fun removeAt(index: Int): Int {
        if (index < 0 || index >= len) throw IndexOutOfBoundsException()
        var data = arr[index]
        arr = arr.copyInto(arr, index, index + 1, len)
        len--
        return data
    }

    override fun remove(elm: Any?): Boolean {
        for (i in 0 until len) {
            if (arr[i] == elm) {
                removeAt(i)
                return true
            }
        }
        return false
    }

    override fun indexOf(elm: Any?): Int {
        for ((index, value) in arr.withIndex()) {
            if (value == elm) {
                return index
            }
        }
        return -1
    }

    override fun contains(elm: Any?): Boolean = indexOf(elm) != -1

    override fun toString(): String {
        return if (len == 0) "[]"
        else {
            var sb = StringBuilder("[")
            for (i in 0 until len-1) {
                sb.append("${arr[i]}, ")
            }
            sb.append("${arr[len - 1]}]")
            sb.toString()
        }
    }

    fun reverse() = arr.reverse()

    fun binarySearch(elm: Int): Int = arr.binarySearch(elm)

    fun sort() = arr.sort(0, len)

    override fun iterator(): Iterator<Int> = object : MutableIterator<Int> {
        private var index = 0
        override fun hasNext(): Boolean = index < len

        override fun next(): Int = arr[index++]

        override fun remove() = throw UnsupportedOperationException()
    }

    companion object {
        private const val DEFAULT_CAP = 1 shl 3

        @JvmStatic
        fun main(args: Array<String>) {
            val ar = DSIntArray(50)
            ar.add(3)
            ar.add(7)
            ar.add(6)
            ar.add(-2)
            ar.sort() // [-2, 3, 6, 7]

            // Prints [-2, 3, 6, 7]
            for (i in 0 until ar.size()) println(ar[i])

            // Prints [-2, 3, 6, 7]
            println(ar)
        }
    }
}