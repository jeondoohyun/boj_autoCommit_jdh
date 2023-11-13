import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 브루트 포스

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 1 <= e <= 15
    // 1 <= s <= 28
    // 1 <= m <= 19
    var (e,s,m) = br.readLine().split(" ").map { it.toInt() }

    var result = 0
    var flagCheck = true
    var cnt = 0
    while (flagCheck) {
        result = 15 * cnt + e
        if ( (result % 28 == s || result % 28 + 28 == s) &&
            (result % 19 == m || result % 19 + 19 == m) ) flagCheck = false
        else cnt++
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()

//    var a = br.readLine().toInt()
//    println("${a%15}, ${a%28}, ${a%19}")

}