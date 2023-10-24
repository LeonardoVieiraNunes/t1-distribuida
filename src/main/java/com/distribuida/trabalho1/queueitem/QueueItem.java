package com.distribuida.trabalho1.queueitem;

public class QueueItem implements Comparable<QueueItem> {
    private final String task_message;
    private final int priority;

    public QueueItem(String task_message, int priority) {
        this.task_message = task_message;
        this.priority = priority;
    }

    public String getTask_message() {
        return task_message;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(QueueItem o) {
        return priority - o.getPriority();
    }
}
