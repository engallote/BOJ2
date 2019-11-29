import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(hasNext()){
        var str = next()
        var num = nextInt()//mm
        if(str == "#" && num == 0) break
        var N:Int = nextInt()
        println("$str Library")
        for(i in 1..N){
            var w:Int = nextInt()//width
            var lable:String = next()

            if(lable.length * num + 2 <= w) println("Book $i horizontal")
            else println("Book $i vertical")
        }
    }
}