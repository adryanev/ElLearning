package com.circlenode.el_learning.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.circlenode.el_learning.R
import com.circlenode.el_learning.activities.KelasActivity
import com.circlenode.el_learning.activities.MainActivity
import com.circlenode.el_learning.activities.PertemuanActivity
import com.circlenode.el_learning.databinding.FragmentKelasTujuhBinding


class KelasTujuhFragment : Fragment(){
    private var _binding : FragmentKelasTujuhBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentKelasTujuhBinding.inflate(inflater,container,false)

        val view: View? = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent: Intent = Intent(activity,PertemuanActivity::class.java)
        binding.tujuhSatu.setOnClickListener({

            intent.putExtra(KelasActivity.KELAS, KelasActivity.KELAS_TUJUH)
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_SATU)
            startActivity(intent)
        })
        binding.tujuhDua.setOnClickListener({
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_DUA)
            intent.putExtra(KelasActivity.KELAS, KelasActivity.KELAS_TUJUH)
            startActivity(intent)
        })
    }
}