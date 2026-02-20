package resolver

import model.Player
import model.Position
import model.Team

class Resolver(val playerList: List<Player>) : IResolver {
    override fun getCountWithoutAgency(): Int {
        return playerList.filter { it.agency.isBlank() }.size
    }

    override fun getBestScorerDefender(): Pair<String, Int> {
        return playerList.filter { it.position == Position.DEFENDER }
            .maxBy { it.goals }
            .let { Pair(it.name, it.goals) }
    }

    override fun getTheExpensiveGermanPlayerPosition(): String {
        return playerList.filter { it.nationality == "Germany" }
            .maxBy { it.transferCost }
            .position
            .name
    }

    override fun getTheRudestTeam(): Team {
        return playerList.groupBy { it.team }
            .mapValues { it.value.sumOf { player -> player.redCards } / it.value.size }
            .maxBy { it.value }
            .key
    }
}