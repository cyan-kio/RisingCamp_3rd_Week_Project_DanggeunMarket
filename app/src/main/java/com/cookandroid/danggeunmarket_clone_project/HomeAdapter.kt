package com.cookandroid.danggeunmarket_clone_project

import android.content.Context
import android.content.Intent
import android.opengl.GLES30
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.danggeunmarket_clone_project.databinding.HomeListItemBinding

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var data = mutableListOf<ResellData>()
    lateinit var context: Context
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

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}