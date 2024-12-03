package com.sajla.nightguard_31.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sajla.nightguard_31.R
import com.sajla.nightguard_31.components.buttons.LoginButton
import com.sajla.nightguard_31.components.images.CustomImage

@Composable
fun StartView(navController: NavController) {
    var isFirstImage by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Botones de la parte superior
        IconButton(
            onClick = { navController.navigate("Home") },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "User Button",
                tint = Color.Gray
            )
        }

        IconButton(
            onClick = { navController.navigate("Login") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.flechaizquierda),
                contentDescription = "Back Button",
                tint = Color.Gray
            )
        }

        // Imagen central y botón
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val currentImage = if (isFirstImage) R.drawable.boton1 else R.drawable.boton2

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(16.dp, androidx.compose.foundation.shape.CircleShape)
                    .background(
                        if (isFirstImage) Color(0xAAFF0000) else Color(0xAA00FF00),
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
                    .padding(16.dp)
            ) {
                CustomImage(image = currentImage, description = "App Logo")
            }

            Spacer(modifier = Modifier.height(20.dp))

            LoginButton(
                name = "Start App",
                backColor = R.color.teal_200,
                color = R.color.white
            ) {
                isFirstImage = !isFirstImage
            }
        }

        // Barra inferior
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Settings",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { navController.navigate("AppUsage") }) {
                Icon(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = "Info",
                    tint = Color.Gray
                )
            }

        }
        }

}
