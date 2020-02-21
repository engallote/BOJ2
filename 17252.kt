import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow

var flag:Boolean = false
var arr:ArrayList<Int> = ArrayList()
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
	
	if(N == 0){
		println("NO")
		return
	}
	
	flag = false
	var num:Int = 1
	
	arr.add(1)
    for(i in 1..19){
		arr.add(num * 3)
		num *= 3
	}

    solve(N, arr.size-1)

    if(flag) println("YES")
    else println("NO")
}

fun solve(n: Int, idx: Int) {
    if(flag) return
    if(n == 0){
        flag = true
        return
    }

    for(i in idx downTo 0)
        if(arr[i] <= n) solve(n - arr[i], i-1)
}
