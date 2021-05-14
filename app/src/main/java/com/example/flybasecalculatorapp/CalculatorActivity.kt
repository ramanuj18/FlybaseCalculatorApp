package com.example.flybasecalculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flybasecalculatorapp.databinding.ActivityCalculatorBinding


class CalculatorActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_calculator)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
    }
}