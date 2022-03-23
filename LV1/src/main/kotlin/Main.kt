import kotlin.random.Random
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var hand1 = Hand()
    var rolledTimes = 0
    var i = 0
    println("Do you want to roll? Type y if you want, anything else if you want to exit.")
    var input = readLine()
    println("You entered: $input")
    if (input == "y") {
        hand1.roll()
        rolledTimes++
        hand1.print()
    } else
        System.exit(-1)
    for (i in 0..1) {
        println("Do you want to reroll? Type y if you want.")
        var input1 = readLine()
        if (input1 == "y") {
            hand1.reRoll()
            hand1.print()
        } else {
            hand1.checkYamb()
            System.exit(-1)
        }
    }
    hand1.checkYamb()
}