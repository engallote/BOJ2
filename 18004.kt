import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var M:Int = nextInt()
    var N:Int = nextInt()

    if(M < N){
        println(N-M)
        return
    }

    var res:Int = 0

    while(M > N){
        if(M % 2 == 0) M /= 2
        else M += 1
        ++res
    }
    
    res += N-M
    println(res)
}