package com.askarakss.notes_hw5mth3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.askarakss.notes_hw5mth3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IItemClick {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = NoteAdapter(this  )

        binding.mainRecycler.adapter = adapter

        binding.addNote.setOnClickListener{
           if (binding.editNote.text.isBlank()){

           }else{
               val note = NoteModel(binding.editNote.text.toString(),
                   binding.editNoteDesc.text.toString())
               adapter.addNote(note)
               binding.editNote.text.clear()

           }
        }



    }

    override fun delete(pos: Int) {
        adapter.delete(pos)
    }

    override fun edit(pos: Int) {
       val clickNote = adapter.getlist()[pos]
        binding.editNote.setText(clickNote.title)
        binding.editNoteDesc.setText(clickNote.desc)
        binding.addNote.setOnClickListener{
            val newNote = NoteModel(binding.editNote.text.toString(),
                binding.editNoteDesc.text.toString())
            binding.addNote.text = "edit"
            adapter.edit(pos, newNote)
            binding.editNote.text.clear()
            binding.editNoteDesc.text.clear()




        }
        val list = listOf<String>("Hello", "buy", "trade", "Sleep")

    }
}