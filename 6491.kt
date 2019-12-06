import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var num:Int = nextInt()
        if(num == 0) break
        var sum:Int = 0

        for(j in 1 until num)
            if(num % j == 0) sum += j

        if(sum == num) println("$num PERFECT")
        else if(sum > num) println("$num ABUNDANT")
        else println("$num DEFICIENT")
    }
}