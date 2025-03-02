package CRUD;

import javax.swing.JOptionPane;

public class ListaEnlazada {
    NodoSimple cabeza;
        
    public boolean vacia ()
    {
    return cabeza == null;    
    }

    public void agregarAlFinal (String nombre, int edad)
    {
        NodoSimple nuevo = new NodoSimple(nombre, edad);
        if (vacia()) {
            cabeza = nuevo;
            return;
        }
        
        NodoSimple mensajero = cabeza;
        while (mensajero.siguiente != null)
        {
            mensajero = mensajero.siguiente;
        }
        mensajero.siguiente = nuevo;
    }

    public void mostrarListaEstudiantes()
    {
        if (vacia())
        {
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
            return;
        }
        StringBuilder listaEstudiantes = new StringBuilder();
        NodoSimple mensajer = cabeza;
        ordenar();
        while (mensajer != null) 
        {
            listaEstudiantes.append("Estudiante:  ").append(mensajer.estudiante.nombre)
            .append(" Edad: ").append(mensajer.estudiante.edad).append("\n");
            mensajer = mensajer.siguiente;
        }
        JOptionPane.showConfirmDialog(null,listaEstudiantes.toString());
    }

    public void borrarEstudiante(String nombre) {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
    
        // Si el primer estudiante es el que se quiere eliminar
        if (cabeza.estudiante.nombre.equals(nombre)) {
            cabeza = cabeza.siguiente;
            JOptionPane.showMessageDialog(null, "Se eliminó a " + nombre + " correctamente.");
            return;
        }
        //caso que no, se tiene que iniciar un mensajero desde la cabeza
        NodoSimple enlistador = cabeza;
        while (enlistador.siguiente != null) {
            if (enlistador.siguiente.estudiante.nombre.equals(nombre)) {
                    enlistador.siguiente = enlistador.siguiente.siguiente;
                    JOptionPane.showMessageDialog(null, "Se eliminó a: " + nombre + " de forma correcta.");
                    return;
            }
            enlistador = enlistador.siguiente;
        }
    
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }
    
    public void buscarEstudiante(String nombre) {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
    
        NodoSimple enlistador = cabeza;
        int indice = 1;
        while (enlistador != null) {
            if (enlistador.estudiante.nombre.equals(nombre)) {
                JOptionPane.showMessageDialog(null, "Estudiante encontrado: " + enlistador.estudiante.nombre +
                        ", Edad: " + enlistador.estudiante.edad + ", Posición: " + indice);
                return;
            }
            enlistador = enlistador.siguiente;
            indice++;
        }
    
        JOptionPane.showMessageDialog(null, "El estudiante " + nombre + " no existe.");
    }

    // Metodo para ordenar de forma Alfabetica la lista por metodo burbuja 
    public void ordenar()
    {
        if(cabeza == null || cabeza.siguiente == null)
        {
            return;
        }
        boolean cambio;
        do {
            cambio = false;
            NodoSimple actual = cabeza;
            NodoSimple anterior = null;
            while (actual != null && actual.siguiente != null) 
            {
                NodoSimple siguiente = actual.siguiente;

                if (actual.estudiante.nombre.compareToIgnoreCase(siguiente.estudiante.nombre)>0) 
                {
                    Estudiante temporal= actual.estudiante;
                    actual.estudiante = siguiente.estudiante;
                    siguiente.estudiante =temporal;
                    cambio = true;
                }
                anterior = actual;
                actual = actual.siguiente;
            }

        } while (cambio);
    }
}
