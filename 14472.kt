import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var K:Int = nextInt()
    var arr:Array<CharArray> = Array(N){ CharArray(M) }

    for(i in 0 until N)
        arr[i] = next().toCharArray()

    var res:Int = 0
    for(i in 0 until N){
        for(j in 0 until M){
            if(arr[i][j] == '#') continue
            //row
            var cnt:Int = 0
            for(k in j until M){
                if(arr[i][k] != '.') break
                ++cnt
                if(cnt == K) break
            }
            if(cnt == K) ++res

            //col
            cnt = 0
            for(k in i until N){
                if(arr[k][j] != '.') break
                ++cnt
                if(cnt == K) break
            }
            if(cnt == K) ++res
        }
    }

    println(res)
}