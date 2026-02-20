import parser.CsvParser
import java.io.File

fun main(args: Array<String>) {
    val file = File("src/main/resources/fakePlayers.csv")
    val parsed = CsvParser.parsePlayers(file)
}