import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var arr:IntArray = IntArray(3)

    for(i in 1..3){
        var num:Int = nextInt()
        ++arr[num]
    }

    if(arr[1] < arr[2]) println(2)
    else println(1)
}