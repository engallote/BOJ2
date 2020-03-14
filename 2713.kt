import java.util.*

var cnt:Int = 0
var dx = arrayOf(0, 1, 0, -1)
var dy = arrayOf(1, 0, -1, 0)
var flag:Boolean = false
var r:Int = 0
var c:Int = 0
var d:Int = 0
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var T:Int = nextInt()
    while(--T >= 0){
        var R:Int = nextInt()
        var C:Int = nextInt()
        var ch:CharArray = nextLine().trim().toCharArray()
        var arr:Array<IntArray> = Array<IntArray>(R){ IntArray(C){-1} }
        r = 0
        c = 0
        d = 0
        flag = false

        for(i in ch.indices){
            var tmp:String = ""
            if(ch[i] == ' ') tmp = "00000"
            else tmp = Integer.toBinaryString((ch[i]-'A') + 1)
            var len:Int = tmp.length
            for(j in 0 until 5-len){//앞에 0으로 채우기
                if(arr[r][c] == -1){
                    arr[r][c] = 0
                    r += dx[d]
                    c += dy[d]

                    if(r < 0 || r >= R || c < 0 || c >= C || arr[r][c] != -1){
                        r -= dx[d]
                        c -= dy[d]
                        rotation(R, C, arr)
                    }
                    if(flag) break
                }
                else{
                    rotation(R, C, arr)
                    if(flag) break
                }
            }
            if(flag) break
            for(j in 0 until len){
                if(arr[r][c] == -1){
                    arr[r][c] = Integer.parseInt(tmp[j].toString())
                    r += dx[d]
                    c += dy[d]

                    if(r < 0 || r >= R || c < 0 || c >= C || arr[r][c] != -1){
                        r -= dx[d]
                        c -= dy[d]
                        rotation(R, C, arr)
                    }
                    if(flag) break
                }
                else{
                    rotation(R, C, arr)
                    if(flag) break
                }
            }
        }

        for(i in 0 until R)
            for(j in 0 until C){
                if(arr[i][j] == -1) print(0)
                else print(arr[i][j])
            }
        println()
    }
}

fun rotation(R:Int, C:Int, arr:Array<IntArray>) {
    cnt = 0
    while(true){
        if(cnt == 4){
            flag = true
            return
        }
        ++d
        d %= 4
        r += dx[d]
        c += dy[d]
        if(r >= 0 && c >= 0 && c < C && r < R && arr[r][c] == -1) break
        ++cnt
        r -= dx[d]
        c -= dy[d]
    }
}
