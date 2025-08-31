package kr.io.wolverine.kotlindemo.example

fun main() {
    // Kotlin 함수
    // 함수 선언 문법
    // public 접근 지시어 생략가능
    // block 대신 = 사용가능 -> 이거 대박
    fun max(a: Int, b: Int): Int = if (a > b) a else b
    // =으로 선언했을 때 반환 타입 생략가능
    // -> block을 사용하는 경우 반환 타입이 Unit이 아니라면 반환타입을 명시적으로 작성해줘야함
    fun max2(a: Int, b: Int) = if (a > b) a else b

    // Default parameter
    // Java overloading을 대신할 수 있다.. 대박..
    fun repeat(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
    ) {
        for (i in 0..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }
    }
    repeat("Hello")
    // 그래도 Kotlin에선 오버로드와 오버라이드 다 존재한다.

    // Named argument
//    repeat(str = "Hello", false) <- 이건 불가능 하지만 아래처럼 이름을 명시적으로 넣어주면 가능하다
    repeat("Hello", useNewLine = false)
    // Builder를 직접 만들지 않고 builder의 장점을 가지게 된다.
    // Java함수를 사용할 때는 named argument 사용불가

    // 가변인자
    fun printAll(vararg strings: String) {
        for (str in strings) {
            println(str)
        }
    }

    printAll("A", "B", "C")
    val array = arrayOf("A", "B", "C")
    printAll(*array) // 스프레드 연산자를 이용해 넣어야한다

}