package org.example.domain;

public class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }

    public boolean addVertice(int id) {
        return false;
    }

    public Vertice removeVertice(int id) {
        return new Vertice(-1);
    }

    public boolean addAresta(int origem, int destino) {
        return false;
    }

    public Aresta removeAresta(int id, int destino) {
        return new Aresta(-1, -2);
    }

    public void carregar(String nomeArquivo) {

    }


    public void salvar(String nomeArquivo) {

    }

    
}