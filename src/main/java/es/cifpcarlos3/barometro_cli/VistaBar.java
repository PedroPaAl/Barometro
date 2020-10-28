/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcarlos3.barometro_cli;

import java.time.LocalDateTime;
import java.util.Date;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author Pedro
 */
public class VistaBar {
    private Double presion; 
    private LocalDateTime fecha;
    
    private ControladorBar controlador;
    
    
    public VistaBar(){
        this.controlador = new ControladorBar(this);       
    }    
    public static void main(String[] args) {
        VistaBar vista = new VistaBar();
        
        vista.show(args);
        
    }    
    public Double getPresion(){
        return presion;
    }
    public LocalDateTime getFecha(){
        return fecha;
    }   
    
    
    private void show(String args[]){
        HelpFormatter formatter = new HelpFormatter();
        
        Options opts = new Options();
        opts.addOption("pr",true,"Añade presion");
        opts.addOption("dt",true,"Fecha y hora");
        
        opts.addOption("prediccion","devuelve preddiccion");
        CommandLineParser parser = new DefaultParser();
        
        try{
        CommandLine cmd = parser.parse(opts,args);
        
        if (cmd.hasOption("pr") && cmd.hasOption("dt"))
        {   
            presion = Double.parseDouble(cmd.getOptionValue("pr"));
            fecha = LocalDateTime.parse(cmd.getOptionValue("dt"));
            controlador.registrarPresion(presion,fecha);
            System.out.println("Se ha guardado la presion");
            System.out.println(presion);
            System.out.println(fecha);
        }
        if (cmd.hasOption("prediccion"))
        {
            
        }
        }       
        
        catch(ParseException e){
        System.out.println("me cago en la puta");
        }
    }
    
}
