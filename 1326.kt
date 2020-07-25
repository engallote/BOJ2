import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var arr:IntArray = IntArray(N)
    var chk:IntArray = IntArray(N){ Int.MAX_VALUE}
    for(i in 0 until N)
        arr[i] = nextInt()

    var S:Int = nextInt() - 1
    var E:Int = nextInt() - 1

    if(arr[S] == 1){
        println(1)
        return
    }

    var q:Queue<Int> = LinkedList()
    q.offer(S)
    chk[S] = 0
    var size:Int = 0

    while(!q.isEmpty()){
        size = q.size
        while(--size >= 0){
            var x:Int = q.poll()

            if(x == E) continue

            for(i in 1..999999){
                if(x + (arr[x] * i) >= N && x - (arr[x] * i) < 0) break
                if(x + (arr[x] * i) < N && chk[x + (arr[x] * i)] > chk[x] + 1){
                    chk[x + (arr[x] * i)] = chk[x] + 1
                    q.offer(x + (arr[x] * i))
                }
                if(x - (arr[x] * i) >= 0 && chk[x - (arr[x] * i)] > chk[x] + 1){
                    chk[x - (arr[x] * i)] = chk[x] + 1
                    q.offer(x - (arr[x] * i))
                }
            }
        }
    }

    if(chk[E] == Int.MAX_VALUE) chk[E] = -1
    println(chk[E])
}