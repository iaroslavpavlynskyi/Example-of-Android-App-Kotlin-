package com.iaroslav.routineapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class MenuAdapter(internal var mContext: Context, internal var items: List<Item>, private var onClick: OnClickCallback) :
    RecyclerView.Adapter<MenuAdapter.MenuView>() {
    internal var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuView {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)
        return MenuView(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MenuView, position: Int) {
        holder.imgIcon.setImageResource(items.get(position).icon)
        holder.imgIcon.setBackgroundColor(
            if (position == selectedPosition)
                Color.parseColor("#fff1f1f1")
            else
                Color.parseColor("#ffffff")
        )
    }


    inner class MenuView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imgIcon: ImageView
        lateinit var onClickCallback: OnClickCallback

        init {
            onClickCallback = onClick
            imgIcon = itemView.findViewById(R.id.img_icon)
            itemView.setOnClickListener {
                notifyItemChanged(selectedPosition)
                selectedPosition = adapterPosition
                onClickCallback.onClick(it,selectedPosition)
                notifyItemChanged(selectedPosition)
            }
        }
    }
}