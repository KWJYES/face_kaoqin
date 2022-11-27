package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStudentLoginBindingImpl extends ActivityStudentLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout, 5);
        sViewsWithIds.put(R.id.linearLayout2, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.Button mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickRegisterAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mClickLoginAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.email.getValue()
            //         is svm.email.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // svm
            com.viewmodel.svm.activity.student.StudentLoginSVM svm = mSvm;
            // svm.email.getValue()
            java.lang.String svmEmailGetValue = null;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.email != null
            boolean svmEmailJavaLangObjectNull = false;
            // svm.email
            androidx.lifecycle.MutableLiveData<java.lang.String> svmEmail = null;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmEmail = svm.email;

                svmEmailJavaLangObjectNull = (svmEmail) != (null);
                if (svmEmailJavaLangObjectNull) {




                    svmEmail.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.password.getValue()
            //         is svm.password.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // svm.password.getValue()
            java.lang.String svmPasswordGetValue = null;
            // svm
            com.viewmodel.svm.activity.student.StudentLoginSVM svm = mSvm;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.password
            androidx.lifecycle.MutableLiveData<java.lang.String> svmPassword = null;
            // svm.password != null
            boolean svmPasswordJavaLangObjectNull = false;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmPassword = svm.password;

                svmPasswordJavaLangObjectNull = (svmPassword) != (null);
                if (svmPasswordJavaLangObjectNull) {




                    svmPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityStudentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityStudentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[6]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
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
            setSvm((com.viewmodel.svm.activity.student.StudentLoginSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.activity.student.StudentLoginActivity.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.activity.student.StudentLoginSVM Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.activity.student.StudentLoginActivity.ClickClass Click) {
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
                return onChangeSvmPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeSvmEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSvmPassword(androidx.lifecycle.MutableLiveData<java.lang.String> SvmPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmEmail(androidx.lifecycle.MutableLiveData<java.lang.String> SvmEmail, int fieldId) {
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
        com.viewmodel.svm.activity.student.StudentLoginSVM svm = mSvm;
        java.lang.String svmEmailGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmPassword = null;
        android.view.View.OnClickListener clickRegisterAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener clickLoginAndroidViewViewOnClickListener = null;
        java.lang.String svmPasswordGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmEmail = null;
        com.view.activity.student.StudentLoginActivity.ClickClass click = mClick;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (svm != null) {
                        // read svm.password
                        svmPassword = svm.password;
                    }
                    updateLiveDataRegistration(0, svmPassword);


                    if (svmPassword != null) {
                        // read svm.password.getValue()
                        svmPasswordGetValue = svmPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (svm != null) {
                        // read svm.email
                        svmEmail = svm.email;
                    }
                    updateLiveDataRegistration(1, svmEmail);


                    if (svmEmail != null) {
                        // read svm.email.getValue()
                        svmEmailGetValue = svmEmail.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x18L) != 0) {



                if (click != null) {
                    // read click::register
                    clickRegisterAndroidViewViewOnClickListener = (((mClickRegisterAndroidViewViewOnClickListener == null) ? (mClickRegisterAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickRegisterAndroidViewViewOnClickListener).setValue(click));
                    // read click::login
                    clickLoginAndroidViewViewOnClickListener = (((mClickLoginAndroidViewViewOnClickListener == null) ? (mClickLoginAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mClickLoginAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, svmEmailGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, svmPasswordGetValue);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(clickLoginAndroidViewViewOnClickListener);
            this.mboundView4.setOnClickListener(clickRegisterAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.activity.student.StudentLoginActivity.ClickClass value;
        public OnClickListenerImpl setValue(com.view.activity.student.StudentLoginActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.register(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.view.activity.student.StudentLoginActivity.ClickClass value;
        public OnClickListenerImpl1 setValue(com.view.activity.student.StudentLoginActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.login(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm.password
        flag 1 (0x2L): svm.email
        flag 2 (0x3L): svm
        flag 3 (0x4L): click
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}