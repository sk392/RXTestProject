package latte.example.com.rxtestproject;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import latte.example.com.androidstudyproject.databinding.ItemProjectBinding;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>{
    private List<ProjectItem> mProjectItems;
    private OnItemClickListener mOnClickListener;
    private Context mContext;

    interface OnItemClickListener {
        void onClick(ProjectItem item);
    }

    public ProjectAdapter(Context context) {
        mContext = context;
        mProjectItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ProjectViewHolder projectViewHolder = new ProjectViewHolder(DataBindingUtil.inflate(inflater
                ,R.layout.item_project,parent,false));
        return projectViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bindItem(mProjectItems.get(position),mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mProjectItems.size();
    }

    public void setProjectItems(List<ProjectItem> projectItems) {
        if(mProjectItems != null){
            mProjectItems.clear();
        }
        mProjectItems.addAll(projectItems);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder{

        private ItemProjectBinding mProjectBinding;
        ProjectViewHolder(ItemProjectBinding projectBinding) {
            super(projectBinding.getRoot());
            mProjectBinding = projectBinding;
        }

        void bindItem(ProjectItem item,OnItemClickListener onItemClickListener){
            mProjectBinding.projectDate.setText(item.getProjectDate());
            mProjectBinding.projectName.setText(item.getProjectName());

            mProjectBinding.getRoot().setOnClickListener(v -> onItemClickListener.onClick(item));
            setBackground(mProjectBinding.projectLayout);
        }

        private void setBackground(View view){

            int[] colors = mContext.getResources().getIntArray(R.array.projectBackgroundColors);
            view.setBackgroundColor(colors[(new Random()).nextInt(colors.length)]);

        }
    }

}
