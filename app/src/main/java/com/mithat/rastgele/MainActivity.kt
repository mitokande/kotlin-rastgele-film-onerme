package com.mithat.rastgele

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text : TextView = findViewById(R.id.metin)
        val btn : Button = findViewById(R.id.rastgele)
        val resim : ImageView = findViewById(R.id.resim)
        //val filmsayi : EditText = findViewById(R.id.index)
        val avatar : Movie = Movie(this.getDrawable(R.drawable.avatar)!!, "Avatar")
        val spiderman : Movie = Movie(this.getDrawable(R.drawable.spiderman)!!, "Spiderman")
        val avengers : Movie = Movie(this.getDrawable(R.drawable.avengers2012)!!, "Avengers 2012")
        val i_am_legend : Movie = Movie(this.getDrawable(R.drawable.i_am_legend)!!, "I am Legend")

        val filmlistesi : List<Movie> = listOf(avatar,spiderman,avengers,i_am_legend)

        text.text = "Rastgele Film için butona basın!"
        btn.setOnClickListener{
            //val indexsayisi = filmsayi.text.toString().toInt()

            val filmsonuc : Movie = rastgelefim(filmlistesi)
            resim.setImageDrawable(filmsonuc.resim)
            text.text = filmsonuc.isim
        }

    }

//    fun getfilm(liste : List<Movie>, index : Int) :Movie {
//        return liste.get(index)
//    }


    fun rastgelefim(liste : List<Movie>) : Movie{
        val sonuc : Int = (0..liste.size-1).random()
        return liste.get(sonuc)
    }

}

class Movie(resim : Drawable, isim : String){
    val resim = resim
    val isim = isim
}