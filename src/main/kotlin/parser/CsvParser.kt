package parser

import model.Player
import model.Team
import model.Position
import java.io.File

object CsvParser {
    fun parsePlayers(file: File): List<Player> {
        val lines = file.readLines()
            .drop(1)
            .map{ it.split(';') }

        return getPlayersList(lines)
    }

    private fun getPlayersList(lines: List<List<String>>): List<Player> {
        return lines.map {
            Player(
                name = it[0],
                team = Team(it[1], it[2]),
                position = Position.valueOf(it[3]),
                nationality = it[4],
                agency = it[5],
                transferCost = it[6].toInt(),
                participations = it[7].toInt(),
                goals = it[8].toInt(),
                assists = it[9].toInt(),
                yellowCards = it[10].toInt(),
                redCards = it[11].toInt()
            )
        }
    }
}