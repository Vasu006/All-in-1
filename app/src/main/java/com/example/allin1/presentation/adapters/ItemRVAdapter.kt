package com.example.allin1.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.allin1.R
import com.example.allin1.data.Cartitems
import kotlinx.android.synthetic.main.items_recyclerview.view.*

class ItemRVAdapter(

) : RecyclerView.Adapter<ItemRVAdapter.Item_RV_ViewHolder>() {
    private var setListener: Listener? = null
    private var groceries_item = emptyList<Cartitems>()

    inner class Item_RV_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item_RV_ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_recyclerview, parent, false)
        return Item_RV_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Item_RV_ViewHolder, position: Int) {

        holder.itemView.apply {

            rv_item_name.text = groceries_item[position].Name
            rv_item_price.text =
                "${groceries_item[position].Price} Rs / ${groceries_item[position].Weight}"

            setListener?.checkCartItem(groceries_item[position], this)

            btn_addToCart.setOnClickListener {
                if (setListener != null) {
                    setListener!!.onClickItem(groceries_item[position], this)
                }
            }

            Glide.with(context)
                .load(groceries_item[position].Img_url)
                .into(rv_item_image)
        }
    }

    override fun getItemCount(): Int {
        return groceries_item.size
    }

    interface Listener {
        fun onClickItem(item: Cartitems, view: View)
        fun checkCartItem(item: Cartitems, view: View)
    }

    fun setInterface(setListener: Listener) {
        this.setListener = setListener
    }

    fun setItems(list: List<Cartitems>) {
        this.groceries_item = list
        notifyDataSetChanged()
    }
}