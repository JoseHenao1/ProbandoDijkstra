/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3.estaciones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Liceo_2
 */
public class VentanaGrafo extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGrafo
     */
    JPanel lienzo;
    private int x;
    private int y;
    private int veces;
    private String nombre;
    private int radio = 10;
    private int diametro = 20;
    //public int[] xs = {200, 220, 180, 240, 160, 260, 140, 280, 120, 300};
    public static int[] xs;
    //public int[] ys = {100, 120, 140, 160, 180, 200, 220, 240, 260, 280};
    public static int [] ys;
    int xAnterior;
    int yAnterior;
    Distancias[] distancias;

    public Distancias[] getDistancias() {
        return distancias;
    }

    public void setDistancias(Distancias[] distancias) {
        this.distancias = distancias;
    }
    
    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JPanel getLienzo() {
        return lienzo;
    }

    public void setLienzo(JPanel lienzo) {
        this.lienzo = lienzo;
    }

    public int getxAnterior() {
        return xAnterior;
    }

    public void setxAnterior(int xAnterior) {
        this.xAnterior = xAnterior;
    }

    public int getyAnterior() {
        return yAnterior;
    }

    public void setyAnterior(int yAnterior) {
        this.yAnterior = yAnterior;
    }

    public int[] getXs() {
        return xs;
    }

    public void setXs(int[] xs) {
        this.xs = xs;
    }

    public int[] getYs() {
        return ys;
    }

    public void setYs(int[] ys) {
        this.ys = ys;
    }
    
    public void llenarVectorXyY(int[][] matrizInicial) {
        int controlD = 0;
        int cont = 0;
        Random aleatorio = new Random();
        int [] vX = new int[matrizInicial.length];
        int [] vY = new int[matrizInicial.length];
        distancias = new Distancias[matrizInicial.length];
        for (int i = 0; i < matrizInicial.length; i++) {
            for (int j = 0; j < matrizInicial.length; j++) {
                if (j+controlD<matrizInicial.length) {
                    if (matrizInicial[i][controlD + j] != 0) {
                        Distancias d = new Distancias(i,(controlD + j),(matrizInicial[i][controlD + j]));
                        distancias[cont] = d ;
                        cont++;
                    }
                }

            }
            controlD++;
        }
        int xyz;
        numero p;
         ArrayList<numero> xAnt = new ArrayList<>();
        ArrayList<numero> yAnt = new ArrayList<>();
        for(int x=0;x<vX.length;x++){
            /* int distX;
             int distY;
              //if(distancias[x]!=null){
               //dist  = distancias[x].getDistancia();
               distX = aleatorio.nextInt(600);
               distY = aleatorio.nextInt(400);
            
            
            
            if(x==0){
                vX[x]=200;
                vY[x]=300;
            }else if(x%2==0){
                int nuevoX = distX;
                int nuevoY = distY;
                if(noEsta(nuevoX, xAnt)){
                    vX[x]= nuevoX+60;
                }else{
                   vX[x]= nuevoX+80;
                }
                 if(noEsta(nuevoY, yAnt)){
                    vY[x]= nuevoY+60;
                }else{
                   vY[x]= nuevoY+80;
                }
                     
                p = new numero(nuevoX);
                xAnt.add(p);
                p = new numero(nuevoY);
                yAnt.add(p);
            }else if(x%2==1){
                int nuevoX = distX;
                int nuevoY = distY;
                if(noEsta(nuevoX, xAnt)){
                    vX[x]= nuevoX+60;
                }else{
                   vX[x]= nuevoX+60;
                }
                 if(noEsta(nuevoY, yAnt)){
                    vY[x]= nuevoY+60;
                }else{
                   vY[x]= nuevoY+50;
                }
                     
                p = new numero(nuevoX);
                xAnt.add(p);
                p = new numero(nuevoY);
                yAnt.add(p);
            }*/
            if (x==0){
                vX[x] = 100;
                vY[x] = 130;
            }else if(x%3==0){
                vX[x] = 100;
                vY[x] =vY[x-1]+113;
            }else{
                vX[x] = vX[x-1]+280;
                vY[x] = vY[x-1];
            }
        }
        this.setXs(vX);
        this.setYs(vY); 
        //getDistancias()[i].getEstacinO() == 0
        
    }

    public VentanaGrafo() {
        initComponents();
        this.setLocationRelativeTo(null);
        lienzo = new JPanel();
        this.setBounds(WIDTH, WIDTH, 826, 540);
        lienzo.setBackground(Color.WHITE);
        //repaint();

    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        pintarCirculo(g, x, y, nombre, veces,xAnterior,yAnterior);
    }
    */

    public static void pintarCirculo(Graphics g, int x, int y, String estacion, int[][]matrizCostos, int xAnterior,int yAnterior) {
        //g.drawOval(x, y-10, 20, 20);

       /* if (veces > 0) {
            //pintarLinea(g, xAnterior + 10, yAnterior + 10, x + 10, y + 10, 0);
        }*/
       int controlD=0;
        for (int i = 0; i <matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                if (j+controlD<matrizCostos.length) {
                    if (matrizCostos[i][controlD + j] != 0) {
                        pintarLinea(g, xs[i], ys[i], xs[j+1], ys[j+1], matrizCostos[i][j]);
                    }
                }

            }
            controlD++;
        }
        ((Graphics2D) g).setColor(Color.blue);
        ((Graphics2D) g).setStroke(new BasicStroke(3));//leda el grosor al circulo        
        ((Graphics2D) g).fillOval(x, y, 20, 20);
        ((Graphics2D) g).setColor(Color.BLACK);
        ((Graphics2D) g).drawOval(x, y, 20, 20);

        ((Graphics2D) g).setColor(Color.ORANGE);
        Font fuente = new Font("Monospaced", Font.BOLD, 12);
        g.setFont(fuente);
        ((Graphics2D) g).drawString(estacion, x - 20, y);

    }

    public static void pintarLinea(Graphics g, int x1, int y1, int x2, int y2, int tam) {
        int xAux = 0;
        int yAux = 0;
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) g).setStroke(stroke);
        ((Graphics2D) g).drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
        if (x1 <= x2) {
            xAux = ((x2 - x1) / 2) + x1;
        }
        if (x1 > x2) {
            xAux = ((x1 - x2) / 2) + x2;
        }
        if (y1 < y2) {
            yAux = ((y2 - y1) / 2) + y1;
        }
        if (y1 >= y2) {
            yAux = ((y1 - y2) / 2) + y2;
        }
         ((Graphics2D)g).setColor(Color.black);
        Font fuente = new Font("Monospaced", Font.PLAIN, 12);
        g.setFont(fuente);
        ((Graphics2D) g).drawString(String.valueOf(tam), xAux, yAux);
    }

    public int CalcularX(int i) {
        int salida = 0;
        salida=xs[i];
        return salida;
    }

    public int CalcularY(int i) {
        int salida;
        salida=ys[i];
        return salida;
    }

    public boolean noEsta(int numero, ArrayList<numero> l) {
        boolean salida = false;
        for (numero object : l) {
            if (numero == object.getValor()) {
                salida = true;
                break;
            } else {
                salida = false;
            }
        }
        return salida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
