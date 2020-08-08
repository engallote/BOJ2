import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var sum:Long = 0
    var X:Long = 0

    for(i in 1..N) {
        var num: Int = nextInt()

        if (num == 1) {
            var x: Int = nextInt()
            sum += x
            X = X xor x.toLong()
        } else if (num == 2) {
            var x: Int = nextInt()
            sum -= x
            X = X xor x.toLong()
        }
        else if (num == 3) println(sum)
        else println(X)
    }
}