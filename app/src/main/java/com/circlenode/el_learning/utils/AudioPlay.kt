package com.circlenode.el_learning.utils

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.widget.Toast
import java.io.IOException

class AudioPlay  {

    companion object {
        lateinit var mediaPlayer : MediaPlayer
        var isPlayingAudio : Boolean = false
        var a : Boolean = false


        fun playAudio(context: Context, assetFileDescriptor: AssetFileDescriptor){
            mediaPlayer = MediaPlayer()
            if(!mediaPlayer.isPlaying){
                try{
                    mediaPlayer.setDataSource(assetFileDescriptor.fileDescriptor,assetFileDescriptor.startOffset,assetFileDescriptor.length)

                } catch (e : IOException){
                    Toast.makeText(context, "Tidak dapat menemukan file audio.",Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
            if(!isPlayingAudio){
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener {
                    if(!it.isPlaying){
                        isPlayingAudio = false
                        it.start()
                    }
                    else{
                        isPlayingAudio = true
                        it.stop()
                        it.release()
                    }
                }
            }
        }

        fun playAudio(context: Context, path : String) : Unit{
            mediaPlayer = MediaPlayer()
            if(!mediaPlayer.isPlaying){
                try{
                    mediaPlayer.setDataSource(path)

                } catch (e : IOException){
                    Toast.makeText(context, "Tidak dapat menemukan file audio.",Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
            if(!isPlayingAudio){
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener {
                    if(!it.isPlaying){
                        isPlayingAudio = false
                        it.start()
                    }
                    else{
                        isPlayingAudio = true
                        it.stop()
                        it.release()
                    }
                }
            }


        }

        fun isComplete() : Boolean{
            mediaPlayer.setOnCompletionListener {
                a = true
            }

            return a
        }

        fun stopAudio(){
            isPlayingAudio = false
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        fun pauseAudio(){
            isPlayingAudio = false
            mediaPlayer.pause()
        }
    }
}