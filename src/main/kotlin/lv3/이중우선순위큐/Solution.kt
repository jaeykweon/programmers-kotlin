package lv3.이중우선순위큐

import java.util.PriorityQueue

class Solution {

    private val doublePriorityQueue = DoublePriorityQueue()

    fun solution(operations: Array<String>): IntArray {

        operations.forEach { operation ->
            val (command,data) = operation.split(" ").let { Pair(it.first(), it.last().toInt()) }
            when(command) {
                Input -> doublePriorityQueue.add(data)
                Delete -> {
                    when (data) {
                        DeleteMax -> doublePriorityQueue.deleteMax()
                        DeleteMin -> doublePriorityQueue.deleteMin()
                        else -> throw IllegalArgumentException()
                    }
                }
                else -> throw IllegalArgumentException()
            }
        }
        return intArrayOf(
            doublePriorityQueue.getMax() ?: 0,
            doublePriorityQueue.getMin() ?: 0
        )
    }

    companion object Command {
        const val Input = "I"
        const val Delete = "D"
        const val DeleteMax = 1
        const val DeleteMin = -1
    }
}

class DoublePriorityQueue {
    private val ascPQ = PriorityQueue<Int>(reverseOrder())
    private val dscPQ = PriorityQueue<Int>()

    fun add(input: Int) {
        ascPQ.add(input)
        dscPQ.add(input)
    }

    fun deleteMax() {
        if (ascPQ.isEmpty()) return;
        val removed = ascPQ.poll()
        dscPQ.remove(removed)
    }

    fun deleteMin() {
        if (dscPQ.isEmpty()) return;
        val removed = dscPQ.poll()
        ascPQ.remove(removed)
    }

    fun getMax(): Int? = ascPQ.peek()

    fun getMin(): Int? = dscPQ.peek()
}