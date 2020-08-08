import java.lang.Integer.max
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var max:Int = 0
    var hs:HashMap<String, Int> = HashMap()

    for(i in 1..N){
        var name:String = next()
        if(!hs.containsKey(name)) hs[name] = 1
        else hs.replace(name, hs[name]!! + 1)
        max = max(max, hs[name]!!)
    }

    var pq:PriorityQueue<String> = PriorityQueue()
    var it:Iterator<String> = hs.keys.iterator()
    while(it.hasNext()){
        var key:String = it.next()
        var value:Int = hs[key]!!

        if(value == max) pq.offer(key)
    }

    while(!pq.isEmpty())
        println(pq.poll())
}