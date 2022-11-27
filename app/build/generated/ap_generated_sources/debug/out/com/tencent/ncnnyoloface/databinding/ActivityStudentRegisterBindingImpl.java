package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStudentRegisterBindingImpl extends ActivityStudentRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout0, 9);
        sViewsWithIds.put(R.id.linearLayout2, 10);
        sViewsWithIds.put(R.id.linearLayout, 11);
        sViewsWithIds.put(R.id.linearLayout3, 12);
        sViewsWithIds.put(R.id.linearLayout4, 13);
        sViewsWithIds.put(R.id.linearLayout5, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.EditText mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView6;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickRegisterAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mClickGetCaptchaAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.student_id.getValue()
            //         is svm.student_id.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.student_id.getValue()
            java.lang.String svmStudentIdGetValue = null;
            // svm.student_id
            androidx.lifecycle.MutableLiveData<java.lang.String> svmStudentId = null;
            // svm.student_id != null
            boolean svmStudentIdJavaLangObjectNull = false;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmStudentId = svm.student_id;

                svmStudentIdJavaLangObjectNull = (svmStudentId) != (null);
                if (svmStudentIdJavaLangObjectNull) {




                    svmStudentId.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.username.getValue()
            //         is svm.username.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.username != null
            boolean svmUsernameJavaLangObjectNull = false;
            // svm.username
            androidx.lifecycle.MutableLiveData<java.lang.String> svmUsername = null;
            // svm.username.getValue()
            java.lang.String svmUsernameGetValue = null;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmUsername = svm.username;

                svmUsernameJavaLangObjectNull = (svmUsername) != (null);
                if (svmUsernameJavaLangObjectNull) {




                    svmUsername.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.email.getValue()
            //         is svm.email.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
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
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.password.getValue()
            //         is svm.password.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // svm.password.getValue()
            java.lang.String svmPasswordGetValue = null;
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
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
    private androidx.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.password_confirm.getValue()
            //         is svm.password_confirm.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.password_confirm
            androidx.lifecycle.MutableLiveData<java.lang.String> svmPasswordConfirm = null;
            // svm.password_confirm.getValue()
            java.lang.String svmPasswordConfirmGetValue = null;
            // svm.password_confirm != null
            boolean svmPasswordConfirmJavaLangObjectNull = false;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmPasswordConfirm = svm.password_confirm;

                svmPasswordConfirmJavaLangObjectNull = (svmPasswordConfirm) != (null);
                if (svmPasswordConfirmJavaLangObjectNull) {




                    svmPasswordConfirm.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of svm.captcha.getValue()
            //         is svm.captcha.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // svm.captcha != null
            boolean svmCaptchaJavaLangObjectNull = false;
            // svm
            com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
            // svm != null
            boolean svmJavaLangObjectNull = false;
            // svm.captcha
            androidx.lifecycle.MutableLiveData<java.lang.String> svmCaptcha = null;
            // svm.captcha.getValue()
            java.lang.String svmCaptchaGetValue = null;



            svmJavaLangObjectNull = (svm) != (null);
            if (svmJavaLangObjectNull) {


                svmCaptcha = svm.captcha;

                svmCaptchaJavaLangObjectNull = (svmCaptcha) != (null);
                if (svmCaptchaJavaLangObjectNull) {




                    svmCaptcha.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityStudentRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityStudentRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[14]
            );
        this.button.setTag(null);
        this.button2.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.EditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.EditText) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
            setSvm((com.viewmodel.svm.activity.student.StudentRegisterSVM) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.view.activity.student.StudentRegisterActivity.ClickClass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSvm(@Nullable com.viewmodel.svm.activity.student.StudentRegisterSVM Svm) {
        this.mSvm = Svm;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.svm);
        super.requestRebind();
    }
    public void setClick(@Nullable com.view.activity.student.StudentRegisterActivity.ClickClass Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
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
                return onChangeSvmPasswordConfirm((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeSvmEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeSvmStudentId((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeSvmCaptcha((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeSvmUsername((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
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
    private boolean onChangeSvmPasswordConfirm(androidx.lifecycle.MutableLiveData<java.lang.String> SvmPasswordConfirm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmEmail(androidx.lifecycle.MutableLiveData<java.lang.String> SvmEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmStudentId(androidx.lifecycle.MutableLiveData<java.lang.String> SvmStudentId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmCaptcha(androidx.lifecycle.MutableLiveData<java.lang.String> SvmCaptcha, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSvmUsername(androidx.lifecycle.MutableLiveData<java.lang.String> SvmUsername, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        com.viewmodel.svm.activity.student.StudentRegisterSVM svm = mSvm;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmPassword = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmPasswordConfirm = null;
        java.lang.String svmPasswordConfirmGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmEmail = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmStudentId = null;
        java.lang.String svmEmailGetValue = null;
        java.lang.String svmUsernameGetValue = null;
        android.view.View.OnClickListener clickRegisterAndroidViewViewOnClickListener = null;
        java.lang.String svmStudentIdGetValue = null;
        android.view.View.OnClickListener clickGetCaptchaAndroidViewViewOnClickListener = null;
        java.lang.String svmPasswordGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmCaptcha = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> svmUsername = null;
        com.view.activity.student.StudentRegisterActivity.ClickClass click = mClick;
        java.lang.String svmCaptchaGetValue = null;

        if ((dirtyFlags & 0x17fL) != 0) {


            if ((dirtyFlags & 0x141L) != 0) {

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
            if ((dirtyFlags & 0x142L) != 0) {

                    if (svm != null) {
                        // read svm.password_confirm
                        svmPasswordConfirm = svm.password_confirm;
                    }
                    updateLiveDataRegistration(1, svmPasswordConfirm);


                    if (svmPasswordConfirm != null) {
                        // read svm.password_confirm.getValue()
                        svmPasswordConfirmGetValue = svmPasswordConfirm.getValue();
                    }
            }
            if ((dirtyFlags & 0x144L) != 0) {

                    if (svm != null) {
                        // read svm.email
                        svmEmail = svm.email;
                    }
                    updateLiveDataRegistration(2, svmEmail);


                    if (svmEmail != null) {
                        // read svm.email.getValue()
                        svmEmailGetValue = svmEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x148L) != 0) {

                    if (svm != null) {
                        // read svm.student_id
                        svmStudentId = svm.student_id;
                    }
                    updateLiveDataRegistration(3, svmStudentId);


                    if (svmStudentId != null) {
                        // read svm.student_id.getValue()
                        svmStudentIdGetValue = svmStudentId.getValue();
                    }
            }
            if ((dirtyFlags & 0x150L) != 0) {

                    if (svm != null) {
                        // read svm.captcha
                        svmCaptcha = svm.captcha;
                    }
                    updateLiveDataRegistration(4, svmCaptcha);


                    if (svmCaptcha != null) {
                        // read svm.captcha.getValue()
                        svmCaptchaGetValue = svmCaptcha.getValue();
                    }
            }
            if ((dirtyFlags & 0x160L) != 0) {

                    if (svm != null) {
                        // read svm.username
                        svmUsername = svm.username;
                    }
                    updateLiveDataRegistration(5, svmUsername);


                    if (svmUsername != null) {
                        // read svm.username.getValue()
                        svmUsernameGetValue = svmUsername.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x180L) != 0) {



                if (click != null) {
                    // read click::register
                    clickRegisterAndroidViewViewOnClickListener = (((mClickRegisterAndroidViewViewOnClickListener == null) ? (mClickRegisterAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickRegisterAndroidViewViewOnClickListener).setValue(click));
                    // read click::getCaptcha
                    clickGetCaptchaAndroidViewViewOnClickListener = (((mClickGetCaptchaAndroidViewViewOnClickListener == null) ? (mClickGetCaptchaAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mClickGetCaptchaAndroidViewViewOnClickListener).setValue(click));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x180L) != 0) {
            // api target 1

            this.button.setOnClickListener(clickRegisterAndroidViewViewOnClickListener);
            this.button2.setOnClickListener(clickGetCaptchaAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x148L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, svmStudentIdGetValue);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x160L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, svmUsernameGetValue);
        }
        if ((dirtyFlags & 0x144L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, svmEmailGetValue);
        }
        if ((dirtyFlags & 0x141L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, svmPasswordGetValue);
        }
        if ((dirtyFlags & 0x142L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, svmPasswordConfirmGetValue);
        }
        if ((dirtyFlags & 0x150L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, svmCaptchaGetValue);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.view.activity.student.StudentRegisterActivity.ClickClass value;
        public OnClickListenerImpl setValue(com.view.activity.student.StudentRegisterActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.register(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.view.activity.student.StudentRegisterActivity.ClickClass value;
        public OnClickListenerImpl1 setValue(com.view.activity.student.StudentRegisterActivity.ClickClass value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.getCaptcha(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): svm.password
        flag 1 (0x2L): svm.password_confirm
        flag 2 (0x3L): svm.email
        flag 3 (0x4L): svm.student_id
        flag 4 (0x5L): svm.captcha
        flag 5 (0x6L): svm.username
        flag 6 (0x7L): svm
        flag 7 (0x8L): click
        flag 8 (0x9L): null
    flag mapping end*/
    //end
}