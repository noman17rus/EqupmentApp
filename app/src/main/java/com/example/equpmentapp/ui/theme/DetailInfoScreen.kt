package com.example.equpmentapp.ui.theme

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.equpmentapp.DataBase
import com.example.equpmentapp.EViewModel
import com.example.equpmentapp.Equipment
import com.example.equpmentapp.navi.AllScreens
import java.util.Calendar
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailInfoScreen(navigator: NavHostController, viewModel: EViewModel) {

    val nameState = remember { mutableStateOf("") }
    nameState.value = viewModel.name.observeAsState("").value.trim()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Введите наименование оборудования:", Modifier.padding(8.dp), fontSize = 24.sp)
        OutlinedTextField(
            value = nameState.value, onValueChange = { viewModel.editName(it) },
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.None
            )
        )
        Text(text = "Выберите дату последней поверки:", Modifier.padding(8.dp), fontSize = 24.sp)
        DatePicker()
        ButtonAddCard(nameState, navigator, viewModel)
    }
}

@Composable
fun ButtonAddCard(
    state: MutableState<String>,
    navigator: NavHostController,
    viewModel: EViewModel
) {
    val context = LocalContext.current
    Button(onClick = {
        if (state.value == "") {
            Toast.makeText(context, "Введите название оборудования", Toast.LENGTH_SHORT).show()
        } else {
            DataBase.dataBase.add(Equipment(state.value, 12, "hello", "Android"))
            navigator.navigate(route = AllScreens.HomeScreen.route)
            viewModel.name.value = ""
        }

    }) {
        Text(text = "Add")
    }
}

@Composable
fun DatePicker() {
    val context = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()
    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()
    // Declaring a string value to
    // store date in string format
    //state = (viewModel.bd.observeAsState("").value as MutableList<Equipment>)

    val mDate = remember {
        mutableStateOf("")
    }

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth.${mMonth}.$mYear"
        }, mYear, mMonth, mDay
    )

    Button(
        onClick = {
            mDatePickerDialog.show()
        },
    ) {
        Text(text = "Open Date Picker")
    }
}

