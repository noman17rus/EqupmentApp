@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.equpmentapp.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun AddTopBarCompose() {
    TopAppBar(
        title = {
            Text(
                text = "Equipment app",
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {},
    )
}