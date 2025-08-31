package kr.io.wolverine.kotlindemo.example

fun main() {
    var score = 60
    // 조건문
    // if문
    fun validateScoreIsNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
        }
    }

    // Statement: 프로그램의 문장, 하나의 값으로 도출되지 않는다
    // Expression: 하나의 값으로 도출되는 문장 -> a + b는 statement이면서 expression이다
    // Java에서 3항 연산자는 하나의 값으로 취급
//    val score = 60
//    val grade = score >= 50 ? "P": "F";

    fun getPassOrFail(score: Int): String {
        return if (score < 60) {
            "F"
        } else {
            "P"
        }
    }
    // Java에서 if-elsesms Statement이지만, Kotlin에서는 Expression 이다 ***
    // -> 그래서 3항 연산자가 없다

    // 0이상 100이하 조건
    if (score !in 0..100) {
        println("$score")
    }

    // Kotlin에서 switch 문 대신 when을 사용한다.
    fun getGradeWithSwitch(score: Int): String {
        return when (score) {
            in 90..100 -> "A"
            in 80..89 -> "B"
            70 -> "C"
            60 -> "D"
            else -> "F"
        }
    }

    fun startsWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A") // 스마트 캐스팅
            else -> false
        }
    }

    fun judgeNumber(number: Int) {
        when (number) {
            -1, 0, 1 -> println("어디서 많이 본 숫자입니다")
            else -> println("-1, 0, 1이 아닙니다")
        }
    }

    fun judgeNumber2(number: Int) {
        when {
            number == 0 -> println("주어진 숫자는 0입니다")
            number %2 == 0 -> println("짝수입니다.")
            else -> println("홀수입니다.")
        }
    }

    // When은 Enum class, Sealed class와 함께 사용할 경우, 더욷거 진가를 발휘한다.
}