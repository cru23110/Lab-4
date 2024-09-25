package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class ConfiguracionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SettingsScreen(modifier = Modifier.padding(innerPadding),
                        onNavigateBack = {finish()},
                        navController = navController
                        )
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier,navController: NavHostController, onNavigateBack: () -> Unit) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
            Text(
                text = "Settings",
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold
            )
            SettingsList(onNavigateBack = onNavigateBack,navController = navController)
        }
    }
}

@Composable
fun SettingsList(onNavigateBack: () -> Unit,navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        SettingsCard(
            imageResource = R.drawable.profile,
            title = stringResource(id = R.string.textS1),
            onClick = {}
        )
        SettingsCard(
            imageResource = R.drawable.email,
            title = stringResource(id = R.string.textS2),
            onClick = {}
        )
        SettingsCard(
            imageResource = R.drawable.noti,
            title = stringResource(id = R.string.textS3),
            onClick = {}
        )
        SettingsCard(
            imageResource = R.drawable.privacy,
            title = stringResource(id = R.string.textS4),
            onClick = {}
        )

        SettingsCard(
            imageResource = R.drawable.question,
            title = stringResource(id = R.string.textS5),
            onClick = {}
        )
        SettingsCard(
            imageResource = R.drawable.info,
            title = stringResource(id = R.string.textS6),
            onClick = {}
        )
        LogoutButton(onNavigateBack)
    }
}

@Composable
fun SettingsCard(imageResource: Int, title: String,onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}

@Composable
fun LogoutButton(onNavigateBack: () -> Unit) {
    TextButton(
        onClick = {onNavigateBack()},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Volver",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    Laboratorio4Theme {
        val navController = rememberNavController()
        SettingsScreen(onNavigateBack = {}, navController = navController)
    }
}
