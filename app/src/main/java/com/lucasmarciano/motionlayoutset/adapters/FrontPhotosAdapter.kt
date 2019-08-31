package com.lucasmarciano.motionlayoutset.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucasmarciano.motionlayoutset.model.Cats
import com.lucasmarciano.motionlayoutset.R

class FrontPhotosAdapter: RecyclerView.Adapter<SceneThreeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneThreeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.motion_24_recyclerview_expanded_text_header -> SceneThreeViewHolder.TextHeaderViewHolder(
                itemView
            )
            R.layout.motion_24_recyclerview_expanded_text_description -> SceneThreeViewHolder.TextDescriptionViewHolder(
                itemView
            )
            R.layout.motion_24_recyclerview_expanded_row -> SceneThreeViewHolder.CatRowViewHolder(
                itemView
            )
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: SceneThreeViewHolder, position: Int) {
        when (holder) {
            is SceneThreeViewHolder.TextHeaderViewHolder -> {}
            is SceneThreeViewHolder.TextDescriptionViewHolder -> {}
            is SceneThreeViewHolder.CatRowViewHolder -> {
                val imagePosition = position - 2
                holder.textView.text = holder.textView.resources.getString(R.string.cat_n, imagePosition)
                Glide.with(holder.imageView)
                    .load(Cats.catImages[imagePosition])
                    .into(holder.imageView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> R.layout.motion_24_recyclerview_expanded_text_header
            1 -> R.layout.motion_24_recyclerview_expanded_text_description
            else -> R.layout.motion_24_recyclerview_expanded_row
        }
    }

    override fun getItemCount() = Cats.catImages.size + 2 // For text header and text description
}

sealed class SceneThreeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class TextHeaderViewHolder(itemView: View) : SceneThreeViewHolder(itemView)

    class TextDescriptionViewHolder(itemView: View) : SceneThreeViewHolder(itemView)

    class CatRowViewHolder(itemView: View) : SceneThreeViewHolder(itemView) {
        val imageView = itemView.findViewById(R.id.image_row) as ImageView
        val textView = itemView.findViewById(R.id.text_row) as TextView
    }
}