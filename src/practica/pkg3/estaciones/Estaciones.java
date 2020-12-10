/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3.estaciones;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Jhosepe
 * @author JuanLema
 * @author JoseHenao
 */
public class Estaciones extends javax.swing.JFrame {

    /**
     * Creates new form Estaciones
     */
    private String clave = "admin";
    private String usuarios = "admin";
    private int[][] matCostos;
    private String[] estaciones;
    public int[][] matTemp;
    public String[] estTemp;
    public JFrame lienzo;
    public JPanel pin;

    public Estaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getIconImage();
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/metroicon.png"));
        return retValue;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public int[][] getMatCostos() {
        return matCostos;
    }

    public void setMatCostos(int[][] matCostos) {
        this.matCostos = matCostos;
    }

    public String[] getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(String[] estaciones) {
        this.estaciones = estaciones;
    }

    public int[][] getMatTemp() {
        return matTemp;
    }

    public void setMatTemp(int[][] matTemp) {
        this.matTemp = matTemp;
    }

    public String[] getEstTemp() {
        return estTemp;
    }

    public void setEstTemp(String[] estTemp) {
        this.estTemp = estTemp;
    }

    public void CrearMatCostosyVecEstaciones(String entrada) {
        int estaTemp;
        String nEsta;
        int apuntador = 0;
        int fila = 0;
        int columna = 0;
        int[][] mat;
        String[] lineas = entrada.split("\n");
        nEsta = lineas[0].trim();
        //JOptionPane.showMessageDialog(null,nEsta);
        //JOptionPane.showMessageDialog(null,MostrarEstaciones(lineas));
        String[] estacionesT;
        String[] separador;
        String eTemporal;

        estaTemp = Integer.parseInt(nEsta);
        //JOptionPane.showMessageDialog(null," "+estaTemp);
        mat = new int[estaTemp][estaTemp];
        estacionesT = new String[estaTemp];

        //inicializamos estacionesT
        for (int i = 0; i < estaTemp; i++) {
            estacionesT[i] = "";
        }

        //craremos el vector para almacenar las estaTemp
        for (int i = 1; i < lineas.length; i++) {
            boolean esta = true;
            separador = lineas[i].split(",");
            for (int j = 0; j < 2; j++) {
                eTemporal = separador[j];
                // JOptionPane.showMessageDialog(null,MostrarEstaciones(estacionesT));
                for (int k = 0; k < estaTemp; k++) {
                    if (eTemporal.equalsIgnoreCase(estacionesT[k])) {
                        esta = false;
                        break;
                    }
                }
                if (esta) {
                    if (apuntador < estaTemp) {
                        estacionesT[apuntador] = eTemporal;
                        apuntador++;

                    }

                }

            }

        }

        //crearemos la matriz de costos
        for (int b = 1; b < lineas.length; b++) {
            separador = lineas[b].split(",");
            for (int j = 0; j < estaTemp; j++) {
                if (separador[0].equals(estacionesT[j])) {
                    fila = j;
                }
                if (separador[1].equals(estacionesT[j])) {
                    columna = j;
                }
            }
            // JOptionPane.showMessageDialog(null," "+fila+" "+columna);
            mat[fila][columna] = Integer.parseInt(separador[2].trim());
            mat[columna][fila] = Integer.parseInt(separador[2].trim());

        }
        setMatTemp(mat);
        setEstTemp(estacionesT);

    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public String MostarMat(int[][] matriz) {
        String salida = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                salida += matriz[i][j] + "\t";
            }
            salida += "\n";

        }
        return salida;
    }

    public String MostrarEstaciones(String[] e) {
        String salida = "";
        for (int i = 0; i < e.length; i++) {
            salida += (i + 1) + ". " + e[i] + "\t\n";
        }
        return salida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        administrar = new javax.swing.JTabbedPane();
        panelRuta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textOrigen = new javax.swing.JTextField();
        textDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaListaE = new javax.swing.JTextArea();
        bClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaRuta = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textDistancia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        botonCalcular = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
        PanelGrafica = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areamatriz = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Administracion = new javax.swing.JPanel();
        Bcarga = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textuser = new javax.swing.JTextField();
        textpass = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        errorPass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textConfirmacion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Bcancelar = new javax.swing.JButton();
        Bok = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BInicio = new javax.swing.JButton();
        BcerrarS = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        administrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                administrarMouseClicked(evt);
            }
        });

        panelRuta.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Metro UdeA");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Estacion de partida:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Estacion de destino:");

        textOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textOrigenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Listado de Estaciones");

        areaListaE.setEditable(false);
        areaListaE.setColumns(20);
        areaListaE.setRows(5);
        jScrollPane1.setViewportView(areaListaE);

        bClear.setBackground(new java.awt.Color(0, 102, 0));
        bClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bClear.setText("Limpiar");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        areaRuta.setColumns(20);
        areaRuta.setFont(new java.awt.Font("Kalinga", 1, 24)); // NOI18N
        areaRuta.setRows(5);
        jScrollPane2.setViewportView(areaRuta);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setText("La mejor ruta para llegar a su destino es: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setText("Distancia a recorrer: ");

        textDistancia.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        textDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDistanciaActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ver Estaciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botonCalcular.setBackground(new java.awt.Color(0, 102, 0));
        botonCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCalcular.setText("Calcular Ruta");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/metro.png"))); // NOI18N

        javax.swing.GroupLayout panelRutaLayout = new javax.swing.GroupLayout(panelRuta);
        panelRuta.setLayout(panelRutaLayout);
        panelRutaLayout.setHorizontalGroup(
            panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(textOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(textDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(158, 158, 158)
                .addComponent(jLabel6))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(textDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(bClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(jLabel4))
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(icono))
        );
        panelRutaLayout.setVerticalGroup(
            panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutaLayout.createSequentialGroup()
                .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRutaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(textOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(textDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(16, 16, 16)
                        .addGroup(panelRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(bClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3))
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(panelRutaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        administrar.addTab("Ruta Metro", panelRuta);

        areamatriz.setColumns(20);
        areamatriz.setRows(5);
        jScrollPane4.setViewportView(areamatriz);

        jButton4.setText("ver Matriz");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Grafo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGraficaLayout = new javax.swing.GroupLayout(PanelGrafica);
        PanelGrafica.setLayout(PanelGraficaLayout);
        PanelGraficaLayout.setHorizontalGroup(
            PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGraficaLayout.createSequentialGroup()
                .addGroup(PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGraficaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton4)
                        .addGap(46, 46, 46)
                        .addComponent(jButton3))
                    .addGroup(PanelGraficaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        PanelGraficaLayout.setVerticalGroup(
            PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(33, 33, 33))
        );

        administrar.addTab("Grafica", PanelGrafica);

        Administracion.setBackground(new java.awt.Color(255, 255, 255));
        Administracion.setFocusable(false);
        Administracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bcarga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bcarga.setText("Cargar Estaciones");
        Bcarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BcargaMouseClicked(evt);
            }
        });
        Bcarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcargaActionPerformed(evt);
            }
        });
        Administracion.add(Bcarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 141, -1));

        Bedit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bedit.setText("Editar Credenciales");
        Bedit.setEnabled(false);
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });
        Administracion.add(Bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 141, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Usuario: ");
        Administracion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 246, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Clave:");
        Administracion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));
        Administracion.add(textuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 249, 100, -1));

        textpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textpassActionPerformed(evt);
            }
        });
        Administracion.add(textpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 293, 100, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        Administracion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 77, -1, -1));

        errorPass.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Administracion.add(errorPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 181, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Administracion.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 10, 437));

        textConfirmacion.setColumns(20);
        textConfirmacion.setRows(5);
        jScrollPane3.setViewportView(textConfirmacion);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Confirmación:");

        Bcancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bcancelar.setText("Cancelar");
        Bcancelar.setEnabled(false);
        Bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarActionPerformed(evt);
            }
        });

        Bok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bok.setText("Ok");
        Bok.setEnabled(false);
        Bok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Bok)
                                .addGap(18, 18, 18)
                                .addComponent(Bcancelar))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bcancelar)
                    .addComponent(Bok))
                .addGap(41, 41, 41))
        );

        Administracion.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 520));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon soporte3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Administracion.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));

        BInicio.setBackground(new java.awt.Color(255, 255, 255));
        BInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BInicio.setText("Iniciar");
        BInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioActionPerformed(evt);
            }
        });
        Administracion.add(BInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, 34));

        BcerrarS.setBackground(new java.awt.Color(255, 255, 255));
        BcerrarS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BcerrarS.setText("Cerrar Sesión");
        BcerrarS.setEnabled(false);
        BcerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcerrarSActionPerformed(evt);
            }
        });
        Administracion.add(BcerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 34));

        administrar.addTab("Administrar", Administracion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(administrar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(administrar, javax.swing.GroupLayout.PREFERRED_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        textDestino.setText("");
        textOrigen.setText("");
        areaListaE.setText("");
        areaRuta.setText("");
        textDistancia.setText("");

    }//GEN-LAST:event_bClearActionPerformed

    private void textDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDistanciaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (getEstaciones() != null) {
            areaListaE.setText(MostrarEstaciones(estaciones));
        } else {
            areaListaE.setText("Favor solicite al administrador cargar las estaciones.\t\n gracias");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed
        setUsuarios(JOptionPane.showInputDialog(null, "Ingrese el nuevo usuario"));
        setClave(JOptionPane.showInputDialog(null, "Ingrese la nueva clave"));
        Bedit.setEnabled(false);
        Bcarga.setEnabled(false);
    }//GEN-LAST:event_BeditActionPerformed

    private void administrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administrarMouseClicked
        // aqui vamos a poner la validacion de usuario


    }//GEN-LAST:event_administrarMouseClicked

    private void BInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioActionPerformed
        String messErr;
        try {
            String user = textuser.getText();
            char[] pass = textpass.getPassword();

            if (user.equals(usuarios)) {
                if (clave.equals(String.valueOf(pass))) {
                    Bcarga.setEnabled(true);
                    Bedit.setEnabled(true);
                    BcerrarS.setEnabled(true);
                } else {
                    messErr = "Contraseña Incorrecta";
                    errorPass.setText(messErr);
                }

            } else {
                messErr = "Usuario Incorrecto";
                errorPass.setText(messErr);
            }

        } catch (Exception e) {
        }
        textuser.setText("");
        textpass.setText("");


    }//GEN-LAST:event_BInicioActionPerformed

    private void BcargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcargaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BcargaMouseClicked

    private void textpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textpassActionPerformed

    private void BcargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcargaActionPerformed
        JFileChooser buscar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TXT", "txt");
        buscar.setFileFilter(filtro);
        String cadena = "";
        int selecion = buscar.showOpenDialog(this);

        if (selecion == JFileChooser.APPROVE_OPTION) {
            File archivo = buscar.getSelectedFile();
            try (FileReader fr = new FileReader(archivo)) {

                int linea = fr.read();
                while (linea != -1) {
                    cadena += (char) linea;
                    linea = fr.read();
                }
                //this.textConfirmacion.setText(cadena);
            } catch (Exception e) {
            }
        }
        CrearMatCostosyVecEstaciones(cadena);

        Bedit.setEnabled(false);
        Bcarga.setEnabled(false);
        Bok.setEnabled(true);
        Bcancelar.setEnabled(true);
        textConfirmacion.setText(MostrarEstaciones(estTemp));
    }//GEN-LAST:event_BcargaActionPerformed

    private void textOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textOrigenActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        Dijkstra obj = new Dijkstra(estaciones.length);
        if (estaciones.length != 0) {
            String origen = textOrigen.getText();
            String destino = textDestino.getText();
            String result;
            String rutaFinal = "";
            String distancia="";
            int orig = 0;
            int dest = 0;
            int dist=0;
            String[] ruta = new String[estaciones.length];
            boolean band = true;
            boolean band2 = true;
            for (int i = 0; i < estaciones.length; i++) {
                for (int j = 0; j < estaciones.length; j++) {
                    if (matCostos[i][j] != 0) {
                        obj.addEdge(i, j, matCostos[i][j], true);
                    }
                }
            }
            if (isNumeric(origen)) {
                int aux1 = Integer.parseInt(origen);
                aux1=aux1-1;
                if (aux1 <= estaciones.length) {
                    orig = aux1;
                } else {
                    JOptionPane.showMessageDialog(null, "El numero de origen no existe");
                }
            } else {
                for (int i = 0; i < estaciones.length; i++) {
                    if (origen.equalsIgnoreCase(estaciones[i])) {
                        orig = i;
                        band = false;
                    }
                    if (band && i == estaciones.length - 1) {
                        JOptionPane.showMessageDialog(null, "El origen ingresado es incorrecto");
                        band2 = false;
                    }
                }
            }

            band = true;

            if (isNumeric(destino)) {
                int aux2 = Integer.parseInt(destino);
                aux2=aux2-1;
                if (aux2 < estaciones.length) {
                    dest = aux2;
                } else {
                    JOptionPane.showMessageDialog(null, "El numero de destino no existe");
                }

            } else {
                for (int j = 0; j < estaciones.length; j++) {
                    if (destino.equalsIgnoreCase(estaciones[j])) {
                        dest = j;
                        band = false;
                    }
                    if (band && j == estaciones.length - 1) {
                        JOptionPane.showMessageDialog(null, "El destino ingresado es incorrecto");
                        band2 = false;
                    }
                }
            }
            obj.dijkstra(orig);
            obj.setDestino(dest);
            if (band2) {
                result = obj.printShortestPath();
                ruta = result.split(" ");
                int x;
                int y=0;
                for (int i = 0; i < ruta.length; i++) {
                    x = Integer.parseInt(ruta[i]);
                    if(i<ruta.length-1){
                        y = Integer.parseInt(ruta[i+1]);
                    }
                    rutaFinal += estaciones[x - 1] + ", ";
                    dist+=matCostos[x-1][y-1];
                }
                distancia=String.valueOf(dist);
                textDistancia.setText(distancia);
                areaRuta.setText(rutaFinal);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se ha cargado el archivo");
        }
        
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String text = " \t.   Horario de atención 8:00-12:00 & 14:00-18:00 \n \t"
                + "                 Tel: 01800046952\n \t"
                + "        Email: soportesJJJ@udea.edu.com.co \n \t"
                + "           Jose David Henao Gallego\n \t"
                + "            Juan Andres Lema Tamayo \n \t"
                + "           Jhon Sebastian Peñate Peña\n \t"
                + "                     JJJ S.A";
        JOptionPane.showMessageDialog(null, text);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BcerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcerrarSActionPerformed
        Bcarga.setEnabled(false);
        Bedit.setEnabled(false);
        BcerrarS.setEnabled(false);
    }//GEN-LAST:event_BcerrarSActionPerformed

    private void BokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BokActionPerformed
        //Aqui pasaremos el vector y la matiz a las variables con las que trabajaremos el resto del codigo
        if (matTemp != null && estTemp != null) {
            setMatCostos(matTemp);
            setEstaciones(estTemp);
            JOptionPane.showMessageDialog(null, "Las estaciones Se han cargado satisfactoreamente");
            textConfirmacion.setText("");
            Bok.setEnabled(false);
            Bcancelar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Algo Salio Mal\n \t"
                    + "favor revisar el Archivo y proceda a cargarlo nuevamente.\n \t"
                    + "Gracias.");
        }
    }//GEN-LAST:event_BokActionPerformed

    private void BcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarActionPerformed
        JOptionPane.showMessageDialog(null, "No se guardaron cambios ");
        textConfirmacion.setText("");
    }//GEN-LAST:event_BcancelarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        areamatriz.setText(MostarMat(matCostos));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         Pintador pintor = new Pintador();
         lienzo = new JFrame();
         this.pin = new JPanel();
         this.lienzo.setVisible(true);
         this.lienzo.setSize(750,540);
         this.pin.setSize(750, 540);
         this.pin.setBackground(Color.red);
         this.lienzo.add(this.pin);
         this.pin.setEnabled(true);
         this.pin.setVisible(true);
         Pintador.pintarCirculo(this.pin.getGraphics(),10,10,"puta");
         
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Estaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Estaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Administracion;
    private javax.swing.JButton BInicio;
    private javax.swing.JButton Bcancelar;
    private javax.swing.JButton Bcarga;
    private javax.swing.JButton BcerrarS;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bok;
    private javax.swing.JPanel PanelGrafica;
    private javax.swing.JTabbedPane administrar;
    private javax.swing.JTextArea areaListaE;
    private javax.swing.JTextArea areaRuta;
    private javax.swing.JTextArea areamatriz;
    private javax.swing.JButton bClear;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel icono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelRuta;
    private javax.swing.JTextArea textConfirmacion;
    private javax.swing.JTextField textDestino;
    private javax.swing.JTextField textDistancia;
    private javax.swing.JTextField textOrigen;
    private javax.swing.JPasswordField textpass;
    private javax.swing.JTextField textuser;
    // End of variables declaration//GEN-END:variables
}
