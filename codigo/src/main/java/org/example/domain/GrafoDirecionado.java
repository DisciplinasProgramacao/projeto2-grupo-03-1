package org.example.domain;

public class GrafoDirecionado extends GrafoMutavel {

    public GrafoDirecionado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        return super.addAresta(origem, destino, peso) ;
    }

    @Override
    public Aresta removeAresta(int id, int destino) {
        return super.removeAresta(id, destino);
    }
}