package kr.io.wolverine.kotlindemo.example

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    // 예외 다루는 방법
    // try catch finally 구문
    fun parseIntOrThrow(str: String): Int {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("주어진 ${str}는 숫자가 아닙니다")
        } finally {
            println("finally")
        }
    }

    fun parseIntOrNull(str: String): Int? {
        // Expression 로 간주된다..!! 대박
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
    // Checked Exception, Unchecked Exception
    fun readFile() {
        // Java에선 Checked Exception의 경우
        // throws 구문이나 try catch 구문이 필요하지만
        // Kotlin에선 필요없다
        // Kotling에선 모두 Unchecked Exception이다.. 대박
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }
    readFile()


    // try with resources
    // JavaFilePrinter <- Java 문법
    // Kotlin에선 try with resources 구문이 사라지고 use를 사용한다
    fun readFileWithResources(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
           println(reader.readLine())
        }
    }
}