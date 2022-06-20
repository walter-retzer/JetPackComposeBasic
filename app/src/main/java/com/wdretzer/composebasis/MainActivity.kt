package com.wdretzer.composebasis

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wdretzer.composebasis.ui.theme.ComposeBasisTheme
import com.wdretzer.composebasis.ui.theme.LatoFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FeedItem()
                    //Greeting("Android")
                    //CustomText(textResId = R.string.app_name)
                }
            }
        }
    }
}

@Composable
fun FeedItem() {
    Column {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "Description"
            )
            Text(
                text = "30:12",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp, 8.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Description",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
            )
            Column {
                Text(text = "JetPack Compose - Conceitos Básicos")
                Spacer(modifier = Modifier.size(8.dp))

                Row {
                    Text(
                        text = "Usuario",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "| 171 Views",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = " | 2 days ago",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}


@Composable
fun CustomText(@StringRes textResId: Int) {
    Text(
        text = stringResource(id = textResId),
        color = Color(0xFF02AA02),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("Welcome", "Clicado")
            },
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = LatoFamily,
        textAlign = TextAlign.Center,
    )

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", fontSize = 20.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasisTheme {
        //CustomText(textResId = R.string.app_name)
        FeedItem()
    }
}
