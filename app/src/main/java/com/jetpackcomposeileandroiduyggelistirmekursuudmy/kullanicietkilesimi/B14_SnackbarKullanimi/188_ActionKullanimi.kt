package com.jetpackcomposeileandroiduyggelistirmekursuudmy.kullanicietkilesimi.B14_SnackbarKullanimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun snackbaractionkullanimi(){
    val snackbarHostState= remember { SnackbarHostState() }
    val scope = rememberCoroutineScope() // Coroutine dedigimiz yapi asenkor calisir ve daha performansli yapi sunar

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
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
                       val sb= snackbarHostState.showSnackbar(message = "Silmek ister misin?", actionLabel = "Evet")

                        if (sb==SnackbarResult.ActionPerformed){
                            snackbarHostState.showSnackbar(message = "Silindi")
                        }
                    }
                }) {
                    Text(text = "Snackbar Action")

                }
                Button(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(message = "Hosgeldiniz")
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
fun snackbaractionkullanimipreview(){
    snackbaractionkullanimi()
}