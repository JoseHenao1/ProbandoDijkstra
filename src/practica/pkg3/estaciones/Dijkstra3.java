/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3.estaciones;

import java.util.*;

class Dijkstra {

    //similar a los defines de C++
    private final int MAX = 10005;  
    private final int INF = 1 << 30;  

    private List< List< Node>> ady = new ArrayList< List< Node>>(); 
    private int distancia[] = new int[MAX];          
    private boolean visitado[] = new boolean[MAX];   
    private PriorityQueue< Node> Q = new PriorityQueue<Node>();
    private int nEstaciones;                                      
    private int previo[] = new int[MAX];              
    private boolean dijkstraEjecutado;
    private int destino;
    private String salida = "";

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    Dijkstra(int V) {
        this.nEstaciones = V;
        for (int i = 0; i <= V; ++i) {
            ady.add(new ArrayList<Node>()); 
        }
        dijkstraEjecutado = false;
    }

    //En el caso de java usamos una clase que representara el pair de C++
    class Node implements Comparable<Node> {

        int first, second;

        Node(int d, int p) {                          
            this.first = d;
            this.second = p;
        }

        public int compareTo(Node other) {             
            if (second > other.second) {
                return 1;
            }
            if (second == other.second) {
                return 0;
            }
            return -1;
        }
    };

    //función de inicialización
    private void init() {
        for (int i = 0; i <= nEstaciones; ++i) {
            distancia[i] = INF;  
            visitado[i] = false; 
            previo[i] = -1;      
        }
    }

    //Paso de relajacion
    private void relajacion(int actual, int adyacente, int peso) {
        if (distancia[actual] + peso < distancia[adyacente]) {
            distancia[adyacente] = distancia[actual] + peso; 
            previo[adyacente] = actual; 
            Q.add(new Node(adyacente, distancia[adyacente]));
        }
    }

    void dijkstra(int inicial) {
        init();
        Q.add(new Node(inicial, 0)); 
        distancia[inicial] = 0;
        int actual, adyacente, peso;
        while (!Q.isEmpty()) {             
            actual = Q.element().first;           
            Q.remove();
            if (visitado[actual]) {
                continue;
            }
            visitado[actual] = true;

            for (int i = 0; i < ady.get(actual).size(); ++i) {
                adyacente = ady.get(actual).get(i).first;
                peso = ady.get(actual).get(i).second;
                if (!visitado[adyacente]) {
                    relajacion(actual, adyacente, peso);
                }
            }
        }

        System.out.printf("Distancias mas cortas iniciando en vertice %d\n", inicial);
        for (int i = 1; i <= nEstaciones; ++i) {
            System.out.printf("Vertice %d , distancia mas corta = %d\n", i, distancia[i]);
        }
        dijkstraEjecutado = true;
    }

    void addEdge(int origen, int destino, int costos, boolean dirigido) {
        ady.get(origen).add(new Node(destino, costos));
        if (!dirigido) {
            ady.get(destino).add(new Node(origen, costos));
        }
    }

    String printShortestPath() {
        if (!dijkstraEjecutado) {
            return ("Es necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");
        }
        String salida = print(this.destino);
        return salida;
    }

    String print(int destino) {
        if (previo[destino] != -1)
        {
            print(previo[destino]);
        }
        System.out.printf("%d ", destino + 1);
        salida += (destino + 1) + " ";
        return salida;
    }
}
