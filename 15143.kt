import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    var hs:HashMap<String, Double> = HashMap()

    for(tc in 1..T){
        var str:String = next()
        var num:Double = nextDouble()
        hs.put(str, num)
    }

    var ch:CharArray = next().toCharArray()

    var str:String = ""
    var res:Double = 0.0
    var cnt:Int = 0
    var chk:BooleanArray = BooleanArray(ch.size)

    for(i in ch.indices){
        if(chk[i]) continue
        if(ch[i] in 'A'..'Z') {
            if(!str.isEmpty() && (str.length == 2 || str[str.length-1] in 'A'..'Z')){
                if(cnt == 0) cnt = 1
                res += hs[str]!! * cnt
                cnt = 0
                str = ""
            }
            str += ch[i]
            if(i + 1 < ch.size && ch[i+1] in 'a'..'z'){
                str += ch[i+1]
                chk[i+1] = true
            }
        }
        else {
            cnt *= 10
            cnt += ch[i]-'0'
        }
    }
	
	if(cnt == 0) cnt = 1
	res += hs[str]!! * cnt
    println(String.format("%.2f", res))
}