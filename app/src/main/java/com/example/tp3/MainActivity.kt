package com.example.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3.databinding.ActivityMainBinding

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        binding.rclNames.setHasFixedSize(true)

        val nameList = getListOfNames()



        val namesAdapter = NameAdapter(nameList)
        binding.rclNames.adapter = namesAdapter
// Setting our RecyclerView's layout manager equal to LinearLayoutManager
        binding.rclNames.layoutManager = LinearLayoutManager(this)
    //    rclNames.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)



      binding.btnUpdateList.setOnClickListener {
           nameList[nameList.size - 1] = "Hello! I've been updated right now :)"
          namesAdapter.notifyDataSetChanged()
      }
        namesAdapter.itemClickListener = { position, name ->
            Toast.makeText(this, "position: $position - name: $name", Toast.LENGTH_SHORT)
                .show()
        }
    }
    // This function just creates a list of names for us
    private fun getListOfNames(): MutableList<String> {
        val nameList = mutableListOf<String>()
        nameList.add("ahmed")
        nameList.add("yassine")
        nameList.add("sonia")
        nameList.add("mariem")
        nameList.add("taha")
        nameList.add("oussema")
        nameList.add("fatma")
        nameList.add("haythem")
        nameList.add("ayoub")
        nameList.add("aya")
        nameList.add("houda")
        return nameList

    }

}