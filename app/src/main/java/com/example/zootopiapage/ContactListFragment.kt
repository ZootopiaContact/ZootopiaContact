package com.example.zootopiapage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.DialogAddItemBinding
import com.example.zootopiapage.databinding.FragmentContactListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactListFragment : Fragment() {

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
        recyclerView.layoutManager = GridLayoutManager(context, 4)

        // 아이템 클릭시 실행 코드
        adapter = ContactAdapter(ZootopiaData.get()) { position ->
            val clickedItem = ZootopiaData.get()[position]
            // MainActivity의 아이템 클릭 이벤트 메서드 호출
            (requireActivity() as MainActivity).onRecyclerViewItemClick(position, clickedItem)
        }
        recyclerView.adapter = adapter

        return binding.root
    }

    fun addItemDialog() {
        val dialogBinding = DialogAddItemBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("연락처 추가")
            .setView(dialogBinding.root)
            .setPositiveButton("추가") { _, _ ->
                val name = dialogBinding.nameDialogEdit.text.toString()
                val call = dialogBinding.phoneDialogEdit.text.toString()
                val email = dialogBinding.emailDialogEdit.text.toString()

                val addItem = ZootopiaInfo( R.drawable.apple,name, call, email)

                // ContactAdapter 내에서 addItem 함수를 호출하여 아이템 추가
                adapter.addItem(addItem)
            }
            .setNegativeButton("취소", null)
            .create()

        dialog.show()
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
