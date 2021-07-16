package com.viewhigh.example.icustomeview.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.viewhigh.example.icustomeview.R

class RVAdapter(
    private val context: Context,
    list: List<ItemBean>,
    val itemClick: (ItemBean) -> Unit
) :
    RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    private val data = mutableListOf<ItemBean>()

    init {
        data.clear()
        data.addAll(list)
    }

    /**
     * 设置新的集合
     */
    fun setData(list: List<ItemBean>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun addData(list: List<ItemBean>) {
        data.addAll(list)
    }


    fun addItemTop(itemBean: ItemBean) {
        data.add(0, itemBean)
        notifyItemChanged(0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_content, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val title = data[position].name
        holder.tvTitle.text = title
        holder.tvTitle.setOnClickListener {
            itemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)


    }
}