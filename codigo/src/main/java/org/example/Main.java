package org.example;

import org.example.domain.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo("Grafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addAresta(1, 2, 1);
        grafo.addAresta(2, 1, 2);
        grafo.addAresta(2, 3, 2);
        grafo.addAresta(2, 4, 2);
        grafo.addAresta(3, 4, 2);
        System.out.print(grafo.ordem());
        grafo.salvar("grafo");
    }
}