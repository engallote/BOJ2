import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var table:HashMap<String, Int> = HashMap()
    table["TT"] = 75
    table["TX"] = 50
    table["PR"] = 80
    table["RT"] = 30
    table["AP"] = 25
    table["PX"] = 60
	
    while(true){
        var W:Int = nextInt()
        var N:Int = nextInt()
		
		if(W == 0 && N == 0) break
		
        var hs:HashMap<String, Int> = HashMap()
        var idx:Int = 0
        var str:Array<String> = Array<String>(N){""}
        var arr:IntArray = IntArray(N)
        for(i in 0 until N){
            var name:String = next()
            var code:String = next()

            if(hs.containsKey(name)) arr[hs[name]!!] += table[code]!!
            else{
                str[idx] = name
                arr[idx] += table[code]!!
                hs[name] = idx
                ++idx
            }
        }
		print("Week $W ")
		
        var sb:StringBuilder = StringBuilder()
        for(i in 0 until idx)
            if(arr[i] >= 100)
                sb.append("${str[i]},")
		
        if(sb.toString().isEmpty()) println("No phones confiscated")
        else println(sb.toString().substring(0, sb.length-1))
    }
}