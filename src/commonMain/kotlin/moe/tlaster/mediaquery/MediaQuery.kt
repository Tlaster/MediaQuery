package moe.tlaster.mediaquery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalMediaQuery = staticCompositionLocalOf { MediaQuery() }

class MediaQuery {

    var width: Width by mutableStateOf(Width.Compact)
        private set
    var height: Height by mutableStateOf(Height.Compact)
        private set

    val isPhone: Boolean by derivedStateOf { width == Width.Compact }
    val isTablet: Boolean by derivedStateOf { width == Width.Medium }
    val isDesktop: Boolean by derivedStateOf { width == Width.Expanded }

    fun update(width: Dp, height: Dp) {
        this.width = Width.fromWidth(width)
        this.height = Height.fromHeight(height)
    }

    @Immutable
    @kotlin.jvm.JvmInline
    value class Width private constructor(private val value: String) {
        companion object {
            val Compact = Width("Compact")
            val Medium = Width("Medium")
            val Expanded = Width("Expanded")
            internal fun fromWidth(width: Dp): Width {
                require(width >= 0.dp) { "Width must not be negative" }
                return when {
                    width < 600.dp -> Compact
                    width < 840.dp -> Medium
                    else -> Expanded
                }
            }
        }
    }

    @Immutable
    @kotlin.jvm.JvmInline
    value class Height private constructor(private val value: String) {
        companion object {
            val Compact = Height("Compact")
            val Medium = Height("Medium")
            val Expanded = Height("Expanded")
            internal fun fromHeight(height: Dp): Height {
                require(height >= 0.dp) { "Height must not be negative" }
                return when {
                    height < 480.dp -> Compact
                    height < 900.dp -> Medium
                    else -> Expanded
                }
            }
        }
    }
}

@Composable
fun ProvideMediaQuery(
    content: @Composable () -> Unit,
) {
    val mediaQuery = remember { MediaQuery() }
    CompositionLocalProvider(
        LocalMediaQuery provides mediaQuery
    ) {
        Layout(
            content = content,
            measurePolicy = { measures, constraints ->
                mediaQuery.update(constraints.maxWidth.toDp(), constraints.maxHeight.toDp())
                val placeables = measures.map { it.measure(constraints) }
                layout(constraints.maxWidth, constraints.maxHeight) {
                    placeables.forEach {
                        it.placeRelative(0, 0)
                    }
                }
            }
        )
    }
}
