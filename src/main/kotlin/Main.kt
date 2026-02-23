import parser.CsvParser
import resolver.Resolver
import taskvariant1.ProportionDrawer
import java.io.File

fun main(args: Array<String>) {
    val file = File("src/main/resources/fakePlayers.csv")
    val playerList = CsvParser.parsePlayers(file)
    val resolver = Resolver(playerList)

    println("Количество игроков, интересы которых не представляет агенство: " +
            resolver.getCountWithoutAgency())
    println("Автор наибольшего числа голов из числа защитников и их количество: " +
            resolver.getBestScorerDefender())
    println("Название позиции самого дорогого немецкого игрока: " +
            resolver.getTheExpensiveGermanPlayerPosition())
    println("Команда с наибольшим средним числом красных карточек на одного игрока: " +
            resolver.getTheRudestTeam())

    ProportionDrawer.drawPositionProportion(playerList)
}
