package kr.io.wolverine.kotlindemo.example

fun main() {
    // 확장함수 -> 어떤 클래스안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자
    val str = "ABC"
    println(str.lastChar())

    // 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다
    // 멤버함수와 확장함수의 시그니처가 같다면? -> 멤버함수가 우선적으로 실행된다.

    // Java에서 Kotlin의 확장함수를 사용할 때 정적 메소드를 호출하는것처럼 사용 가능하다.

    // 중위 함수 infix
    // 변수.함수이름(argument) 대신 -> 변수 함수이름 argument
    // 확장함수 뿐만 아니라 멤버함수에도 사용가능하다
    3.add(4)
    3.add2(4)
    3 add2 4

    // inline 함수
    // 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
    // 함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다. 하지만 성능 측정과 함께 신중하게 사용되어야한다.

    // 지역함수
    // 함수안에 함수를 만들수있다.
}

fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

// 여기서 String은 this의 타입으로 수신객체 타입이라고 한다.
fun String.lastChar(): Char {
    // 수신객체인 this를 이용해 실제 클래스 안의 값에 접근
    return this[this.length - 1]
}

// 확장 프로퍼티의 원리는 확장함수 + custom getter와 동일하다.
val String.lastChar: Char
    get() = get(length - 1)