package com.example.fragmentvazifa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentvazifa2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            val fragmentBlank = BlankFragment()
            val fragmentManager = supportFragmentManager
            val customFragment = MyCustomFragment()
            binding.btnAdd.setOnClickListener{
                fragmentManager.beginTransaction().add(R.id.my_container,fragmentBlank)
                    .addToBackStack(fragmentBlank.toString())
                    .commit()
            }
            binding.btnDelete.setOnClickListener {
                fragmentManager.beginTransaction().remove( fragmentBlank)
                    .commit()
            }
            binding.btnReplace.setOnClickListener {
                fragmentManager.beginTransaction().replace(R.id.my_container,customFragment)
                    .commit()
            }
            binding.btnHide.setOnClickListener {
                fragmentManager.beginTransaction().hide(fragmentBlank)
                    .commit()
            }
            binding.btnShow.setOnClickListener {
                fragmentManager.beginTransaction().show(fragmentBlank)
                    .commit()
            }
        }
    }
}