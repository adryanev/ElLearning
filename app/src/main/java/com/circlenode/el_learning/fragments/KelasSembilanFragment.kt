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
import com.circlenode.el_learning.databinding.FragmentKelasSembilanBinding

class KelasSembilanFragment : Fragment(){
    private var _binding: FragmentKelasSembilanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentKelasSembilanBinding.inflate(inflater, container, false)
        val view: View? = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent: Intent = Intent(activity, PertemuanActivity::class.java)


        binding.sembilanSatu.setOnClickListener({
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_SATU)
            intent.putExtra(KelasActivity.KELAS, KelasActivity.KELAS_SEMBILAN)
            startActivity(intent)
        })
        binding.sembilanDua.setOnClickListener({
            intent.putExtra(KelasActivity.KELAS,KelasActivity.KELAS_SEMBILAN)
            intent.putExtra(KelasActivity.SEMESTER, KelasActivity.SEMESTER_DUA)
            startActivity(intent)
        })
    }
}