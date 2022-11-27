package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMineBindingImpl extends FragmentMineBinding  {

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
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickMyAttendanceAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public FragmentMineBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentMineBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.textView10.setTag(null);
        this.textView11.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setSvm((com.viewmodel.svm.fragment.student.StudentMineSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.fragment.student.StudentMineFragment.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.fragment.student.StudentMineSVM Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.fragment.student.StudentMineFragment.ClickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSvmStudentName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeSvmStudentId((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSvmStudentName(androidx.lifecycle.MutableLiveData<java.lang.String> SvmStudentName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmStudentId(androidx.lifecycle.MutableLiveData<java.lang.String> SvmStudentId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        android.view.View.OnClickListener clickMyAttendanceAndroidViewViewOnClickListener = null;
        com.viewmodel.svm.fragment.student.StudentMineSVM svm = mSvm;
        com.view.fragment.student.StudentMineFragment.ClickClass click = mClick;
        java.lang.String svmStudentNameGetValue = null;
        java.lang.String svmStudentIdGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmStudentName = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmStudentId = null;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (svm != null) {
                        // read svm.student_name
                        svmStudentName = svm.student_name;
                    }
                    updateLiveDataRegistration(0, svmStudentName);


                    if (svmStudentName != null) {
                        // read svm.student_name.getValue()
                        svmStudentNameGetValue = svmStudentName.getValue();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (svm != null) {
                        // read svm.student_id
                        svmStudentId = svm.student_id;
                    }
                    updateLiveDataRegistration(1, svmStudentId);


                    if (svmStudentId != null) {
                        // read svm.student_id.getValue()
                        svmStudentIdGetValue = svmStudentId.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x18L) != 0) {



                if (click != null) {
                    // read click::myAttendance
                    clickMyAttendanceAndroidViewViewOnClickListener = (((mClickMyAttendanceAndroidViewViewOnClickListener == null) ? (mClickMyAttendanceAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickMyAttendanceAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(clickMyAttendanceAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView10, svmStudentNameGetValue);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView11, svmStudentIdGetValue);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.fragment.student.StudentMineFragment.ClickClass value;
        public OnClickListenerImpl setValue(com.view.fragment.student.StudentMineFragment.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.myAttendance(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm.student_name
        flag 1 (0x2L): svm.student_id
        flag 2 (0x3L): svm
        flag 3 (0x4L): click
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}