package com.example.equpmentapp.ui.theme

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.equpmentapp.navi.AllScreens


@Composable
fun AddActionButton(navigator: NavHostController) {
    FloatingActionButton(
        onClick = { navigator.navigate(route = AllScreens.DetailInfoScreen.route) },
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
    )
    {
        Icon(Icons.Filled.Add, contentDescription = "Добавить")
    }
}