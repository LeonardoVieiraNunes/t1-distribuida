package com.distribuida.trabalho1.queue;

import com.distribuida.trabalho1.queueitem.QueueItem;

import java.util.*;

public class PriorityQueue {
    public int size;
    private LinkedList<QueueItem> queue = new LinkedList<>() ;

    public QueueItem remove() {
        if (isEmpty()) {
            return null;
        }

        return queue.removeFirst();
    }

    public void add(QueueItem t) {

        if (queue.isEmpty()) {
            queue.add(t);
            return;
        }
        var insert_index = 0;
        while (insert_index < queue.size()){
            QueueItem next_item = queue.get(insert_index);
            int compare = t.compareTo(next_item);
            if (compare > 0) {
                queue.add(insert_index, t);
                return;
            }
            insert_index++;
        }
        queue.addLast(t);


    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }
}
