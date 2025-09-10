package kr.io.wolverine.kotlindemo.example

fun main() {
    // Kotlin에서 Java와 다르게 함수가 그 자체로 값이 될 수 있다.
    // 변수에 할당될 수도, 파라미터로 넘길 수도 있다.

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )

    // 이름 없는 함수, 람다
    // 선언하는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다의 타입: (파라미터 타입...) -> 반환 타입
    val isApple2: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 선언하는 방법 2
    val isApple3 = { fruit: Fruit -> fruit.name == "사과" }

    // 호출 방법 1
    isApple(fruits[0])
    // 호출 방법 2
    isApple.invoke(fruits[0])

    // 람다 함수를 매개변수로 넣을수 있다.
    filterFruits(fruits, isApple)

    // 만약 람다 함수가 마지막 매개변수라면 중괄호를 활용해 표현가능
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    // 타입 생략도 가능
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    // 람다 함수의 매개변수가 1개라면 화살표를 생략하고 it 사용가능
    filterFruits(fruits) { it.name == "사과" }

    // Kotlin에서 함수는 1급 시민, Java에서는 2급 시민

    // 람다를 여러줄 작성가능하고, 마지막 줄의 결과가 람다의 반환값이다.
    filterFruits(fruits) { fruit ->
        println("사과만 받음!!")
        fruit.name == "사과"
    }

    // Closure
    // Java에서는 람다를 쓸 때 사용할 수 있는 변수에 제약이 있음
    // Kotlin에선 이게 가능하다 -> 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
    // 이렇게 해야만, 람다를 진정한 일급 시민으로 간주할 수 있다. 이 데이터 구조를 Closure라고 부른다.
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName } // <- java에선 불가능

    // try with resources
    // use 함수 -> Closeable 구현체에 대한 확장 함수, inline 함수, 람다를 매개변수로 받는다

}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) { // filter.invoke(fruit)
            results.add(fruit)
        }
    }
    return results
}
