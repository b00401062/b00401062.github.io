package leetcode

object Interpret {
    fun interpret(command: String): String {
        return command.replace("()", "o").replace("(al)", "al")
    }
}