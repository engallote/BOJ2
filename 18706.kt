import java.lang.Math.floor
import java.util.*
import kotlin.collections.HashMap

var max:Long = 0
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    while(--T >= 0){
        var N:Int = nextInt()
        var M:Int = nextInt()
        var arr:Array<IntArray> = Array<IntArray>(N){ IntArray(3) }
        var hs:HashMap<String, Int> = HashMap()
        var idx:Int = 0
        var del:Int = kotlin.math.floor(100.0 / M).toInt()

        for(i in 0 until N){
            var name:String = next()
            if(hs.containsKey(name)){
                for(j in 0 until 3)
                    arr[hs[name]!!][j] = nextInt()
            }
            else{
                hs[name] = idx
                for(j in 0 until 3)
                    arr[idx][j] = nextInt()
                ++idx
            }
        }

        for(i in 0 until M){
            var name:String = next()
            var size:String = next()
            var menu:String = next()
            var sizeNum:Int = 0
            if(size == "medium") sizeNum = 1
            else if(size == "large") sizeNum = 2
            var res: Int = arr[hs[menu]!!][sizeNum] + del

            if(res % 10 == 4 || res % 10 == 9) res += 1
            else if(res % 10 == 6 || res % 10 == 1) res -= 1
            println("$name $res")
        }
    }
}