package kr.io.wolverine.kotlindemo.example

fun main() {
    var array = arrayOf(100, 200)

    // index 를 가져올수있다
    for (i in array.indices) {
        println("$i ${array[i]}")
    }

    // 배열 값 추가
    array = array.plus(300)

    // index, value 모두 가져오는 방법
    for ((index, value) in array.withIndex()) {
        println("$index $value")
    }

}
