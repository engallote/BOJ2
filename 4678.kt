import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var num:String = next()
        if(num == "0") break

        var res:Long = 0

        for(i in num.indices){
            var tmp:Long = (num[i] - '0').toLong()
            var tmp2:Long = 2.0.pow((num.length - i).toDouble()).toLong() - 1
			
            res += tmp * tmp2
        }

        println(res)
    }
}
