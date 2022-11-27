package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardview, 4);
        sViewsWithIds.put(R.id.constraintLayout, 5);
        sViewsWithIds.put(R.id.statusBarHeightView, 6);
        sViewsWithIds.put(R.id.course_recyclerview, 7);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.Button mboundView2;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickJoinInCourseAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mClickRefreshAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[3]
            , (androidx.cardview.widget.CardView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (com.customview.StatusBarHeightView) bindings[6]
            );
        this.button3.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.Button) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.svm == variableId) {
            setSvm((com.viewmodel.svm.fragment.student.StudentHomeSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.fragment.student.StudentHomeFragment.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.fragment.student.StudentHomeSVM Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.fragment.student.StudentHomeFragment.ClickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSvmUserName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSvmUserName(androidx.lifecycle.MutableLiveData<java.lang.String> SvmUserName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String svmUserNameJavaLangString = null;
        android.view.View.OnClickListener clickJoinInCourseAndroidViewViewOnClickListener = null;
        com.viewmodel.svm.fragment.student.StudentHomeSVM svm = mSvm;
        android.view.View.OnClickListener clickRefreshAndroidViewViewOnClickListener = null;
        java.lang.String svmUserNameGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmUserName = null;
        com.view.fragment.student.StudentHomeFragment.ClickClass click = mClick;

        if ((dirtyFlags & 0xbL) != 0) {



                if (svm != null) {
                    // read svm.userName
                    svmUserName = svm.userName;
                }
                updateLiveDataRegistration(0, svmUserName);


                if (svmUserName != null) {
                    // read svm.userName.getValue()
                    svmUserNameGetValue = svmUserName.getValue();
                }


                // read (svm.userName.getValue()) + (" 同学")
                svmUserNameJavaLangString = (svmUserNameGetValue) + (" 同学");
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (click != null) {
                    // read click::joinInCourse
                    clickJoinInCourseAndroidViewViewOnClickListener = (((mClickJoinInCourseAndroidViewViewOnClickListener == null) ? (mClickJoinInCourseAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickJoinInCourseAndroidViewViewOnClickListener).setValue(click));
                    // read click::refresh
                    clickRefreshAndroidViewViewOnClickListener = (((mClickRefreshAndroidViewViewOnClickListener == null) ? (mClickRefreshAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mClickRefreshAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.button3.setOnClickListener(clickJoinInCourseAndroidViewViewOnClickListener);
            this.mboundView2.setOnClickListener(clickRefreshAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, svmUserNameJavaLangString);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.fragment.student.StudentHomeFragment.ClickClass value;
        public OnClickListenerImpl setValue(com.view.fragment.student.StudentHomeFragment.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.joinInCourse(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.view.fragment.student.StudentHomeFragment.ClickClass value;
        public OnClickListenerImpl1 setValue(com.view.fragment.student.StudentHomeFragment.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.refresh(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm.userName
        flag 1 (0x2L): svm
        flag 2 (0x3L): click
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}