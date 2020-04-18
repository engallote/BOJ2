import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N:Int = nextInt()
    val M:Int = nextInt()
    val M1:Int = nextInt()
    val M2:Int = nextInt()
    val dx:IntArray = intArrayOf(M1, M1, -M1, -M1, M2, M2, -M2, -M2)
    val dy:IntArray = intArrayOf(M2, -M2, M2, -M2, M1, -M1, M1, -M1)
    val arr:Array<IntArray> = Array(N){IntArray(M)}
    var chk:Array<IntArray> = Array(N){IntArray(M)}
    var x:Int = 0
    var y:Int = 0

    for(i in 0 until N)
        for(j in 0 until M) {
            arr[i][j] = nextInt()
            chk[i][j] = Int.MAX_VALUE
            if(arr[i][j] == 3){
                x = i
                y = j
            }
            else if(arr[i][j] == 2) arr[i][j] = -1
        }

    bfs(x, y, N, M, arr, chk, dx, dy)
}

fun bfs(x: Int, y: Int, N: Int, M: Int, arr: Array<IntArray>, chk: Array<IntArray>,dx: IntArray, dy: IntArray) {
    var q:Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    var size:Int = 0
    var res:Int = 0
    q.offer(Pair(x, y))
    chk[x][y] = 0

    while(!q.isEmpty()){
        size = q.size

        while(--size >= 0){
            var p:Pair<Int, Int> = q.poll()

            if(arr[p.first][p.second] == 4){
                println(res)
                return
            }

            for(i in 0 until 8){
                var nx:Int = p.first + dx[i]
                var ny:Int = p.second + dy[i]
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] <= res || arr[nx][ny] <= 0)
                    continue
                chk[nx][ny] = res
                q.offer(Pair(nx, ny))
            }
        }
        ++res
    }
}
