import java.util.*
import kotlin.math.max

var N:Int = 0
var arr:Array<CharArray> = Array(1000){CharArray(1000){'.'} }
var chk:Array<BooleanArray> = Array(1000){ BooleanArray(1000) }
var dx:IntArray = intArrayOf(1,0,-1,0)
var dy:IntArray = intArrayOf(0,1,0,-1)
fun main(args: Array<String>) {
	var sc:Scanner = Scanner(System.`in`)
    N = sc.nextInt()
    var res:Int = 0
    for(i in 0 until N)
		arr[i] = sc.next().toCharArray()
	
	for(i in 0 until N){
		for(j in 0 until N){
			if(arr[i][j] == '*' && !chk[i][j]){
				++res
                dfs(i, j)
            }
        }
	}
	
	println(res)
}
private fun dfs(x: Int, y: Int) {
	chk[x][y] = true;
	for(i in 0 until 4)
    {
		var nx = x + dx[i]
		var ny = y + dy[i]
		if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] == '.')
			continue
		dfs(nx, ny)
	}
}