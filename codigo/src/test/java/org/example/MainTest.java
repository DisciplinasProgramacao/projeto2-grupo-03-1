package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.Grafo;

class MainTest {

    @Test
    void testExemplo() {
        fail("Está funcionando!");
    }

    @Test
    void testSalvarGrafo() {
        Grafo grafo = new Grafo("MeuGrafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(1, 3, 3);
        grafo.addAresta(2, 3, 1);
    
        grafo.salvar("grafo_salvo.txt");
        
    }

    @Test
    void testSalvarGrafoCompleto() {
        Grafo grafo = Grafo.grafoCompleto(5);
    
        grafo.salvar("grafo_salvo.txt");
        
    }
}