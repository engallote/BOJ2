import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N:Int = nextInt()
    var price:Int = nextInt()
    var hprice:Int = nextInt()

    for(i in 1..N){
        var num:Int = nextInt()
        if(hprice < num){
            hprice = num
            println("BBTV: Dollar reached $hprice Oshloobs, A record!")
        }
        else if(price > num) println("NTV: Dollar dropped by ${price-num} Oshloobs")
        price = num
    }
}