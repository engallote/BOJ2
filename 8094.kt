import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var arr:IntArray = IntArray(M)

    for(i in 0 until M)
        arr[i] = nextInt()

    Arrays.sort(arr)

    if(M == 1){
        println(1)
        return
    }

    if(arr[M-1] + arr[M-2] <= N) println(M/2 + M%2)
    else{
        var res:Int = 0
        var l:Int = 0
        var r:Int = M - 1
        while(l <= r){
            if(arr[l] + arr[r] <= N){
                ++res
                ++l
                --r
            }
            else{
                ++res
                --r
            }
        }
        println(res)
    }
}
