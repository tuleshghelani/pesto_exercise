package com.tulesh.springboot.service.impl;

import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.repository.TaskRepository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskNotificationServiceimpl {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(cron = "0 0 1 * * ?") // Runs at 1:00 AM every day
    public void sendTaskNotifications() {
        System.out.println("sendTaskNotifications");
        LocalDate today = LocalDate.now();
        LocalDate twoDaysLater = today.plusDays(2);

        List<Task> tasksDueWithinTwoDays = taskRepository.findByDueDateBetween(today, twoDaysLater);

        for (Task task : tasksDueWithinTwoDays) {
            String subject = "Task Due Soon: " + task.getTitle();
            String text = "Hello,\n\nThis is a reminder that the task \"" + task.getTitle() +
                    "\" is due on " + task.getDueDate() + ".\n\nRegards,\nYour Application";

            sendEmailNotification(task, subject, text);
        }
    }


    public void sendEmailNotification(Task task, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(task.getCreatedBy().getEmail());
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        System.out.println("sendEmailNotification");
        javaMailSender.send(mailMessage);
    }
}
