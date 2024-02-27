package com.tulesh.springboot.service;

import com.tulesh.springboot.model.Task;

public interface TaskNotificationService {

    public void sendTaskNotifications();

    public void sendEmailNotification(Task task);
}
