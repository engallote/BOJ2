import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var ch:CharArray = next().toCharArray()
    if(ch[0] == ch[1] && ch[1] == ch[2] && ch[0] == '5') println("YES")
    else println("NO")
}