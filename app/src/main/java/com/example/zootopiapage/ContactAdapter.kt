package com.example.zootopiapage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zootopiapage.databinding.ContactListBinding
import com.example.zootopiapage.databinding.GridContactListBinding

class ContactAdapter( val zootopiaList : MutableList<ZootopiaInfo>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_LIST = 1
        const val VIEW_TYPE_GRID = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_TYPE_LIST) {
            val binding = ContactListBinding.inflate(inflater, parent, false)
            ViewHolder(binding.root)
        } else {
            val binding = GridContactListBinding.inflate(inflater, parent, false)
            ViewHolder(binding.root)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = zootopiaList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return zootopiaList.size
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_GRID
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ZootopiaInfo) {
            contactImage.setImageResource(item.profile)
            name.text = item.name
        }
        val contactImage = itemView.findViewById<ImageView>(R.id.contact_image)
        val name = itemView.findViewById<TextView>(R.id.contact_name_text)
    }
}
