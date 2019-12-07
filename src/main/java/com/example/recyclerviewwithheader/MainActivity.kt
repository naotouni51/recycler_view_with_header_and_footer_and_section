package com.example.recyclerviewwithheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Member

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecycler.layoutManager = GridLayoutManager(this, 1)
        val members = prepareMemBerList()
        mainRecycler.adapter = CustomAdapter(members)
    }

    private fun prepareMemBerList(): List<MemberData> {
        val members = ArrayList<MemberData>()
        members.add((MemberData("", "", false)))

        for (i in 0..29) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(MemberData("伊達" + i, "尚登" + i, false))
            } else {
                members.add(MemberData("テスト" + i, "テスト" + i, true))
            }
        }

        members.add(MemberData("", "", false))
        return members
    }
}
