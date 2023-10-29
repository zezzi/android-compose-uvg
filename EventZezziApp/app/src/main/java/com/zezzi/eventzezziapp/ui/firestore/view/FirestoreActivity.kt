package com.zezzi.eventzezziapp.ui.firestore.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirestoreActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventZezziAppTheme() {
                val isInput = remember { mutableStateOf(false) }
                Surface() {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = {
                                isInput.value = true
                            }) {
                                Icon(Icons.Default.Add, contentDescription = "")
                            }
                        }
                    ) {
                        FirestoreScreen(isInput)
                    }
                }
            }
        }
    }

}