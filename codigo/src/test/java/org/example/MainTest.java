package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.Grafo;
import org.example.domain.GrafoCompleto;
import org.example.domain.GrafoMutavel;
import org.example.domain.Vertice;

class MainTest {
    GrafoMutavel grafo;

    @BeforeEach
    public void setUp() {
        grafo = new GrafoMutavel("MeuGrafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(1, 3, 3);
        grafo.addAresta(2, 3, 1);
    }

    @Test
    void testSalvarGrafo() {
        grafo.salvar("grafo_salvo.txt");
        
    }

    @Test
    public void testBFS() {

    }
}