import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine()
    var x = br.readLine().split(" ")
    var min = x[0].toInt()
    x.forEach {
        if (it.toInt() <= min) min = it.toInt()
    }

    var max = x[0].toInt()
    x.forEach {
        if (it.toInt() >= max) max = it.toInt()
    }
    bw.write("$min $max")
    bw.flush()
    bw.close()


}