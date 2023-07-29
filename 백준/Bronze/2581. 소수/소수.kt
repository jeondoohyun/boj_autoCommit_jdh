import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val M = br.readLine().toInt()
        val N = br.readLine().toInt()

        var result_arr = mutableListOf<Int>()

        for (i in M..N) {
            if (PrimalityCheck2(i)) result_arr.add(i)
        }
        result_arr.sort()

        var sb = StringBuffer()

        if (result_arr.size == 0) sb.append("-1")
        else {
            sb.append("${result_arr.sum()}\n")
            sb.append("${result_arr[0]}")
        }
        
        bw.write(sb.toString())
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun PrimalityCheck2(a: Int): Boolean {
    if (a<2) return false  // 0,1은 소수가 아니다

    for (i in 2 until a) {
        if (a%i == 0) return false
    }

    return true
}