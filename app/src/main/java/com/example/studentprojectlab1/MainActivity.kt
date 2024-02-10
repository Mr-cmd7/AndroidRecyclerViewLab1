package com.example.studentprojectlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentprojectlab1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var students = ArrayList<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInitalData();
        val studentClickListener:StudentAdapter.OnStudentClickListener = object:StudentAdapter.OnStudentClickListener{
            override fun OnStudentClick(student: Student?, position: Int) {
                TODO("Not yet implemented")
            }
        }
        val recyclerView = binding.list
        setInitalData();

        val adapter = StudentAdapter(this,R.layout.list_item,students)

        recyclerView.adapter = adapter
    }
    private fun setInitalData() {
        students.add(Student("Иван","22-ИСП",R.drawable.ivan))
        students.add(Student("Иван","22-ИСП",R.drawable.ivan))
        students.add(Student("Иван","22-ИСП",R.drawable.ivan))
        students.add(Student("Иван","22-ИСП",R.drawable.ivan))
        students.add(Student("Иван","22-ИСП",R.drawable.ivan))
    }

}