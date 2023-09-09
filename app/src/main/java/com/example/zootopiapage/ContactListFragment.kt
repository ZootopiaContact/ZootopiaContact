package com.example.zootopiapage

import DialogAddItemFragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.FragmentContactListBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactListFragment : Fragment(), OnItemAddedListener {

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        recyclerView = binding.contactRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = ContactAdapter(ZootopiaData.get()) { position ->
            val clickedItem = ZootopiaData.get()[position]
            // MainActivity의 아이템 클릭 이벤트 메서드 호출
            (requireActivity() as MainActivity).onRecyclerViewItemClick(position, clickedItem)
        }
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