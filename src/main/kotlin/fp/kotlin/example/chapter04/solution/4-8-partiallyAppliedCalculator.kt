package fp.kotlin.example.chapter04.solution

/**
 * 연습문제 4-8
 *
 * ``add``, ``minus``, ``product``를 갖는 ``calculator``의 확장함수면서 부분함수인
 * ``addCalculator``, ``minusCalculator``, ``productCalculator`` 를 구현해보자.
 */

fun main(args: Array<String>) {
    println(calculator.addCalculator(15, 10))       // 25
    println(calculator.minusCalculator(15, 10))     // 5
    println(calculator.productCalculator(15, 10))   // 150
}

val calculator: ((Int, Int) -> Int, Int, Int) -> Int = { calc, x, y ->
    calc(x, y)
}

val add: (Int, Int) -> Int = { x, y -> x + y }
val minus: (Int, Int) -> Int = { x, y -> x - y }
val product: (Int, Int) -> Int = { x, y -> x * y }

fun (((Int, Int) -> Int, Int, Int) -> Int).addCalculator(x: Int, y: Int) = this(add, x, y)
fun (((Int, Int) -> Int, Int, Int) -> Int).minusCalculator(x: Int, y: Int) = this(minus, x, y)
fun (((Int, Int) -> Int, Int, Int) -> Int).productCalculator(x: Int, y: Int) = this(product, x, y)