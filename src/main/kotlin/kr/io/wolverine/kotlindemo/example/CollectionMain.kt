package kr.io.wolverine.kotlindemo.example

fun main() {
    // 컬렉션을 만들어 줄 때, 불변인지 가변인지 선언해야한다.
    // 불편 컬렉션이라도 reference Type인 Element의 필드는 바꿀 수 있다.

    // list
    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>() // <- 타입을 명시적으로 적어줘야함
    printNumbers(emptyList()) // 다만 타입이 추론 가능하면 생략 가능하다

    // index로 요소 값 가져오는 방법
    numbers.get(0) // java와 동일
    numbers[0]

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문
    for ((index, value) in numbers.withIndex()) {
        println("$index $value")
    }

    // 가변 list
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)

    // set -> list와 사용방법 동일
    val setNumbers = setOf(100, 200)
    // 가변 set
    val mutableSetNumbers = mutableSetOf(100, 200)

    // map
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1, "MONDAY") // java와 같은 방법
    oldMap[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY") // 중위호출 Pair

    for (key in oldMap.keys) {
        println("$key : ${oldMap[key]}")
    }

    // 똑같음
    for ((key, value) in oldMap.entries) {
        println("$key : $value")
    }
    for ((key, value) in oldMap) {
        println("$key : $value")
    }

    // 콜렉션에서 null
    // List<Int?> 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
    // List<Int>? 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
    // List<Int?>? 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음


}

private fun printNumbers(numbers: List<Int>) {

}