package org.example;

import org.example.domain.Grafo;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo("Grafo");
        try {
            carregarGrafo(grafo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}