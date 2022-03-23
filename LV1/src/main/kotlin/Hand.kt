import kotlin.random.Random

class Hand {
    var dice1 = Dice(0)
    var dice2 = Dice(0)
    var dice3 = Dice(0)
    var dice4 = Dice(0)
    var dice5 = Dice(0)
    var dice6 = Dice(0)

    fun roll() {
        if (dice1.rollAgain)
            dice1.number = Random(System.nanoTime()).nextInt(6) + 1
        dice1.rollAgain = false
        if (dice2.rollAgain)
            dice2.number = Random(System.nanoTime()).nextInt(6) + 1
        dice2.rollAgain = false
        if (dice3.rollAgain)
            dice3.number = Random(System.nanoTime()).nextInt(6) + 1
        dice3.rollAgain = false
        if (dice4.rollAgain)
            dice4.number = Random(System.nanoTime()).nextInt(6) + 1
        dice4.rollAgain = false
        if (dice5.rollAgain)
            dice5.number = Random(System.nanoTime()).nextInt(6) + 1
        dice5.rollAgain = false
        if (dice6.rollAgain)
            dice6.number = Random(System.nanoTime()).nextInt(6) + 1
        dice6.rollAgain = false
    }

    fun reRoll() {
        println("Type index of the dice you want to reroll, from 1 to 6, Like this: 123 or 1 2 3 without enter.")
        var input2 = readLine()
        if (input2 != null) {
            if (input2.contains("1"))
                dice1.rollAgain = true
            if (input2.contains("2"))
                dice2.rollAgain = true
            if (input2.contains("3"))
                dice3.rollAgain = true
            if (input2.contains("4"))
                dice4.rollAgain = true
            if (input2.contains("5"))
                dice5.rollAgain = true
            if (input2.contains("6"))
                dice6.rollAgain = true
            roll()
        }
    }

    fun checkYamb() {
        var lockedNumbers = mutableListOf<Int>()
        lockedNumbers.add(dice1.number)
        lockedNumbers.add(dice2.number)
        lockedNumbers.add(dice3.number)
        lockedNumbers.add(dice4.number)
        lockedNumbers.add(dice5.number)
        lockedNumbers.add(dice6.number)
        //if(dice1.number == dice2.number && dice1.number == dice3.number && dice1.number == dice4.number && dice1.number == dice5.number && dice1.number == dice6.number)
        //  println("YOU'V GOT YAMB")
        if (lockedNumbers.contains(1) && lockedNumbers.contains(2) && lockedNumbers.contains(3) && lockedNumbers.contains(
                4
            ) && lockedNumbers.contains(5)
        )
            println("YOU'V GOT STRAIGH")
        if (lockedNumbers.contains(6) && lockedNumbers.contains(2) && lockedNumbers.contains(3) && lockedNumbers.contains(
                4
            ) && lockedNumbers.contains(5)
        )
            println("YOU'V GOT STRAIGH")
        var i = 0
        var j = 0
        var counter = 0
        var max = 0
        for (i in 0..5) {
            counter = 0
            for (j in 0..5)
                if (lockedNumbers[i] == lockedNumbers[j]) {
                    counter++
                    if (counter > max)
                        max = counter
                }
        }
        if (max == 6)
            println("YOU'V GOT YAMB")
        if (max == 5)
            println("YOU'V GOT POKER")
        else if (max == 1 || max == 2 || max == 3 || max == 4)
            println("YOU'V GOT NOTHING")
    }

    fun print() {
        println("First die is " + dice1.number)
        println("Second die is " + dice2.number)
        println("Third die is  " + dice3.number)
        println("Fourth die is  " + dice4.number)
        println("Fifth die is " + dice5.number)
        println("Sixth die is  " + dice6.number)
    }
}