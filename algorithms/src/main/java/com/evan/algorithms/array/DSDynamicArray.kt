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

    override fun add(elm: T) {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun remove(elm: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun indexOf(elm: Any?): Int {
        TODO("Not yet implemented")
    }

    override fun contains(elm: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DEFAULT_CAP = 1 shl 4
    }
}