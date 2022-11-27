package com.adapter.teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.callback.CourseItemOnClickListener;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ItemInquireCourseBeanMessageBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private CourseItemOnClickListener courseItemOnClickListener;

    public void setCourseItemOnClickListener(CourseItemOnClickListener courseItemOnClickListener) {
        this.courseItemOnClickListener = courseItemOnClickListener;
    }

    private List<InquireCourseBean.Message> data;

    public List<InquireCourseBean.Message> getData() {
        return data;
    }

    public void setData(List<InquireCourseBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    public CourseAdapter(List<InquireCourseBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInquireCourseBeanMessageBinding binding = DataBindingUtil.inflate((LayoutInflater.from(parent.getContext())),
                R.layout.item_inquire_course_bean__message,
                parent,
                false);
        ViewHolder holder=new ViewHolder(binding);
        holder.binding.setClick(new ClickClass(holder));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InquireCourseBean.Message item= data.get(position);
        holder.binding.setSvm(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemInquireCourseBeanMessageBinding binding;

        public ViewHolder(@NonNull ItemInquireCourseBeanMessageBinding binding) {
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
