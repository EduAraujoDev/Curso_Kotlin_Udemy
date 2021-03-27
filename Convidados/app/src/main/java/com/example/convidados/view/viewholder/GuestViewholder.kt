package com.example.convidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel
import com.example.convidados.view.listener.GuestListener

class GuestViewholder(itemView: View, val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {
    fun bind(guestModel: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guestModel.name

        textName.setOnClickListener {
            listener.onClick(guestModel.id)
        }

        textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guestModel.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }
    }
}