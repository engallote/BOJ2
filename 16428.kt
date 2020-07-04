import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var a:BigInteger = BigInteger(next())
    var b:BigInteger = BigInteger(next())
    var c:BigInteger = a.divide(b)

    if(b.abs().multiply(c.abs()) < a.abs()){
        if(a < BigInteger.ZERO && b < BigInteger.ZERO)
            c = c.add(BigInteger.ONE)
        else if(a < BigInteger.ZERO)
            c = c.subtract(BigInteger.ONE)
    }

    var d:BigInteger = c.abs() * b.abs()
    a = a.abs()

    println(c)
    println(d.subtract(a).abs())
}