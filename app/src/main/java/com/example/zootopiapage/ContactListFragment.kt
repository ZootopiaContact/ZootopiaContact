package com.example.zootopiapage

import DialogAddItemFragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.FragmentContactListBinding
class ContactListFragment : Fragment(),OnItemAddedListener {

    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        recyclerView = binding.contactRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ContactAdapter(ZootopiaData.get())

        binding.addListBtn.setOnClickListener {
            val dialogFragment = DialogAddItemFragment()
            dialogFragment.show(childFragmentManager, "ContactListFragment")
        }
        return binding.root

    }
    override fun onItemAdded(item: ZootopiaInfo) {
        addItem(item)
    }
    fun addItem(item: ZootopiaInfo) {
        val adapter = recyclerView.adapter as ContactAdapter
        adapter.addContact(item)
        adapter.notifyItemInserted(adapter.itemCount - 1)
        Log.d("ContactListFragment", "Item added: $item")
    }}
