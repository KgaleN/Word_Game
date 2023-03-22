package com.example.wordgame
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class WordAdapter (var data: List<String>):RecyclerView.Adapter<WordAdapter.ViewHolder>(){
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
{
    val Word: TextView = itemView.findViewById(R.id.WordFromList)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val ItemsViewModel = data[position]
        holder.Word.text = ItemsViewModel.toString()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return data.size
    }
}