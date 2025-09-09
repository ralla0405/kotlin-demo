package kr.io.wolverine.kotlindemo.example

fun main() {
    // 확장함수 -> 어떤 클래스안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자
    val str = "ABC"
    println(str.lastChar())

    // 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다
    // 멤버함수와 확장함수의 시그니처가 같다면? -> 멤버함수가 우선적으로 실행된다.

}


// 여기서 String은 this의 타입으로 수신객체 타입이라고 한다.
fun String.lastChar(): Char {
    // 수신객체인 this를 이용해 실제 클래스 안의 값에 접근
    return this[this.length - 1]
}