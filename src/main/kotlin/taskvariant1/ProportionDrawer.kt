package taskvariant1

import model.Player
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.pie
import org.jetbrains.kotlinx.kandy.letsplot.style.Style

object ProportionDrawer {
    fun drawPositionProportion(playerList: List<Player>){
        val groupedPlayersByPos = playerList.groupBy { it.position }
        val positionProportion = dataFrameOf(
            "Позиция" to groupedPlayersByPos.keys.map { it.positionName },
            "Количество" to groupedPlayersByPos.values.map { it.size }
        )
        positionProportion.plot {
            pie {
                slice("Количество")
                fillColor("Позиция")
                size = 20.0
            }
            layout {
                style(Style.Void)
            }
        }.save("pie.png")
    }
}