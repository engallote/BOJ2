import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    while(--T >= 0){
        nextLine()
        var ch:CharArray = nextLine().toCharArray()
        var N:Int = nextInt()
        var cur:Int = 0

        while(--N >= 0){
            var num:Int = nextInt()

            cur += num
            if(cur < 0) cur += ch.size
            else cur %= ch.size

            print(ch[cur])
        }
        println()
    }
}
