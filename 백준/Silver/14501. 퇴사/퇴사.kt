import java.io.*
import kotlin.math.max

var N_14501 = 0
lateinit var T: IntArray // 상담 소요 일수
lateinit var P: IntArray // 수익
var result_14501 = 0
fun main(args: Array<String>) {

    // 브루트포스 (완전탐색)
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))


    N_14501 = br.readLine().toInt() // 일할수 있는 날짜
    T = IntArray(N_14501) // 상담 소요 일수
    P = IntArray(N_14501) // 수익

    for (i in 0 until N_14501) {
        var (t,p) = br.readLine().split(" ").map { it.toInt() }
        T[i] = t
        P[i] = p
    }
    check14501(0,0, 0, true)

    bw.write(result_14501.toString())
    bw.flush()
    bw.close()

}

fun check14501(idx: Int, cnt: Int, total: Int, flag: Boolean) {
    var price = total

    // cnt : 현재날짜 + 상담에 필요한 일수
    // total : 수익 총액
    if (cnt >= N_14501) { // stopping condition
        result_14501 = max(result_14501, total)
        return
    }

    for (i in idx until N_14501) {
        var a = P[i]

        // i+T[i] : 상담한후 날짜
        if (i+T[i] <= N_14501) price += a
        check14501(i + T[i], i+T[i], price, false)
        if (i+T[i] <= N_14501) price -= a

//        if (!flag) {    // 처음 실행된 반복문만 진행됨. 소요날짜가 정해져있기때문에 다음날짜의 상담을 진행하고 싶다고 진행할수 있는게 아니기때문
//            break
//        }
//        price -= a
    }
}