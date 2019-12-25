import java.lang.StringBuilder
import kotlin.collections.ArrayList
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var arr:ArrayList<Int> = ArrayList()
    var chk:BooleanArray = BooleanArray(33000)
    for(i in 2 until 33000){
        if(!chk[i]) arr.add(i)
        for(j in i+i until 33000 step i) chk[j] = true
    }
    var T:Int = nextInt()
    while(--T >= 0){
        var res:Int = 0
        var sb:StringBuilder = StringBuilder()
        var num:Int = nextInt()

        for(i in 0 until arr.size){
            if(arr[i] >= num) break
            for(j in i until arr.size){
                if(arr[i] + arr[j] > num) break
                if(arr[i] + arr[j] == num){
                    ++res
                    var a = arr[i]
                    var b = arr[j]
                    sb.append("$a+$b\n")
                }
            }
        }

        println("$num has $res representation(s)")
        println(sb.toString())
    }
}