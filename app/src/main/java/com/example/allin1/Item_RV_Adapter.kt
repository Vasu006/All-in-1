package com.example.allin1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.items_recyclerview.view.*

class Item_RV_Adapter(
    var gloceries_item : List<Gloceries_data >
) : RecyclerView.Adapter<Item_RV_Adapter.Item_RV_ViewHolder>() {

    inner class Item_RV_ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item_RV_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_recyclerview, parent, false)
        return Item_RV_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Item_RV_ViewHolder, position: Int) {
        holder.itemView.apply {
            rv_item_name.text = gloceries_item[position].Name
            rv_item_price.text = "${gloceries_item[position].Price} Rs / ${gloceries_item[position].Weight}"
            Glide.with(context)
                .load(gloceries_item[position].Img_url)
                .into(rv_item_image)
        }
    }

    override fun getItemCount(): Int {
        return gloceries_item.size
    }
}