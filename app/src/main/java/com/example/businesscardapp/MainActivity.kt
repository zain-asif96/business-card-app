package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffd2e8d4)
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    data class SocialLink(val icon: Painter, val infoText: String)

    val socialLinks = listOf(
        SocialLink(
            icon = painterResource(R.drawable.phone),
            infoText = stringResource(R.string.phone_number)
        ),
        SocialLink(
            icon = painterResource(R.drawable.messenger),
            infoText = stringResource(R.string.email_address)
        ),
        SocialLink(
            icon = painterResource(R.drawable.facebook),
            infoText = stringResource(R.string.fb_handle)
        ),
    )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardIntroduction(
                fullName = stringResource(R.string.full_name),
                logo = painterResource(R.drawable.ic_launcher_foreground) ,
                jobTitle = stringResource(R.string.jd),
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
            ) {
                for (item in socialLinks) {
                    SocialInfo(icon = item.icon, infoText = item.infoText)
                }
            }

        }

}

@Composable
private fun CardIntroduction(
    fullName: String,
    logo: Painter,
    jobTitle: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier= modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier.background(Color(0xff073042))
        ) {
            Image(
                painter = logo,
                contentDescription = "logo",
                colorFilter = ColorFilter.tint(Color(0xff3ddc84))

            )
        }

        Text(
            modifier = modifier.padding(vertical = 10.dp),
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            color = Color(0xff0c7141),
            text = jobTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun SocialInfo(icon: Painter, infoText: String, modifier: Modifier = Modifier){
    Row(
        modifier = modifier.padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.Center,
    ){
        Image(
            painter = icon,
            contentDescription = "icon",
            modifier= modifier.width(20.dp),
            colorFilter = ColorFilter.tint(Color(0xff0e7443)))
        Text(
            text = infoText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier.padding(horizontal = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardScreen()
    }
}