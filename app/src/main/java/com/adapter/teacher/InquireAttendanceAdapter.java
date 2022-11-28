package com.adapter.teacher;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ItemInquireAttendanceBinding;

import java.util.ArrayList;
import java.util.List;

public class InquireAttendanceAdapter extends RecyclerView.Adapter<InquireAttendanceAdapter.ViewHolder> {
    private List<TeacherInquireAttendanceBean.Message> data;

    public InquireAttendanceAdapter(List<TeacherInquireAttendanceBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInquireAttendanceBinding binding= DataBindingUtil.inflate((LayoutInflater.from(parent.getContext())),
                R.layout.item_inquire_attendance,
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemInquireAttendanceBinding binding;
        public ViewHolder(@NonNull ItemInquireAttendanceBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
