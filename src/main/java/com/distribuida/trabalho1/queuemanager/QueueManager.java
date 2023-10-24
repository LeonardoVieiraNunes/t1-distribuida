package com.distribuida.trabalho1.queuemanager;

import com.distribuida.trabalho1.queue.PriorityQueue;
import com.distribuida.trabalho1.queueitem.QueueItem;

public class QueueManager {
    PriorityQueue queue;
    public QueueManager() {
        queue = new PriorityQueue();
    }



    public synchronized void send(String message_text) {
        //TODO check
        QueueItem message = new QueueItem(message_text, 1);
        queue.add(message);
    }


    public synchronized String receive() {
        //TODO check
        return queue.remove().getTask_message();
    }
}
