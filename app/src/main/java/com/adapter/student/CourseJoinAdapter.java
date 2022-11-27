package com.adapter.student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.callback.CourseJoinItemOnClickListener;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ItemInquireCourseJoinBeanMessageBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseJoinAdapter extends RecyclerView.Adapter<CourseJoinAdapter.ViewHolder> {

    private CourseJoinItemOnClickListener courseItemOnClickListener;

    public void setCourseItemOnClickListener(CourseJoinItemOnClickListener courseItemOnClickListener) {
        this.courseItemOnClickListener = courseItemOnClickListener;
    }

    private List<InquireCourseJoinBean.Message> data;

    public List<InquireCourseJoinBean.Message> getData() {
        return data;
    }

    public void setData(List<InquireCourseJoinBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    public CourseJoinAdapter(List<InquireCourseJoinBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInquireCourseJoinBeanMessageBinding binding = DataBindingUtil.inflate((LayoutInflater.from(parent.getContext())),
                R.layout.item_inquire_course_join_bean__message,
                parent,
                false);
        ViewHolder holder=new ViewHolder(binding);
        holder.binding.setClick(new ClickClass(holder));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InquireCourseJoinBean.Message item= data.get(position);
        holder.binding.setSvm(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemInquireCourseJoinBeanMessageBinding binding;

        public ViewHolder(@NonNull ItemInquireCourseJoinBeanMessageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class ClickClass {
        private ViewHolder holder;

        public ClickClass(ViewHolder holder) {
            this.holder = holder;
        }

        public void itemOnClick(View view) {
            if (courseItemOnClickListener == null) return;
            int position = holder.getAdapterPosition();
            if (position == -1) return;
            courseItemOnClickListener.onClick(data.get(position));
        }
    }
}
