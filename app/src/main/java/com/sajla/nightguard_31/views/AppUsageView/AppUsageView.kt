package com.sajla.nightguard_31.views.AppUsageView

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sajla.nightguard_31.viewmodel.AppUsage.AppUsageViewModel

@Composable
fun AppUsageScreen(viewModel: AppUsageViewModel = viewModel()) {
    val appUsageList = viewModel.appUsageList.observeAsState(emptyList())

    LazyColumn(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(appUsageList.value) { appUsage ->
            Column(modifier = androidx.compose.ui.Modifier.padding(8.dp)) {
                Text(
                    text = "App: ${appUsage.appName}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Tiempo de uso: ${appUsage.usageTime}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
