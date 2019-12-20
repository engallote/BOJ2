import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    //p home
    var p1:Int = nextInt()
    var e1:Int = nextInt()

    //e home
    var e2:Int = nextInt()
    var p2:Int = nextInt()

    if(p1+p2 > e1+e2) println("Persepolis")
    else if(p1+p2 < e1+e2) println("Esteghlal")
    else{
        if(p2 > e1) println("Persepolis")
        else if(p2 < e1) println("Esteghlal")
        else println("Penalty")
    }
}