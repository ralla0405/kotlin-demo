package kr.io.wolverine.kotlindemo.example

class Cat(
    species: String
): Animal(species, legCount = 4) { // :를 이용해 상속한다

    // override 필수적으로 붙여야함
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}