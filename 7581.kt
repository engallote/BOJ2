import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var a:Int = nextInt()
        var b:Int = nextInt()
        var c:Int = nextInt()
        var mul:Int = nextInt()

        if(a == 0 && b == 0 && c == 0 && mul == 0) break

        if(a == 0){
            var tmp = b * c
            a = mul / tmp
        }
        else if(b == 0){
            var tmp = a * c
            b = mul / tmp
        }
        else if(c == 0){
            var tmp = a * b
            c = mul / tmp
        }
        else{
            mul = a * b * c
        }
        println("$a $b $c $mul")
    }
}