import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var hs:HashSet<Char> = HashSet()

    nextLine()
    for(i in 1..N){
        var str:String = nextLine()
        var arr:List<String> = str.split(" ")
        var flag:Boolean = false
        var ans:String = ""
        for(j in arr.indices){
            if(!flag && !hs.contains(arr[j][0])){
                hs.add(arr[j][0].toLowerCase())
                hs.add(arr[j][0].toUpperCase())
                for(k in arr[j].indices){
                    if(k == 0) ans += "[${arr[j][k]}]"
                    else ans += arr[j][k]
                }
                ans += " "
                flag = true
            }
            else ans += arr[j] + " "
        }

        if(flag){
            println(ans.trim())
            continue
        }

        for(j in str.indices){
            if(str[j] == ' '){
                print(" ")
                continue
            }
            if(!flag && !hs.contains(str[j])){
                hs.add(str[j].toLowerCase())
                hs.add(str[j].toUpperCase())
                flag = true
                print("[${str[j]}]")
            }
            else print(str[j])
        }
        println()
    }
}