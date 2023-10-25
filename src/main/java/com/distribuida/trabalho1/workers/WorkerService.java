package com.distribuida.trabalho1.workers;


import org.springframework.web.client.RestTemplate;


public class WorkerService {


    public void request() {
        RestTemplate restTemplate = new RestTemplate();
        String received = restTemplate.getForObject("http://localhost:8080/cliente/fila", String.class);
        String toprint;
        if (received != null) {
            if (received.isEmpty()) toprint = "Fila vazia!";
            else toprint = "Requisição recebida de " + received;
            System.out.println(toprint);
        } else {System.out.println("Fila vazia!");}
//        System.out.println("stub");

    }

//    public void sendBack(String clientName) {
//        // TODO
//    }
}
