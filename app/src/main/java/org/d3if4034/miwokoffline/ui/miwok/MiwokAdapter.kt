package org.d3if4034.miwokoffline.ui.miwok

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.d3if4034.miwokoffline.R
import org.d3if4034.miwokoffline.model.Miwok
import org.d3if4034.miwokoffline.databinding.RecyclerviewMiwokBinding
import org.d3if4034.miwokoffline.utils.RecyclerViewClickListener

@Suppress("SpellCheckingInspection")
class MiwokAdapter(
    private val miwok: List<Miwok>
) : RecyclerView.Adapter<MiwokAdapter.MiwokViewHolder>() {

    var listener: RecyclerViewClickListener? = null

    inner class MiwokViewHolder(
        val recyclerviewMiwokBinding: RecyclerviewMiwokBinding
    ) : RecyclerView.ViewHolder(recyclerviewMiwokBinding.root)

    override fun getItemCount() = miwok.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MiwokViewHolder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_miwok, parent, false)
    )

    override fun onBindViewHolder(holder: MiwokViewHolder, position: Int) {
        holder.recyclerviewMiwokBinding.tvCategory.text = miwok[position].category
        holder.recyclerviewMiwokBinding.listMiwok.setBackgroundColor(Color.parseColor(miwok[position].background))
        holder.recyclerviewMiwokBinding.listMiwok.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, miwok[position])
        }
    }
}