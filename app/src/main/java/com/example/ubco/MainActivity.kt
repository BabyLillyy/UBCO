package com.example.ubco

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.ubco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnOkay.setOnClickListener {
                if (edtInput.editText?.text?.isNotEmpty() == true) {
                    tvResultTranslatedText.text = viewModel.translateFromEng(edtInput.editText?.text.toString())
                    hideSoftKeyboard(this@MainActivity)
                    edtInput.clearFocus()
                } else {
                    edtInput.error = "Please enter a sentence"
                }
            }

            edtInput.setEndIconOnClickListener {
                tvResultTranslatedText.text = ""
                edtInput.editText?.apply {
                    setText("")
                    clearFocus()
                }
            }

            edtInput.editText?.doOnTextChanged { _, _, _, _ ->
                edtInput.isErrorEnabled = false
            }
        }

    }

    private fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputMethodManager.isAcceptingText) {
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
        }
    }
}