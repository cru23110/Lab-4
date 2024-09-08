package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class CampusInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Laboratorio4Theme {
                CampusInfoScreen()
            }
        }
    }
}

@Composable
fun CampusInfoScreen() {
    // Habilitar desplazamiento para la pantalla completa
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado entre elementos
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Imagen principal del Campus
            Image(
                painter = painterResource(id = R.drawable.campus_image),
                contentDescription = "Campus Central",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título "Campus Central"
            Text(
                text = "Campus Central",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sección "Destacados"
            SectionTitle(title = "Destacados")
            HighlightSection()

            Spacer(modifier = Modifier.height(16.dp))

            // Sección "Servicios y Recursos"
            SectionTitle(title = "Servicios y Recursos")
            ServicesSection()
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Hace que la columna ocupe todo el ancho disponible
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Composable
fun HighlightSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Bloques con imágenes y títulos para "Destacados"
        HighlightCard(
            title = "Service Now",
            imageRes = R.drawable.service_now,
            backgroundColor = Color(0xFF4CAF50) // Verde
        )
        HighlightCard(
            title = "Actualidad UVG",
            imageRes = R.drawable.actualidad_uvg,
            backgroundColor = Color.Gray
        )
    }
}

@Composable
fun HighlightCard(title: String, imageRes: Int, backgroundColor: Color) {
    Card(
        modifier = Modifier
            .width(170.dp) // Ajuste del ancho de las tarjetas
            .height(150.dp) // Ajuste de la altura de las tarjetas
            .clickable { /* acción de clic */ },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ServicesSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Bloques con imágenes y títulos para "Servicios y Recursos"
        HighlightCard(
            title = "Directorio de Servicios Estudiantiles",
            imageRes = R.drawable.servicios_estudiantiles,
            backgroundColor = Color(0xFF4CAF50)
        )
        HighlightCard(
            title = "Portal Web Bibliotecas UVG",
            imageRes = R.drawable.portal_bibliotecas,
            backgroundColor = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCampusInfoScreen() {
    Laboratorio4Theme {
        CampusInfoScreen()
    }
}
