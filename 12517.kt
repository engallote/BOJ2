import java.util.*

fun main(args: Array<String>) {
        var sc:Scanner = Scanner(System.`in`)
        var T = sc.nextInt()

        for(i in 1..T){
            var str:String = sc.next()
            if(str[str.length-1] == 'a' || str[str.length-1] == 'e' || str[str.length-1] == 'i' || str[str.length-1] == 'o' || str[str.length-1] == 'u')
                println("Case #$i: $str is ruled by a queen.")
            else if(str[str.length-1] == 'y')
                println("Case #$i: $str is ruled by nobody.")
            else println("Case #$i: $str is ruled by a king.")
        }
    }