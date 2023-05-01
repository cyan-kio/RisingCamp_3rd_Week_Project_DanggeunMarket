package com.cookandroid.danggeunmarket_clone_project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.opengl.GLES30
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.danggeunmarket_clone_project.databinding.HomeListItemBinding

class HomeAdapter(val manager: FragmentManager, val context: Context): RecyclerView.Adapter<HomeAdapter.ViewHolder>(), CustomDialogInterface {
    var data = mutableListOf<ResellData>()
    var dbHelper: DBHelper = DBHelper(context, "resellData.db", null, 1)
    var database: SQLiteDatabase = dbHelper.writableDatabase
    inner class ViewHolder(val binding: HomeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(resellData: ResellData){
             binding.homeListImage.setImageDrawable(resellData.image)
             binding.homeListTitle.text = resellData.title
             binding.homeListPlaceTime.text = resellData.placeTime
             binding.homeListCost.text = resellData.cost

             itemView.setOnClickListener {
                 Intent(context, ViewActivity::class.java).apply {
                     putExtra("title", resellData.title)
                     putExtra("placetime", resellData.placeTime)
                     putExtra("cost", resellData.cost)
                     putExtra("content", resellData.content)
                     addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                 }.run { context.startActivity(this) }
             }

             itemView.setOnLongClickListener {
                 val dialog = CustomDialog(this@HomeAdapter, resellData.id)
                 dialog.show(manager, "CustomDialog")
                 return@setOnLongClickListener true
             }
         }

        fun setDataLike(resellData: ResellData){
            binding.homeListLikeNum.text = resellData.likeNum.toString()
            binding.homeListLike.setImageDrawable(context.resources.getDrawable(R.drawable.home_list_like, context.theme))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resellData = data[position]
        holder.setData(resellData)
        if(resellData.likeNum != 0) {
            holder.setDataLike(resellData)
        }

    }

    override fun getItemCount(): Int = data.size
//
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        context = recyclerView.context
//    }

    override fun onUpdateBtnClick(id: Int) {
        Log.d("SQLTEST", "UPDATEFUNCTION")
        val intent = Intent(context, UpdateActivity::class.java)
        intent.putExtra("id", id)
        Log.d("SQLIDTEST", id.toString())
        context.startActivity(intent)
    }

    override fun onDeleteBtnClick(id: Int) {
        Log.d("SQLTEST", "DELETEFUNCTION")
        var query = "DELETE FROM resellData WHERE num =" + id
        database.execSQL(query)
    }
}