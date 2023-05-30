package com.example.equpmentapp.ui.theme

import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.equpmentapp.DataBase
import com.example.equpmentapp.EViewModel
import com.example.equpmentapp.Equipment
import com.example.equpmentapp.navi.AllScreens
import com.google.android.material.datepicker.DateSelector
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailInfoScreen(navigator: NavHostController, viewModel: EViewModel, ) {
    val mContext = LocalContext.current
    var state = remember { mutableStateOf("") }
    state.value = viewModel.name.observeAsState("").value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Введите наименование оборудования:", Modifier.padding(8.dp), fontSize = 24.sp)
        OutlinedTextField(
            value = state.value, onValueChange = {x:String -> viewModel.editName(x)},
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(text = "Выберите дату последней поверки:", Modifier.padding(8.dp), fontSize = 24.sp)

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
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDate.value = "$mDayOfMonth.${mMonth}.$mYear"
            }, mYear, mMonth, mDay
        )

        val localDate = LocalDate.of(mYear, mMonth, mDay)

        Button(
            onClick = {
                mDatePickerDialog.show()
            },
        ) {
            Text(text = "Open Date Picker")
        }

        Button(onClick = {
            DataBase.dataBase.add(Equipment(state.value, 12, "hello", "Android"))
            navigator.navigate(route = AllScreens.HomeScreen.route)
            viewModel.name.value = ""
        }) {
            Text(text = "Add")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewDetailInfo() {

}

