import android.app.Dialog
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.DialogFragment
import com.example.zootopiapage.OnItemAddedListener
import com.example.zootopiapage.R
import com.example.zootopiapage.ZootopiaInfo
import com.example.zootopiapage.databinding.FragmentDialogAddItemBinding

class DialogAddItemFragment : DialogFragment() {

    private lateinit var binding: FragmentDialogAddItemBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val inflater = requireActivity().layoutInflater

        binding = FragmentDialogAddItemBinding.inflate(inflater)
        dialog.setContentView(binding.root)

        binding.saveDialogBtn.setOnClickListener {
            onSaveClicked()
        }
        binding.cancelDialogBtn.setOnClickListener {
            dismiss()
        }

        val dialogName = binding.nameDialogLayout
        val dialogCall = binding.callDialogLayout
        val dialogEmail = binding.emailDialogLayout
        val width = resources.getDimensionPixelSize(R.dimen.dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.dialog_height)
        dialog.window?.setLayout(width, height)

        binding.nameDialogEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val nameValid = s.toString()
                if (!NameCondition(nameValid)) {
                    dialogName.error = "이름을 입력하세요 ex) 동숲"
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
                val callValid = s.toString()
                if (!callCondition(callValid)) {
                    dialogCall.error = "전화번호를 입력하세요 ex) 010-1234-7890"
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
                val emailValid = s.toString()
                if (!emailCondition(emailValid)) {
                    dialogEmail.error = "이메일을 입력하세요 ex) hi@zootopia.com"
                } else {
                    dialogEmail.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        return dialog
    }

    private fun onSaveClicked() {
        val name = binding.nameDialogEdit.text.toString()
        val call = binding.callDialogEdit.text.toString()
        val email = binding.emailDialogEdit.text.toString()

        if (name.isNotEmpty() && call.isNotEmpty() && email.isNotEmpty()) {
            val item = ZootopiaInfo(R.drawable.apple, name, call, email)
            val parentFragment = parentFragment
            if (parentFragment is OnItemAddedListener) {
                parentFragment.onItemAdded(item)
            }
            dismiss()
        }
    }
}

private fun NameCondition(name: String): Boolean {
    return name.length >= 2
}

private fun callCondition(call: String): Boolean {
    return call.length >= 13
}

private fun emailCondition(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
