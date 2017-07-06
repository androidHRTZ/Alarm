package com.example.riven.alarmdemo;

/**
 * Created by Riven on 2017/7/6.
 * Email : 1819485687@qq.com
 */

public class AlarmInfo {

    private String id;
    private String joinId;
    private String customId;
    private String taskId;
    private int isRemind;
    private String remindTime;
    private String repeatWeekdays;
    private String remindRemark;
    private String lastDate;

    public void setId(String id) {
        this.id = id;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setIsRemind(int isRemind) {
        this.isRemind = isRemind;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }

    public void setRepeatWeekdays(String repeatWeekdays) {
        this.repeatWeekdays = repeatWeekdays;
    }

    public void setRemindRemark(String remindRemark) {
        this.remindRemark = remindRemark;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
