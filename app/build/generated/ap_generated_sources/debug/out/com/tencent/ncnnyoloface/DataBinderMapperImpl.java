package com.tencent.ncnnyoloface;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tencent.ncnnyoloface.databinding.ActivityAttendanceInquiryBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStartBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStudentAttendanceRecordBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStudentCourseBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStudentLoginBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStudentMainBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityStudentRegisterBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherCourseBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherLoginBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherMainBindingImpl;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherRegisterBindingImpl;
import com.tencent.ncnnyoloface.databinding.DialogCreateCourseBindingImpl;
import com.tencent.ncnnyoloface.databinding.DialogJoinInCourseBindingImpl;
import com.tencent.ncnnyoloface.databinding.DialogStartAttendanceBindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentAttendanceInquiry1BindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentAttendanceInquiry2BindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentHome2BindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentHomeBindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentMineBindingImpl;
import com.tencent.ncnnyoloface.databinding.FragmentTeacherMineBindingImpl;
import com.tencent.ncnnyoloface.databinding.ItemAttendanceInquireCourseBeanMessageBindingImpl;
import com.tencent.ncnnyoloface.databinding.ItemInquireCourseBeanMessageBindingImpl;
import com.tencent.ncnnyoloface.databinding.ItemInquireCourseJoinBeanMessageBindingImpl;
import com.tencent.ncnnyoloface.databinding.ItemStudentAttendanceBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYATTENDANCEINQUIRY = 1;

  private static final int LAYOUT_ACTIVITYSTART = 2;

  private static final int LAYOUT_ACTIVITYSTUDENTATTENDANCERECORD = 3;

  private static final int LAYOUT_ACTIVITYSTUDENTCOURSE = 4;

  private static final int LAYOUT_ACTIVITYSTUDENTLOGIN = 5;

  private static final int LAYOUT_ACTIVITYSTUDENTMAIN = 6;

  private static final int LAYOUT_ACTIVITYSTUDENTREGISTER = 7;

  private static final int LAYOUT_ACTIVITYTEACHERCOURSE = 8;

  private static final int LAYOUT_ACTIVITYTEACHERLOGIN = 9;

  private static final int LAYOUT_ACTIVITYTEACHERMAIN = 10;

  private static final int LAYOUT_ACTIVITYTEACHERREGISTER = 11;

  private static final int LAYOUT_DIALOGCREATECOURSE = 12;

  private static final int LAYOUT_DIALOGJOININCOURSE = 13;

  private static final int LAYOUT_DIALOGSTARTATTENDANCE = 14;

  private static final int LAYOUT_FRAGMENTATTENDANCEINQUIRY1 = 15;

  private static final int LAYOUT_FRAGMENTATTENDANCEINQUIRY2 = 16;

  private static final int LAYOUT_FRAGMENTHOME = 17;

  private static final int LAYOUT_FRAGMENTHOME2 = 18;

  private static final int LAYOUT_FRAGMENTMINE = 19;

  private static final int LAYOUT_FRAGMENTTEACHERMINE = 20;

  private static final int LAYOUT_ITEMATTENDANCEINQUIRECOURSEBEANMESSAGE = 21;

  private static final int LAYOUT_ITEMINQUIRECOURSEBEANMESSAGE = 22;

  private static final int LAYOUT_ITEMINQUIRECOURSEJOINBEANMESSAGE = 23;

  private static final int LAYOUT_ITEMSTUDENTATTENDANCE = 24;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(24);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_attendance_inquiry, LAYOUT_ACTIVITYATTENDANCEINQUIRY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_start, LAYOUT_ACTIVITYSTART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_student__attendance_record, LAYOUT_ACTIVITYSTUDENTATTENDANCERECORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_student_course, LAYOUT_ACTIVITYSTUDENTCOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_student_login, LAYOUT_ACTIVITYSTUDENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_student_main, LAYOUT_ACTIVITYSTUDENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_student_register, LAYOUT_ACTIVITYSTUDENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_teacher_course, LAYOUT_ACTIVITYTEACHERCOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_teacher_login, LAYOUT_ACTIVITYTEACHERLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_teacher_main, LAYOUT_ACTIVITYTEACHERMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.activity_teacher_register, LAYOUT_ACTIVITYTEACHERREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.dialog_create_course, LAYOUT_DIALOGCREATECOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.dialog_join_in_course, LAYOUT_DIALOGJOININCOURSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.dialog_start_attendance, LAYOUT_DIALOGSTARTATTENDANCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_attendance_inquiry1, LAYOUT_FRAGMENTATTENDANCEINQUIRY1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_attendance_inquiry2, LAYOUT_FRAGMENTATTENDANCEINQUIRY2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_home2, LAYOUT_FRAGMENTHOME2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_mine, LAYOUT_FRAGMENTMINE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.fragment_teacher_mine, LAYOUT_FRAGMENTTEACHERMINE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.item_attendance_inquire_course_bean__message, LAYOUT_ITEMATTENDANCEINQUIRECOURSEBEANMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.item_inquire_course_bean__message, LAYOUT_ITEMINQUIRECOURSEBEANMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.item_inquire_course_join_bean__message, LAYOUT_ITEMINQUIRECOURSEJOINBEANMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.tencent.ncnnyoloface.R.layout.item_student_attendance, LAYOUT_ITEMSTUDENTATTENDANCE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYATTENDANCEINQUIRY: {
          if ("layout/activity_attendance_inquiry_0".equals(tag)) {
            return new ActivityAttendanceInquiryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_attendance_inquiry is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTART: {
          if ("layout/activity_start_0".equals(tag)) {
            return new ActivityStartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_start is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTATTENDANCERECORD: {
          if ("layout/activity_student__attendance_record_0".equals(tag)) {
            return new ActivityStudentAttendanceRecordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student__attendance_record is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTCOURSE: {
          if ("layout/activity_student_course_0".equals(tag)) {
            return new ActivityStudentCourseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_course is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTLOGIN: {
          if ("layout/activity_student_login_0".equals(tag)) {
            return new ActivityStudentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTMAIN: {
          if ("layout/activity_student_main_0".equals(tag)) {
            return new ActivityStudentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTREGISTER: {
          if ("layout/activity_student_register_0".equals(tag)) {
            return new ActivityStudentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEACHERCOURSE: {
          if ("layout/activity_teacher_course_0".equals(tag)) {
            return new ActivityTeacherCourseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_teacher_course is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEACHERLOGIN: {
          if ("layout/activity_teacher_login_0".equals(tag)) {
            return new ActivityTeacherLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_teacher_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEACHERMAIN: {
          if ("layout/activity_teacher_main_0".equals(tag)) {
            return new ActivityTeacherMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_teacher_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEACHERREGISTER: {
          if ("layout/activity_teacher_register_0".equals(tag)) {
            return new ActivityTeacherRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_teacher_register is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCREATECOURSE: {
          if ("layout/dialog_create_course_0".equals(tag)) {
            return new DialogCreateCourseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_create_course is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGJOININCOURSE: {
          if ("layout/dialog_join_in_course_0".equals(tag)) {
            return new DialogJoinInCourseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_join_in_course is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGSTARTATTENDANCE: {
          if ("layout/dialog_start_attendance_0".equals(tag)) {
            return new DialogStartAttendanceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_start_attendance is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTATTENDANCEINQUIRY1: {
          if ("layout/fragment_attendance_inquiry1_0".equals(tag)) {
            return new FragmentAttendanceInquiry1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_attendance_inquiry1 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTATTENDANCEINQUIRY2: {
          if ("layout/fragment_attendance_inquiry2_0".equals(tag)) {
            return new FragmentAttendanceInquiry2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_attendance_inquiry2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME2: {
          if ("layout/fragment_home2_0".equals(tag)) {
            return new FragmentHome2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMINE: {
          if ("layout/fragment_mine_0".equals(tag)) {
            return new FragmentMineBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mine is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTEACHERMINE: {
          if ("layout/fragment_teacher_mine_0".equals(tag)) {
            return new FragmentTeacherMineBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_teacher_mine is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMATTENDANCEINQUIRECOURSEBEANMESSAGE: {
          if ("layout/item_attendance_inquire_course_bean__message_0".equals(tag)) {
            return new ItemAttendanceInquireCourseBeanMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_attendance_inquire_course_bean__message is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINQUIRECOURSEBEANMESSAGE: {
          if ("layout/item_inquire_course_bean__message_0".equals(tag)) {
            return new ItemInquireCourseBeanMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_inquire_course_bean__message is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINQUIRECOURSEJOINBEANMESSAGE: {
          if ("layout/item_inquire_course_join_bean__message_0".equals(tag)) {
            return new ItemInquireCourseJoinBeanMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_inquire_course_join_bean__message is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSTUDENTATTENDANCE: {
          if ("layout/item_student_attendance_0".equals(tag)) {
            return new ItemStudentAttendanceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_student_attendance is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "click");
      sKeys.put(2, "course");
      sKeys.put(3, "item");
      sKeys.put(4, "svm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(24);

    static {
      sKeys.put("layout/activity_attendance_inquiry_0", com.tencent.ncnnyoloface.R.layout.activity_attendance_inquiry);
      sKeys.put("layout/activity_start_0", com.tencent.ncnnyoloface.R.layout.activity_start);
      sKeys.put("layout/activity_student__attendance_record_0", com.tencent.ncnnyoloface.R.layout.activity_student__attendance_record);
      sKeys.put("layout/activity_student_course_0", com.tencent.ncnnyoloface.R.layout.activity_student_course);
      sKeys.put("layout/activity_student_login_0", com.tencent.ncnnyoloface.R.layout.activity_student_login);
      sKeys.put("layout/activity_student_main_0", com.tencent.ncnnyoloface.R.layout.activity_student_main);
      sKeys.put("layout/activity_student_register_0", com.tencent.ncnnyoloface.R.layout.activity_student_register);
      sKeys.put("layout/activity_teacher_course_0", com.tencent.ncnnyoloface.R.layout.activity_teacher_course);
      sKeys.put("layout/activity_teacher_login_0", com.tencent.ncnnyoloface.R.layout.activity_teacher_login);
      sKeys.put("layout/activity_teacher_main_0", com.tencent.ncnnyoloface.R.layout.activity_teacher_main);
      sKeys.put("layout/activity_teacher_register_0", com.tencent.ncnnyoloface.R.layout.activity_teacher_register);
      sKeys.put("layout/dialog_create_course_0", com.tencent.ncnnyoloface.R.layout.dialog_create_course);
      sKeys.put("layout/dialog_join_in_course_0", com.tencent.ncnnyoloface.R.layout.dialog_join_in_course);
      sKeys.put("layout/dialog_start_attendance_0", com.tencent.ncnnyoloface.R.layout.dialog_start_attendance);
      sKeys.put("layout/fragment_attendance_inquiry1_0", com.tencent.ncnnyoloface.R.layout.fragment_attendance_inquiry1);
      sKeys.put("layout/fragment_attendance_inquiry2_0", com.tencent.ncnnyoloface.R.layout.fragment_attendance_inquiry2);
      sKeys.put("layout/fragment_home_0", com.tencent.ncnnyoloface.R.layout.fragment_home);
      sKeys.put("layout/fragment_home2_0", com.tencent.ncnnyoloface.R.layout.fragment_home2);
      sKeys.put("layout/fragment_mine_0", com.tencent.ncnnyoloface.R.layout.fragment_mine);
      sKeys.put("layout/fragment_teacher_mine_0", com.tencent.ncnnyoloface.R.layout.fragment_teacher_mine);
      sKeys.put("layout/item_attendance_inquire_course_bean__message_0", com.tencent.ncnnyoloface.R.layout.item_attendance_inquire_course_bean__message);
      sKeys.put("layout/item_inquire_course_bean__message_0", com.tencent.ncnnyoloface.R.layout.item_inquire_course_bean__message);
      sKeys.put("layout/item_inquire_course_join_bean__message_0", com.tencent.ncnnyoloface.R.layout.item_inquire_course_join_bean__message);
      sKeys.put("layout/item_student_attendance_0", com.tencent.ncnnyoloface.R.layout.item_student_attendance);
    }
  }
}
