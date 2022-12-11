package gaur.himanshu.parallaxyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gaur.himanshu.parallaxyt.ui.theme.ParallaxYTTheme
import gaur.himanshu.parallaxyt.ui.theme.Purple700
import java.lang.Float.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallaxYTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Parallax()
                }
            }
        }
    }
}

@Composable
fun Parallax() {

    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .graphicsLayer {
                        alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                        translationY = 0.5f * scrollState.value
                    }, contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.king_kohli),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = stringResource(id = R.string.title),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )

            Text(
                text = stringResource(id = R.string.desc),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .graphicsLayer {
                    alpha = min(1f, (scrollState.value.toFloat() / scrollState.maxValue))
                }
                .background(color = Purple700), contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = "King is Back",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 12.dp),
                color = Color.White
            )

        }
    }

}













