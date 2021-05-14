package com.example.flybasecalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.flybasecalculatorapp.databinding.ActivityCalculatorBinding


class CalculatorActivity : AppCompatActivity() {

    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_calculator)
        binding.handler = this

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.model = viewModel

        viewModel.rawCalculationString.observe(this, Observer {value ->
            value?.let { binding.editText.setText(it)}
        })

        viewModel.errorMessage.observe(this, Observer {error ->
            error?.let { Toast.makeText(this@CalculatorActivity, error, Toast.LENGTH_SHORT).show() }
        })
    }

    fun onButtonClick(view: View,value: String){
        viewModel.validateInput(value)
    }
}