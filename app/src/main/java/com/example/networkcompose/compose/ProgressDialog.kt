package com.example.networkcompose.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ProgressDialog(
    modifier: Modifier = Modifier,
    setShowDialog: (Boolean) -> Unit
){
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Box(
            /*modifier = modifier
                .height(150.dp)
                .width(150.dp)
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(15.dp)
                )*/
        ) {
            CircularProgressIndicator(
                modifier = modifier.align(Alignment.Center)
            )
        }
    }
}