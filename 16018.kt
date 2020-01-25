import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var yest:CharArray = next().toCharArray()
    var today:CharArray = next().toCharArray()
    var res:Int = 0

    for(i in 0 until N){
        if(yest[i] == today[i] && yest[i] == 'C') ++res
    }

    println(res)
}