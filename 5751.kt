import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var N:Int = nextInt()
        if(N == 0) break

        var m:Int = 0
        var j:Int = 0
        for(i in 1..N){
            var num:Int = nextInt()
            if(num == 0) ++m
            else ++j
        }

        println("Mary won $m times and John won $j times")
    }
}