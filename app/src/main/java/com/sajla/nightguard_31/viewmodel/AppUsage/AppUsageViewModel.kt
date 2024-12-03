package com.sajla.nightguard_31.viewmodel.AppUsage

import android.app.Application
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sajla.nightguard_31.data.models.AppUsageItem
import java.text.SimpleDateFormat
import java.util.*

class AppUsageViewModel(application: Application) : AndroidViewModel(application) {

    private val _appUsageList = MutableLiveData<List<AppUsageItem>>()
    val appUsageList: LiveData<List<AppUsageItem>> = _appUsageList

    fun fetchAppUsageData() {
        try {
            val usageStats = getAppUsageStats(getApplication())
            val appUsageItems = parseUsageStats(usageStats, getApplication())
            _appUsageList.postValue(appUsageItems)
        } catch (e: Exception) {
            _appUsageList.postValue(emptyList())
        }
    }

    private fun getAppUsageStats(context: Context): List<UsageStats> {
        val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        val calendar = Calendar.getInstance()
        val endTime = calendar.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val startTime = calendar.timeInMillis

        return usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
        ) ?: emptyList()
    }

    private fun parseUsageStats(usageStats: List<UsageStats>, context: Context): List<AppUsageItem> {
        val packageManager = context.packageManager
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return usageStats.mapNotNull {
            try {
                val appName = packageManager.getApplicationLabel(
                    packageManager.getApplicationInfo(it.packageName, 0)
                ).toString()
                val usageTime = dateFormat.format(Date(it.totalTimeInForeground))
                AppUsageItem(appName, usageTime)
            } catch (e: Exception) {
                null
            }
        }
    }
}
