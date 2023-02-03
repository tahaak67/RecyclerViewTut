package com.example.recyclerviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.recyclerviewapplication.databinding.ActivityMainBinding
import com.example.recyclerviewapplication.databinding.DialogEtBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val namesList = mutableListOf(
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
        Person("Ali", R.drawable.baseline_child_care_24),
        Person("Ayoub", R.drawable.baseline_catching_pokemon_24),
        Person("Mohab", R.drawable.baseline_catching_pokemon_24),
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
        Person("Hatem", R.drawable.baseline_child_care_24),
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
        Person("Ali", R.drawable.baseline_cruelty_free_24),
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
        Person("Derar", R.drawable.baseline_delete_24),
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
        Person("Mo", R.drawable.ic_launcher_background),
        Person("Ali", R.drawable.baseline_cruelty_free_24),
        Person("Hatem", R.drawable.baseline_cruelty_free_24),
        Person("Ali", R.drawable.baseline_cruelty_free_24),
        Person("Ali", R.drawable.baseline_cruelty_free_24),
        Person("Mo", R.drawable.ic_launcher_background),
        Person("Mo", R.drawable.ic_launcher_background),
        Person("Mo", R.drawable.ic_launcher_background),
        Person("Ali", R.drawable.baseline_cruelty_free_24),
        Person("Ali", R.drawable.baseline_catching_pokemon_24),
    )

    //create the adapter
    private val adapter = PersonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //assign the adapter to the recyclerView
        binding.rvPeople.adapter = adapter
        //submit the list
        adapter.submitList(namesList)
        binding.apply {
            btnAddRmv.setOnClickListener {
                showDialog()
            }

        }
    }

    private fun showDialog() {
        val dialogEtBinding = DialogEtBinding.inflate(layoutInflater)
        AlertDialog.Builder(this).setView(dialogEtBinding.root).setPositiveButton("+") { _, _ ->
            try {
                dialogEtBinding.apply {
                    addToIndex(etIndex.text.toString().toInt())
                    etIndex.setText("")
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }

        }.setNegativeButton(" - ") { _, _ ->
            try {
                dialogEtBinding.apply {
                    removeItemFromIndex(etIndex.text.toString().toInt())
                    etIndex.setText("")
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }

        }.show()
    }

    private fun removeItemFromIndex(index: Int) {
        namesList.removeAt(index - 1)
        adapter.notifyItemRemoved(index - 1)
    }

    private fun addToIndex(index: Int) {
        val strings =
            listOf("Derar", "SomeName", "Ali", "Ayoub", "Majid", "Yousra", "Islam", "Mohab")
        val drawableResList = listOf(
            R.drawable.baseline_catching_pokemon_24,
            R.drawable.baseline_delete_24,
            R.drawable.baseline_cruelty_free_24,
            R.drawable.baseline_child_care_24,
            R.drawable.baseline_directions_run_24,
            R.drawable.ic_launcher_foreground
        )
        //add/delete from list
        namesList.add(index - 1, Person(strings.random(), drawableResList.random()))
        //notify the adapter
        adapter.notifyItemInserted(index - 1)
    }
}