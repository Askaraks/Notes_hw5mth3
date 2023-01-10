package com.askarakss.notes_hw5mth3

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askarakss.notes_hw5mth3.databinding.FragmentNoteBinding

class NoteFragment : Fragment(),IItemClick {

    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddListener()

        adapter = NoteAdapter(this)

        binding.mainRecycler.adapter = adapter
        binding.sort.setOnClickListener {
            adapter.sort()
        }
    }

    private fun setAddListener() {
        binding.addNote.setOnClickListener{
            if (binding.editNote.text.isBlank()){
                binding.editNote.error= "Error"
            }else {
                val note =
                    NoteModel(binding.editNote.text.toString(), binding.editNoteDesc.text.toString())
                adapter.addNote(note)
                binding.editNote.text.clear()
                binding.editNoteDesc.text.clear()

            }

        }
    }

    override fun delete(pos: Int) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle(getString(R.string.warning))
        alert.setMessage(getString(R.string.message))
        alert.setPositiveButton("ok") { _, _ ->

        }
        alert.setNegativeButton(getText(R.string.cancel),null)
        alert.show()
        adapter.delete(pos)

    }

    override fun edit(pos: Int) {
        val editNote = adapter.getList()[pos]
        binding.editNote.setText(editNote.title)
        binding.editNoteDesc.setText(editNote.desc)
        binding.addNote.text = getString(R.string.edit)
        binding.addNote.setOnClickListener {
            if (binding.editNote.text.isBlank()){
                binding.editNote.error= "Error"
            }else{
                val newNote = NoteModel(binding.editNote.text.toString(),binding.editNoteDesc.text.toString())
                adapter.edit(pos,newNote)
            }

        }
    }
}