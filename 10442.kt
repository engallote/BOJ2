import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var tc:Int = 1
    while(hasNext()){
        var N:Int = nextInt()
        var arr1:ArrayList<Pair<Int,Int>> = ArrayList()
        var arr2:ArrayList<Pair<Int,Int>> = ArrayList()

        for(i in 1..N) arr1.add(Pair(i, nextInt()))
        for(i in 1..N) arr2.add(Pair(i, nextInt()))

        var list1 = arr1.sortedWith(compareBy({it.second}, {it.first})).asReversed()
        var list2 = arr2.sortedWith(compareBy({it.second}, {it.first})).asReversed()
        var res:Int = -1
        for(i in 0 until N){
            if(list1[i].first != list2[i].first){
                res = i + 1
                break
            }
        }

        if(res == -1) println("Case $tc: agree")
        else println("Case $tc: $res")
        ++tc
    }
}