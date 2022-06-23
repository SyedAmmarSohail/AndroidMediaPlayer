package com.example.androidmediaplayer

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class AndroidPlayer(private val context: Context, attributes: AudioAttributes, url: String) :
    IMediaPlayer {

    private var onError: (() -> Unit)? = null
    private var onCompletion: (() -> Unit)? = null
    private var onPrepared: (() -> Unit)? = null
    private var player: MediaPlayer = MediaPlayer().apply {
        setDataSource(url)
//        create(context, url)
        setAudioAttributes(
            attributes
        )
        prepareAsync()
    }

    init {
        player.setOnErrorListener { _, _, _ ->
            onError?.invoke()
            false
        }
        player.setOnCompletionListener { onCompletion?.invoke() }
        player.setOnPreparedListener { onPrepared?.invoke() }
    }

    override fun seekTo(to: Int) = player.seekTo(to)

    override fun isPlaying() = player.isPlaying

    override fun start() {
        player.start()
    }

    override fun resume() {
        player.start()
    }

    override fun pause() = player.pause()

    override fun setWakeMode(mode: Int) = player.setWakeMode(context, mode)

    override val duration: Int
        get() = player.duration

    override var playbackSpeed: Float = 1F
        get() = 1F

    override fun release() = player.release()

    override fun audioSessionId() = player.audioSessionId

    override fun onError(action: (() -> Unit)?) {
        onError = action
    }

    override fun onCompletion(action: (() -> Unit)?) {
        onCompletion = action
    }

    override fun onPrepared(action: (() -> Unit)?) {
        onPrepared = action
    }

    override fun flush() {
        player.stop()
        player.reset()
        player.release()
    }

    override fun setAudioStreamType(streamType: Int) = player.setAudioStreamType(streamType)

    override fun setVolume(volume: Float) {
        player.setVolume(volume, volume)
    }

    override fun prepare(uri: Uri) {
        player.setDataSource(context, uri)
        player.prepare()
    }

    override fun prepareAsync(uri: Uri) {
        player.setDataSource(context, uri)
        player.prepareAsync()
    }

    override fun reset() = player.reset()

    override val currentPosition: Int
        get() = player.currentPosition
}