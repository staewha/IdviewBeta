package com.example.idviewbeta

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceListAdapter(private var list: List<TestData>) :
    RecyclerView.Adapter<ServiceListAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!){
        var serviceName : TextView = itemView!!.findViewById(R.id.serviceName)
        var serviceInfo : TextView = itemView!!.findViewById(R.id.serviceInfo)
        var btnGoDetail : ImageButton = itemView!!.findViewById(R.id.goDetailPage)

        fun bind(data : TestData, position: Int){
            Log.v("ServiceListAdapter", "===========================bind===========================")
            serviceName.text = data.getServiceName()

            val privacy_list = data.getPrivacyList()
            var info_text = ""
            for (i: Int in 0..2)
                info_text += "${privacy_list?.get(i)}, "

            info_text += "등을 수집합니다."

            serviceInfo.text = info_text
            btnGoDetail.setOnClickListener {
                val context = itemView.context
                val doDetailIntent = Intent(context, ServiceDetailActivity::class.java)
                context.startActivity(doDetailIntent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_list, parent, false)
        return ServiceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

}