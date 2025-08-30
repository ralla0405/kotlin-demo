package kr.io.wolverine.kotlindemo.example

fun main() {

    // Java와 동일
    // 단항 연산자 -> ++, --
    var a = 1
    var b = 2
//    a++
//    b--
    // 산술 연산자 -> +, -, *, /, %
//    a = a + b
//    b = a - b
//    a = a * b
//    b = a / b
//    a = a % b
    // 산술대입 연산자 -> +=, -=, *=, /=, %/
//    a += b
//    b -= a
//    a *= b
//    b /= a
//    a %= b

    // 비교 연산자 ->  >, <. >=. <=
    // 코틀린에선 객체를 비교할 때 compareTo를 자동으로 호출한다
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)
    if (money1 > money2) { // >를 클릭해보면 compareTo 로 이동
        println("money1이 money2 보다 금액이 큽니다")
    }

    // 동등성(Equality): 두 객체의 값이 같은가?
    // 동일성(Identity): 완전히 동일한 객체인가?! 즉 주소가 같은가?!

    // Java에서는 동일성에 ==, 동등성에 equals 호출
    // Kotlin에서는 동일성에 ===, 동등성에 == 호출(간접적으로 equals호출)

    val money3 = JavaMoney(2_000L)
    val money4 = money3
    val money5 = JavaMoney(2_000L)

    println(money3 === money4) // 주소가 같은가? true
    println(money3 === money5) // 주소가 같은가? false
    println(money3 == money5)  // 값이 같은가? true -> JavaMoney 객체에 equals와 hashCode를 작성해야함

    // 논리 연산자 -> ||, &&, !
    // Java와 동일하고 Lazy 연산도 동일함
    if (true || false) {} // true 조건으로만 성립
    if (false && true) {} // false 조건으로만 성립

    // Kotlin에 있는 특이한 연산자
    // in / !in -> 컬렉션 범위에 포함 되어있는지 여부
    // a..b -> 범위 객체를 생성
    // a[i] -> a에서 특정 index i로 값을 가져온다
    // a[i] = b 특정 index i에 b값을 저장한다

    // Kotlin에서는 객체마다 연산자를 직접 정의할 수 있음
    // operator fun plus(other: Money): Money <- 이런식
}