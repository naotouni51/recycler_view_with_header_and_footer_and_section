package com.example.recyclerviewwithheader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Member

class CustomAdapter(val members: List<MemberData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NOT_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3

    override fun getItemCount() : Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position)) return TYPE_ITEM_HEADER
        if (isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members[position]
        return if (member.available) TYPE_ITEM_YES_VIEW else TYPE_ITEM_NOT_VIEW
    }

    fun isHeader(position: Int) : Boolean {
        return position == 0
    }

    fun isFooter(position: Int) : Boolean {
        return position == members.size - 1
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM_HEADER) {
            val header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header, viewGroup, false)
            return CustomViewHeaderHolder(header)
        } else if (viewType == TYPE_ITEM_YES_VIEW) {
            val view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yes, viewGroup, false)
            return CustomViewYesHolder(view)
        } else if (viewType == TYPE_ITEM_NOT_VIEW) {
            val view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.not, viewGroup, false)
            return CustomViewNotHolder(view)
        }

        val footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footer, viewGroup, false)
        return CustomViewFooterHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if (holder is CustomViewYesHolder) {
            holder.first_name.setText(member.firstName)
            holder.last_name.setText(member.lastName)
        }

        if (holder is CustomViewNotHolder) {
            holder.first_name.setText(member.firstName)
            holder.last_name.setText(member.lastName)
        }
    }

    class CustomViewHeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    class CustomViewYesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewNotHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewFooterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}