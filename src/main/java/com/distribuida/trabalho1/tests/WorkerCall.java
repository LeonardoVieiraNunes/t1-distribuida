package com.distribuida.trabalho1.tests;


import com.distribuida.trabalho1.cliente.ClienteModel;
import com.distribuida.trabalho1.queuemanager.QueueManager;
import com.distribuida.trabalho1.workers.WorkerService;
import org.springframework.web.client.RestTemplate;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerCall {

    public static void main(String[] args) {

        // Crie um ExecutorService com duas threads
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Execute as duas threads simultaneamente
        executorService.execute(WorkerCall::makeCalls);


        // Aguarde a conclusão das threads
        executorService.shutdown();
    }

    private static void makeCalls() {
        WorkerService workerService = new WorkerService();
        int tries = 0;
        while (tries <= 100) {
            workerService.request();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tries++;
        }
    }
}
