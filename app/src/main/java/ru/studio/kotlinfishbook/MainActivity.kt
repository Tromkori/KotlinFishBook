package ru.studio.kotlinfishbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*
//
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter:MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()
        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImageId(R.array.fish_image_array)))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter

    }
//  функция слушатель нажатия NavigationView
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_fish -> {
                Toast.makeText(this, "id_fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }
            R.id.id_nazivki -> {
                Toast.makeText(this, "id_nazivki", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.nazivki),
                    resources.getStringArray(R.array.nazivki_content),
                    getImageId(R.array.nazivki_image_array)))
            }
            R.id.id_snasty -> {
                Toast.makeText(this, "id_snasty", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.snasty),
                    resources.getStringArray(R.array.snasty_content),
                    getImageId(R.array.snasty_image_array)))
            }
            R.id.id_history -> {
                Toast.makeText(this, "id_history", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.history),
                    resources.getStringArray(R.array.history_content),
                    getImageId(R.array.history_image_array)))
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
// функция заполнения массива
    fun fillArrays(titlearray:Array<String>, contentArray:Array<String>, imageArray: IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titlearray.size-1){
            var  listItem = ListItem(imageArray[n], titlearray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
// функция для расшифровки индефикаторов картинки
    fun getImageId(imageArrayId: Int): IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val idS = IntArray(count)
        for (i in idS.indices){
            idS[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return idS
    }
}