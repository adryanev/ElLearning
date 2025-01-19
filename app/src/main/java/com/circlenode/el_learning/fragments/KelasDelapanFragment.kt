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
import com.circlenode.el_learning.databinding.FragmentKelasDelapanBinding

class KelasDelapanFragment : Fragment() {

    private var _binding: FragmentKelasDelapanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentKelasDelapanBinding.inflate(inflater, container, false)
        val view: View? = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent: Intent = Intent(activity, PertemuanActivity::class.java)

        binding.delapanSatu.setOnClickListener({
            intent.putExtra(KelasActivity.KELAS, KelasActivity.KELAS_DELAPAN)
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_SATU)
            startActivity(intent)

        })

        binding.delapanDua.setOnClickListener({
            intent.putExtra(KelasActivity.KELAS,KelasActivity.KELAS_DELAPAN)
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_DUA)
            startActivity(intent)
        })
    }
}