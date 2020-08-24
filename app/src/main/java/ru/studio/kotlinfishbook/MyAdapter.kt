package ru.studio.kotlinfishbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// создание адаптера и передача из него данных в MainActivity
class MyAdapter(ListArray:ArrayList<ListItem>, context: Context):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR = ListArray
    var contextR = context
    // заполнене item_layout
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val im = view.findViewById<ImageView>(R.id.im)

        fun bind(listItem: ListItem, context: Context){
        tvTitle.text = listItem.titleText
            var textcon = listItem.contentText.substring(0,50)+"..."
        tvContent.text = textcon
        im.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed: ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val i = Intent(context, contentActivity::class.java).apply{
                    putExtra("title",tvTitle.text.toString())
                    putExtra("content", listItem.contentText)
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(i)
            }
        }
    }
// надувание item_layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }
// передача количества элементов в массиве
    override fun getItemCount(): Int {
        return listArrayR.size
    }
// запуск функции bind
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR)
    }
// функция обновления списка
    fun updateAdapter(ListArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(ListArray)
        notifyDataSetChanged()
    }
}