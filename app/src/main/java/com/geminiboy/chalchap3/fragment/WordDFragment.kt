package com.geminiboy.chalchap3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.chalchap3.Data
import com.geminiboy.chalchap3.adapter.DAdapter
import com.geminiboy.chalchap3.databinding.FragmentWordDBinding

class WordDFragment : Fragment() {

    private var _binding: FragmentWordDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordDBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filter: List<String> =
            Data.listData.filter { it.startsWith(arguments?.getString("EXTRA_WORD")!!, true) }
        binding.apply {
            rvDetail.adapter = DAdapter(filter)
            rvDetail.layoutManager = LinearLayoutManager(requireContext())
            rvDetail.setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

