package com.view.activity.student;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.adapter.viewpager2.MainViewPager2Adapter;
import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStudentMainBinding;
import com.view.fragment.student.StudentHomeFragment;
import com.view.fragment.student.StudentMineFragment;
import com.viewmodel.rvm.activity.student.StudentMainRVM;
import com.viewmodel.svm.activity.student.StudentMainSVM;

import java.util.ArrayList;
import java.util.List;

public class StudentMainActivity extends BaseActivity {
    ActivityStudentMainBinding binding;
    StudentMainSVM svm;
    StudentMainRVM rvm;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentMainSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentMainRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_main);
    }

    @Override
    protected void getInternetData() {

    }

    @Override
    protected void observerDataStateUpdateAction() {

    }

    @Override
    protected void initView() {
        initViewPager2();
        initBottomNav();
    }

    /**
     * 加载ViewPager2
     */
    @SuppressLint("ClickableViewAccessibility")
    private void initViewPager2() {
        List<Fragment> fragmentLis = new ArrayList<>();
        fragmentLis.add(new StudentHomeFragment());
        fragmentLis.add(new StudentMineFragment());
        MainViewPager2Adapter adapter = new MainViewPager2Adapter(this, fragmentLis);
        binding.mainViewPager2.setAdapter(adapter);
        //去除尽头阴影
        View childAt = binding.mainViewPager2.getChildAt(0);
        if (childAt instanceof RecyclerView) {
            childAt.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
        binding.mainViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.bottomNavigation.setSelectedItemId(binding.bottomNavigation.getMenu().getItem(position).getItemId());
            }
        });
    }

    /**
     * 初始化BottomNav与viewPager联动
     * <p>
     * 按住松手后进入选中
     * <p>
     * 拦截item长按事件，去掉文字吐司
     */
    @SuppressLint({"NonConstantResourceId", "ClickableViewAccessibility"})
    private void initBottomNav() {
        //初始化BottomNav与viewPager联动
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.main_home:
                    binding.mainViewPager2.setCurrentItem(0);
                    return true;
                case R.id.main_my:
                    binding.mainViewPager2.setCurrentItem(1);
                    return true;
            }
            return false;
        });
        //按住松手后进入选中
        binding.bottomNavigation.findViewById(R.id.main_home).setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP)
                binding.bottomNavigation.setSelectedItemId(v.getId());
            return false;
        });
        binding.bottomNavigation.findViewById(R.id.main_my).setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP)
                binding.bottomNavigation.setSelectedItemId(v.getId());
            return false;
        });
        //拦截item长按事件，去掉文字吐司
        binding.bottomNavigation.findViewById(R.id.main_home).setOnLongClickListener(view -> true);
        binding.bottomNavigation.findViewById(R.id.main_my).setOnLongClickListener(view -> true);
    }

    public class ClickClass{

    }

    long startTime = 0;

    /**
     * 重写onKeyUp，监听BACK键 设置2s内再按一次返回桌面
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - startTime < 2000) {
                finish();
            } else {
                //记录时间
                startTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}