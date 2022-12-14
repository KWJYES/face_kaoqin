// Generated by data binding compiler. Do not edit!
package com.tencent.ncnnyoloface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tencent.ncnnyoloface.R;
import com.view.activity.student.StudentLoginActivity;
import com.viewmodel.svm.activity.student.StudentLoginSVM;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityStudentLoginBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @Bindable
  protected StudentLoginActivity.ClickClass mClick;

  @Bindable
  protected StudentLoginSVM mSvm;

  protected ActivityStudentLoginBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout linearLayout, LinearLayout linearLayout2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
  }

  public abstract void setClick(@Nullable StudentLoginActivity.ClickClass click);

  @Nullable
  public StudentLoginActivity.ClickClass getClick() {
    return mClick;
  }

  public abstract void setSvm(@Nullable StudentLoginSVM svm);

  @Nullable
  public StudentLoginSVM getSvm() {
    return mSvm;
  }

  @NonNull
  public static ActivityStudentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_student_login, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentLoginBinding>inflateInternal(inflater, R.layout.activity_student_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityStudentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_student_login, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentLoginBinding>inflateInternal(inflater, R.layout.activity_student_login, null, false, component);
  }

  public static ActivityStudentLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityStudentLoginBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityStudentLoginBinding)bind(component, view, R.layout.activity_student_login);
  }
}
