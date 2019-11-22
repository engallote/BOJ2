import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
        var sc:Scanner = Scanner(System.`in`)
        var arr:IntArray = IntArray(26)
        var max:Int = 0
        for(i in 0 until 5){
            var str:String = sc.next()
            if(str[0] in 'A'..'Z'){
                ++arr[str[0]-'A'+1]
                max = max(max, arr[str[0]-'A'+1])
            }
            else{
                ++arr[str[0]-'0']
                max = max(max, arr[str[0]-'0'])
            }
        }
        println(max)
    }