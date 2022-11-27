package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemInquireCourseBeanMessageBindingImpl extends ItemInquireCourseBeanMessageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.cardview.widget.CardView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickItemOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemInquireCourseBeanMessageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemInquireCourseBeanMessageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.cardview.widget.CardView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setSvm((com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.adapter.teacher.CourseAdapter.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.adapter.teacher.CourseAdapter.ClickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.lang.String svmCourseName = null;
        com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message svm = mSvm;
        java.lang.String javaLangStringSvmId = null;
        android.view.View.OnClickListener clickItemOnClickAndroidViewViewOnClickListener = null;
        java.lang.String javaLangStringSvmTeacherId = null;
        com.adapter.teacher.CourseAdapter.ClickClass click = mClick;
        java.lang.String svmId = null;
        java.lang.String svmTeacherId = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (svm != null) {
                    // read svm.course_name
                    svmCourseName = svm.getCourse_name();
                    // read svm.id
                    svmId = svm.getId();
                    // read svm.teacher_id
                    svmTeacherId = svm.getTeacher_id();
                }


                // read ("课号：") + (svm.id)
                javaLangStringSvmId = ("课号：") + (svmId);
                // read ("任课教师：") + (svm.teacher_id)
                javaLangStringSvmTeacherId = ("任课教师：") + (svmTeacherId);
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (click != null) {
                    // read click::itemOnClick
                    clickItemOnClickAndroidViewViewOnClickListener = (((mClickItemOnClickAndroidViewViewOnClickListener == null) ? (mClickItemOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickItemOnClickAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(clickItemOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, javaLangStringSvmTeacherId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView4, svmCourseName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView5, javaLangStringSvmId);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.adapter.teacher.CourseAdapter.ClickClass value;
        public OnClickListenerImpl setValue(com.adapter.teacher.CourseAdapter.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.itemOnClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm
        flag 1 (0x2L): click
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}