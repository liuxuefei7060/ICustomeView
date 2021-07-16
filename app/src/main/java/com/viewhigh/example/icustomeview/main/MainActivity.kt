package com.viewhigh.example.icustomeview.main

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.viewhigh.example.icustomeview.BaseActivity
import com.viewhigh.example.icustomeview.CustomLayoutActivity
import com.viewhigh.example.icustomeview.RecyclerViewDemoActivity
import com.viewhigh.example.icustomeview.databinding.ActivityMainBinding
import com.viewhigh.example.icustomeview.hencoder.HenCoderCustomViewDrawActivity
import com.viewhigh.example.icustomeview.hencoder.draw1.HenCoderDraw1Activity
import com.viewhigh.example.icustomeview.hencoder.draw2.HenCoderDraw2Activity

class MainActivity : BaseActivity() {


    private lateinit var binding: ActivityMainBinding

    private val data = mutableListOf<ItemBean>()
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()

        binding.rvContent.adapter = RVAdapter(this, data) {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, it.clazz))

        }
        binding.rvContent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvContent.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }


    private fun initData() {
//        data.add("自定义 FlowLayout")
//        data.add("RecyclerView的使用")
        data.add(ItemBean("自定义FlowLayout", CustomLayoutActivity::class.java))
        data.add(ItemBean("RecyclerView的使用", RecyclerViewDemoActivity::class.java))
        data.add(ItemBean("HenCoder CustomView Draw", HenCoderCustomViewDrawActivity::class.java))
        data.add(ItemBean("HenCoder 官方练习 Draw1", HenCoderDraw1Activity::class.java))
        data.add(ItemBean("HenCoder 官方练习 Draw2", HenCoderDraw2Activity::class.java))
        data.add(ItemBean("HenCoder CustomViewLayout", RecyclerViewDemoActivity::class.java))
        data.add(ItemBean("HenCoder CustomViewFeedback", RecyclerViewDemoActivity::class.java))

    }
}