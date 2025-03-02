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
    // Ordenar las edades de mayor a menor por el metodo burbuja 
    public void ordenarEdades() {
        if (cabeza == null || cabeza.siguiente == null) {
            return;  // Si la lista está vacía o tiene solo un elemento, no hay necesidad de ordenar.
        }
    
        boolean cambio;
        do {
            cambio = false;
            NodoSimple actual = cabeza;
    
            while (actual != null && actual.siguiente != null) { // Recorrer la lista mientras haya un siguiente nodo
                NodoSimple siguiente = actual.siguiente;
    
                // Compara las edades de los estudiantes y realiza un intercambio si están en el orden incorrecto.
                if (actual.estudiante.edad < siguiente.estudiante.edad) {  // De mayor a menor
                    // Intercambia los estudiantes entre los nodos sin mover los nodos en sí
                    Estudiante temporal = actual.estudiante;
                    actual.estudiante = siguiente.estudiante;
                    siguiente.estudiante = temporal;
                    cambio = true;  // Marca que hubo un cambio, para repetir la comparación.
                }
    
                actual = actual.siguiente;  // Avanza al siguiente nodo.
            }
        } while (cambio);  // Si hubo un cambio, repite el proceso de ordenar.
    
        mostrarListaEstudiantesEdades();  // Muestra la lista ya ordenada.
    }
    public void mostrarListaEstudiantesEdades()
    {
        if (vacia())
        {
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
            return;
        }
        StringBuilder listaEstudiantes = new StringBuilder();
        NodoSimple mensajer = cabeza;
        while (mensajer != null) 
        {
            listaEstudiantes.append("Estudiante:  ").append(mensajer.estudiante.nombre)
            .append(" Edad: ").append(mensajer.estudiante.edad).append("\n");
            mensajer = mensajer.siguiente;
        }
        JOptionPane.showConfirmDialog(null,listaEstudiantes.toString());
    }

    

}
