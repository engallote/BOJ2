import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var str:String = next()
    var N:Int = nextInt()
    var l = 0
    var r = str.length
    while(--N >= 0){
        var a:Int = nextInt()
        var b:Int = nextInt()
        l += a
        r = l + b
    }
    println(str.substring(l, r))
}