package kr.io.wolverine.kotlindemo.example

interface Swimable {

    val swimAbility: Int

    fun act() {
        // default 키워드 없이 메소드 구현이 가능하다
        println("어푸 어푸")
    }
}