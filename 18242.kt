import java.lang.Integer.min
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var min:Int = Int.MAX_VALUE
    var ch:Array<CharArray> = Array(N){ CharArray(M) }
    var arr:IntArray = IntArray(4)
	var ans:String = ""
	
    for(i in 0 until N)
        ch[i] = next().toCharArray()

    var cnt:Int = 0
    //up, down
    for(i in 0 until N){
        var sh:Int = 0
        for(j in 0 until M)
            if(ch[i][j] == '#') ++sh
        if(sh <= 2) continue
        if(cnt == 0){
            cnt = 1
            arr[0] = sh
			if(sh < min){
				min = sh
				ans = "UP"
			}
        }
        else {
            arr[1] = sh
            if(sh < min){
				min = sh
				ans = "DOWN"
			}
        }
    }
    cnt = 0
    //left, right
    for(j in 0 until M){
        var sh:Int = 0
        for(i in 0 until N)
            if(ch[i][j] == '#') ++sh
        if(sh <= 2) continue
        if(cnt == 0){
            cnt = 1
            arr[2] = sh
            if(sh < min){
				min = sh
				ans = "LEFT"
			}
        }
        else {
            arr[3] = sh
            if(sh < min){
				min = sh
				ans = "RIGHT"
			}
        }
    }
	
	println(ans)
}