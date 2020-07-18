import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()

    while(--T >= 0){
        var str:StringBuilder = StringBuilder(next())
        nextLine()
        while(true){
            var order:String = nextLine()
            if(order == "END") break
            var arr: List<String> = order.split(" ")

            if(arr[0] == "I"){
                str.insert(Integer.parseInt(arr[2]), arr[1])
            }
            else{
                var res:String = str.substring(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])+1)
                println(res)
            }
        }
    }
}