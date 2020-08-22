import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    val arr:Array<IntArray> = Array(10){ IntArray(2){-1}}
    arr[1][1] = 2
    arr[1][0] = 4
    arr[2][1] = 3
    arr[2][0] = 5
    arr[3][0] = 6
    arr[4][1] = 5
    arr[4][0] = 7
    arr[5][1] = 6
    arr[5][0] = 8
    arr[6][0] = 9
    arr[7][1] = 8
    arr[8][1] = 9
    arr[8][0] = 0

    while(--T >= 0){
        val N:Int = nextInt()
        var dp:Array<BooleanArray> = Array(10){ BooleanArray(1000)}
        val q:Queue<Pair<Int, Int>> = LinkedList()
        for(i in 1..9)
            q.offer(Pair(i, i))
        var size:Int = 0
        var res:Int = 0
        var min:Int = 10000000

        while(!q.isEmpty()){
            size = q.size
            while(--size >= 0){
                val x:Int = q.peek().first
                val num:Int = q.poll().second

                var sub:Int = kotlin.math.abs(N - num)
                if(sub < min){
                    min = sub
                    res = num
                }
                if(num > N) continue
                if(dp[x][num]) continue

                dp[x][num] = true
                q.offer(Pair(x, num * 10 + x))
                for(i in 0..1){
                    val next:Int = arr[x][i]
                    if(next == -1) continue
                    q.offer(Pair(next, num * 10 + next))
                    q.offer(Pair(next, num))
                }
            }
        }

        println(res)
    }
}