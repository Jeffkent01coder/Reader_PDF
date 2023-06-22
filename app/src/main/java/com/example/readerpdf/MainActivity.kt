package com.example.readerpdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.readerpdf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            launcher.launch("application/pdf")
        }
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
        uri ->
        uri?.let {
            binding.pdfView.fromUri(it).load()
        }
    }
}