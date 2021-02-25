package com.evan.algorithms.stack

/**
 * @author:  Evan
 * Date:    2021-02-25
 * Description:
 */
class DSIntStack(private val maxSize: Int) : DSStack<Int> {

    private val arr = IntArray(maxSize)
    private var pos = 0

    override fun size(): Int = pos

    override fun isEmpty(): Boolean = pos == 0

    override fun push(elm: Int?) {
        arr[pos++] = elm!!
    }

    override fun pop(): Int = arr[--pos]

    override fun peek(): Int = arr[pos - 1]

    override fun search(elm: Int?): Int {
        for (i in 0 until pos) {
            if (arr[i] == elm) {
                return i
            }
        }
        return -1
    }

    override fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var index = 0
        override fun hasNext(): Boolean = index < pos

        override fun next(): Int = arr[index]

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = DSIntStack(5)
            s.push(1)
            s.push(2)
            s.push(3)
            s.push(4)
            s.push(5)
            println(s.pop())
            println(s.pop())
            println(s.pop())
            while (!s.isEmpty()) println(s.pop())
            benchMarkTest()
        }

        private fun benchMarkTest() {
            val n = 10000000
            val intStack = DSIntStack(n)

            // IntStack times at around 0.0324 seconds
            var start = System.nanoTime()
            for (i in 0 until n) intStack.push(i)
            for (i in 0 until n) intStack.pop()
            var end = System.nanoTime()
            println("IntStack Time: " + (end - start) / 1e9)

            // ArrayDeque times at around 1.438 seconds
            //    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
            //    java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
//            val arrayDeque = ArrayDeque<Int>(n) // strangely the
//            // ArrayQueue is slower when you give it an initial capacity.
//            start = System.nanoTime()
//            for (i in 0 until n) arrayDeque.push(i)
//            for (i in 0 until n) arrayDeque.pop()
//            end = System.nanoTime()
//            println("ArrayDeque Time: " + (end - start) / 1e9)
            val listStack = DSListStack<Int>()
            start = System.nanoTime()
            for (i in 0 until n) listStack.push(i)
            for (i in 0 until n) listStack.pop()
            end = System.nanoTime()
            println("ListStack Time: " + (end - start) / 1e9)
            val arrayStack: DSStack<Int> = DSArrayStack()
            start = System.nanoTime()
            for (i in 0 until n) arrayStack.push(i)
            for (i in 0 until n) arrayStack.pop()
            end = System.nanoTime()
            println("ArrayStack Time: " + (end - start) / 1e9)
        }
    }
}