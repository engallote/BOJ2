import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var ch:Array<CharArray> = Array(N){ CharArray(M) }
    var x:Int = 0
    var y:Int = 0

    for(i in 0 until N){
        ch[i] = next().toCharArray()
        for(j in 0 until M)
            if(ch[i][j] == 'C'){
                x = i
                y = j
            }
    }

    bfs(x, y, N, M, ch)
}

fun bfs(x: Int, y: Int, N: Int, M: Int, ch: Array<CharArray>) {
    var dx = intArrayOf(1, 0, -1, 0)
    var dy = intArrayOf(0, 1, 0, -1)
    var size:Int = 0
    var time:Int = 0
    var chk:Array<BooleanArray> = Array(N){ BooleanArray(M){false} }
    var q:Queue<Pair<Int, Int>> = LinkedList()
    q.offer(Pair(x, y))
    chk[x][y] = true

    while(!q.isEmpty()){
        size = q.size
        while(--size >= 0){
            var p:Pair<Int, Int> = q.poll()

            if(ch[p.first][p.second] == 'B'){
                println(time)
                return
            }

            for(i in 0..3){
                var nx:Int = p.first + dx[i]
                var ny:Int = p.second + dy[i]

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || ch[nx][ny] == '*' || chk[nx][ny])
                    continue
                chk[nx][ny] = true
                q.offer(Pair(nx, ny))
            }
        }
        ++time
    }
}
