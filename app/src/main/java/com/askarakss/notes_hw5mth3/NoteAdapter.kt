package com.askarakss.notes_hw5mth3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.askarakss.notes_hw5mth3.databinding.ItemNoteBinding

class NoteAdapter(val listener: IItemClick) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var list:MutableList<NoteModel> = ArrayList()

    fun addNote(note: NoteModel){
        list.add(note)
        notifyItemInserted(list.size )
    }

    fun delete(pos: Int){
        list.removeAt(pos)
        notifyItemRemoved(pos)

    }

    fun getlist(): MutableList<NoteModel>{
        return list
    }

   inner class ViewHolder(val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(note: NoteModel){
            binding.itemText.text = note.title
            binding.itemTextDesc.text = note.desc
            binding.itemText.setOnLongClickListener{
                listener.delete(adapterPosition)

                true
            }
            binding.root.setOnClickListener{
                listener.edit(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size

}
    fun edit(pos: Int, note: NoteModel){
        list[pos] = note
        notifyItemChanged(pos)
    }
}
