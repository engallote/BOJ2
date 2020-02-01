import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt() + 1
    var M:Int = nextInt() + 1
    var K:Int = nextInt() + 1

    var res:Int = N * M
    res /= K
    res -= 1

    println(res)
}