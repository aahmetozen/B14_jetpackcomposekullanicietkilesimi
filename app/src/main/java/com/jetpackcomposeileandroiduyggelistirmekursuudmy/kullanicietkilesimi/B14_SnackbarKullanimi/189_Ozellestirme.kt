package com.jetpackcomposeileandroiduyggelistirmekursuudmy.kullanicietkilesimi.B14_SnackbarKullanimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun snackbarozellsetirme(){
    val snackbarHostState= remember { SnackbarHostState() }
    val scope = rememberCoroutineScope() // Coroutine dedigimiz yapi asenkor calisir ve daha performansli yapi sunar

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState){
                Snackbar(
                    snackbarData = it, // gelen nesneyi temsil ediyor
                    containerColor = Color.White, // arkaplan rengi
                    contentColor = Color.Blue, // yazi rengi
                    actionColor = Color.Red // actionLabel rengi
                    // burada yapilan degisiklikler tum snackbarlari etkiler
                )


            }
        }
    ){paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(message = "Merhaba")
                    }
                }) {
                    Text(text = "Varsayilan")

                }
                Button(onClick = {
                    scope.launch {
                        val sb1= snackbarHostState.showSnackbar(message = "Silmek ister misin?", actionLabel = "Evet")

                        if (sb1== SnackbarResult.ActionPerformed){
                            snackbarHostState.showSnackbar(message = "Silindi")
                        }
                    }
                }) {
                    Text(text = "Snackbar Action")

                }
                Button(onClick = {
                    scope.launch {
                       val sb2= snackbarHostState.showSnackbar(message = "Internet baglantisi yok !", actionLabel = "Tekrar dene")

                        if (sb2==SnackbarResult.ActionPerformed){
                            snackbarHostState.showSnackbar("Tekrar denendi")
                        }
                    }
                }) {
                    Text(text = "Snackbar Ozel")

                }

            }

        }



    }



}
@Preview
@Composable
fun snackbarozellsetirmepreview(){
    snackbarozellsetirme()
}