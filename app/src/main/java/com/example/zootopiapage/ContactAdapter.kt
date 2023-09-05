package com.example.zootopiapage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.ContactListBinding

class ContactAdapter(val items: MutableList<ZootopiaInfo>) : RecyclerView.Adapter<ContactAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder {
        return Holder(
            ContactListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.profile.setImageResource(items[position].profile)
        holder.name.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root) {
        val profile = binding.contactImage
        val name = binding.contactNameText
    }
}