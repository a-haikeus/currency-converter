fun convert(currencies: List<String>): Double {
    val yenEquals: List<Double> = listOf(1.57, 123.48, 108.98, 137.29, 1.0, 15.33, 1.44, 4.08)
    var amount: Int = readLine()!!.toInt()
    var fromU: String = readLine().toString()
    var toU: String = readLine().toString()
    var from: Int = 0
    var to: Int = 0

    for (i in currencies.indices) {
        if (currencies[i] == fromU) {
            from = i
        } else if (currencies[i] == toU) {
            to = i
        }
    }

    return amount * yenEquals[from] / yenEquals[to]
}

fun main(args: Array<String>) {
    val currencies: List<String> = listOf("рубль", "евро", "доллар", "фунт", "йена", "юань", "рупия", "гривна")

    println(convert(currencies))
}