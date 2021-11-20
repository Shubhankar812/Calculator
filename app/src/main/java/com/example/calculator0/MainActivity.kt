@file:Suppress("UnusedImport")

package com.example.calculator0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.ArithmeticException
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var lastNumeric : Boolean = false
    var lastdot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OneDigit(view: View) {
        val tvinput = findViewById<TextView>(R.id.tvinput)


        // val tvinput = findViewById<TextView>(R.id.tvinput)
         tvinput.append((view as Button).text)
        lastNumeric = true

     //   Toast.makeText(this, "button works", Toast.LENGTH_SHORT).show()


    }
    fun onClear(view: View){
        val tvinput = findViewById<TextView>(R.id.tvinput)
        tvinput.text = " "

        val tvinput1 = findViewById<Button>(R.id.btndec)
        lastdot  = false
        lastNumeric = false
    }

    fun OnEqual(view: android.view.View) {
        if(lastNumeric){
            var tvValue = tvinput.text.toString()
            var prefix = ""

            try {
              //  if (tvValue.startsWith("-")) {
                    if (tvValue.contains("-")) {
                        val splitvalue = tvValue.split("-")
                        var one = splitvalue[0]
                        var two = splitvalue[1]

                        if(!prefix.isEmpty()){
                            one = prefix + one
                        }
                        tvinput.text = (one.toDouble() - two.toDouble()).toString()
                    }
               // }
                else if (tvValue.contains("+")) {
                    val splitvalue = tvValue.split("+")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(!prefix.isEmpty()){
                        one = prefix + one
                    }
                    tvinput.text = (one.toDouble() + two.toDouble()).toString()
                }

            else if (tvValue.contains("*")) {
                val splitvalue = tvValue.split("*")
                var one = splitvalue[0]
                var two = splitvalue[1]

                if(!prefix.isEmpty()){
                    one = prefix + one
                }
                tvinput.text = (one.toDouble() * two.toDouble()).toString()
            }
                if (tvValue.contains("/")) {
                    val splitvalue = tvValue.split("/")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(!prefix.isEmpty()){
                        one = prefix + one
                    }
                    tvinput.text = (one.toDouble() / two.toDouble()).toString()
                }

            }
            catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }
}