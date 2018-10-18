package com.circlenode.el_learning.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.circlenode.el_learning.R
import com.circlenode.el_learning.activities.KelasActivity
import com.circlenode.el_learning.activities.PertemuanActivity
import kotlinx.android.synthetic.main.fragment_kelas_sembilan.*

class KelasSembilanFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_kelas_sembilan,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent: Intent = Intent(activity, PertemuanActivity::class.java)


        sembilan_satu.setOnClickListener({
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_SATU)
            intent.putExtra(KelasActivity.KELAS, KelasActivity.KELAS_SEMBILAN)
            startActivity(intent)
        })
        sembilan_dua.setOnClickListener({
            intent.putExtra(KelasActivity.KELAS,KelasActivity.KELAS_SEMBILAN)
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_DUA)
            startActivity(intent)
        })
    }
}