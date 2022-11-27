package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogStartAttendanceBindingImpl extends DialogStartAttendanceBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView7, 4);
        sViewsWithIds.put(R.id.linearLayout6, 5);
        sViewsWithIds.put(R.id.spinner, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView3;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickAttendanceAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public DialogStartAttendanceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private DialogStartAttendanceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.Spinner) bindings[6]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.textView8.setTag(null);
        this.textView9.setTag(null);
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
        if (BR.course == variableId) {
            setCourse((com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.dialog.teacher.StartAttendanceDialog.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCourse(@Nullable com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message Course) {
        this.mCourse = Course;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.course);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.dialog.teacher.StartAttendanceDialog.ClickClass Click) {
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
        java.lang.String courseCourseName = null;
        android.view.View.OnClickListener clickAttendanceAndroidViewViewOnClickListener = null;
        java.lang.String courseId = null;
        com.response.retrofit_api.resposebody_bean.InquireCourseBean.Message course = mCourse;
        java.lang.String javaLangStringCourseCourseName = null;
        java.lang.String javaLangStringCourseId = null;
        com.view.dialog.teacher.StartAttendanceDialog.ClickClass click = mClick;

        if ((dirtyFlags & 0x5L) != 0) {



                if (course != null) {
                    // read course.course_name
                    courseCourseName = course.getCourse_name();
                    // read course.id
                    courseId = course.getId();
                }


                // read ("名称：") + (course.course_name)
                javaLangStringCourseCourseName = ("名称：") + (courseCourseName);
                // read ("课号：") + (course.id)
                javaLangStringCourseId = ("课号：") + (courseId);
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (click != null) {
                    // read click::attendance
                    clickAttendanceAndroidViewViewOnClickListener = (((mClickAttendanceAndroidViewViewOnClickListener == null) ? (mClickAttendanceAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickAttendanceAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(clickAttendanceAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView8, javaLangStringCourseId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView9, javaLangStringCourseCourseName);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.dialog.teacher.StartAttendanceDialog.ClickClass value;
        public OnClickListenerImpl setValue(com.view.dialog.teacher.StartAttendanceDialog.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.attendance(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): course
        flag 1 (0x2L): click
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}