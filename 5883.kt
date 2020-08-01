import java.util.*
import kotlin.collections.HashSet
import kotlin.math.max

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var arr:IntArray = IntArray(N)
    var hs:HashSet<Int> = HashSet()

    for(i in 0 until N){
        arr[i] = nextInt()
        hs.add(arr[i])
    }

    var it:Iterator<Int> = hs.iterator()
    var res:Int = 1

    while(it.hasNext()){
        var num:Int = it.next()
        var prev:Int = -1
        var cnt:Int = 0

        for(i in 0 until N){
            if(arr[i] == num) continue
            else{
                if(prev == arr[i]) ++cnt
                else{
                    prev = arr[i];
                    res = max(res, cnt)
                    cnt = 1
                }
            }
        }
        res = max(res, cnt)
    }

    println(res)
}