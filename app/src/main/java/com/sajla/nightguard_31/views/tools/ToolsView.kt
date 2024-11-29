package com.sajla.nightguard_31.views.tools

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sajla.nightguard_31.components.hour.CustomTimePicker
import com.sajla.nightguard_31.components.lists.CustomDropdown
import com.sajla.nightguard_31.components.switchs.CustomSwitch
import com.sajla.nightguard_31.viewmodel.list.ListViewModel
import com.sajla.nightguard_31.viewmodel.switch.SwitchViewModel
import com.sajla.nightguard_31.viewmodel.time.TimeViewModel

@Composable
fun ToolsView(navController: NavController, context: Context) {
    val timeViewModel: TimeViewModel = viewModel()
    val listViewModel: ListViewModel = viewModel()
    val switchViewModel: SwitchViewModel = viewModel()

    val timeState = timeViewModel.state
    val listState = listViewModel.state
    val switchState = switchViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Selecciona una Hora", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        CustomTimePicker(
            context = context,
            initialHour = timeState.hour,
            initialMinute = timeState.minute,
            onTimeSelected = { formattedTime ->
                val (hour, minute) = formattedTime.split(":").map { it.toInt() }
                timeViewModel.onTimeSelected(hour, minute)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Hora seleccionada: ${timeState.formattedTime}",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Selecciona una Opción", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        CustomDropdown(
            options = listState.options,
            label = "Opciones",
            onOptionSelected = { selectedOption ->
                listViewModel.onOptionSelected(selectedOption)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Opción seleccionada: ${listState.selectedOption}",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Controla el Switch", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        CustomSwitch(
            context = context,
            isOn = switchState.isOn,
            onToggle = { switchViewModel.toggleSwitch() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (switchState.isOn) "El Switch está Prendido" else "El Switch está Apagado",
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
    }
}