/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcarlos3.barometro_cli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ModeloBar {

    List<ValorPresion> lista = new ArrayList();
    
    public void guardarPresion(Double presion,LocalDateTime fecha) {

        lista.add(new ValorPresion(presion,fecha));        
    }
    
    public void preddicion(){
        
       
        
    }

    public class ValorPresion {
        Double presion;
        LocalDateTime fecha;

        public ValorPresion(Double presion, LocalDateTime fecha) {
            this.presion = presion;
            this.fecha = fecha;
        }
    }
}
