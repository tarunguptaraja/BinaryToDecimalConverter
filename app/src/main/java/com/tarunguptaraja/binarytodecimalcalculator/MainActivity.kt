package com.tarunguptaraja.binarytodecimalcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Long.valueOf as valueOf1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val error = findViewById<TextView>(R.id.error)
        val result = findViewById<TextView>(R.id.result)
        button.setOnClickListener {
            error.setText("")
            val text= editText.text.trim().toString()
            for(i in text.indices){
                if(text[i]=='2'||text[i]=='3'||text[i]=='4'||text[i]=='5'||text[i]=='6'||text[i]=='7'||text[i]=='8'||text[i]=='9'){
                    error.setText("(only 1's and 0's)")
                    return@setOnClickListener
                }
            }
            
            val value= text.toLongOrNull() ?: 0
            val res=convertBinaryToDecimal(value)
            result.setText(res.toString())

        }
    }
    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }
}





