import kotlin.String

fun main(){
    println(myString("Wambui"))
    println(validPassword("Grace7Yi#"))
    println(validPassword("password"))
    multiples()
    val Account= CurrentAccount (346575662,"Grace Njuguna",56000.9)
    val result =Account.deposit(800.5)
    println(result)
    val answer= Account.withdraw(15007.1)
    println(answer)
    Account.details()
    val Savings=SavingsAccount(893652834,"Grace",900.9,3)
    val ans=Savings.withdraw()
    println(ans)


}
//Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not.
fun myString(str:String):Triple<Char, Char,Int> {
        val firstChar = str.first()
        val lastChar = str.last()
        val length = str.length
//        val startsWithVowel = str.startsWith("a", "e", "i", "o", "u", "A", "E", "I", "O", "U")

        return Triple(firstChar,lastChar ,length)
    }

//Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false
fun validPassword(password: String): Boolean {
    val minLength = 8
    val maxLength = 16
    val number = arrayOf(1,2,3,4,5,6,7,8,9)
    if (password.length < minLength) {
        return false
    }
    else if(password.length > maxLength) {
        return false
    }
     else if(password == "password") {
        return false
    }
    else{
        return true
    }
}


//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!”
fun multiples() {
    for (i in 1..1000) {
        if (i % 6 == 0 && i % 8 == 0) {
            println("Bingo!")
        } else if (i % 6 == 0) {
            println("$i multiple of 6")
        } else if (i % 8 == 0) {
            println("$i multiple of 8")
        }
    }
}

//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z”

open class CurrentAccount (var accountNumber: Int, var accountName:String, var balance: Double){
    fun deposit(amount: Double):Double{
        balance += amount
        return balance
    }
   fun  withdraw(amount: Double):Double{
       balance-=amount
       return balance
   }
    fun details(){
        println("Account Number ${accountNumber }  with balance ${balance} is operated by ${accountName}")
    }
}
//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal

class SavingsAccount(accountNumber: Int,accountName: String,balance: Double, var withdrawals:Int):CurrentAccount(accountNumber, accountName,balance) {
    fun withdraw() :Int{
        if (withdrawals < 4){
            withdrawals ++

        }
        return withdrawals
    }
}

