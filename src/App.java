import javax.swing.JOptionPane;

import CRUD.ListaEnlazada;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEnlazada lista = new ListaEnlazada();
        int opcion = 0;

        while (opcion != 5) {
            String menu = "Menú de Opciones:\n"
                    + "1. Agregar estudiante\n"
                    + "2. Mostrar estudiantes\n"
                    + "3. Buscar estudiante\n"
                    + "4. Eliminar estudiante\n"
                    + "5. Salir\n"
                    + "Elige una opción:";

            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                        if (nombre == null || nombre.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nombre no válido.");
                            break;
                        }

                        String edadStr = JOptionPane.showInputDialog("Ingrese la edad del estudiante:");
                        if (edadStr == null) break;

                        try {
                            int edad = Integer.parseInt(edadStr);
                            lista.agregarAlFinal(nombre, edad);
                            JOptionPane.showMessageDialog(null, "Estudiante agregado con éxito.");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Edad no válida.");
                        }
                        break;

                    case 2:
                        lista.mostrarListaEstudiantes();
                        break;

                    case 3:
                        String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a buscar:");
                        if (nombreBuscar != null && !nombreBuscar.trim().isEmpty()) {
                            lista.buscarEstudiante(nombreBuscar);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nombre no válido.");
                        }
                        break;

                    case 4:
                        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a eliminar:");
                        if (nombreEliminar != null && !nombreEliminar.trim().isEmpty()) {
                            lista.borrarEstudiante(nombreEliminar);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nombre no válido.");
                        }
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida, intenta de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        }
    }
}
