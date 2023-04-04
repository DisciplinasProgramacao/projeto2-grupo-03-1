package org.example.domain;

public class GrafoDirecionado extends GrafoMutavel {

    public GrafoDirecionado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        return false;
    }

    @Override
    public Aresta removeAresta(int id, int destino) {
        return new Aresta(-1, -2);
    }

}