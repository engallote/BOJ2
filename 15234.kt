import java.util.*

fun main(args: Array<String>) {
        var sc:Scanner = Scanner(System.`in`)
        var N = sc.nextInt()
        var K = sc.nextInt()
        var arr:IntArray = IntArray(N)
        for(i in 0 until N) arr[i] = sc.nextInt()
        arr.sort()

        var res:Int = 0
        for(i in 0 until N){
            for(j in i+1 until N){
                if(arr[i] + arr[j] == K) ++res
            }
        }
        println(res)
    }