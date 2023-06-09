package org.example.domain;
/**
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;
    private LinkedList<Integer> adj[]; // lista de adjacência

    public static Grafo grafoCompleto(int ordem) {
        Grafo g = new Grafo("Completo");
        for(int i = 1; i != ordem; i++) {
            g.addVertice(i);
            for(int j = ordem; j > i; j--) {
                g.addAresta(i, j, 0);
            }
        }
        return g;
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        if(nome.length()==0)
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     * @return O nome do grafo (uma string)
     */
    public String nome(){
        return this.nome;
    }

    /**
     * Adiciona um método para ler o grafo, arestas e vértices presentes no arquivo
     * @param nomeArquivo
     * @throws IOException
     */
    public void carregar(String nomeArquivo) throws IOException {
        Path path = Paths.get("./data/" + nomeArquivo + ".txt").normalize();
        Pattern pattern = Pattern.compile("\\d+");

        for (String line : Files.readAllLines(path)) {
            Matcher matcher = pattern.matcher(line);
            List<Integer> list = new LinkedList<>();

            while (matcher.find()) {
                String group = matcher.group();
                list.add(Integer.valueOf(group));
            }

            this.addVertice(list.get(0));
            this.addVertice(list.get(1));

            this.addAresta(list.get(0), list.get(1), list.get(2));
        }
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo.
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = (saida.addAresta(destino, peso)&&chegada.addAresta(origem, peso));
        }
        return adicionou;

    }


    public Aresta removeAresta(int origem, int destino){
        Vertice vertA = this.existeVertice(origem);
        Vertice vertB = this.existeVertice(destino);
        Aresta aresta = existeAresta(origem, destino);
        if (aresta != null) {
            vertB.removeAresta(origem);
            return vertA.removeAresta(destino);
        }
        return null;
    }

    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice vertA = this.existeVertice(verticeA);
        Vertice vertB = this.existeVertice(verticeB);
        if(vertA != null && vertB != null){
            Aresta aresta = vertA.existeAresta(verticeB);
            if(aresta != null)
                return aresta;
        }
        return null;
    }


    public boolean completo(){
        return ordem() * (ordem() - 1) == tamanho() * 2;
    }

    public Vertice getVertice(int vertice) {
        return this.vertices.find(vertice);
    }

    public GrafoMutavel subGrafo(Lista<Integer> vertices){
        GrafoMutavel subgrafo = new GrafoMutavel("Subgrafo de " + this.nome);
        //Vertice[] listaVertices = this.vertices.allElements(new Vertice[this.vertices.size()]);

        //coleta os indices da lista-parametro
        Integer todos[] = new Integer[vertices.size()];
        todos = vertices.allElements(todos);
        
        //cria os vertices da lista no subgrafo

        for (int i = 0; i < todos.length; i++){
            subgrafo.addVertice(todos[i]);
        }

        //para cada vertice da lista
        for (Integer id : todos) {
            
            //pergutamos se tem aresta para os outros da lista no grafo original
            for (Integer idOutro : todos) {
                if(idOutro!=id){
                    Aresta qual = this.existeAresta(id, idOutro);
                    if( qual !=null){
                        subgrafo.addAresta(id, idOutro, qual.peso());   //se tiver, adiciona no subg
                    }
                }
            }
        }
       
          return subgrafo;  

    }


    /**
     * Retorna o número de arestas do grafo (tamanho)
     * 
     * @return O tamanho do grafo
     */
    public int tamanho(){
        int cont = 0;

        Vertice aV[] = new Vertice[vertices.size()];
        vertices.allElements(aV);
        for (Vertice v : aV) {
            cont += v.grau();
        }
        return cont/2;
    }


    /** 
     * Retorna o número de vértices do grafo (ordem)
     * 
     * @return A ordem do grafo
     */
    public int ordem(){
        return this.vertices.size();
    }

    
    // executa a busca em profundidade 
    public GrafoMutavel buscaProfundidade(int idVertice) {
        GrafoMutavel DFS = new GrafoMutavel("A");
        DFS.addVertice(idVertice);
        vertices.find(idVertice).visitar();
        Integer[] vizinhos = new Integer[vertices.find(idVertice).vizinhos().size()];
        vertices.find(idVertice).vizinhos().allElements(vizinhos);
        for (int vizinho : vizinhos) {
            if (!vertices.find(vizinho).visitado()) {
                DFS.addVertice(vizinho);
                Vertice v = vertices.find(vizinho);
                v.visitar();
                DFS.addAresta(idVertice, vizinho);
                buscaProfundidade(vizinho);
            }
        }
        return DFS;
    }
    


/*
 * Realiza a busca em largura
 */
    public GrafoMutavel BFS(int idVertice) {
        //Cria uma lista de vértices, uma de vizinhos de cada vértice e adciona o vertice inicial de busca
        Lista<Integer> listaVisitados = new Lista<>();
        listaVisitados.add(idVertice);
        LinkedList<Integer> fila = new LinkedList<>();
        fila.add(idVertice);

        while (fila.size() != 0) {
            idVertice = fila.poll();
            Integer[] vizinhos = new Integer[vertices.find(idVertice).vizinhos().size()];
            vertices.find(idVertice).vizinhos().allElements(vizinhos);
            
            for (int i = 0; i < vizinhos.length; i++) {
                int vertice = vizinhos[i];
                
                if(!vertices.find(vertice).visitado()) {
                    vertices.find(vertice).visitar();
                    fila.add(vertice);
                    listaVisitados.add(vertice);
                }
            }
        }
        return subGrafo(listaVisitados);                     
    }

}

