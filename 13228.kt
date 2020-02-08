import java.lang.Math.abs
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    while(--T >= 0){
        var A1:Int = nextInt()
        var B1:Int = nextInt()
        var C1:Int = nextInt()

        var A2:Int = nextInt()
        var B2:Int = nextInt()
        var C2:Int = nextInt()

        var res = C1 + abs(A2-A1) + abs(B2 - B1) + C2
        println(res)
    }
}