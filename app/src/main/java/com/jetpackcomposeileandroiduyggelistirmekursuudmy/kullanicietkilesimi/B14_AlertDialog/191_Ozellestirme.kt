package com.jetpackcomposeileandroiduyggelistirmekursuudmy.kullanicietkilesimi.B14_AlertDialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun alertdialogozellestırme(){
    val aciliskontrolvarsayilan= remember { mutableStateOf(false) }
    val aciliskontrolozel= remember { mutableStateOf(false) }
    val tf= remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            aciliskontrolvarsayilan.value=true
        }) {
            Text(text = "Varsayilan")

        }
        if (aciliskontrolvarsayilan.value==true){
            AlertDialog(onDismissRequest = {aciliskontrolvarsayilan.value=false },
                title = { Text(text = "Baslik") },
                text = { Text(text = "Mesaj") },
                confirmButton = {
                    Text(
                        text = "Tamam",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            aciliskontrolvarsayilan.value=false
                        })
                },
                dismissButton = {
                    Text(text = "Iptal",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            aciliskontrolvarsayilan.value=false
                        })
                })
        }
        Button(onClick = { aciliskontrolozel.value=true }) {
            Text(text = "Ozel")

        }
        if (aciliskontrolozel.value==true){
            AlertDialog(onDismissRequest = {aciliskontrolozel.value=false },
                title = { Text(text = "Baslik", color = Color.Black) },
                text = {
                       TextField(value = tf.value, onValueChange = {tf.value=it},
                           label = { Text(text = "Veri")})
                },
                confirmButton = {
                    Text(
                        text = "Tamam",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all = 10.dp).clickable {
                            aciliskontrolozel.value=false
                        })
                },
                dismissButton = {
                    Text(text = "Iptal",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all = 10.dp).clickable {
                            aciliskontrolozel.value=false
                        })
                },
                containerColor = Color.LightGray
                )
        }

    }
}

@Preview
@Composable
fun alertdialogozellestırmepreview(){
    alertdialogozellestırme()
}