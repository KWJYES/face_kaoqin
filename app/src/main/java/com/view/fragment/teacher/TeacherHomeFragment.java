package com.view.fragment.teacher;

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

import com.adapter.teacher.CourseAdapter;
import com.base.BaseFragment;
import com.entity.EventBusMessage;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentHome2Binding;
import com.utils.ApplicationConfig;
import com.view.activity.teacher.TeacherCourseActivity;
import com.view.dialog.teacher.CreateCourseDialog;
import com.viewmodel.rvm.fragment.teacher.TeacherHomeRVM;
import com.viewmodel.svm.fragment.teacher.TeacherHomeSVM;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Objects;


public class TeacherHomeFragment extends BaseFragment {


    FragmentHome2Binding binding;
    TeacherHomeRVM rvm;
    TeacherHomeSVM svm;
    private CreateCourseDialog dialog;

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherHomeSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherHomeRVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home2, container, false);
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
    protected void observerDataStateUpdateAction() {
        rvm.createState.observe(this, aBoolean -> {
            Toast toast;
            if (dialog.isShowing()) dialog.cancel();
            if (aBoolean) {
                toast = Toast.makeText(getActivity(), "\n课程已创建\n", Toast.LENGTH_SHORT);
                rvm.inquireCourse();//刷新
            } else {
                toast = Toast.makeText(getActivity(), "\n课程创建失败\n", Toast.LENGTH_SHORT);
            }
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });
        rvm.checkCourseExistState.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(getActivity(), "网络错误！", Toast.LENGTH_SHORT).show();
            }
        });
        rvm.checkCourseExistMsg.observe(this, s -> Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show());
        rvm.inquireCourseState.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(getActivity(), "无课程", Toast.LENGTH_SHORT).show();
            }
        });
        rvm.courseList.observe(this, this::updateCourseList);
    }

    private void updateCourseList(List<InquireCourseBean.Message> courseList) {
        CourseAdapter adapter=new CourseAdapter(courseList);
        adapter.setCourseItemOnClickListener(course -> {
            Intent intent=new Intent(getActivity(), TeacherCourseActivity.class);
            intent.putExtra("course",course);
            startActivity(intent);
        });
        binding.courseRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.courseRecyclerview.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        svm.userName.setValue(ApplicationConfig.userName);
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

    public class ClickClass {
        /**
         * 创建一个新的课号
         *
         * @param view
         */
        public void createCourse(View view) {
            dialog = new CreateCourseDialog(Objects.requireNonNull(getActivity()), bean -> rvm.createCourse(bean));
            dialog.show();
        }

        /**
         * 刷新课程列表
         *
         * @param view
         */
        public void refresh(View view) {
            rvm.inquireCourse();
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}