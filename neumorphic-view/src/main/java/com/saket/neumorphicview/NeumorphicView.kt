package com.saket.neumorphicview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun NeumorphicView(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    elevation: Dp = 6.dp,
    backgroundColor: Color = Color(0xFFE0E5EC),
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier) {
        // Light shadow (top-left)
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset((-3).dp, (-3).dp)
                .shadow(
                    elevation = elevation,
                    shape = RoundedCornerShape(cornerRadius),
                    ambientColor = Color.White,
                    spotColor = Color.White
                )
                .zIndex(-1f)
        )

        // Dark shadow (bottom-right)
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(3.dp, 3.dp)
                .shadow(
                    elevation = elevation,
                    shape = RoundedCornerShape(cornerRadius),
                    ambientColor = Color.Black.copy(alpha = 0.25f),
                    spotColor = Color.Black.copy(alpha = 0.25f)
                )
                .zIndex(-1f)
        )

        // Content box
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    shape = RoundedCornerShape(cornerRadius)
                    clip = true
                }
                .background(backgroundColor)
                .padding(16.dp),
            content = content
        )
    }
}

private fun offset(x: Dp, y: Dp) = androidx.compose.ui.geometry.Offset(x.value, y.value) 