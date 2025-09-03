package com.example.jetpackcomposetutorial

import android.R.attr.text
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackcomposetutorialTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackcomposetutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                    MultipleStyleText()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(Modifier.padding(24.dp)) {
        Greeting()
        Spacer(modifier = Modifier.height(12.dp))
        MultipleStyleText()
    }
}
@Composable
fun Greeting() {
    Text(
        text = stringResource(R.string.greeting),
        color = Color.Red,
        fontSize =  30.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.SansSerif,
        maxLines = 2,
        overflow = TextOverflow.Clip

    )
}

@Composable
fun MultipleStyleText() {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.End)) {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.LineThrough)) {
                append("ello")
            }
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("F")
            }
            append("rank")
        }
    })

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomposetutorialTheme {
        HomeScreen()
    }
}