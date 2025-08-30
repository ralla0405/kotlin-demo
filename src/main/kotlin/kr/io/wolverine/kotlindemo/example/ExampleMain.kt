package kr.io.wolverine.kotlindemo.example

fun main() {

    // 가변
    var number: Long = 10L
    number = 20
    println(number)
    // 불변(read-only)
    val number2: Long = 10L
    // number2 = 30L <- 변경 불가

    // 타입을 지정하지 않아도 컴파일 시점에 타입이 지정됨
    val number3 = 30L
    println(number3.javaClass)

    // val 컬렉션에서도 값은 추가할 수 있다
    val numbers = arrayListOf<Int>()
    numbers.add(10)
    println(numbers)

    // 객체 인스턴스 생성시 new 를 붙이지 않아도 된다. Java -> new Person("Jung");
    val person = Person("Jung")
    println(person.name)

    // 개발자가 타입 boxing unboxing 고려하지 않아도 된다, 언어 레벨에서 알아서해줌
    val number4: Long = 10L
    println(number4.javaClass) // <- long 타입

    // 그래서 nullable 타입은 아예 다른 타입으로 취급
    val str: String? = "ABC" // 타입 뒤에 ? 붙여서 null이 들어갈 수 있는지 명시해줘야한다
    // println(str.length) <- Null이 들어갈수 있는 타입이라 오류가 발생
    println(str?.length) // Safe Call을 통해 null아닌 경우에만 length가 실행된다.
    // Elvis 연산자로 null일 경우 다른값으로 대체 가능
    val str2: String? = null
    println(str2?.length ?: 0)

    // Elvis 연산자는 early return 에도 자주 쓰임
    fun calculate(number: Long?): Long {
        return number ?: 0L
        // 다음 로직
    }

    // Null이 아닌것을 단언하는 방법도 있다
    fun startWith(str: String?): Boolean {
        return str!!.startsWith("J")
    }
    println(startWith("Jung")) // <- true
    println(startWith("Jung")) // <- false
//    println(startWith(null)) // <- NPE 에러
    // 정말 null이 아닌게 확실한 경우에만 !! 사용하여 널이 아님을 단언해야한다

    // 플랫폼 타입 -> Kotlin에서 Java 코드를 가져다 사용할 때 어떻게 처리될까?
    val person2 = PersonWithNullable("Jung")
    fun startWithJ(str: String): Boolean {
        return str.startsWith("J")
    }
    // startWithJ(person2.name) java class의 getName 메소드에 @Nullable이 붙어 있어서 오류가 발생
    // 만약 Nullable이 없다면 kotlin에서는 이 값이 nullable인지 non-nullable인지 알 수가 없다. 이 타입을 플랫폼 타입이라고 한다
    // Runtime시 Exception이 발생할 수 있다.
    val person3 = Person(null)
    // startWithJ(person3.name) <- runtime시 에러 발생한다
}