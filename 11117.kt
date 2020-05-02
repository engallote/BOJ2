import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    while(--T >= 0){
        var ch: CharArray = next().toCharArray()
        var arr:IntArray = IntArray(26)
        var tmp:IntArray = IntArray(26)

        for(i in ch.iterator())
            arr[i-'A'] += 1

        var N:Int = nextInt()
        var flag:Boolean = false

        while(--N >= 0){
            var str:String = next()
            flag = true
            Arrays.fill(tmp, 0)
            for(i in str.iterator())
                tmp[i-'A'] += 1

            for(i in 0..25)
                if(arr[i] < tmp[i]){
                    flag = false
                    break
                }
            if(flag) println("YES")
            else println("NO")
        }
    }
}