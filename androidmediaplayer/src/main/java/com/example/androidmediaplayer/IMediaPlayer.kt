package com.example.androidmediaplayer

import android.media.AudioAttributes
import android.net.Uri
import java.io.IOException

@Suppress("unused")
interface IMediaPlayer {

    fun audioSessionId(): Int

    fun isPlaying(): Boolean

    fun pause()

    @Throws(IOException::class)
    fun prepare(uri: Uri)

    fun prepareAsync(uri: Uri)

    fun reset()

    fun release()

    fun seekTo(to: Int)

    fun setAudioStreamType(streamType: Int)

    fun setVolume(volume: Float)

    fun setWakeMode(mode: Int)

    fun start()

    fun resume()

    val currentPosition: Int

    val duration: Int

    var playbackSpeed: Float

    fun onError(action: (() -> Unit)?)

    fun onCompletion(action: (() -> Unit)?)

    fun onPrepared(action: (() -> Unit)?)

    fun flush()
}