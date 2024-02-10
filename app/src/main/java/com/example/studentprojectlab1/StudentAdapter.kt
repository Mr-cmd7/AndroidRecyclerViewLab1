package com.example.studentprojectlab1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentprojectlab1.databinding.ListItemBinding

class StudentAdapter(context: Context,val layout:Int,val students:MutableList<Student>):
    RecyclerView.Adapter<StudentAdapter.ViewHolder>()
{
        internal interface OnStudentClickListener{
            fun OnStudentClick(
                student: Student?,
                position: Int
            )
        }
    private val onClickListener:OnStudentClickListener? = null
    private var inflater: LayoutInflater? = null
    init{
        this.inflater = LayoutInflater.from(context)
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val photoView:ImageView
        val surnameView: TextView
        val groupView: TextView
        init {
            val binding = view.let{ListItemBinding.bind(it)}
            photoView=binding.photo
            surnameView = binding.surname
            groupView = binding.group
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? = inflater?.inflate(layout, parent, false)
        return ViewHolder(view!!)
    }
    override fun getItemCount(): Int {
        return students.size;
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.photoView.setImageResource(student.photo)
        holder.surnameView.text=student.surname
        holder.groupView.text=student.group
        onClickListener?.OnStudentClick(student,position)
    }
}