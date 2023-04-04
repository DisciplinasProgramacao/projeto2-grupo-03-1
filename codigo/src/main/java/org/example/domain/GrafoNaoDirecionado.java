package org.example.domain;

public class GrafoNaoDirecionado extends GrafoMutavel {
    
    public GrafoNaoDirecionado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        return super.addAresta(origem, destino, peso) 
                && super.addAresta(destino, origem, peso);
    }

    @Override
    public Aresta removeAresta(int id, int destino) {
        super.removeAresta(destino, id);
        return super.removeAresta(id, destino);
    }
}
