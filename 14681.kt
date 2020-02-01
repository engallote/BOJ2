import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var x:Int = nextInt()
    var y:Int = nextInt()

    if(x < 0){
        if(y < 0) println(3)
        else println(2)
    }
    else{
        if(y < 0) println(4)
        else println(1)
    }
}