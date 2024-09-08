package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MiPerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Laboratorio4Theme {
                MyProfileScreen()
            }
        }
    }
}

@Composable
fun MyProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado con imagen de fondo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_background),
                contentDescription = "Profile Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Ícono de perfil en círculo
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 40.dp), // Ajustar la posición del ícono
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape) // Forma circular
                        .background(Color.Gray) // Color de fondo del ícono
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Nombre del usuario
                Text(
                    text = "Usuario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Lista de opciones
        OptionItem(iconRes = R.drawable.ic_campus, title = "My Campus", subtitle = "Campus Central")
        OptionItem(iconRes = R.drawable.ic_friends, title = "My Friends")
        OptionItem(iconRes = R.drawable.ic_calendar, title = "My Calendar")
        OptionItem(iconRes = R.drawable.ic_courses, title = "My Courses")
        OptionItem(iconRes = R.drawable.ic_grades, title = "My Grades")
        OptionItem(iconRes = R.drawable.ic_groups, title = "My Groups")
        OptionItem(iconRes = R.drawable.ic_events, title = "My Upcoming Events")
    }
}

@Composable
fun OptionItem(iconRes: Int, title: String, subtitle: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono de la opción
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 16.dp)
        )

        // Texto de la opción
        Column {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            subtitle?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyProfileScreen() {
    Laboratorio4Theme {
        MyProfileScreen()
    }
}
