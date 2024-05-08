package com.example.diceroller

import android.graphics.Color
import android.graphics.PorterDuff
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.let_roll)
        rollButton.setOnClickListener { roll() }


    }

    private fun roll() {
        val dadulagi1 = diceroll1()
        val dadulagi2 = diceroll2()

        if (dadulagi1 == dadulagi2) {
            showCustomToast("Selamat anda dapat dadu double!", Color.parseColor("#F0F0F0"), Color.BLACK)
        } else {
            showCustomToast("Anda belum beruntung!", Color.parseColor("#F0F0F0"), Color.BLACK)
        }
    }
    private fun showCustomToast(message: String, backgroundColor: Int, textColor: Int) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        val view = toast.view

        view?.background?.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN)

        val text = view?.findViewById<TextView>(android.R.id.message)
        text?.setTextColor(textColor)

        toast.show()
    }


    private fun diceroll1(): Int {
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        val diceImage1: ImageView = findViewById(R.id.dice_image1)

        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = diceRoll1.toString()
        return diceRoll1
    }

    private fun diceroll2(): Int {
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val diceImage2: ImageView = findViewById(R.id.dice_image2)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()
        return diceRoll2
    }

}


class Dice(private val numSides: Int) {


    fun roll(): Int {
        return (1..numSides).random()
    }
}

