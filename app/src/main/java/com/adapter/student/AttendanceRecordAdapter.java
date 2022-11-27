package com.adapter.student;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ItemStudentAttendanceBinding;

import java.util.ArrayList;
import java.util.List;

public class AttendanceRecordAdapter extends RecyclerView.Adapter<AttendanceRecordAdapter.ViewHolder> {
    private List<InquireAttendanceBean.Message> data;

    public AttendanceRecordAdapter(List<InquireAttendanceBean.Message> data) {
        this.data = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudentAttendanceBinding binding= DataBindingUtil.inflate((LayoutInflater.from(parent.getContext())),
                R.layout.item_student_attendance,
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
        ItemStudentAttendanceBinding binding;
        public ViewHolder(@NonNull ItemStudentAttendanceBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
