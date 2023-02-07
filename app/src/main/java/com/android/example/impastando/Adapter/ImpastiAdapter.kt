package com.android.example.impastando.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.impastando.R
import com.android.example.impastando.databinding.ImpastoCardBinding
import com.android.example.impastando.dataclass.Impasti


class ImpastiAdapter(private val data: List<Impasti>):
        RecyclerView.Adapter<ImpastiAdapter.ImpastiViewHolder>() {


        class ImpastiViewHolder(val binding: ImpastoCardBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Impasti) {
                binding.nomeImpasti.text = itemView.context.getString(R.string.impasto, item.type)
                binding.imageImpasti.setImageResource(item.image.geticon())

            }



        }

        override fun onBindViewHolder(holder: ImpastiViewHolder, position: Int) {
            holder.bind(data[position])

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




