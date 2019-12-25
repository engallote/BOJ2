import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var A:Int = nextInt()
    var B:Int = nextInt()
    var N:Int = nextInt()
    var res:Int = 0
	
    while(--N >= 0){
        var num:Int = nextInt()
        if(num in A..B) ++res
    }
	
    println(res)
}