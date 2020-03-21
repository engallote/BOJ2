import java.util.*

var chk:BooleanArray = BooleanArray(5)
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    for(tc in 1..T){
        var ch:CharArray = next().toCharArray()
        Arrays.fill(chk, false)
        println("Case # $tc:")
        solve(ch, 0, "")
    }
}

fun solve(ch: CharArray, idx: Int, str:String) {
    if(idx == ch.size){
        println(str)
        return
    }
    
    for(i in ch.indices) 
        if (!chk[i]){
            chk[i] = true
            solve(ch, idx + 1, str+""+ch[i])
            chk[i] = false;
        }
}
