import java.lang.StringBuilder
import kotlin.collections.ArrayList
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    while(--T >= 0){
        var ch:CharArray = next().toCharArray()
        var L:Int = ch.size
        var K:Int = L
        var m:Int = 0
        for(i in 1..L){
            var num:Int = i * i
            if(num >= L){
                K = num
                m = i
                break
            }
        }
        var arr:Array<CharArray> = Array(m){CharArray(m)}
        var arr2:Array<CharArray> = Array(m){CharArray(m)}
        var idx:Int = 0
        var r:Int = m - 1
        var c:Int = 0

        for(i in 0 until m)
            for(j in 0 until m){
                if(idx < L) arr[i][j] = ch[idx]
                else arr[i][j] = '*'
                ++idx
            }

        for(i in 0 until m){
            for(j in 0 until m){
                arr2[j][i] = arr[r][c]
                ++c
            }
            c = 0
            --r
        }

        var res:StringBuilder = StringBuilder()
        for(i in 0 until m)
            for(j in 0 until m)
                if(arr2[i][j] != '*') res.append(arr2[i][j])

        println(res.toString())
    }
}