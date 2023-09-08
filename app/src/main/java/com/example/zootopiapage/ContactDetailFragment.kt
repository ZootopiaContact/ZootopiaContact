package com.example.zootopiapage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.zootopiapage.databinding.FragmentContactDetailBinding
import android.net.Uri
import androidx.core.content.ContextCompat

class ContactDetailFragment : Fragment() {

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        val contactData = arguments?.getParcelable<ZootopiaInfo>("contactData")
        if (contactData != null) {
            binding.detailName.text = contactData.name
            binding.detailNumber.text = contactData.call
            binding.detailEmail.text = contactData.email
            binding.detailImg.setImageResource(contactData.profileImageResourceId)

            Log.d("ContactDetailFragment", "Received Contact Data: $contactData")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val messagebt = view.findViewById<Button>(R.id.detail_message)
        val callbt = view.findViewById<Button>(R.id.detail_call)

        messagebt.setOnClickListener{
            val contactData = arguments?.getParcelable<ZootopiaInfo>("contactData")
            val phoneNumber = contactData?.call
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:$phoneNumber")

            ContextCompat.startActivity(requireContext(), intent, null)
        }
        callbt.setOnClickListener {
            val phoneNumber = binding.detailNumber.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data =Uri.parse("tel:$phoneNumber")

            startActivity(callIntent)
        }
    }

    companion object {
        fun newInstance(contactData: ZootopiaInfo) = ContactDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("contactData", contactData)
            }
        }
    }
}
