import java.lang.Integer.min
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N:Int = nextInt()
    val M:Int = nextInt()
    var arr:Array<CharArray> = Array(N){ CharArray(M) }
    var chk:Array<BooleanArray> = Array(N){BooleanArray(M)}
    var q:Queue<Int> = LinkedList()
    var x:Int = 0
    var y:Int = 0
    var sum:Int = -1

    for(i in 0 until N) {
        arr[i] = next().toCharArray()
        for(j in 0 until M)
            if(arr[i][j] == 'L'){
                x = i
                y = j
                break
            }
    }

    if(x == 0) sum *= -1
    while(y < M){
        chk[x][y] = true
        x += sum
        ++y
        if(x == 0 || x == N - 1) sum *= -1
    }

    for(j in 0 until M){
        q.clear()
        var flag:Boolean = false
        for(i in 0 until N){
            if(chk[i][j] && arr[i][j] == '|'){
                flag = true
            }
            if(arr[i][j] == '|'){
                arr[i][j] = '.'
                q.offer(i)
            }
        }

        if(q.isEmpty()) continue
        if(!flag){
            while(!q.isEmpty()) arr[q.poll()][j] = '|'
            continue
        }

        var size:Int = 0
        var tmp:Queue<Int> = LinkedList()
        tmp.addAll(q)

        //up
        while(true){
            size = q.size
            flag = false

            while(--size >= 0){
                var nx:Int = q.poll() - 1
                if(nx >= 0 && chk[nx][j]) flag = true
                q.offer(nx)
            }

            if(!flag && q.peek() >= 0){
                while(!q.isEmpty()){
                    var nx:Int = q.poll()
                    arr[nx][j] = '|'
                }
                break
            }
            else if(q.peek() < 0) break
        }

        if(q.isEmpty()) continue

        q.clear()
        q.addAll(tmp)

        //down
        while(true){
            size = q.size
            flag = false
            var last:Int = 0

            while(--size >= 0){
                var nx:Int = q.poll() + 1
                if(nx < N && chk[nx][j]) flag = true
                last = nx
                q.offer(nx)
            }

            if(!flag && last < N){
                while(!q.isEmpty()){
                    var nx:Int = q.poll()
                    arr[nx][j] = '|'
                }
                break
            }
            else if(last >= N) break
        }
    }

    for(i in 0 until N)
        for(j in 0 until M)
            if(chk[i][j]) arr[i][j] = 'L'

    for(i in 0 until N)
        println(String(arr[i]))
}