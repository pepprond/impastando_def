package com.android.example.impastando.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.impastando.R
import com.android.example.impastando.databinding.ImpastoCardBinding
import com.android.example.impastando.dataclass.Impasti

interface onItemClickView {
    fun onCardItemClick(position : Int)
}

class ImpastiAdapter(private val data: List<Impasti>, val listener : onItemClickView):
        RecyclerView.Adapter<ImpastiAdapter.ImpastiViewHolder>() {


        class ImpastiViewHolder(val binding: ImpastoCardBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Impasti, listener : onItemClickView, position : Int) {
                binding.nomeImpasti.text = itemView.context.getString(R.string.impasto, item.type)
                binding.imageImpasti.setImageResource(item.image.geticon())
                binding.cardview.setOnClickListener{
                    listener.onCardItemClick(position)
                    Log.d("ImpastiAdapter","Item click")
                }
            }



        }

        override fun onBindViewHolder(holder: ImpastiViewHolder, position: Int) {
            holder.bind(data[position], listener, position)

        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImpastiViewHolder {

            return ImpastiViewHolder(ImpastoCardBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
        }



    }




