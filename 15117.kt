import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var arr:Array<CharArray> = Array(N){CharArray(N)}
    var res:String = "Reduced"
    var hs:HashSet<Char> = HashSet()

    for(i in 0 until N)
        arr[i] = next().toCharArray()

    var pre:Char = '0'
    for(i in 0 until N){//col
        hs.clear()
        if(i == 0){
            pre = arr[i][0]
            hs.add(pre)
            for(j in 1 until N){
                if(arr[i][j] > pre) pre = arr[i][j]
                else res = "Not Reduced"
                hs.add(arr[i][j])
            }
        }
        else{
            for(j in 0 until N)
                hs.add(arr[i][j])
        }
        if(hs.size != N){
            res = "No"
            break
        }
    }

    for(j in 0 until N){//row
        hs.clear()
        if(j == 0){
            pre = arr[0][j]
            hs.add(pre)
            for(i in 1 until N){
                if(arr[i][j] > pre) pre = arr[i][j]
                else res = "Not Reduced"
                hs.add(arr[i][j])
            }
        }
        else{
            for(i in 0 until N)
                hs.add(arr[i][j])
        }
        if(hs.size != N){
            res = "No"
            break
        }
    }

    println(res)
}