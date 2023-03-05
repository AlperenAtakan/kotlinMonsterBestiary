package com.example.bestiarykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bestiarykotlin.databinding.ActivityDetail1Binding

class DetailActivity1 : AppCompatActivity() {
    private lateinit var binding:ActivityDetail1Binding
    private lateinit var ContentList1:ArrayList<ContentDetail>
    private lateinit var sameContentList:ArrayList<ContentDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetail1Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val intent=intent
        val selectedContent=intent.getSerializableExtra("content") as ContentDetail
        sameContentList= ArrayList<ContentDetail>()
        ContentList1= ArrayList<ContentDetail>()
        ContentList1=intent.getSerializableExtra("detaillist") as ArrayList<ContentDetail>

        val selectedText=selectedContent.typename.toString()
        binding.textView.text=selectedText


        for (ContentDetail in ContentList1){
            print(ContentDetail.typename)
            if (ContentDetail.typename.equals(selectedContent.typename.toString())){
                sameContentList.add(ContentDetail)
            }
        }

        binding.recyclerViewdetail1.layoutManager= LinearLayoutManager(applicationContext)
        val contentDetailAdapter=contentDetailAdapter(sameContentList)
        binding.recyclerViewdetail1.adapter=contentDetailAdapter



    }
}