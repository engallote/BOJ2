import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(true){
        var ch:CharArray = nextLine().toCharArray()
        if(String(ch) == "END") break

        if(ch[0] != '"') println("not a quine")
        else{
            var flag:Boolean = true
            var idx:Int = -1
            var str:String = ""
            var di:String = ""
            for(i in 1 until ch.size){
                if(ch[i] == '"'){
                    if(idx != -1){
                        flag = false
                        break
                    }
                    idx = i
					break
                }
                else str += ch[i]
            }
			
			for(i in idx + 2 until ch.size) di += ch[i]
			
//			println("[$str] [$di]")
            if(idx == -1 || (idx + 1 < ch.size && ch[idx+1] != ' ') || str != di || str.trim() == "" || di.trim() == "")
				flag = false

            if(flag) println("Quine($str)")
            else println("not a quine")
        }
    }
}