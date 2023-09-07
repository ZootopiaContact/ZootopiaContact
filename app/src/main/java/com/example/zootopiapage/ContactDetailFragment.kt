package com.example.zootopiapage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zootopiapage.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Fragment의 뷰 바인딩을 초기화합니다.
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        // 연락처 데이터를 가져와서 표시합니다.
        val contactData = arguments?.getParcelable<ZootopiaInfo>("contactData")

        if (contactData != null) {
            // 연락처 데이터를 사용하여 UI를 업데이트합니다.
            binding.detailName.text = contactData.name
            binding.detailNumber.text = contactData.call
            binding.detailEmail.text = contactData.email
            // 프로필 이미지 설정 (리소스 ID를 사용하여 이미지 설정)
            binding.detailImg.setImageResource(contactData.profileImageResourceId)

            Log.d("ContactDetailFragment", "Received Contact Data: $contactData")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 뷰 바인딩을 해제합니다.
        _binding = null
    }

    companion object {
        fun newInstance(contactData: ZootopiaInfo) = ContactDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("contactData", contactData)
            }
        }
    }
}
