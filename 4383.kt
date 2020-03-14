import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(hasNextInt()){
        var N:Int = nextInt()
        var pre:Int = 0
        var arr:IntArray = IntArray(N)
        for(i in 0 until N){
            var num:Int = nextInt()
            if(i == 0){
                pre = num
                continue
            }
            else{
                var tmp:Int = abs(num - pre)
                if(tmp in 1 until N) arr[tmp] = 1
				pre = num
            }
        }
        var flag:Boolean = true
        for(i in 1 until N)
            if(arr[i] == 0){
                flag = false
                break
            }
        if(flag) println("Jolly")
        else println("Not jolly")
    }
}