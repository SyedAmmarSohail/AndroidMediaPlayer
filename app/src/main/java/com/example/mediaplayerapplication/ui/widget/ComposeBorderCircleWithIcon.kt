package com.example.mediaplayerapplication.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.mediaplayerapplication.ui.spacing
import com.example.mediaplayerapplication.ui.theme.Teal200

@Composable
fun ComposeBorderCircleWithIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.Add,
    size : Dp = MaterialTheme.spacing.view_12x,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .size(size, size)
            .clip(RoundedCornerShape(size))
            .border(
                BorderStroke(MaterialTheme.spacing.view_1, Teal200),
                shape = RoundedCornerShape(size)
            )
            .clickable { onClick() }

    ) {
        Icon(icon, contentDescription = "centerIcon", modifier = Modifier.align(Alignment.Center))
    }
}