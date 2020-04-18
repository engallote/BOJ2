import java.util.*

var dp:IntArray = IntArray(2100000)
var res:Long = Long.MAX_VALUE
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var arr:LongArray = LongArray(M+1)

    for(i in 1..M) arr[i] = nextLong()

    Arrays.sort(arr, 1, M+1)
    Arrays.fill(dp, -1)

    solve(0, 0, 0, N, M, arr)
    println(res)
}

fun solve(idx: Int, chk: Int, sum: Long, n: Int, m: Int, arr:LongArray) {
    if(sum in n until res) res = sum
    if(idx > m) return
    if(dp[chk] != -1) return

    for(i in (idx+1)..m)
        solve(i, chk + (1 shl i), sum + arr[i], n, m, arr)
	
    dp[chk] = 1
}
