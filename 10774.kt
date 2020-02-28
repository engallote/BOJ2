import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var J:Int = nextInt()
    var A:Int = nextInt()
    var arr:CharArray = CharArray(J+1)
    var res:Int = 0

    for(i in 1..J){
        var size:Char = next()[0]
        arr[i] = size
    }

    for(i in 0 until A){
        var size:Char = next()[0]
        var num:Int = nextInt()

        if(arr[num] == '.') continue
        if(arr[num] == size) {
            arr[num] = '.'
            ++res
        }
        else{
            if(size == 'S') {
                arr[num] = '.'
                ++res
            }
            else if(size == 'M' && arr[num] == 'L') {
                arr[num] = '.'
                ++res
            }
        }
    }

    println(res)
}