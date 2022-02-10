package com.test.vergo.dto;

import java.util.Objects;

public class TaskDTO {

    public TaskDTO(){

    }

    private int id;
    private String description;
    private int status;
    private int assigne;
    private int priority;
    private String statusName;
    private String assigneName;
    private String priorityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAssigne() {
        return assigne;
    }

    public void setAssigne(int assigne) {
        this.assigne = assigne;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAssigneName() {
        return assigneName;
    }

    public void setAssigneName(String assigneName) {
        this.assigneName = assigneName;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return id == taskDTO.id &&
                status == taskDTO.status &&
                assigne == taskDTO.assigne &&
                priority == taskDTO.priority &&
                Objects.equals(description, taskDTO.description) &&
                Objects.equals(statusName, taskDTO.statusName) &&
                Objects.equals(assigneName, taskDTO.assigneName) &&
                Objects.equals(priorityName, taskDTO.priorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status, assigne, priority, statusName, assigneName, priorityName);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", assigne=" + assigne +
                ", priority=" + priority +
                ", statusName='" + statusName + '\'' +
                ", assigneName='" + assigneName + '\'' +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }
}
