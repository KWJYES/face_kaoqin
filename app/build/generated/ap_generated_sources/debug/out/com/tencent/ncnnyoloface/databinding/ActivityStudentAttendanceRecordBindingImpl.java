package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStudentAttendanceRecordBindingImpl extends ActivityStudentAttendanceRecordBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.statusBarHeightView2, 2);
        sViewsWithIds.put(R.id.constraintLayout2, 3);
        sViewsWithIds.put(R.id.smartRefreshLayout, 4);
        sViewsWithIds.put(R.id.attendanceRV, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickBackAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityStudentAttendanceRecordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityStudentAttendanceRecordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (com.scwang.smart.refresh.layout.SmartRefreshLayout) bindings[4]
            , (com.customview.StatusBarHeightView) bindings[2]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
            setSvm((com.viewmodel.svm.activity.student.StudentAttendanceRecordSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.activity.student.StudentAttendanceRecordActivity.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.activity.student.StudentAttendanceRecordSVM Svm) {
        this.mSvm = Svm;
    }
    public void setClick(@Nullable com.view.activity.student.StudentAttendanceRecordActivity.ClickClass Click) {
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
        android.view.View.OnClickListener clickBackAndroidViewViewOnClickListener = null;
        com.view.activity.student.StudentAttendanceRecordActivity.ClickClass click = mClick;

        if ((dirtyFlags & 0x6L) != 0) {



                if (click != null) {
                    // read click::back
                    clickBackAndroidViewViewOnClickListener = (((mClickBackAndroidViewViewOnClickListener == null) ? (mClickBackAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickBackAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.imageView.setOnClickListener(clickBackAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.activity.student.StudentAttendanceRecordActivity.ClickClass value;
        public OnClickListenerImpl setValue(com.view.activity.student.StudentAttendanceRecordActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.back(arg0); 
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