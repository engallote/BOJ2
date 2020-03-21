import java.util.*

var max:Long = 0
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Long = nextLong()
    var ch:CharArray = N.toString().toCharArray()
    var K:Int = nextInt()
    var arr:IntArray = IntArray(K)
	
    for(i in 0 until K)
        arr[i] = nextInt()

    Arrays.sort(arr)
    solve(ch, arr, N, 0, 0)
    println(max)
}

fun solve(ch: CharArray, arr: IntArray, N:Long, idx: Int, num:Long) {
    if(num <= N) max = max.coerceAtLeast(num)
    if(idx == ch.size) return

    for(i in (arr.size-1) downTo 0 step 1)
        solve(ch, arr, N, idx + 1, num * 10 + arr[i])
}
