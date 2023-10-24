package com.distribuida.trabalho1.workers;

import com.distribuida.trabalho1.cliente.ClienteModel;
import com.distribuida.trabalho1.enums.Prioridade;
import com.distribuida.trabalho1.queuemanager.QueueManager;
import org.springframework.web.client.RestTemplate;


public class WorkerService {


    public void request() {
        RestTemplate restTemplate = new RestTemplate();
        String received = restTemplate.getForObject("http://localhost:8080/cliente/fila", String.class);
        String toprint;
        assert received != null;
        if (received.isEmpty()) toprint = "Fila vazia!";
        else toprint = "Requisição recebida de " + received;
        System.out.println(toprint);
//        System.out.println("stub");

    }

    public void sendBack(String clientName) {
        // TODO
    }
}
