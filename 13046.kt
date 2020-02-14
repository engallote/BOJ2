import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var ch:CharArray = next().toCharArray()
    var N:Int = nextInt()

    for(i in 1..N) {
        var tmp: CharArray = next().toCharArray()
        var res: Int = 0
        var not: Int = 0
        for (j in tmp.indices) {
            if (ch[j] == tmp[j]) ++res
            else if (ch.contains(tmp[j])) ++not
        }
        println("$res $not")
    }
}