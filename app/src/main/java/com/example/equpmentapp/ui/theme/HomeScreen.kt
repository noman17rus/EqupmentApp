package com.example.equpmentapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.equpmentapp.DataBase
import com.example.equpmentapp.navi.AllScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navigator: NavHostController) {
    Scaffold(
        floatingActionButton = { AddActionButton(navigator) },
        floatingActionButtonPosition = FabPosition.Center,
        topBar = { AddTopBarCompose() }
    ) {
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Column(modifier = Modifier.fillMaxWidth(1f)) {
                for (item in DataBase.dataBase) {
                    AddCardEquipment(name = item.name)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    EqupmentAppTheme {
        
    }
}