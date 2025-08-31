package kr.io.wolverine.kotlindemo.example

fun main() {
    // 반복문
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) { // : 대신 in을 사용
        println(number)
    }

    // 와 이거 대박이네...
    for (i in 1..100) {
        println(i)
    }

    for (i in 100 downTo 1) {
        println(i)
    }
    // step 설정 2씩 올라간다
    for (i in 1..100 step 2) {
        println(i)
    }
    // 등차수열을 만들어주는 함수가 내장되어있다. IntProgression
    // downTo, step 은 중위 호출 함수

    // While, Do While 문은 Java와 동일
    var i = 1
    while (i <= 100) {
        println(i)
        i++
    }

}