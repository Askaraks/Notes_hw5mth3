package com.askarakss.notes_hw5mth3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import com.askarakss.notes_hw5mth3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IItemClick {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun delete(pos: Int) {

    }

    override fun edit(pos: Int) {

    }
}
