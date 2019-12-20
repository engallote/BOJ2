import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var A:Int = nextInt()
    var op:Char = next()[0]
    var B:Int = nextInt()
    var op2:Char = next()[0]
    var C:Int = nextInt()

    if(A + B == C) println("YES")
    else println("NO")
}