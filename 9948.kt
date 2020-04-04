import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var arr = intArrayOf(0,31,28,31,30,31,30,31,31,30,31,30,31)
    var hs:HashMap<String, Int> = HashMap()
    hs["January"] = 1
    hs["February"] = 2
    hs["March"] = 3
    hs["April"] = 4
    hs["May"] = 5
    hs["June"] = 6
    hs["July"] = 7
    hs["August"] = 8
    hs["September"] = 9
    hs["October"] = 10
    hs["November"] = 11
    hs["December"] = 12

    while(true){
        var day:Int = nextInt()
        var str:String = next()

        if(day == 0 && str == "#") break

        var mon:Int = hs[str]!!
        if(mon < 8){
            if(day in 1..arr[mon]) println("Yes")
            else if(mon == 2 && day == 29) println("Unlucky")
        }
        else if(mon == 8){
            when {
                day < 4 -> println("Yes")
                day == 4 -> println("Happy birthday")
                else -> println("No")
            }
        }
        else println("No")
    }
}