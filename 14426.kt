import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var arr:Array<String> = Array(N){"."}

    for(i in 0 until N)
        arr[i] = next()

    var res:Int = 0
    for(i in 1..M){
        var str:String = next()

        for(j in 0 until N){
            var idx:Int = arr[j].indexOf(str)
            if(idx == 0){
                ++res
                break
            }
        }
    }

    println(res)
}