package org.example;

import org.example.domain.Grafo;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo("Grafo");
        try {
            grafo.carregar("graph-test-100");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}