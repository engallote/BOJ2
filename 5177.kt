import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    nextLine()
    for(tc in 1..T){
        var str1:String = nextLine().trim().toUpperCase()
        var str2:String = nextLine().trim().toUpperCase()

        while(str1.contains("{"))
            str1 = str1.replaceFirst("{", "(")
        while(str1.contains("["))
            str1 = str1.replaceFirst("[", "(")
        while(str1.contains(";"))
            str1 = str1.replaceFirst(";", ",")
		while(str1.contains("}"))
            str1 = str1.replaceFirst("}", ")")
        while(str1.contains("]"))
            str1 = str1.replaceFirst("]", ")")

        while(str2.contains("{"))
            str2 = str2.replaceFirst("{", "(")
        while(str2.contains("["))
            str2 = str2.replaceFirst("[", "(")
		while(str2.contains("}"))
            str2 = str2.replaceFirst("}", ")")
        while(str2.contains("]"))
            str2 = str2.replaceFirst("]", ")")
        while(str2.contains(";"))
            str2 = str2.replaceFirst(";", ",")
        
        var ch1:CharArray = str1.toCharArray()
        var ch2:CharArray = str2.toCharArray()

        var sb1:StringBuilder = StringBuilder()
        var sb2:StringBuilder = StringBuilder()

        for(i in ch1.indices)
            if(sp(ch1[i])){
                for(j in i - 1 downTo 0){
                    if(ch1[j] == ' ') ch1[j] = '!'
                    else break
                }
                for(j in i + 1 until ch1.size){
                    if(ch1[j] == ' ') ch1[j] = '!'
                    else break
                }
            }
        for(i in ch2.indices)
            if(sp(ch2[i])){
                for(j in i - 1 downTo 0){
                    if(ch2[j] == ' ') ch2[j] = '!'
                    else break
                }
                for(j in i + 1 until ch2.size){
                    if(ch2[j] == ' ') ch2[j] = '!'
                    else break
                }
            }
		
        var pre:Char = '.'
        for(i in ch1.indices){
            if(ch1[i] == '!') continue
            else {
                if(pre == ' '){
                    if(ch1[i] == ' ') continue
                    sb1.append(ch1[i])
                }
                else sb1.append(ch1[i])
            }
            pre = ch1[i]
        }
        pre = '.'
        for(i in ch2.indices){
            if(ch2[i] == '!') continue
            else {
                if(pre == ' '){
                    if(ch2[i] == ' ') continue
                    sb2.append(ch2[i])
                }
                else sb2.append(ch2[i])
            }
            pre = ch2[i]
        }
//        println("$sb1, $sb2")
        if(sb1.toString() == sb2.toString()) println("Data Set $tc: equal\n")
        else println("Data Set $tc: not equal\n")
    }
}

fun sp(c: Char): Boolean {
    if("()[]{}.,;:".contains(c)) return true
    return false
}
