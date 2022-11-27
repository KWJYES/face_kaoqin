package com.callback;

import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;

public interface StartAttendanceDialogListener {
    void attendance(InputAttendanceRecordBean bean);
}
