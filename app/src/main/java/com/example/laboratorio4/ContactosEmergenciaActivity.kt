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
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class ContactosEmergenciaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmergencyContactsScreen(
                        modifier = Modifier.padding(innerPadding),
                        onNavigateBack = { finish() } 
                    )
                }
            }
        }
    }
}

@Composable
fun EmergencyContactsScreen(modifier: Modifier = Modifier, onNavigateBack: () -> Unit) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Emergency Contacts",
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold
            )
            EmergencyContactsList()
            Spacer(modifier = Modifier.weight(1f)) 
            BackButton(onClick = onNavigateBack) 
        }
    }
}

@Composable
fun EmergencyContactsList() {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Card de Emergencias
        EmergencyCard(
            imageResource = R.drawable.emergency,
            title = stringResource(id = R.string.textE1),
            description = stringResource(id = R.string.textE2),
            buttonText = stringResource(id = R.string.textE3)
        )
        // Card de la Clínica UVG
        EmergencyCard(
            imageResource = R.drawable.clinic,
            title = stringResource(id = R.string.textC1),
            description = """La Clínica UVG, presta los siguientes servicios:
                 -Atención a Emergencias
                 -Atención Primaria a Enfermedades
                 -Plan Educacional sobre Enfermedades

                Horario de Atención: 7:00 a.m. a 8:30 p.m.
                Campus Central Edificio F 119 120.""".trimIndent(),
            buttonText = stringResource(id = R.string.textC2)
        )
    }
}

@Composable
fun EmergencyCard(imageResource: Int, title: String, description: String, buttonText: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = description, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))

            CallButton(buttonText = buttonText)
        }
    }
}

@Composable
fun CallButton(buttonText: String) {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = buttonText, color = Color.White, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun BackButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Volver", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmergencyContactsScreen() {
    Laboratorio4Theme {
        EmergencyContactsScreen(onNavigateBack = {})
    }
}