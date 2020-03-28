import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var M:Int = nextInt()
    var arr:IntArray = IntArray(M)
    for(i in 0 until M) arr[i] = nextInt()

    var l:Int = 1
    var r:Int = 100000000
    var mid:Int = 0
    var res:Int = r

    while(l <= r){
        mid = (l + r) / 2
        var flag:Boolean = true
        var pre:Int = 0
        pre = arr[0] + mid
        if(arr[0] - mid > 0){
            l = mid + 1
            continue
        }

        for(i in 1 until M){
            if(arr[i] - mid <= pre) pre = arr[i] + mid
            else{
                flag = false
                break
            }
        }

        if(!flag || pre < N){
            l = mid + 1
            continue
        }
        else{
            if(res > mid) res = mid
            r = mid - 1
        }
    }

    println(res)
}