import java.lang.Integer.min
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while(hasNextLine()){
        var a:String = nextLine()
        var b:String = nextLine()
        var arr1:IntArray = IntArray(130)
        var arr2:IntArray = IntArray(130)

        for(i in a.indices)
            ++arr1[a[i].toInt()]

        for(i in b.indices)
            ++arr2[b[i].toInt()]

        for(i in 97 until 124){
            var min:Int = min(arr1[i], arr2[i])
            for(j in 0 until min)
                print(i.toChar())
        }
        println()
    }
}