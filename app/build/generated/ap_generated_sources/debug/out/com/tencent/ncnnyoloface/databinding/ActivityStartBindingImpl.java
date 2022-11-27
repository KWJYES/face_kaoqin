package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStartBindingImpl extends ActivityStartBinding  {

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
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickStudentBtnAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mClickTeacherBtnAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityStartBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityStartBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[1]
            , (androidx.cardview.widget.CardView) bindings[2]
            );
        this.cardView.setTag(null);
        this.cardView2.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.click == variableId) {
            setClick((com.view.activity.StartActivity.CLickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClick(@Nullable com.view.activity.StartActivity.CLickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        android.view.View.OnClickListener clickStudentBtnAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener clickTeacherBtnAndroidViewViewOnClickListener = null;
        com.view.activity.StartActivity.CLickClass click = mClick;

        if ((dirtyFlags & 0x3L) != 0) {



                if (click != null) {
                    // read click::studentBtn
                    clickStudentBtnAndroidViewViewOnClickListener = (((mClickStudentBtnAndroidViewViewOnClickListener == null) ? (mClickStudentBtnAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickStudentBtnAndroidViewViewOnClickListener).setValue(click));
                    // read click::teacherBtn
                    clickTeacherBtnAndroidViewViewOnClickListener = (((mClickTeacherBtnAndroidViewViewOnClickListener == null) ? (mClickTeacherBtnAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mClickTeacherBtnAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.cardView.setOnClickListener(clickStudentBtnAndroidViewViewOnClickListener);
            this.cardView2.setOnClickListener(clickTeacherBtnAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.activity.StartActivity.CLickClass value;
        public OnClickListenerImpl setValue(com.view.activity.StartActivity.CLickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.studentBtn(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.view.activity.StartActivity.CLickClass value;
        public OnClickListenerImpl1 setValue(com.view.activity.StartActivity.CLickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.teacherBtn(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): click
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}