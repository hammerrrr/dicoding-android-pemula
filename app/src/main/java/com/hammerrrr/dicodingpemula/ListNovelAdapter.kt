package com.hammerrrr.dicodingpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListNovelAdapter(val listNovel: ArrayList<Novel>) : RecyclerView.Adapter<ListNovelAdapter.ListViewHolder>() {
    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView     = itemView.findViewById(R.id.tv_novel_title)
        var tvRates: TextView     = itemView.findViewById(R.id.tv_novel_rates)
        var tvAuthor: TextView    = itemView.findViewById(R.id.tv_novel_author)
        var imgPhoto: ImageView   = itemView.findViewById(R.id.img_novel)
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ListNovelAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_novel, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNovel.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, photo, author, rates, synopsis) = listNovel[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvTitle.text = title
        holder.tvRates.text = rates
        holder.tvAuthor.text= author

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetail = Intent(mContext, DetailActivity::class.java)

            moveDetail.putExtra("TITLE", title)
            moveDetail.putExtra("AUTHOR", author)
            moveDetail.putExtra("RATES", rates)
            moveDetail.putExtra("SYNOPSIS", synopsis)
            moveDetail.putExtra("PHOTO", photo)

            mContext.startActivity(moveDetail)
        }
    }

}