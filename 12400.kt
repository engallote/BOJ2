import java.util.*
import java.lang.StringBuilder

fun main(args: Array<String>) {
	var sc = Scanner(System.`in`)
    var T:Int = sc.nextInt()
	sc.nextLine()
	var ch = arrayOf('y', 'h', 'e', 's', 'o', 'c', 'v', 'x', 'd', 'u', 'i', 'g', 'l', 'b', 'k', 'r', 'z', 't', 'n', 'w', 'j', 'p', 'f', 'm', 'a', 'q')
        
	for(case in 1..T){
		var sb:StringBuilder = StringBuilder()
		var str:String = sc.nextLine()
		for(i in str.toCharArray()) {
			if(i == ' ') sb.append(" ")
			else sb.append(ch[i-'a'])
		}
		println("Case #$case: $sb")
	}
}