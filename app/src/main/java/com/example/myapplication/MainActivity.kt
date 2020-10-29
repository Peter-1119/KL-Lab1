package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //宣告查表  列為玩家情況, 行為電腦情況 以左上繳依序為剪刀、石頭、布
    var situation = arrayOf(
            intArrayOf(0, -1, 1),
            intArrayOf(1, 0, -1),
            intArrayOf(-1, 1, 0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //宣告變數 連結畫面中的物件
        var ed_name: EditText = findViewById(R.id.ed_name)
        var tv_text: TextView = findViewById(R.id.tv_text)
        var tv_name: TextView = findViewById(R.id.tv_name)
        var tv_winner: TextView = findViewById(R.id.tv_winner)
        var tv_mmora: TextView = findViewById(R.id.tv_mmora)
        var tv_cmora: TextView = findViewById(R.id.tv_cmora)
        var btn_scissor: RadioButton = findViewById(R.id.btn_scissor)
        var btn_stone: RadioButton = findViewById(R.id.btn_stone)
        var btn_paper: RadioButton = findViewById(R.id.btn_paper)
        var btn_mora: Button = findViewById(R.id.btn_mora)
        //設定按鈕按下事件
        btn_mora.setOnClickListener(View.OnClickListener {
            var me = 0
            val shape = arrayOf("剪刀", "石頭", "布")
            //輸入姓名
            if (ed_name.length() < 1) tv_text.text = "請輸入玩家姓名" else {
                tv_name.text = (String.format("名字\n%s", ed_name.text.toString()))
                //讀取radio button
                if (btn_scissor.isChecked) me = 0 else if (btn_stone.isChecked) me = 1 else me = 2
                tv_mmora.text = "我方出拳\n${shape[me]}"
                //亂數產生電腦出拳
                val computer = (Math.random() * 3).toInt()
                tv_cmora.text = "電腦出拳\n${shape[computer]}"
                //查表以數值分析局勢
                if (situation[me][computer] == 0){
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請再試一次"
                } else if(situation[me][computer] == -1){
                    tv_winner.text = "勝利者\n 電腦"
                    tv_text.text = "可惜，電腦獲勝了!"
                } else{
                    tv_winner.text = "勝利者\n${ed_name.text}"
                }

            }
        })
    }
}