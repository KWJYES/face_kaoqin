package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTeacherCourseBindingImpl extends ActivityTeacherCourseBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView3, 6);
        sViewsWithIds.put(R.id.textView6, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.Button mboundView5;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickAttendanceAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mClickDeleteCourseAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityTeacherCourseBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityTeacherCourseBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            );
        this.button4.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (android.widget.Button) bindings[5];
        this.mboundView5.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            setSvm((com.viewmodel.svm.activity.teacher.TeacherCourseSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.activity.teacher.TeacherCourseActivity.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.activity.teacher.TeacherCourseSVM Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.activity.teacher.TeacherCourseActivity.ClickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSvmCourseName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeSvmCourseId((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeSvmTeacherId((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSvmCourseName(androidx.lifecycle.MutableLiveData<java.lang.String> SvmCourseName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmCourseId(androidx.lifecycle.MutableLiveData<java.lang.String> SvmCourseId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmTeacherId(androidx.lifecycle.MutableLiveData<java.lang.String> SvmTeacherId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        android.view.View.OnClickListener clickAttendanceAndroidViewViewOnClickListener = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmCourseName = null;
        com.viewmodel.svm.activity.teacher.TeacherCourseSVM svm = mSvm;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmCourseId = null;
        java.lang.String javaLangStringSvmCourseId = null;
        android.view.View.OnClickListener clickDeleteCourseAndroidViewViewOnClickListener = null;
        java.lang.String svmTeacherIdGetValue = null;
        java.lang.String javaLangStringIDSvmTeacherId = null;
        com.view.activity.teacher.TeacherCourseActivity.ClickClass click = mClick;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmTeacherId = null;
        java.lang.String svmCourseIdGetValue = null;
        java.lang.String svmCourseNameGetValue = null;

        if ((dirtyFlags & 0x2fL) != 0) {


            if ((dirtyFlags & 0x29L) != 0) {

                    if (svm != null) {
                        // read svm.course_name
                        svmCourseName = svm.course_name;
                    }
                    updateLiveDataRegistration(0, svmCourseName);


                    if (svmCourseName != null) {
                        // read svm.course_name.getValue()
                        svmCourseNameGetValue = svmCourseName.getValue();
                    }
            }
            if ((dirtyFlags & 0x2aL) != 0) {

                    if (svm != null) {
                        // read svm.course_id
                        svmCourseId = svm.course_id;
                    }
                    updateLiveDataRegistration(1, svmCourseId);


                    if (svmCourseId != null) {
                        // read svm.course_id.getValue()
                        svmCourseIdGetValue = svmCourseId.getValue();
                    }


                    // read ("课号：") + (svm.course_id.getValue())
                    javaLangStringSvmCourseId = ("课号：") + (svmCourseIdGetValue);
            }
            if ((dirtyFlags & 0x2cL) != 0) {

                    if (svm != null) {
                        // read svm.teacher_id
                        svmTeacherId = svm.teacher_id;
                    }
                    updateLiveDataRegistration(2, svmTeacherId);


                    if (svmTeacherId != null) {
                        // read svm.teacher_id.getValue()
                        svmTeacherIdGetValue = svmTeacherId.getValue();
                    }


                    // read ("任课教师ID：") + (svm.teacher_id.getValue())
                    javaLangStringIDSvmTeacherId = ("任课教师ID：") + (svmTeacherIdGetValue);
            }
        }
        if ((dirtyFlags & 0x30L) != 0) {



                if (click != null) {
                    // read click::attendance
                    clickAttendanceAndroidViewViewOnClickListener = (((mClickAttendanceAndroidViewViewOnClickListener == null) ? (mClickAttendanceAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickAttendanceAndroidViewViewOnClickListener).setValue(click));
                    // read click::deleteCourse
                    clickDeleteCourseAndroidViewViewOnClickListener = (((mClickDeleteCourseAndroidViewViewOnClickListener == null) ? (mClickDeleteCourseAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mClickDeleteCourseAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.button4.setOnClickListener(clickAttendanceAndroidViewViewOnClickListener);
            this.mboundView5.setOnClickListener(clickDeleteCourseAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, javaLangStringIDSvmTeacherId);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView4, svmCourseNameGetValue);
        }
        if ((dirtyFlags & 0x2aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView5, javaLangStringSvmCourseId);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.activity.teacher.TeacherCourseActivity.ClickClass value;
        public OnClickListenerImpl setValue(com.view.activity.teacher.TeacherCourseActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.attendance(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.view.activity.teacher.TeacherCourseActivity.ClickClass value;
        public OnClickListenerImpl1 setValue(com.view.activity.teacher.TeacherCourseActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.deleteCourse(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm.course_name
        flag 1 (0x2L): svm.course_id
        flag 2 (0x3L): svm.teacher_id
        flag 3 (0x4L): svm
        flag 4 (0x5L): click
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}