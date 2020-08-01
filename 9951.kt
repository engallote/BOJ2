import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val hs:HashSet<String> = HashSet()
    val pq:PriorityQueue<String> = PriorityQueue()
    while(true){
        val str:String = nextLine().toLowerCase()
        if(str == "#") break

        pq.clear()
        hs.clear()

        val list:List<String> = str.split(" ")
        var flag = false
        var tmp = ""
        for(i in list.indices){
            tmp = ""
            flag = false
            for(j in list[i].indices){
                if(list[i][j] in 'A'..'Z' || list[i][j] in 'a'..'z'){
                    tmp += list[i][j]
                    flag = true
                }
                else if(list[i][j] in '0'..'9') tmp += list[i][j]
                else continue
            }

            if(flag) hs.add(tmp)
        }

        val it:Iterator<String> = hs.iterator()
        while(it.hasNext()) pq.offer(it.next())
        while(!pq.isEmpty()) println(pq.poll())
        println()
    }
}