package com.scott.transer.handler;

import android.text.TextUtils;

import com.scott.annotionprocessor.ITask;
import com.scott.annotionprocessor.TaskType;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2017-12-14 15:29</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:
 *      该类是 当前保存的任务列表 的 item
 * </p>
 */

public class TaskHandlerHolder implements ITaskHandlerHolder {

    private ITaskHandler mHandler;
    private ITask mTask;

    @Override
    public ITask getTask() {
        if(mHandler != null && mHandler.getTask() != null) {
            return mHandler.getTask();
        }
        return mTask;
    }

    @Override
    public void setTask(ITask task) {
        mTask = task;
    }

    @Override
    public TaskType getType() {
        if(mHandler == null) {
            return  mTask.getType();
        }
        return mHandler.getType();
    }

    @Override
    public void setTaskHandler(ITaskHandler handler) {
        mHandler = handler;
        if(handler != null) {
            mHandler.setTask(mTask);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ITaskHandlerHolder)) {
            return false;
        }

        ITaskHandlerHolder holder = (ITaskHandlerHolder) obj;
        return TextUtils.equals(mTask.getTaskId(),holder.getTask().getTaskId());
    }

    @Override
    public ITaskHandler getTaskHandler() {
        return mHandler;
    }
}
