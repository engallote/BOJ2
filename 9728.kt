import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val T:Int = nextInt()

    for(tc in 1..T){
        val N:Int = nextInt()
        val M:Int = nextInt()
        val arr:IntArray = IntArray(N)
        var hs:HashSet<Int> = HashSet()

        for(i in 0 until N) {
            arr[i] = nextInt()
            hs.add(arr[i])
        }

        var res:Int = 0

        for(i in 0 until N)
            if(hs.contains(M-arr[i])) ++res

        res /= 2
        println("Case #$tc: $res")
    }
}