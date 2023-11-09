import java.io.*

// 슬라이딩 윈도우
var conditionArr = IntArray(4)
fun main(args: Array<String>) {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    // 결과값 변수
    var result = 0

    // s : 임의로 만든 DNA 문자열 길이 s
    // p : 비밀번호로 사용할 부분문자열의 길이 p
    var (s,p) = br.readLine().split(" ").map { it.toInt() }

    // dna : 임의로 만든 dna 문자열
    var dna = br.readLine()

    // c : 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
    var c = br.readLine().split(" ").map { it.toInt() }

    var dnaArr = IntArray(4){0}
    conditionArr = IntArray(4)
    for (i in c.indices) {  // 0 until c.size
        conditionArr[i] = c[i]
    }

    for (i in 0 until p) {
        var s = dna[i]
        if (s=='A') dnaArr[0] += 1
        else if (s=='C') dnaArr[1] += 1
        else if (s=='G') dnaArr[2] += 1
        else if (s=='T') dnaArr[3] += 1
    }

//    for (i in conditionArr.indices) {
//        if (conditionArr[i] > dnaArr[i]) break
//        else if(i == 3) result++
//    }
    result += compareCondition(dnaArr)

    // n : 슬라이딩 하는 횟수
    var n = s-p
    for (i in 0 until  n) {
        var s = dna[i]
        if (s == 'A') dnaArr[0] -= 1
        else if (s == 'C') dnaArr[1] -= 1
        else if (s == 'G') dnaArr[2] -= 1
        else if (s == 'T') dnaArr[3] -= 1

        s = dna[p+i]
        if (s == 'A') dnaArr[0] += 1
        else if (s == 'C') dnaArr[1] += 1
        else if (s == 'G') dnaArr[2] += 1
        else if (s == 'T') dnaArr[3] += 1

        result += compareCondition(dnaArr)
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun compareCondition(dnaArr: IntArray): Int {
    var a = 0
    for (i in conditionArr.indices) {
        if (conditionArr[i] > dnaArr[i]) break
        else if(i == 3) a++
    }

    return a
}