package kr.io.wolverine.kotlindemo.example

fun main() {
    // 기본 타입 -> Byte, Short, Int, Long, Float, Double, 부호 없는 정수들
    // 코틀린에선 선언된 기본값을 보고 타입을 추론한다.
    val number1 = 3 // Int
    val number2 = 3L // Long
    val number3 = 3.0f // Float
    val number4 = 3.0 // Double
    // Java에서는 타입간의 변화는 암시적으로 이루어지지만 Kotlin에서는 명시적으로 이루어져야 한다.
    // Java 예시 -> int number1 = 4; long number2 = number1; System.out.println(number1 + number2);
    val number5: Int = 4
    val number6: Long = number5.toLong()
    // 코틀린에선 to변환타입 으로 명식적으로 선언해줘야한다
    // 다만 변수가 nullable이라면 적절한 처리가 필요
    val number7: Int? = 3
    val number8: Long = number7?.toLong() ?: 0L

    // Any -> Java의 Object 역할(모든 객체의 최상위 타입)
    // Java와 다르게 Primitive Type의 최상의 타입도 Any
    // Any자체로는 null을 포함할 수 없어서 null을 포함하고 싶다면, Any?로 표현
    // Any에 equals / hashCode / toString 존재

    // Unit -> Java의 void와 동일한 역할
    // void와 다른점 -> Unit 그 자체로 타입 인자로 사용 가능
    // 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미

    // Nothing은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    // 무조건 예외가 발생하는 함수의 반환 타입, 무한 루프 함수 등

    // String interpolation
    val person = JavaPerson("Jung")
    println("나의 이름은 ${person.name}")

    // 간단한 변수는 $만으로 표현 가능
    val name = "정승환"
    println("나의 이름은 $name")

    // indent
    val witoutIndent = """
        ABC
        123
        456
        $name
    """.trimIndent()
    println(witoutIndent)

    // String indexing
    val str = "ABCDE"
    println(str[0])
    println(str[3])


}

// 타입캐스팅! Java의 Object -> Any, instanceof -> is, Object 타입변환 -> as 객체
fun printNameIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.name)
    }
}

// 코틀린은 스마트 캐스팅 가능
fun printNameIfPersonBySmartCasting(obj: Any) {
    if (obj is Person) {
        println(obj.name)
    }
}

// is앞에 !를 붙이면 조건에 해당되지 않는 경우 표현가능
fun printNameIfPersonByNotIs(obj: Any) {
    if (obj !is Person) {
//        println(obj.name)
    }
}

// null 인 경우
fun printNameIfPersonByNull(obj: Any?) {
    val person = obj as? Person
    println(person?.name ?: "No name")
}