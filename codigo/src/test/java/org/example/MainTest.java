package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.example.domain.Grafo;
import org.example.domain.GrafoCompleto;
import org.example.domain.Vertice;

class MainTest {
    Grafo grafo;

    @BeforeEach
    public void setUp() {
        grafo = new Grafo("MeuGrafo");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(1, 3, 3);
        grafo.addAresta(2, 3, 1);
    }

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

    @Test
    public void testRemoveVertice() {
        assertNotNull(grafo.existeVertice(1));
        grafo.removeVertice(1);
        assertNull(grafo.existeVertice(1));
    }

    @Test
    public void testExisteVertice() {
        assertNotNull(grafo.existeVertice(2));
        grafo.removeVertice(2);
        assertNull(grafo.existeVertice(2));
    }

    @Test
    public void testRemoveAresta() {
        assertEquals(grafo.tamanho(), 3);
        grafo.removeAresta(1, 2);
        assertEquals(grafo.tamanho(), 2);
    }

    @Test
    public void testExisteAresta() {
        assertNotNull(grafo.existeAresta(1, 2));
        grafo.removeAresta(1, 2);
        assertNull(grafo.existeAresta(1, 2));
    }

    @Test
    public void testCompleto() {
        assertTrue(grafo.completo());
        grafo.removeAresta(1, 2);
        assertFalse(grafo.completo());
    }

    @Test
    public void testGetVertice() {
        assertNotNull(grafo.getVertice(1));
        grafo.removeVertice(1);
        assertNull(grafo.getVertice(1));
    }

    @Test
    public void testTamanho() {
        assertEquals(grafo.tamanho(), 3);
        grafo.removeAresta(1, 2);
        assertEquals(grafo.tamanho(), 2);
    }

    @Test
    public void testOrdem() {
        assertEquals(grafo.ordem(), 3);
        grafo.removeVertice(1);
        assertEquals(grafo.ordem(), 2);
    }

    @Test
    public void testGrafoCompleto() {
        Grafo grafoCompleto = new GrafoCompleto(4);
        assertEquals(grafoCompleto.ordem(), 4);
        assertEquals(grafoCompleto.tamanho(), 6);
    }

    @Test
    public void testVizinhos() {
        Vertice v = grafo.getVertice(2);
        Integer arest[] = new Integer[v.vizinhos().size()];
        arest = v.vizinhos().allElements(arest);
        Integer result[] = new Integer[2];
        result[0]=1;
        result[1]=3;
        for(int i=0; i<v.vizinhos().size(); i++) {
            assertEquals(arest[i], result[i]);
        }
    }
}