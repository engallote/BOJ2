import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var N:Int = nextInt()
        var M:Int = nextInt()
        if(N == 0 && M == 0) break
        var arr:IntArray = IntArray(N+1)
        for(i in 0 until M)
            ++arr[nextInt()]

        var res:Int = 0
        for(i in 1..N)
            if(arr[i] > 1) ++res

        println(res)
    }
}