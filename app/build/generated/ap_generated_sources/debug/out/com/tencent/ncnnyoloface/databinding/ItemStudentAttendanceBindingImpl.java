package com.tencent.ncnnyoloface.databinding;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemStudentAttendanceBindingImpl extends ItemStudentAttendanceBinding  {

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
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemStudentAttendanceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemStudentAttendanceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.textView12.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.response.retrofit_api.resposebody_bean.InquireAttendanceBean.Message) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.response.retrofit_api.resposebody_bean.InquireAttendanceBean.Message Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
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
        int itemAttendanceStateEqualsJavaLangStringInt0xFF00D809Int0xFFE53935 = 0;
        java.lang.String itemAttendanceTimeJavaLangStringItemLessonsTimeJavaLangString = null;
        com.response.retrofit_api.resposebody_bean.InquireAttendanceBean.Message item = mItem;
        java.lang.String itemAttendanceTimeJavaLangString = null;
        java.lang.String itemAttendanceState = null;
        java.lang.String itemAttendanceTime = null;
        java.lang.String itemCourseId = null;
        java.lang.String itemLessonsTime = null;
        java.lang.String itemCourseName = null;
        java.lang.String itemCourseNameItemCourseId = null;
        boolean itemAttendanceStateEqualsJavaLangString = false;
        java.lang.String itemAttendanceTimeJavaLangStringItemLessonsTime = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.attendance_state
                    itemAttendanceState = item.getAttendance_state();
                    // read item.attendance_time
                    itemAttendanceTime = item.getAttendance_time();
                    // read item.course_id
                    itemCourseId = item.getCourse_id();
                    // read item.lessons_time
                    itemLessonsTime = item.getLessons_time();
                    // read item.course_name
                    itemCourseName = item.getCourse_name();
                }


                if (itemAttendanceState != null) {
                    // read item.attendance_state.equals("出勤")
                    itemAttendanceStateEqualsJavaLangString = itemAttendanceState.equals("出勤");
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(itemAttendanceStateEqualsJavaLangString) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
                // read (item.attendance_time) + (" 第")
                itemAttendanceTimeJavaLangString = (itemAttendanceTime) + (" 第");
                // read (item.course_name) + (item.course_id)
                itemCourseNameItemCourseId = (itemCourseName) + (itemCourseId);


                // read item.attendance_state.equals("出勤") ? 0xFF00D809 : 0xFFE53935
                itemAttendanceStateEqualsJavaLangStringInt0xFF00D809Int0xFFE53935 = ((itemAttendanceStateEqualsJavaLangString) ? (0xFF00D809) : (0xFFE53935));
                // read ((item.attendance_time) + (" 第")) + (item.lessons_time)
                itemAttendanceTimeJavaLangStringItemLessonsTime = (itemAttendanceTimeJavaLangString) + (itemLessonsTime);


                // read (((item.attendance_time) + (" 第")) + (item.lessons_time)) + ("大节")
                itemAttendanceTimeJavaLangStringItemLessonsTimeJavaLangString = (itemAttendanceTimeJavaLangStringItemLessonsTime) + ("大节");
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, itemAttendanceTimeJavaLangStringItemLessonsTimeJavaLangString);
            this.mboundView3.setTextColor(itemAttendanceStateEqualsJavaLangStringInt0xFF00D809Int0xFFE53935);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, itemAttendanceState);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView12, itemCourseNameItemCourseId);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
        flag 2 (0x3L): item.attendance_state.equals("出勤") ? 0xFF00D809 : 0xFFE53935
        flag 3 (0x4L): item.attendance_state.equals("出勤") ? 0xFF00D809 : 0xFFE53935
    flag mapping end*/
    //end
}