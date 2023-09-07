package com.example.zootopiapage

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zootopiapage.databinding.FragmentDialogAddItemBinding
import com.google.android.material.textfield.TextInputLayout

class DialogAddItemFragment : Fragment() {

    private lateinit var binding: FragmentDialogAddItemBinding
    private lateinit var dialogName: TextInputLayout
    private lateinit var dialogCall: TextInputLayout
    private lateinit var dialogEmail: TextInputLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogAddItemBinding.inflate(inflater, container, false)
        dialogName = binding.nameDialogLayout
        dialogCall = binding.callDialogLayout
        dialogEmail = binding.emailDialogLayout

        binding.saveDialogBtn.setOnClickListener {
            val name = binding.nameDialogEdit.text.toString()
            val call = binding.callDialogEdit.text.toString()
            val email = binding.emailDialogEdit.text.toString()

            if (name.isNotEmpty() && call.isNotEmpty() && email.isNotEmpty()) {
                val item = ZootopiaInfo(R.drawable.apple, name, call, email)

                val contactListFragment =
                    parentFragmentManager.findFragmentByTag("contactListFragment")
                if (contactListFragment is ContactListFragment) {
                    contactListFragment.addItem(item)
                }
                parentFragmentManager.popBackStack()
            }
        }
        binding.cancelDialogBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.nameDialogEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val name = s.toString()
                if (!NameCondition(name)) {
                    dialogName.error = "유효한 이름을 입력하세요"
                } else {
                    dialogName.error = null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.callDialogEdit.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.callDialogEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val call = s.toString()
                if (!callCondition(call)) {
                    dialogCall.error = "유효한 전화번호를 입력하세요"
                } else {
                    dialogCall.error = null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.emailDialogEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = s.toString()
                if (!emailCondition(email)) {
                    dialogEmail.error = "유효한 이메일을 입력하세요"
                } else {
                    dialogEmail.error = null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        return binding.root
    }


    private fun NameCondition(name: String): Boolean {

        return name.length >= 1
    }

    private fun callCondition(call: String): Boolean {

        return call.length >= 13
    }
    private fun emailCondition(email: String): Boolean {

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

}}