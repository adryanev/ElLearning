package com.circlenode.el_learning.utils

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool

class AudioManager  {

    companion object {
        lateinit var mediaPlayer : MediaPlayer
        lateinit var soundPool : SoundPool
        var isPlayingAudio : Boolean = false
        var a : Boolean = false


        fun playAudio(context: Context) : Unit{
            mediaPlayer = MediaPlayer()
            if(mediaPlayer.isPlaying){
                //TODO: media player logic
            }
        }
    }
}