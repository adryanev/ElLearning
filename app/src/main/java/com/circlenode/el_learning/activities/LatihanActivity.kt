package com.circlenode.el_learning.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.circlenode.el_learning.R
import com.circlenode.el_learning.database.entities.Soal
import com.circlenode.el_learning.database.repository.SoalRepository
import com.circlenode.el_learning.utils.AudioPlay
import kotlinx.android.synthetic.main.item_pertanyaan.*
import kotlinx.android.synthetic.main.layout_jawaban.*

class LatihanActivity : AppCompatActivity(), View.OnClickListener {



    lateinit var jawabanSiswa : ArrayList<String>
    lateinit var soalList : List<Soal>
    lateinit var soalSekarang : Soal
    lateinit var assetManager : AssetManager
    lateinit var jawabanBenar : ArrayList<String>

    companion object {
        var nomorSekarang = 0;
        var skor = 0;

    }

    lateinit var soalRepository: SoalRepository
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)
        val kelas = intent.getIntExtra(KelasActivity.KELAS,0)
        val semester = intent.getIntExtra(KelasActivity.SEMESTER,0)
        val pertemuan = intent.getIntExtra("pertemuan",0)
        val kategori : String? = intent.getStringExtra("kategori")
        assetManager = assets
        jawabanSiswa = ArrayList()
        jawabanBenar = ArrayList()
        initSoal(kelas,semester,pertemuan,kategori);
        initView(soalList);




    }

    private fun initSoal(kelas: Int, semester: Int, pertemuan: Int, kategori: String?) {
        soalRepository = SoalRepository(kelas,semester,pertemuan,kategori!!,application)
        soalList = soalRepository.getSoal(kelas,semester,pertemuan,kategori)

        getNextQuestion()
    }

    private fun initView( soalList: List<Soal>) {
    }

    private fun getNextQuestion(){
        if(nomorSekarang < soalList.size){
            Log.d("LatihanActivity","No sekarang sebelum diubah $nomorSekarang")
            nomorSekarang++;
            Log.d("LatihanActivity","No sekarang sesudah diubah $nomorSekarang")
            soalSekarang = soalList.get(nomorSekarang-1)
            Log.d("LatihanActivity",soalSekarang.toString())

            if(soalSekarang.teks == null){
                textTeks.visibility = View.GONE
            }else{
                textTeks.text = soalSekarang.teks
                textTeks.visibility = View.VISIBLE
            }
            if(soalSekarang.audio == null){
                buttonSuara.visibility = View.GONE
            }
            else{
                buttonSuara.visibility = View.VISIBLE
                buttonSuara.setOnClickListener { it ->
                    if(AudioPlay.isPlaying()){
                        Log.d("LatihanActivity","Audio sudah dimulai, mulai menutup audio")
                        buttonSuara.setImageResource(R.drawable.ic_volume_up_black_24dp)
                        AudioPlay.stopAudio()
                    }
                    else{
                        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

                        val assetFileDescriptor = assetManager.openFd(soalSekarang.audio)
                        AudioPlay.playAudio(this@LatihanActivity, assetFileDescriptor)
                        buttonSuara.setImageResource(R.drawable.ic_pause_black_24dp)
                    }
                    AudioPlay.mediaPlayer.setOnCompletionListener {
                        buttonSuara.setImageResource(R.drawable.ic_volume_up_black_24dp)
                        it.stop()
                        it.reset()

                    }
                }
            }
            textPertanyaan.text = "${nomorSekarang}. ${soalSekarang.pertanyaan}"
            jawabanA.text = "A. ${soalSekarang.jawabanA}"
            jawabanB.text = "B. ${soalSekarang.jawabanB}"
            jawabanC.text = "C. ${soalSekarang.jawabanC}"
            jawabanD.text = "D. ${soalSekarang.jawabanD}"

            jawabanA.setOnClickListener(this@LatihanActivity)
            jawabanB.setOnClickListener(this@LatihanActivity)
            jawabanC.setOnClickListener(this@LatihanActivity)
            jawabanD.setOnClickListener(this@LatihanActivity)

        }
        else{
            sendResult()
            Log.d("LatihanActivity",jawabanBenar.toString())
            Log.d("LatihanActivity",jawabanSiswa.toString())
            Log.d("LatihanActivity","Skor Total: $skor")

            finish()
        }
    }

    private fun sendResult() {
        val intent : Intent = Intent(this@LatihanActivity,HasilActivity::class.java)
        intent.putStringArrayListExtra("jawaban",jawabanSiswa)
        intent.putStringArrayListExtra("jawaban_benar",jawabanBenar)
        intent.putExtra("skor",skor)
        startActivity(intent)

    }

    override fun onClick(v: View?) {
        var answer :String = ""
        when(v!!.id){
            R.id.jawabanA -> answer = jawabanA.text.toString().split("\\.".toRegex())[0]
            R.id.jawabanB -> answer = jawabanB.text.toString().split("\\.".toRegex())[0]
            R.id.jawabanC -> answer = jawabanC.text.toString().split("\\.".toRegex())[0]
            R.id.jawabanD -> answer = jawabanD.text.toString().split("\\.".toRegex())[0]
        }

        jawabanSiswa.add(answer.toUpperCase())
        if(answer.toUpperCase().equals(soalSekarang.jawabanBenar.toUpperCase())){
            skor += 100/soalList.size
            Log.d("LatihanActivity","Skor sekarang adalah $skor")
        }
        jawabanBenar.add(soalSekarang.jawabanBenar.toUpperCase())

        Log.d("LatihanActivity","Jawaban siswa: $answer, Jawaban benar: ${soalSekarang.jawabanBenar}")
        getNextQuestion()
    }

    override fun onDestroy() {
        super.onDestroy()
        nomorSekarang = 0
        skor = 0
        AudioPlay.stopAudio()

    }
}