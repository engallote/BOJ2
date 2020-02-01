import java.lang.Integer.min
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var A:Int = nextInt()
    var B:Int = nextInt()
    var C:Int = nextInt()
    var D:Int = nextInt()

    var cnt:Int = 1
    var res:Int = 0
    while(A * cnt < N) ++cnt
    res = B * cnt
    cnt = 1
    while(C * cnt < N) ++cnt
    res = min(res, D * cnt)
    println(res)
}