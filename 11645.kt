import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    while(--T >= 0){
        var N:Int = nextInt()
        var hs:HashSet<String> = HashSet()

        for(i in 0 until N)
            hs.add(next())

        println(hs.size)
    }
}