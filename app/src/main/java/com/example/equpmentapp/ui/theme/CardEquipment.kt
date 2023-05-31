package com.example.equpmentapp.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddCardEquipment(name: String) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .padding(8.dp)
            .clickable { },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = name, fontStyle = FontStyle.Italic, fontSize = 24.sp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row() {
                        Column() {
                            Text(text = "Дата поверки прибора:")
                            Text(text = "18.02.2022")
                        }
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Row() {
                        Column() {
                            Text(text = "Следующая поверка:")
                            Text(text = "18.02.2022")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    AddCardEquipment("dag")
}