package com.sem5.clase2.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sem5.clase2.modelo.*;

@RestController
@RequestMapping("/modeloNumero")

public class ControladorModeloNumero {

    private ModeloNumero modelo = new ModeloNumero();

    @PostMapping("/vistaConectada")
    public List<Respuesta> vistaConectada(){
        return datosModeloNumero();
    }
    @PostMapping("/iniciar")
    public List<Respuesta> iniciar(@RequestParam int cant){
        if (cant < 0) {
            return Respuesta.lista(new Respuesta("msg", "El numero no puede ser menor a 0 "));
        }
        if (modelo.iniciar(cant)) {
            modelo.setCantidad(cant);
            return Respuesta.lista(new Respuesta("msg", "Iniciando con " + cant + " de numeros"));
        }
        return Respuesta.lista(new Respuesta("msg", "Ya fue iniciado"));
    }
    @PostMapping("/ingresar")
    public List<Respuesta> ingresarNumero(@RequestParam int numero){
        if (numero < 0) {
            return Respuesta.lista(new Respuesta("msg", "El numero no puede ser menor a 0 "));
        }
        if (modelo.ingresar(numero)) {
            return Respuesta.lista(new Respuesta("msg", numero + " fue agregado"));
        }
        if (modelo.ingresoFinalizado()) {
            ArrayList<Integer> ret = modelo.obtenerResultado();
            modelo = new ModeloNumero();
            return Respuesta.lista(new Respuesta("resultado", ret),
            new Respuesta("msg", "Resultado..."));
        }
        return Respuesta.lista(new Respuesta("msg", "Inicie de nuevo"));
    }



    private List<Respuesta> datosModeloNumero(){
        List<Respuesta> datos = Respuesta.lista();
        if (modelo.ingresoFinalizado()) {
            datos.add( new Respuesta("listaDev", modelo.obtenerResultado()) );
        }
        if (modelo.vacio()) {
            datos.add( new Respuesta("msgBienvenida", "Bienvenido, ingrese una cantidad y presione Comenzar") );
        }else{
            datos.add(new Respuesta("msgBienvenida", "Ingrese sus numeros en el siguiente input y presione Ingresar") );
            datos.add(new Respuesta("faltanIngresar", "Numeros restantes por ingresar " + modelo.getCantidadFaltan()) );
        }
        return datos;
    }
    @PostMapping("/salir")
    private void vistaCerrada(){
        modelo = new ModeloNumero();
    }

}
