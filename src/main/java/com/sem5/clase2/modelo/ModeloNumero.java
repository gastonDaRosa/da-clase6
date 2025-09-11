package com.sem5.clase2.modelo;

import java.util.ArrayList;

public class ModeloNumero {
    private int cantidad;
    private ArrayList<Integer> pares;
    private ArrayList<Integer> impares;
    private ArrayList<Integer> todos;

    public ModeloNumero() {
        this.cantidad = 0;
        this.pares = new ArrayList<Integer>();
        this.impares = new ArrayList<Integer>();
        this.todos = new ArrayList<Integer>();
    }

    public boolean iniciar(int cant){
        if(this.cantidad == 0){
            this.cantidad = cant;
            this.pares = new ArrayList<>();
            this.impares = new ArrayList<>();
            this.todos = new ArrayList<>();
            return true;
        }
        return false;
    }

    public boolean vacio(){
        return getCantidadFaltan() == 0 && todos.size() == 0;
    }

    public int getCantidadFaltan(){
        return cantidad;
    }

    public boolean ingresar(int numero){
        if(getCantidadFaltan() > 0){
            this.todos.add(numero);
            if(numero % 2 == 0){
                this.pares.add(numero);
            } else {
                this.impares.add(numero);
            }
            this.cantidad--;
            return true;
        }
        return false;
    }

    public boolean ingresoFinalizado(){
        return getCantidadFaltan() == 0 && todos != null;
    }

    public ArrayList<Integer> obtenerResultado(){
        if (ingresoFinalizado()) {
            ArrayList<Integer> resultado = todos;
            if(pares.size() > impares.size()){
                resultado = pares;
            } else if (impares.size() > pares.size()){
                resultado = impares;

            }
            return resultado;
        }
        return new ArrayList<>();
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
