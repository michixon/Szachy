package com.example.szachy

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var alphabet = arrayOf("a", "b", "c", "d", "e", "f", "g", "h")
    var piecesDictionary = getDefaultPieces();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createBoard();
    }

    private fun getDefaultPieces(): MutableMap<String, Piece> {
        var dict = mutableMapOf(
            "a8" to Piece(0, 0, "♜"),
            "b8" to Piece(0, 0, "♞"),
            "c8" to Piece(0, 0, "♝"),
            "d8" to Piece(0, 0, "♚"),
            "e8" to Piece(0, 0, "♛"),
            "f8" to Piece(0, 0, "♝"),
            "g8" to Piece(0, 0, "♞"),
            "h8" to Piece(0, 0, "♜"),
            "a1" to Piece(0, 0, "♖"),
            "b1" to Piece(0, 0, "♘"),
            "c1" to Piece(0, 0, "♗"),
            "d1" to Piece(0, 0, "♕"),
            "e1" to Piece(0, 0, "♔"),
            "f1" to Piece(0, 0, "♗"),
            "g1" to Piece(0, 0, "♘"),
            "h1" to Piece(0, 0, "♖")
        )
        for (col in 0..7) {
            dict.put(alphabet[col] + 7, Piece(0, 0, "♟"))
            dict.put(alphabet[col] + 2, Piece(0, 0, "♙"))
        }
        return dict
    }

    fun createBoard() {

        var boardGrid: GridLayout = findViewById(R.id.boardGrid)
        for (row in 8 downTo 1) {
            for (col in 0..7) {
                var key = alphabet[col] + row.toString();

                if (piecesDictionary.containsKey(key)) {
                    addSquare(boardGrid, row, col, piecesDictionary.get(key))
                } else {
                    addSquare(boardGrid, row, col, null)
                }
            }

        }
    }

    fun addSquare(boardGrid: GridLayout, row: Int, col: Int, type: Piece?) {
        var textView: TextView = TextView(this)
        textView.width = 110
        var color1 = ColorDrawable(Color.parseColor("#F0D985"))
        var color2 = ColorDrawable(Color.parseColor("#B58863"))
        textView.background = if ((col + row) % 2 == 0) color1 else color2;
        textView.textSize = 40f
        if (type?.type == null) {
            textView.text = ""
        } else {
            textView.text = type?.type.toString();
        }


        boardGrid.addView(textView)
    }
}