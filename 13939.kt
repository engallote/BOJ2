import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    nextLine()
    while(T > 0){
        var res:Int = 0
        var str:String = nextLine()
        var len:Int = str.length
        var chk:BooleanArray = BooleanArray(len){false}

        for(i in 0 until len){
            if (str[i] == '.' || str[i] == '?' || str[i] == '!'){
                println(res)
                res = 0
                --T
                continue
            }
            if(chk[i]){
                continue
            }
            if(str[i] in 'A'..'Z') {
                for (j in i + 1 until len) {
                    chk[j] = true
                    if (str[j] == ' ') {
                        ++res
                        break
                    }
                    if (str[j] in 'a'..'z')continue
                    if (str[j] == '.' || str[j] == '?' || str[j] == '!'){
                        ++res
                        break
                    }
                    else break
                }//for j
            }//if
        }//for i
    }
}