import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

var res:Int = Int.MAX_VALUE
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var arr:Array<CharArray> = Array(6){ CharArray(9) }
    var aly:ArrayList<Char> = ArrayList()

    for(i in 0..5) {
        arr[i] = next().toCharArray()
        for(j in 0..8)
            if(!aly.contains(arr[i][j])) aly.add(arr[i][j])
    }

    var path:ArrayList<Char> = ArrayList()
    solve(0, path, arr, aly)

    if(res == Int.MAX_VALUE) res = 18//한 문자만 있는 경우
    println(res)
}

fun solve(idx: Int, path: ArrayList<Char>, arr: Array<CharArray>, aly: ArrayList<Char>) {
    if(idx == 2){
        //row
        res = min(res, findRow(path[0], path[1], path[0], arr))
        res = min(res, findRow(path[1], path[0], path[1], arr))

        //col
        res = min(res, findCol(path[0], path[1], path[0], arr))
        res = min(res, findCol(path[1], path[0], path[1], arr))
    }
    else if(idx == 3){
        //row
        res = min(res, findRow(path[0], path[1], path[2], arr))
        res = min(res, findRow(path[0], path[2], path[1], arr))
        res = min(res, findRow(path[1], path[0], path[2], arr))
        res = min(res, findRow(path[1], path[2], path[0], arr))
        res = min(res, findRow(path[2], path[0], path[1], arr))
        res = min(res, findRow(path[2], path[1], path[0], arr))

        //col
        res = min(res, findCol(path[0], path[1], path[2], arr))
        res = min(res, findCol(path[0], path[2], path[1], arr))
        res = min(res, findCol(path[1], path[0], path[2], arr))
        res = min(res, findCol(path[1], path[2], path[0], arr))
        res = min(res, findCol(path[2], path[0], path[1], arr))
        res = min(res, findCol(path[2], path[1], path[0], arr))
        return
    }

    for(i in 0 until aly.size)
        if(!path.contains(aly[i])) {
            path.add(aly[i])
            solve(idx + 1, path, arr, aly)
            path.removeAt(path.size - 1)
        }
}

fun findCol(a: Char, b: Char, c: Char, arr: Array<CharArray>): Int {
    var sum:Int = 0

    for(j in 0..2)
        for(i in 0..5)
            if(a != arr[i][j]) ++sum

    for(j in 3..5)
        for(i in 0..5)
            if(b != arr[i][j]) ++sum

    for(j in 6..8)
        for(i in 0..5)
            if(c != arr[i][j]) ++sum

    return sum
}

fun findRow(a: Char, b: Char, c: Char, arr: Array<CharArray>): Int {
    var sum:Int = 0

    for(i in 0..1)
        for(j in 0..8)
            if(a != arr[i][j]) ++sum

    for(i in 2..3)
        for(j in 0..8)
            if(b != arr[i][j]) ++sum

    for(i in 4..5)
        for(j in 0..8)
            if(c != arr[i][j]) ++sum

    return sum
}
