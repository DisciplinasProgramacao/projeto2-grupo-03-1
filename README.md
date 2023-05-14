[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10527339)
# Algoritmos em Grafos
Os Grafos podem ser usados para resolver diversos problemas de relacionamento entre grandes conjuntos de dados, de modo que retorne alguma informação mais útil ao usuário. Sendo assimo, nosso objetivo é criar um algoritmo capaz de agilizar o processo de utilização dos grafos.

## Correção e comentários

### Nota: 11,5

Grafo de teste

![Grafo de teste](docs/grafoTeste.png)

---

- UML presente é da primeira iteração
- Sem instrução de uso de onde procurar os arquivos (e com valor literal no código)
- Grafo direcionado adiciona aresta contrária (e atrapalha o grau)
- Não carrega grafo
- Tamanho retorna só arestas (tamanho -> vertices+arestas)
- BFS retorna o próprio grafo, já que todos são visitados. Devia fazer um sugrafo com as arestas de visita.
- DFS só pega 0 e 1.
- Documentação vazia em algumas classes.

---

- Aderência às classes do diagrama: 1/2 pontos
  - Método DFS com outro nome.

- Requisitos de grafos corretamente implementados: 8/12 pontos
  - Carregar/salvar		1/2 pontos
  - Grafo completo e subgrafo 3/3 pontos
  - Grafo ponderado/não ponderado 2/2 pontos
  - Busca em largura e profundidade 1/4 pontos
  - App para uso 0/1 ponto
- Documentação de código: 2/4 pontos
  - UML antiga
- Testes (quantidade e qualidade): 0,5/2 pontos
  - Só buscas, e deixou passar erro.


## Alunos integrantes da equipe

* Augusto Baldiotti Mendonça Alvares
* Caio Elias Rodrigues Araujo
* Daniel de Rezende Leão
* Vitor Lany Freitas Ferreira

## Professores responsáveis

* João Caram Santos de Oliveira

