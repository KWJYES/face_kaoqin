// Generated by data binding compiler. Do not edit!
package com.tencent.ncnnyoloface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tencent.ncnnyoloface.R;
import com.view.activity.student.StudentCourseActivity;
import com.viewmodel.svm.activity.student.StudentCourseSVM;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityStudentCourseBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @Bindable
  protected StudentCourseSVM mSvm;

  @Bindable
  protected StudentCourseActivity.ClickClass mClick;

  protected ActivityStudentCourseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cardView3, TextView textView4, TextView textView5, TextView textView6) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardView3 = cardView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
  }

  public abstract void setSvm(@Nullable StudentCourseSVM svm);

  @Nullable
  public StudentCourseSVM getSvm() {
    return mSvm;
  }

  public abstract void setClick(@Nullable StudentCourseActivity.ClickClass click);

  @Nullable
  public StudentCourseActivity.ClickClass getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityStudentCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_student_course, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentCourseBinding>inflateInternal(inflater, R.layout.activity_student_course, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityStudentCourseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_student_course, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentCourseBinding>inflateInternal(inflater, R.layout.activity_student_course, null, false, component);
  }

  public static ActivityStudentCourseBinding bind(@NonNull View view) {
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
  public static ActivityStudentCourseBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityStudentCourseBinding)bind(component, view, R.layout.activity_student_course);
  }
}