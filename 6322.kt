import java.lang.Integer.min
import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var tc:Int = 1
    while(true){
        var a:Double = nextDouble()
        var b:Double = nextDouble()
        var c:Double = nextDouble()

        if(a == 0.0 && b == 0.0 && c == 0.0) break
        var num:String = ""

        println("Triangle #$tc")
        if(a == -1.0){
            b *= b
            c *= c
            a = c - b;
            if(a <= 0) println("Impossible.")
            else{
                var res:Double = sqrt(a)
                num = String.format("%.3f", res)
                println("a = $num")
            }
        }
        else if(b == -1.0){
            a *= a
            c *= c
            b = c - a
            if(b <= 0) println("Impossible.")
            else{
                var res:Double = sqrt(b)
                num = String.format("%.3f", res)
                println("b = $num")
            }
        }
        else{
            a *= a
            b *= b
            c = a + b

            var res:Double = sqrt(c)
            num = String.format("%.3f", res)
            println("c = $num")
        }
        ++tc
        println()
    }
}