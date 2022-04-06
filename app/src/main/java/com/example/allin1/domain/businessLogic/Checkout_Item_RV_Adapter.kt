package com.example.allin1.domain.businessLogic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.allin1.R
import com.example.allin1.data.Cart_items
import kotlinx.android.synthetic.main.checkout_items_recyclerview.view.*

class Checkout_Item_RV_Adapter(
    var cart_item :List<Cart_items>
) : RecyclerView.Adapter<Checkout_Item_RV_Adapter.Checkout_Item_ViewHolder>(){
    inner class Checkout_Item_ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Checkout_Item_ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.checkout_items_recyclerview, parent, false)
        return Checkout_Item_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Checkout_Item_ViewHolder, position: Int) {
        holder.itemView.apply {
            text_cart_itemPrice.text = "${cart_item[position].Price}"
            text_cart_itemName.text = "${cart_item[position].Name}"
            text_cart_itemWeight.text = "${cart_item[position].Weight}"
            Glide.with(context)
                .load(cart_item[position].Img_url)
                .into(img_cart_item)
        }
    }

    override fun getItemCount(): Int {
        return cart_item.size
    }


}