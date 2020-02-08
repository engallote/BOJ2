import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    for(tc in 1..T){
        var N:Int = nextInt()
        var sb:StringBuilder = StringBuilder()
		
		println("Case $tc:")
		
        for(i in 1..6)
            for(j in i..6)
                if(i + j == N)
                    sb.append("($i,$j)\n")
                
        print(sb.toString())
    }
}