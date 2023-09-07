package com.example.zootopiapage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.FragmentContactListBinding
import com.example.zootopiapage.databinding.GridContactListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactListFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!


    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    fun addItem(item: ZootopiaInfo) {
        val adapter = recyclerView.adapter as ContactAdapter
        adapter.zootopiaList.add(item)
        adapter.notifyItemInserted(adapter.zootopiaList.size - 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        recyclerView = binding.contactRecyclerview
        recyclerView.layoutManager = GridLayoutManager(context, 4)
        recyclerView.adapter = ContactAdapter(ZootopiaData.get())

        binding.addListBtn.setOnClickListener{
            val dialogFragment = DialogAddItemFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(android.R.id.content, dialogFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return binding.root

    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            ContactListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}