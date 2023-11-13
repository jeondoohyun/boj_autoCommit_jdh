import java.io.*
import java.lang.Math.*
import java.util.*

//fun main(args: Array<String>) {
//
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//    var now = 100
//
//    // n : 이동하려는 채널
//    var n = br.readLine()
//
//    // m : 고장난 버튼 개수
//    var m = br.readLine().toInt()
//
//    // troubles : 고장난 버튼들
//    var troubles = br.readLine().split(" ").map { it.toInt() }
//
//    // 사용 가능 버튼 배열
//    var useButton = BooleanArray(10){true}
//
//    troubles.forEach {
//        useButton[it] = false
//    }
//
//    var cnt = abs(now-n)    // +,- 버튼으로만 이동했을경우
//
//    if (n==100) bw.write("0")
//    else {
//        for (i in 0 until n.length) {
//            if (useButton[n[0].toInt()])
//        }
//        useButton[n[0].toInt()]
//        useButton[n[0].toInt()+1]
//
//    }
//
//
//}


lateinit var disableBtn: Array<String>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // target : 이동하려는 채널
    val target = br.readLine().toInt()
    // n : 고장난 버튼 개수
    val n = br.readLine().toInt()

    val usePlusAndMinus = abs(target - 100) // + - 버튼을 사용해서 이동할경우

    if (n == 0) {
        println(min(usePlusAndMinus, target.toString().length))
        return
    }

    val st = StringTokenizer(br.readLine(), " ")
    disableBtn = Array(n) { " " }
    for (i in 0 until n) disableBtn[i] = st.nextToken()

    var cnt = 0


    var upperBtn = target
    var lowerBtn = target


    while (true) {

        if (cnt + upperBtn.toString().length >= usePlusAndMinus && cnt + lowerBtn.toString().length >= usePlusAndMinus) {
            println(usePlusAndMinus)
            break
        }

        if (isAble(lowerBtn) && lowerBtn >= 0) {
            println(cnt + lowerBtn.toString().length)
            break
        }

        if (isAble(upperBtn)) {
            println(cnt + upperBtn.toString().length)
            break
        }

        upperBtn++
        lowerBtn--
        cnt++
    }
}

fun isAble(c: Int): Boolean {
    var channel = c.toString()

    for(i in channel) {
        if(i.toString() in disableBtn) {
            return false
        }
    }
    return true
}
