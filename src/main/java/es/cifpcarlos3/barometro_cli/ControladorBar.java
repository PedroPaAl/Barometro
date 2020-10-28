/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcarlos3.barometro_cli;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ControladorBar {

    private ModeloBar modelo;
    private VistaBar vista;

    public ControladorBar(VistaBar vista) {
        this.vista = vista;
        this.modelo = new ModeloBar();
    }
    public void registrarPresion(Double presion,LocalDateTime fecha){     
    ModeloBar.ValorPresion valor = modelo.new ValorPresion(presion,fecha);
    modelo.guardarPresion(valor.presion, valor.fecha);    
    }   
    public void prediccion(){
        modelo.preddicion();
    }
    }
