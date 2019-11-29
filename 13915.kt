import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(hasNext()){
        var N:Int = nextInt()
        var pq:PriorityQueue<Int> = PriorityQueue()
        var hs:HashSet<Int> = HashSet()
        var res:HashSet<String> = HashSet()
        for(i in 0 until N){
            var tmp = next()
            hs.clear()
            pq.clear()
            for(j in tmp){
                if(hs.contains(Integer.parseInt(j.toString()))) continue
                pq.offer(Integer.parseInt(j.toString()))
                hs.add(Integer.parseInt(j.toString()))
            }
            res.add(hs.toString())
        }
        println(res.size)
    }
}