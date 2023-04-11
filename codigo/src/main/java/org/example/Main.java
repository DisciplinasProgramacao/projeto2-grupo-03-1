package org.example;

import org.example.domain.Grafo;
import org.example.domain.GrafoMutavel;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GrafoMutavel grafo = new GrafoMutavel("MeuGrafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(1, 3, 3);
        grafo.addAresta(2, 3, 1);
        grafo.salvar("grafo");


    }
}