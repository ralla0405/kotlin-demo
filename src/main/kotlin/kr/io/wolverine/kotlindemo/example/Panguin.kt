package kr.io.wolverine.kotlindemo.example

class Panguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다~ 꿱꿱")
    }

    // 프로퍼티를 override하려면 프로퍼티 앞에 open을 붙여줘야한다
    override val legCount: Int
        get() = super.legCount + this.wingCount

    // Java, Kotlin의 추상화 코드는 인스턴스화 할 수 없다~

    override fun act() {
        // 꺽세 사용
        super<Swimable>.act()
        super<Flyable>.act()
    }

    // Kotlin에서는 backing field가 없는 프로퍼티를 interface에 만들 수 있다
    override val swimAbility: Int
        get() = 3
}