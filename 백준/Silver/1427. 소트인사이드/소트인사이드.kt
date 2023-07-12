import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var N_string = br.readLine()

    val list = mutableListOf<String>()

    N_string.forEach {
        list.add(it.toString())
    }
    
    val list_descending = list.sortedDescending()

    var sb = StringBuffer()
    list_descending.forEach {
        sb.append(it)
    }
    write("$sb")
    flush()
    close()
}