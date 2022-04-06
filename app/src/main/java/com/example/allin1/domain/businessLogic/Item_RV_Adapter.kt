package com.example.allin1.domain.businessLogic

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.allin1.R
import com.example.allin1.UI.activities.mainviewmodel
import com.example.allin1.data.Cart_items
import kotlinx.android.synthetic.main.items_recyclerview.view.*

class Item_RV_Adapter(
    var groceries_item: List<Cart_items>
) : RecyclerView.Adapter<Item_RV_Adapter.Item_RV_ViewHolder>() {

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

            if (mainviewmodel.cart_ItemExist(groceries_item[position].Name))
                btn_addToCart.setText("Remove Item")
            else

                btn_addToCart.setText("Add to cart")

            btn_addToCart.setOnClickListener {

                Log.d("ItemExist", "${mainviewmodel.cart_ItemExist(groceries_item[position].Name)}")

                if (mainviewmodel.cart_ItemExist(groceries_item[position].Name)) {
                    btn_addToCart.setText("Add to cart")
                    mainviewmodel.remove_CartItem(groceries_item[position])
                } else {
                    btn_addToCart.setText("Remove Item")
                    mainviewmodel.insert_CartItem(groceries_item[position])
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

}