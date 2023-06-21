package com.example.idviewbeta

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceListAdapter(private var list: List<TestData>) :
    RecyclerView.Adapter<ServiceListAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!){
        var serviceName : TextView = itemView!!.findViewById(R.id.serviceName)
        var serviceInfo : TextView = itemView!!.findViewById(R.id.serviceInfo)

        fun bind(data : TestData, position: Int){
            Log.v("ServiceListAdapter", "===========================bind===========================")
            serviceName.text = data.getServiceName()

            val privacy_list = data.getPrivacyList()
            var info_text = ""
            for (p in privacy_list!!)
                info_text += "${p}, "

            info_text += "등을 수집합니다."

            serviceInfo.text = info_text
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