package org.example.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id) {
        return super.addVertice(id);
    }

    /**
     * Remove um vértice do grafo
     */
    public Vertice removeVertice(int id) {
        return super.removeVertice(id);
    }

    /**
     * Adiciona aresta ao grafo
     */
    public boolean addAresta(int origem, int destino) {
        return super.addAresta(origem, destino, destino);
    }

    /**
     * Remove aresta do vértice
     */
    public Aresta removeAresta(int id, int destino) {
        return super.removeAresta(id, destino);
    }

    public void carregar(String nomeArquivo) {

    }

    public void salvar(String nomeArquivo) {
        File file = new File("./codigo/data/" + nomeArquivo + ".txt");
        
        try {
        	
			FileWriter fw = new FileWriter(file);

			Vertice[] arvoreVertices = vertices.allElements(new Vertice[] {});

	        for (Vertice vertice : arvoreVertices) {
	
	            Aresta[] todasArestas = vertice.todasAsArestas();
	
	            for (Aresta aresta : todasArestas) {
	
	                Vertice destino = new Vertice(aresta.destino());
	                
	                if (aresta.peso() == -1) {
	                	fw.write(vertice.getId() + " " + destino.getId()+ "\n");
	                } else {
	                	fw.write(vertice.getId() + " " + destino.getId() + " " + aresta.peso() + "\n");
	                }
	            }
	        }
	        
	        fw.close();
	        
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}