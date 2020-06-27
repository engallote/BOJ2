import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var str: List<String> = next().split(":")
    var fir:Int = Integer.parseInt(str[0])
    var sec:Int = Integer.parseInt(str[1])
    var thi:Int = Integer.parseInt(str[2])
    var res:Int = 0

    if(hms(fir, sec, thi)) ++res
    if(hsm(fir, sec, thi)) ++res
    if(mhs(fir, sec, thi)) ++res
    if(msh(fir, sec, thi)) ++res
    if(shm(fir, sec, thi)) ++res
    if(smh(fir, sec, thi)) ++res

    println(res)
}

fun smh(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 0..59 && sec in 0..59 && thi in 1..12) return true
    return false
}

fun shm(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 0..59 && sec in 1..12 && thi in 0..59) return true
    return false
}

fun msh(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 0..59 && sec in 0..59 && thi in 1..12) return true
    return false
}

fun mhs(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 0..59 && sec in 1..12 && thi in 0..59) return true
    return false
}

fun hsm(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 1..12 && sec in 0..59 && thi in 0..59) return true
    return false
}

fun hms(fir: Int, sec: Int, thi: Int): Boolean {
    if(fir in 1..12 && sec in 0..59 && thi in 0..59) return true
    return false
}
