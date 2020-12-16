/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3.estaciones;

import com.logicayrepresentacion.grafos.practicaestaciones.Costo;
import java.util.*;

class Dijkstra {

    private final int MAX = 1000;  
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
    private int visitados[];
    
    private int [][]mat;
    private final int[][] matrizAdy;
    
    public void addAdyancencia(int vi, int vj, int distancia) {
        matrizAdy[vi][vj] = 1;
        matrizAdy[vj][vi] = 1;
        mat[vi][vj] = distancia;
        mat[vj][vi] = distancia;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }
    
    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
    /*Dijkstra(){
        
    }*/ 
    
    Dijkstra(int V) {
        this.nEstaciones = V;
        matrizAdy = new int[V][V];
        mat = new int[V][V];
        dijkstraEjecutado = false;
    }
    
    public /*Costo[]*/void dijkstra(int inicial) {
        Costo[][] costos = new Costo[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (matrizAdy[i][j] == 0) {
                    costos[i][j] = Costo.getIndeterminado();
                } else {
                    costos[i][j] = new Costo(mat[i][j]);
                }
            }
        }

        visitados = new int[mat.length];
        Costo[] costoMinimo = new Costo[mat.length];
        for (int j = 0; j < mat.length; j++) {
            costoMinimo[j] = costos[inicial][j];
        }

        visitados[inicial] = 1;
        int indice = 0;
        while (indice < mat.length - 1) {
            int w = escogerMenor(costoMinimo, visitados);
            visitados[w] = 1;
            indice++;
            for (int j = 0; j < visitados.length; j++) {
                if (visitados[j] == 0) {
                    Costo costoJ = costoMinimo[j];
                    Costo distanciaWJ = costos[w][j];
                    Costo costo2 = Costo.sumar(costoMinimo[w], distanciaWJ);
                    costoMinimo[j] = Costo.menor(costoJ, costo2);
                }
            }
        }
        dijkstraEjecutado = true;
        //return costoMinimo;

    }
    
    private int escogerMenor(Costo[] costoMinimo, int[] visitados) {
        int w = 0;
        Costo minimow = costoMinimo[w];
        for (int j = 0; j < visitados.length; j++) {
            if (visitados[j] == 0) {
                Costo posiblemenor = Costo.menor(minimow, costoMinimo[j]);
                if (posiblemenor != minimow) {
                    minimow = posiblemenor;
                    w = j;
                }
            }
        }
        return w;
    }
 
    
    
    /*Dijkstra(int V) {
        this.nEstaciones = V;
        for (int i = 0; i <= V; ++i) {
            ady.add(new ArrayList<Node>()); 
        }
        dijkstraEjecutado = false;
    }*/

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
    private void inicializar() {
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

    /*void dijkstra(int inicial) {
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
    }*/

    void agregarBorde(int origen, int destino, int costos/*, boolean dirigido*/) {
        //ady.get(origen).add(new Node(destino, costos));
        matrizAdy[origen][destino] = costos;
        //setDestino(destino);
        /*if (!dirigido) {
            ady.get(destino).add(new Node(origen, costos));
        }*/
    }

    String imprimirRutaCorta() {
        if (!dijkstraEjecutado) {
            return ("Es necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");
        }
        String salida = imprimir(this.destino);
        return salida;
    }

    String imprimir(int destino) {
        /*if (previo[destino] != -1)
        {
            imprimir(previo[destino]);
        }*/
        System.out.println(destino);
        System.out.println(previo[destino]+"si");
        imprimir(previo[destino]);
        System.out.printf("%d ", destino + 1);
        salida += (destino + 1) + " ";
        return salida;
    }
}
