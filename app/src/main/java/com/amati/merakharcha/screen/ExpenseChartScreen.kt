package com.amati.merakharcha.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amati.merakharcha.dataModel.ExpenseViewModel
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseChartScreen(
    viewModel: ExpenseViewModel,
    onBack: () -> Unit

){
    val summary by viewModel.categorySummary.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Expense Chart") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) { padding ->

        if (summary.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No data to show")
            }
            return@Scaffold
        }


        val colors = listOf(
            Color.Blue,
            Color.Red,
            Color.Green,
            Color.Yellow,
            Color.Magenta,
            Color.Cyan,
            Color.Gray,
            Color.DarkGray,
            Color.LightGray,
            Color.White
        )
        val pieChartData = summary.mapIndexed { index, item ->
            PieChartData.Slice(
//             label = it.category,
                value = item.total.toFloat(),
                color = colors[index % colors.size]
            )

        }


        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {



            PieChart(
                pieChartData = PieChartData(pieChartData),
                modifier = Modifier.size(300.dp),
                animation = simpleChartAnimation(),
            )

            Spacer(modifier = Modifier.height(24.dp))

            summary.forEachIndexed { index, item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.size(12.dp).background(colors[index % colors.size])
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${item.category}: ₹${item.total}",
                        color = Color.White)
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}