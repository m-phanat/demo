package com.m.phanat.demo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.m.phanat.demo.databinding.ItemDbBinding
import com.m.phanat.demo.model.TestModel

class ListDataAdapter(val email: (String) -> Unit) :
    RecyclerView.Adapter<ListDataAdapter.ListViewHolder>() {

    private var items = listOf<TestModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ListViewHolder(ItemDbBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size


    inner class ListViewHolder(private val binding: ItemDbBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: TestModel) {
            binding.tvData.text = item.id.toString() + " " + item.email
            itemView.setOnClickListener {
                item.email?.let {
                    email(it)
                }
            }
        }

    }

    fun load(item: List<TestModel>) {
        items = item
        notifyDataSetChanged()
    }
}