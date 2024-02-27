package com.example.week3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week3.ui.theme.Week3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week3Theme {
                WaterCount()
                //task1()
                //task2()
                //task3()
                //task4()
                //HelloContent()
            }
        }
    }
}

@Composable
fun WaterCount()
{
    Column() {
        var count = rememberSaveable{ mutableStateOf(0)}
      if (count.value <= 1){
          Text(text = "You have had ${count.value} glass of water")
      }else {
          Text(text = "You have had ${count.value} glasses of water")
      }

        Button(onClick = { count.value++ }) {
            Text(text = "Add one glass.")

        }
    }

}
@Composable
    fun task1() {
        var isButtonClicked by remember { mutableStateOf(false) }
        val ColorList = listOf(Color.Green, Color.Red, Color.Green, Color.DarkGray)
        val buttonColor = if (isButtonClicked) {
            Color.Green
        } else {
            Color.Red
        }

        Button(
            onClick = {
                // Toggle the state when the button is clicked
                isButtonClicked = !isButtonClicked
            },
            modifier = Modifier
                .padding(140.dp)
                ,
            colors = ButtonDefaults.buttonColors(buttonColor)
        ) {
            Text("Click me!")
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun task2()
{
    Row(verticalAlignment = Alignment.CenterVertically) {
       Column(modifier = Modifier
           .padding(1.dp)
           .size(width = 120.dp, 120.dp)
           .border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(10.dp))



       ) {

           Image(painter = painterResource(id = R.drawable.deadpool),
               contentDescription ="null",

               modifier= Modifier
                   //.clip(RoundedCornerShape(12.dp))
                   .size(width = 110.dp, height = 130.dp)

                   .fillMaxSize(.1f),
               contentScale = ContentScale.Crop

               )

       }
       Column {
               var text by remember { mutableStateOf("") }
               OutlinedTextField(
                   value = text,
                   onValueChange = { text = it },
                   label = { Text("Name") }
               )
               OutlinedTextField(
                   value = text,
                   onValueChange = { text = it },
                   label = { Text("Phone Number") }
               )


           }
           
       }
          
    }



@Composable
fun task3()
{


    Column {
        val superHeroes = listOf(
            listOf(43,"Iron Man", R.drawable.ironmanbgtr),
            listOf(38,"Hulk", R.drawable.hulk),
            listOf(25,"Deadpool", R.drawable.deadpool),
            listOf(48,"Wolverine", R.drawable.wolverine),
            listOf(30,"Black Widow", R.drawable.blackwid)
        )
        for (hero in superHeroes) {
            if(hero.size>=3)
            {
                val age = hero[0] as Int
                val name = hero[1] as String
                val imageResourceId = hero[2] as Int
                ArtistCard(age = age, name = name, imageResourceId = imageResourceId )
            }
            else{
                print("Invalid List : $hero")
            }
        }

    }
}
@Composable
fun ArtistCard(age: Int, name: String, imageResourceId:Int)
{

    Row(  modifier = Modifier
        .shadow(
            elevation = 2.dp,
        )
        .fillMaxWidth()

    ) {
        Column(modifier = Modifier
            .padding(10.dp)
        ) {

            Image(painter = painterResource(id = imageResourceId ),
                contentDescription ="null",
                modifier= Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(width = 110.dp, height = 100.dp)
                    .fillMaxSize()
            )

        }
        Column {
            Text(text = "$name" , fontWeight = FontWeight.Bold , fontSize = 30.sp, modifier = Modifier.padding(10.dp))
            Text(text = "Age : $age", modifier = Modifier.padding(10.dp))
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun task4() {
    val imgList = listOf(
        listOf(R.drawable.deadpool,"Deadpool"),
        listOf(R.drawable.blackwid,"Black Widow"),
        listOf(R.drawable.hulk,"Hulk"),
        listOf(R.drawable.ironmanbgtr,"Iron Man"),
        listOf(R.drawable.wolverine,"Wolverine"),
        listOf(R.drawable.thor,"Thor")
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(imgList) { (imageResourceId, characterName) ->

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = imageResourceId as Int),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .border(BorderStroke(2.dp, Color.Black)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )

                Text(
                    text = "$characterName",
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .background(Color.Blue)
                        .align(Alignment.BottomStart)
                        .background(Color.Blue),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HelloContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Name") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week3Theme {
        Greeting("Android")
    }
}