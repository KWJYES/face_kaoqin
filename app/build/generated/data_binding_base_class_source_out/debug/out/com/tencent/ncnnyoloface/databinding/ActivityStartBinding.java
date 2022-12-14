// Generated by data binding compiler. Do not edit!
package com.tencent.ncnnyoloface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tencent.ncnnyoloface.R;
import com.view.activity.StartActivity;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityStartBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardView;

  @NonNull
  public final CardView cardView2;

  @Bindable
  protected StartActivity.CLickClass mClick;

  protected ActivityStartBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cardView, CardView cardView2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardView = cardView;
    this.cardView2 = cardView2;
  }

  public abstract void setClick(@Nullable StartActivity.CLickClass click);

  @Nullable
  public StartActivity.CLickClass getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityStartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_start, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityStartBinding>inflateInternal(inflater, R.layout.activity_start, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityStartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_start, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityStartBinding>inflateInternal(inflater, R.layout.activity_start, null, false, component);
  }

  public static ActivityStartBinding bind(@NonNull View view) {
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
  public static ActivityStartBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityStartBinding)bind(component, view, R.layout.activity_start);
  }
}
