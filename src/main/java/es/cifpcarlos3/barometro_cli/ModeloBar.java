/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcarlos3.barometro_cli;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ModeloBar {

    List<ValorPresion> lista = new ArrayList();
    private Double altura = 0.0;

    public ModeloBar() {

        //añadir a la lista 
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 00, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 01, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 02, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 03, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 04, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 05, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 06, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 07, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 8, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 9, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 10, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 11, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 12, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 13, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 14, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 15, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 16, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 17, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 18, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 19, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 20, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 21, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 22, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                28, 23, 00, 00)));
        lista.add(new ValorPresion(1000.0, LocalDateTime.of(2020, Month.OCTOBER,
                29, 00, 00, 00)));

    }

    public void guardarPresion(Double presion, LocalDateTime fecha) {

        lista.add(new ValorPresion(presion, fecha));

    }

    public void preddicion() {

        String generalizacion = "En general, los cambios bruscos de presión "
                + "-subida o bajada- son bastante indecisos para asegurar "
                + "persistencia del tiempo. Habrá que seguir observando.";
       
        Double last = lista.get(lista.size() - 1).getPresion();
        Double twfour = lista.get(lista.size() - 25).getPresion();
        Double avg = (last + lista.get(lista.size() - 2).getPresion()
                + lista.get(lista.size() - 3).getPresion()) / 3;
        if (last - twfour >= 6) //Presion sube lentamente
        {
            System.out.println("Se afianza un tiempo seco, te puedes ir de "
                    + "excursion");
        }

        if (twfour - last >= 6) { //presion baja lentamente
            System.out.println("La borrasca pasa lejos");
        }

        //media 3 ultimas
        if (avg - last > 1) {
            System.out.println("Se acerca una profunda borrasca"
                    + generalizacion);
        }

        if (last - avg > 1) {
            System.out.println("La mejoria puede ser pasajera, por tratarse del"
                    + " paso de una dorsal anticiclonica entre dos borrascas "+
                    generalizacion);
        } else {
            System.out.println("Se necesitan mas datos");
        }

    }

    public void setAltura(Double altura) {
        this.altura = altura;
        System.out.println("Se ha cambiado la altura a " + this.altura + "metros "
                + "respecto al nivel del mar");
    }

    public class ValorPresion {

        Double presion;
        LocalDateTime fecha;

        public ValorPresion(Double presion, LocalDateTime fecha) {
            this.presion = presion;
            this.fecha = fecha;
        }

        public Double getPresion() {
            return presion;
        }
    }
}
