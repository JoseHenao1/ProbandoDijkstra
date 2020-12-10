
package practica.pkg3.estaciones;

import java.util.ArrayList;

//El ejecicio viene comentado explicando las instrucciones y metodos utilizados para realizar el algoritmo de prim
public class Algoritmo_Prim 
{
    public static int [][] Algoritmo_Prim(int [][] MatrizOriginal)
    {
        //Primeramente declaramos 3 Listas 
        ArrayList<Boolean> verticesVisitados = new ArrayList<Boolean>();
        ArrayList<Integer> distanciasRelativas = new ArrayList<Integer>();
        ArrayList<Integer> nodosAdyacentes = new ArrayList<Integer>();
        /**
        Inicializando Variables
        */
        for(Integer contador=0;contador < MatrizOriginal[0].length;contador++)
        {
            verticesVisitados.add(false);
            nodosAdyacentes.add(0);
            distanciasRelativas.add(Integer.MAX_VALUE);
        }
        distanciasRelativas.set(0, new Integer(0));
        /**
        Definicion del punto que sera la raiz del punto resultante
        */
        Integer puntoevaluado = 0;
        Integer Adyacentes = 0;
        /**
        Estructuras para ejecutar algoritmo de Prim
        */
        for(Integer contadorpuntoevaluado = 0;contadorpuntoevaluado < MatrizOriginal[0].length;contadorpuntoevaluado++)
        {
            for(Integer contadorAdyacentes = 0;contadorAdyacentes < MatrizOriginal[0].length;contadorAdyacentes++)
            {
                /**
                Verifica si el nodo a ser valorado en esta iteracion ha sido valorado anteriormente ;
                * si es asi, pasa para la siguiente iteracion
                */
                if((verticesVisitados.get(contadorAdyacentes)) || (contadorAdyacentes == puntoevaluado))
                {
                    continue;
                }
                /**
                Dos comparaciones aki:
                * 1-Verifica si la matrizOriginal hay algo de valor en la columna que es > 0.Si es asi
                * Significa que existe un Arista entre estos dos puntos de la gráfica 
                * 2-Verifica si el peso de la arista entre los dos puntos es menor que el actual distanciaRelativa
                * del nodo vecino
                * Si es correcto, el nodo distanciaRelativa para ser evaluado por el momento sera actualizado
                * el valor de esta nueva distancia valorada para puntoValorado
                */
                if((MatrizOriginal[puntoevaluado][contadorAdyacentes] > 0) && ((MatrizOriginal[puntoevaluado][contadorAdyacentes] < distanciasRelativas.get(contadorAdyacentes))))
                {
                    distanciasRelativas.set(contadorAdyacentes, MatrizOriginal[puntoevaluado][contadorAdyacentes]);
                    nodosAdyacentes.set(contadorAdyacentes,puntoevaluado);
                }
                /**
                _Marca los vertices d puntoevaluado como un vertice ya verificado 
                */
                verticesVisitados.set(puntoevaluado,true);//*Paso de parametro true y de ahicomienza siguiente Vertice */
                /**
                *Prepara para seleccionar el proximo vértice a ser evaluado 
                */
                puntoevaluado = new Integer(0);
                Integer distanciaActualacomparar = new Integer(Integer.MAX_VALUE);
                
                /**
                *Seleccionar el próximo vertice a ser evaluado
                */
                for(Integer contador =1;contador < verticesVisitados.size();contador++)
                {
                    /**
                *Si el vertice a ser verificado ya fue evaluado anteriormente (true)
                * pasa a la proxima iteración
                */
                    if(verticesVisitados.get(contador))
                    {
                        continue;

                    }
                /**
                *Si la distancia relativa de ese punto es menor que a al punto valorado
                * asumir ese nuevo punto como un punto valorado
                * 
                * al final de la iteracion, será seleccionado un punto con menor distancia relativa
                */
                    if(distanciasRelativas.get(contador) < distanciaActualacomparar)
                    {
                        distanciaActualacomparar = distanciasRelativas.get(contador);
                        puntoevaluado = contador;
                    }
                
                }//end 3er for 
        }//end 2do for
        }//end 1er for
        int [][] matrizResultane =new int [MatrizOriginal[0].length][MatrizOriginal[0].length];
                /**
                *Crear una MatrizOriginal como una arbol resultante del Algoritmo de Prim 
                */
                for(int contador = 0;contador < nodosAdyacentes.size();contador++)
                {
                    matrizResultane[contador][nodosAdyacentes.get(contador)] = MatrizOriginal[contador][nodosAdyacentes.get(contador)];
                    matrizResultane[nodosAdyacentes.get(contador)][contador] = matrizResultane[contador][nodosAdyacentes.get(contador)];
                }
        return matrizResultane;
    }//end funcion Prim
    

    public static void main(String[] args) //Funcion principal Main
    {
        //Matriz a aplicarle el algoritmo
        int [][] MMatrizOriginal ={{0, 4, 7, 6, 0, 0},
                                   {4, 0, 0, 0, 0, 0},
                                   {7, 0, 0, 1, 0, 8},
                                   {6, 0, 1, 0, 10, 0},
                                   {0, 0, 0, 10, 0, 12},
                                   {0, 0, 8, 0, 12, 0}
        };
        System.out.println("MATRIZ ORIGINAL");
        for(int contadorHorizontal = 0; contadorHorizontal < MMatrizOriginal[0].length;contadorHorizontal++)
        {
            for(int contadorVertical = 0;contadorVertical < MMatrizOriginal[0].length;contadorVertical++)
            {
                System.out.print(MMatrizOriginal[contadorHorizontal][contadorVertical] + "   ");
            }
            System.out.println();
        }
        /**
        *Invokamos la funcion Prim y le pasamos como parametro la matriz a la cual aplicaremos
        * el algoritmo de Prim
        */
        int [][] MatrizFinal = Algoritmo_Prim(MMatrizOriginal);
        
        /**
        *Impresion de matriz Final
        */
        System.out.println("MATRIZ RESULTANTE");
        for(int contadorHorizontal = 0; contadorHorizontal < MatrizFinal[0].length;contadorHorizontal++)
        {
            for(int contadorVertical = 0;contadorVertical < MatrizFinal[0].length;contadorVertical++)
            {
                System.out.print(MatrizFinal[contadorHorizontal][contadorVertical] + "   ");
            }
            System.out.println();
        }
    }
    
}
