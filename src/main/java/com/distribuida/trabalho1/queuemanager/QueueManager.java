package com.distribuida.trabalho1.queuemanager;

import com.distribuida.trabalho1.queue.PriorityQueue;
import com.distribuida.trabalho1.queueitem.QueueItem;

import static java.util.Objects.nonNull;

public class QueueManager {
    PriorityQueue queue;
    public QueueManager() {
        queue = new PriorityQueue();

    }

    public synchronized void send(String message_text, int message_priority) {
        //TODO check
        QueueItem message = new QueueItem(message_text, message_priority);
        queue.add(message);
    }


    public synchronized String receive() {
        QueueItem removed = queue.remove();
        if (nonNull(removed)) {
            return removed.getTask_message();
        }
        return "null";
    }
}
