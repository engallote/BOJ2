import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var dic:HashMap<Int, String> = HashMap()
    var arr:Array<IntArray> = Array<IntArray>(100){ IntArray(26){0} }
    var idx:Int = 0
	
    while(true){
        var str:String = next()
        if(str == "XXXXXX") break

        dic[idx] = str

        for(i in str.indices)
            ++arr[idx][str[i]-'a']

        ++idx
    }
	
    while(true){
        var str:String = next()
        if(str == "XXXXXX") break

        var tmp:IntArray = IntArray(26)
        for(i in str.indices)
            ++tmp[str[i]-'a']

        var pq:PriorityQueue<String> = PriorityQueue()

        for(i in 0 until idx){
            var flag:Boolean = true
            for(j in 0..25)
                if(arr[i][j] != tmp[j]){
                    flag = false
                    break
                }
			
            if(flag) pq.offer(dic[i])
        }
		
        if(pq.isEmpty()) println("NOT A VALID WORD")
        else{
            while(!pq.isEmpty())
				println(pq.poll())
        }
		
        println("******")
    }
}
