import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while (true){
        var str:String = next()
        if(str == "0") break
        var hs:HashSet<String> = HashSet()
        hs.add(str)
        while(true){
            var N:Int = Integer.parseInt(str) * Integer.parseInt(str)
            var str2:String = N.toString()
            var tmp:String = ""
            for(i in 0 until (8 - str2.length))
                tmp += "0"
            str2 = tmp + str2

            var num:String = ""
            for(i in 2..5)
                num += str2[i]
			
            if(hs.contains(num)) break
            hs.add(num)
            str = num
        }
        println(hs.size)
    }
}