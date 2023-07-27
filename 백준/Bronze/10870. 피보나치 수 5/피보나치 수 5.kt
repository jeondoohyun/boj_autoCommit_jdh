import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    // 피보나치는 1. 재귀함수 2. 배열을 사용하여 구현할수 있다.
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var array = IntArray(n+10) // 각 요소들은 0으로 초기화됨
    array[1] = 1

    for (i in 2 .. n) {
        array[i] = array[i-1] + array[i-2]
    }

    bw.write("${array[n]}")
    bw.flush()
    bw.close()

}