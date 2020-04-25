import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var arr:IntArray = IntArray(12)
    Arrays.fill(arr, 4)
    arr[10] = 16
    var sum:Int = 0

    while(--N >= 0){
        var num:Int = nextInt()
        --arr[num]
        sum += num
    }

    var s:Int = 0
    var b:Int = 0

    for(i in 2..11){
        if(arr[i] == 0) continue
        if(i + sum <= 21) s += arr[i]
        else b += arr[i]
    }

    if(s > b) println("VUCI")
    else println("DOSTA")
}