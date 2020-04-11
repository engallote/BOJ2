import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var pq:PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    for(i in 1..3) pq.offer(nextInt())
    var sum:Int = 0

    while(pq.size > 1) sum += pq.poll()
    println(sum)
}