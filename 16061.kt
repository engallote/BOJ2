import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var K:Int = nextInt()
    var d:Int = nextInt()
    var pq:PriorityQueue<Pair<String, Int>> = PriorityQueue(compareBy<Pair<String, Int>> {-it.second})

    for(i in 1..N){
        var name:String = next()
        var num:Int = nextInt()
        pq.offer(Pair(name, num))
    }

    var sum:Int = 0
    var cnt:Int = 0
    var ans:StringBuilder = StringBuilder()
    while(!pq.isEmpty()){
        var p:Pair<String, Int> = pq.poll()

        sum += p.second
        ++cnt
        ans.append(p.first + ", YOU ARE FIRED!\n")
        if(cnt == d || sum >= K) break
    }

    if(sum >= K){
        println(cnt)
        println(ans)
    }
    else println("impossible")
}