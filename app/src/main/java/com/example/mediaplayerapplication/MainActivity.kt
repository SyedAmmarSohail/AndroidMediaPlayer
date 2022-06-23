package com.example.mediaplayerapplication

import android.content.Context
import android.media.AudioAttributes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.androidmediaplayer.AndroidPlayer
import com.example.androidmediaplayer.IMediaPlayer
import com.example.mediaplayerapplication.ui.spacing
import com.example.mediaplayerapplication.ui.theme.MediaPlayerApplicationTheme
import com.example.mediaplayerapplication.ui.widget.ComposeBorderCircleWithIcon

class MainActivity : ComponentActivity() {

    lateinit var mediaPlayer: IMediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaPlayerApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(
                                    "Audio Player",
                                    color = Color.White
                                )
                            }, backgroundColor = MaterialTheme.colors.primary)
                        },
                        content = { MyContent() }
                    )
                }
            }
        }
    }

    @Composable
    private fun MyContent() {
        setMediaPlayer(LocalContext.current)
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
            ComposeBorderCircleWithIcon(
                icon = Icons.Default.PlayArrow,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                mediaPlayer.resume()
            }
            Spacer(Modifier.width(MaterialTheme.spacing.view_2x))
            ComposeBorderCircleWithIcon(
                icon = Icons.Default.Stop,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                mediaPlayer.pause()
            }
        }
    }

    private fun setMediaPlayer(context: Context) {
        mediaPlayer = AndroidPlayer(
            context,
            AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build(),
            "Replace your mp3 url"
        )
        mediaPlayer.onPrepared {
            mediaPlayer.resume()
        }
        mediaPlayer.onCompletion {
        }
    }
}