package com.softaai.githubprtest.issues.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.softaai.githubprtest.issues.viewmodels.IssueViewModel
import com.softaai.githubprtest.R
import com.softaai.githubprtest.databinding.IssuesListViewItemBinding
import com.softaai.githubprtest.model.IssuesResponse


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

class IssueListAdapter: RecyclerView.Adapter<IssueListAdapter.ViewHolder>() {
    private lateinit var issuesResponseList:List<IssuesResponse>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueListAdapter.ViewHolder {
        val binding: IssuesListViewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.issues_list_view_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssueListAdapter.ViewHolder, position: Int) {
        holder.bind(issuesResponseList[position])

    }

    override fun getItemCount(): Int {
        return if(::issuesResponseList.isInitialized) issuesResponseList.size else 0
        //return issuesResponseList.size
    }

    fun updateIssuesResponseList(issuesResponseList:List<IssuesResponse>){
        this.issuesResponseList = issuesResponseList
    }

    class ViewHolder(private val binding: com.softaai.githubprtest.databinding.IssuesListViewItemBinding):RecyclerView.ViewHolder(binding.root){

        private var viewModel = IssueViewModel()

        fun bind(issue:IssuesResponse){
            viewModel.bind(issue)
            binding.issueViewModel = viewModel
        }



        }
}