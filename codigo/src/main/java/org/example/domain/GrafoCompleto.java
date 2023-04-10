package org.example.domain;

public class GrafoCompleto extends Grafo {


    /**
     * Construtor. Cria um grafo completo com um nome que fala sua ordem. 
     */
    public GrafoCompleto(int ordem) {
        super("Grafo completo - ordem " + ordem);

        ordem = ordem + 1;
        for(int i = 1; i < ordem; i++) {
            addVertice(i);
        }

        for(int i = 1; i < ordem; i++) {
            if(existeVertice(i) != null) {
                Vertice saida = existeVertice(i);
                for(int j = 1; j < ordem; j++) {
                    if (i != j) {
                        Vertice destino = existeVertice(j);

                        if(destino != null){
                            saida.addAresta(j);
                        }
                    }
                }
            }
        }
    }

}