package com.paveltinnik.habridealapp.core.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    deleteButtonTintColor: Color = MaterialTheme.colorScheme.onPrimary,
    description: String,
    onDeleteButtonClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = ShapeDefaults.Medium
            )
            .height(74.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(start = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                modifier = Modifier
                    .width(280.dp)
                    .padding(top = 5.dp),
                text = description,
                color = textColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = onDeleteButtonClick
        ) {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = null,
                tint = deleteButtonTintColor
            )
        }
    }
}

@Composable
@Preview
private fun NoteItemPreview() {
    NoteItem(
        modifier = Modifier,
        title = "Title",
        description = "DescriptionDescriptionDescriptionDescriptionDescription" +
                "DescriptionDescriptionDescriptionDescriptionDescription" +
                "DescriptionDescriptionDescriptionDescriptionDescription" +
                "DescriptionDescriptionDescriptionDescriptionDescription" +
                "DescriptionDescriptionDescriptionDescriptionDescription" +
                "DescriptionDescriptionDescriptionDescriptionDescription"
    ) { }
}
