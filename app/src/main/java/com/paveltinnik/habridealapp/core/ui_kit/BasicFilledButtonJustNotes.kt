package com.paveltinnik.habridealapp.core.ui_kit

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paveltinnik.habridealapp.ui.theme.HabrIdealAppTheme


@Composable
fun BasicFilledButtonJustNotes(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun BasicFilledButtonJustNotesPreview() {
    HabrIdealAppTheme(dynamicColor = false) {
        BasicFilledButtonJustNotes(
            modifier = Modifier
                .width(164.dp)
                .height(50.dp),
            text = "Create",
            onClick = {},
        )
    }
}
