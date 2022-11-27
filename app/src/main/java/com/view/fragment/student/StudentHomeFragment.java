package com.view.fragment.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adapter.student.CourseJoinAdapter;
import com.base.BaseFragment;
import com.entity.EventBusMessage;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentHomeBinding;
import com.utils.ApplicationConfig;
import com.view.activity.student.StudentCourseActivity;
import com.view.dialog.student.JoinInCourseDialog;
import com.viewmodel.rvm.fragment.student.StudentHomeRVM;
import com.viewmodel.svm.fragment.student.StudentHomeSVM;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Objects;


public class StudentHomeFragment extends BaseFragment {

    FragmentHomeBinding binding;
    StudentHomeRVM rvm;
    StudentHomeSVM svm;


    private JoinInCourseDialog dialog;

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentHomeSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentHomeRVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setSvm(svm);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
        EventBus.getDefault().register(this);//注册监听
        return binding.getRoot();
    }

    @Override
    protected void getInternetData() {
        rvm.inquireCourse();
    }

    @Override
    protected void initView() {
        svm.userName.setValue(ApplicationConfig.userName);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.joinInState.observe(this, aBoolean -> {
            Toast toast;
            if (dialog.isShowing()) dialog.cancel();
            if (aBoolean) {
                toast = Toast.makeText(getActivity(), "\n加课成功\n", Toast.LENGTH_SHORT);
                rvm.inquireCourse();//刷新
            } else {
                toast = Toast.makeText(getActivity(), "\n加课失败\n", Toast.LENGTH_SHORT);
            }
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });
        rvm.inquireCourseState.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(getActivity(), "无课程", Toast.LENGTH_SHORT).show();
            }
        });
        rvm.courseList.observe(this, this::updateCourseList);
    }

    private void updateCourseList(List<InquireCourseJoinBean.Message> messages) {
        binding.courseRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseJoinAdapter adapter=new CourseJoinAdapter(messages);
        adapter.setCourseItemOnClickListener(bean -> {
            Intent intent=new Intent(getActivity(), StudentCourseActivity.class);
            intent.putExtra("course",bean);
            startActivity(intent);
        });
        binding.courseRecyclerview.setAdapter(adapter);

    }

    /**
     * 接收EventBus数据
     *
     * @param message 传递来的消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusMessage message){
        switch (message.msg){
            case ApplicationConfig.DELETE_COURSE:
                rvm.inquireCourse();
                break;
        }
    }

    public class ClickClass{
        public void joinInCourse(View view){
            dialog = new JoinInCourseDialog(Objects.requireNonNull(getActivity()), bean -> rvm.joinInCourse(bean));
            dialog.show();
        }
        public void refresh(View view){
            rvm.inquireCourse();//刷新
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}