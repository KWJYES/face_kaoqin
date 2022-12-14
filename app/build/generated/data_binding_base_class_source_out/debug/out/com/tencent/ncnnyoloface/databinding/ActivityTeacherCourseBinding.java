// Generated by data binding compiler. Do not edit!
package com.tencent.ncnnyoloface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tencent.ncnnyoloface.R;
import com.view.activity.teacher.TeacherCourseActivity;
import com.viewmodel.svm.activity.teacher.TeacherCourseSVM;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTeacherCourseBinding extends ViewDataBinding {
  @NonNull
  public final Button button4;

  @NonNull
  public final CardView cardView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @Bindable
  protected TeacherCourseActivity.ClickClass mClick;

  @Bindable
  protected TeacherCourseSVM mSvm;

  protected ActivityTeacherCourseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button button4, CardView cardView3, TextView textView4, TextView textView5,
      TextView textView6) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button4 = button4;
    this.cardView3 = cardView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
  }

  public abstract void setClick(@Nullable TeacherCourseActivity.ClickClass click);

  @Nullable
  public TeacherCourseActivity.ClickClass getClick() {
    return mClick;
  }

  public abstract void setSvm(@Nullable TeacherCourseSVM svm);

  @Nullable
  public TeacherCourseSVM getSvm() {
    return mSvm;
  }

  @NonNull
  public static ActivityTeacherCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_teacher_course, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTeacherCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTeacherCourseBinding>inflateInternal(inflater, R.layout.activity_teacher_course, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTeacherCourseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_teacher_course, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTeacherCourseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTeacherCourseBinding>inflateInternal(inflater, R.layout.activity_teacher_course, null, false, component);
  }

  public static ActivityTeacherCourseBinding bind(@NonNull View view) {
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
  public static ActivityTeacherCourseBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityTeacherCourseBinding)bind(component, view, R.layout.activity_teacher_course);
  }
}
