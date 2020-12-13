/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3.estaciones;

/**
 *
 * @author Liceo_2
 */
public class Distancias {
   private int estacinO;
   private int estacionD;
   private int distancia;

    public Distancias(int estacinO, int estacionD, int distancia) {
        this.estacinO = estacinO;
        this.estacionD = estacionD;
        this.distancia = distancia;
    }

    public Distancias() {
    }

    public int getEstacinO() {
        return estacinO;
    }

    public void setEstacinO(int estacinO) {
        this.estacinO = estacinO;
    }

    public int getEstacionD() {
        return estacionD;
    }

    public void setEstacionD(int estacionD) {
        this.estacionD = estacionD;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    public static void main(String[] args){
        Distancias obj = new Distancias();
        obj.getDistancia();
    }
}
