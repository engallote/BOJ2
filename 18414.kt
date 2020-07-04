import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var x:Int = nextInt()
    var a:Int = nextInt()
    var b:Int = nextInt()

    if(x <= a) println(a)
    else if(x >= b) println(b)
    else println(x)
}