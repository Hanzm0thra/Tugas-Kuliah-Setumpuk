fun main() {
    val num: Int = 1

    if (checkNum(num))
        print("TRUE")
    else
        print("FALSE")
}

fun checkNum(num: Int): Boolean = num <= 60