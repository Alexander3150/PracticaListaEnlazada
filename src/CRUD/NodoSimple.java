package CRUD;

class NodoSimple {
    Estudiante estudiante;
    NodoSimple siguiente;

    public NodoSimple(String nombre, int edad) {
        this.estudiante = new Estudiante(nombre, edad);
        this.siguiente = null;
    }
}
