package com.example.equpmentapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.equpmentapp.navi.ENavHost
import com.example.equpmentapp.ui.theme.AddActionButton
import com.example.equpmentapp.ui.theme.AddCardEquipment
import com.example.equpmentapp.ui.theme.AddTopBarCompose
import com.example.equpmentapp.ui.theme.EqupmentAppTheme
import com.example.equpmentapp.ui.theme.HomeScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigator = rememberNavController()
            val viewModel = viewModel(modelClass = EViewModel::class.java)
            ENavHost(navigator = navigator, viewModel = viewModel)
        }
    }
}






