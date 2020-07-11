import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var speed:Double = nextDouble()
        var weight:Double = nextDouble()
        var strength:Double = nextDouble()

        if(speed == 0.0 && weight == 0.0 && strength == 0.0) break
        var sb:StringBuilder = StringBuilder()

        if(speed <= 4.5 && weight >= 150.0 && strength >= 200.0)
            sb.append("Wide Receiver ")
        if(speed <= 6.0 && weight >= 300.0 && strength >= 500.0)
            sb.append("Lineman ")
        if(speed <= 5.0 && weight >= 200.0 && strength >= 300.0)
            sb.append("Quarterback ")

        if(sb.isEmpty()) println("No positions")
        else println(sb)
    }
}