import java.lang.Integer.min
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N:Int = nextInt()
    val M:Int = nextInt()
    val K:Int = nextInt()
    var arr:Array<CharArray> = Array(N){ CharArray(M) }
    var mr:Int = 0
    var mc:Int = 0
    var max:Int = 0
    var sum:Int = 0

    for(i in 0 until N)
        arr[i] = next().toCharArray()

    for(i in 0..N - K){
        for(j in 0..M - K){
            sum = 0
            for(k in i + 1 until i + K - 1)
                for(l in j + 1 until j + K - 1)
                    if(arr[k][l] == '*') ++sum
            if(sum > max){
                max = sum
                mr = i
                mc = j
            }
        }
    }

    for(i in mr until mr + K) {
        if(i == mr || i == mr + K - 1){
            for(j in mc until mc + K) arr[i][j] = '-'
        }
        else{
            arr[i][mc] = '|'
            arr[i][mc + K - 1] = '|'
        }
    }

    arr[mr][mc] = '+'
    arr[mr][mc + K - 1] = '+'
    arr[mr + K - 1][mc] = '+'
    arr[mr + K - 1][mc + K - 1] = '+'

    println(max)
    for(i in 0 until N){
        for(j in 0 until M)
            print(arr[i][j])
        println()
    }
}