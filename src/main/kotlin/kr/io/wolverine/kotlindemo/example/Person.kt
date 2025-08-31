package kr.io.wolverine.kotlindemo.example


fun main() {
    val person = Person("Jung", 30)
    println("${person.name}, ${person.age}")
    person.age = 35
    println(person.age)
//    person.name = "정"
    // Java 객체를 가져와서 쓰더라도 age .필드명으로 사용할수 있다


}

class Person(
    val name: String,
    var age: Int
) {
    // Class가 초기화되는 시점에 한번 실행되는 블럭
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    // 주생성자는 반드시 존재해야한다(Primary constructor)
    // -> secondary constructor 생성자 오버로딩 가능
    constructor(name: String): this(name, 0)
    constructor(): this("정승환") {
        println("secondary constructor")
    }
    // constructor 생략 가능
    // 프로퍼티 = 필드 + getter + setter
    // 코틀린에선 필드만 만들면 getter, setter 자동으로 만들어줌
    // 클래스의 필드 선언과 생성자를 동시에 선언할 수 있다.
    // Kotlin에선 부생성자보다 default parameter를 권장
    // 만약 필요하다면 정적 팩토리 메소드를 사용해라

    // Custom getter 3가지 방법 가능
    fun isAdult(): Boolean {
        return age >= 20
    }
    val isAdult2: Boolean
        get() = age >= 20
    val isAdult3: Boolean
        get() {
            return age >= 20
        }
}

class BackingFieldPerson(
    name: String,
    var age: Int
) {
    // backing field <- 무한루프 방지
    var name = name
        // 무한루프를 방지하기 위한 field 예약어 사용
        get() = field.uppercase()
        set(value) {
            field = value.lowercase()
        }
}
