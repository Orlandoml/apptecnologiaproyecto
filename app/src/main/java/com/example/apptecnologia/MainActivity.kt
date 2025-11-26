package com.example.apptecnologia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.apptecnologia.ui.theme.AppTecnologiaTheme
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.example.apptecnologia.data.IAEntity
import com.example.apptecnologia.viewmodel.IAViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("apis") { APIScreen() }
            composable("ia") { IAScreen() }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Inicio", "home", Icons.Default.Home),
        BottomNavItem("APIs", "apis", Icons.Default.Public),
        BottomNavItem("IA", "ia", Icons.Default.Build)
    )

    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        val currentRoute = currentRoute(navController) ?: "home"
        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tecnología, APIs e Inteligencia Artificial",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(16.dp))
        Image(
            painter = rememberAsyncImagePainter("https://cdn-icons-png.flaticon.com/512/2103/2103626.png"),
            contentDescription = "Tech",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Las APIs (Application Programming Interfaces) y la Inteligencia Artificial son pilares fundamentales del desarrollo moderno. Las APIs permiten conectar aplicaciones y servicios, mientras que la IA potencia la automatización y el análisis inteligente de datos.",
            fontSize = 16.sp,
            lineHeight = 22.sp
        )
    }
}

@Composable
fun APIScreen() {
    val apis = listOf(
        Pair("Google Maps API", "https://cdn-icons-png.flaticon.com/512/2991/2991148.png"),
        Pair("Firebase API", "https://cdn-icons-png.flaticon.com/512/732/732212.png"),
        Pair("Twitter API", "https://cdn-icons-png.flaticon.com/512/733/733579.png"),
        Pair("REST API", "https://cdn-icons-png.flaticon.com/512/1006/1006771.png"),
        Pair("YouTube Data API", "https://cdn-icons-png.flaticon.com/512/1384/1384060.png")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Principales APIs utilizadas en Android",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(12.dp))
        }

        items(apis) { (name, imageUrl) ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = name,
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}


@Composable
fun IAScreen(viewModel: IAViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val ias by viewModel.ias.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var editingIA by remember { mutableStateOf<IAEntity?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Inteligencias Artificiales destacadas",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            FloatingActionButton(
                onClick = {
                    editingIA = null
                    showDialog = true
                }
            ) {
                Icon(Icons.Default.Add, "Agregar IA")
            }
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(ias) { ia ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(ia.nombre, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                            Text(ia.descripcion, fontSize = 14.sp)
                        }

                        Row {
                            IconButton(onClick = {
                                editingIA = ia
                                showDialog = true
                            }) {
                                Icon(Icons.Default.Edit, "Editar")
                            }
                            IconButton(onClick = { viewModel.deleteIA(ia) }) {
                                Icon(Icons.Default.Delete, "Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }

    if (showDialog) {
        IADialog(
            ia = editingIA,
            onDismiss = { showDialog = false },
            onSave = { nombre, descripcion ->
                if (editingIA != null) {
                    viewModel.updateIA(editingIA!!.copy(nombre = nombre, descripcion = descripcion))
                } else {
                    viewModel.insertIA(nombre, descripcion)
                }
                showDialog = false
            }
        )
    }
}

@Composable
fun IADialog(
    ia: IAEntity?,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var nombre by remember { mutableStateOf(ia?.nombre ?: "") }
    var descripcion by remember { mutableStateOf(ia?.descripcion ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (ia == null) "Agregar IA" else "Editar IA") },
        text = {
            Column {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (nombre.isNotBlank() && descripcion.isNotBlank()) {
                        onSave(nombre, descripcion)
                    }
                }
            ) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}