import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Ejercicio Array");
        ArrayList<Personas> listaPersonas = new ArrayList<Personas>(10);
        //Añadir las 5 instancias al ArrayList
        listaPersonas.add(new Personas("72000001X", "Kevin", "Vasquez"));

        listaPersonas.add(new Personas("72000003X", "David", "Tulcanazo"));

        listaPersonas.add(new Personas("72000005X", "Edgar", "Oviedo"));

        listaPersonas.add(new Personas("72000007X", "Mario", "Pila"));

        listaPersonas.add(new Personas("72000009X", "Marco", "Valiente"));

        Iterator<Personas> iterator = listaPersonas.iterator();
        while (iterator.hasNext()) {
            Personas p = iterator.next();
            System.out.println(p);
        }

        System.out.println("Borrar 2 elementos del array con iterator");
        Iterator<Personas> iterator2 = listaPersonas.iterator();

        while (iterator2.hasNext()) {
            Personas persona = iterator2.next();

            if (persona.getNombre().equals("Kevin") ||
                    persona.getNombre().equals("Mario")) {
                System.out.println("Borramos : " + persona.getNombre());
                iterator2.remove();
            }
        }
        System.out.println("Array con los 2 elementos borrados");
        for (Personas a : listaPersonas) {
            System.out.println(a);
        }

        System.out.println("Añadir nueva persona en mitad de la lista");
        //Lo pondremos en la posicion 2 ya que solo tenemos la posicion 0, 1, 2 y 3 despues de haber borrado los otros 2
        listaPersonas.add(2, new Personas("72000012X", "Nuevo", "Miembro"));
        System.out.println("Recorremos los elementos necesarios");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println(listaPersonas.get(i));
        }
        System.out.println("Mostramos la nueva lista");
        Iterator<Personas> iterator3 = listaPersonas.iterator();
        while (iterator3.hasNext()) {
            Personas listapersona = iterator3.next();
            System.out.println(listapersona);
        }

        System.out.println("Lista ordenada con compareTo");
        listaPersonas.sort(null);
        for (Personas p : listaPersonas) {
            System.out.println(p);
        }
        System.out.println("Eliminar todos los valores del ArrayList");
        listaPersonas.clear();
        System.out.println(listaPersonas.size());
        
//        System.out.println("\n");
//        System.out.println("MISMO EJERCICIO USANDO LINKEDLIST");
//
//        System.out.println("Ejercicio LinkedList");
//        LinkedList<Personas> listaPersonas = new LinkedList<Personas>();
//        //Añadir las 5 instancias al LinkedList
//        listaPersonas.add(new Personas("72000001X", "Kevin", "Vasquez"));
//
//        listaPersonas.add(new Personas("72000003X", "David", "Tulcanazo"));
//
//        listaPersonas.add(new Personas("72000005X", "Edgar", "Oviedo"));
//
//        listaPersonas.add(new Personas("72000007X", "Mario", "Pila"));
//
//        listaPersonas.add(new Personas("72000009X", "Marco", "Valiente"));
//
//        Iterator<Personas> iterator = listaPersonas.iterator();
//        while (iterator.hasNext()) {
//            Personas p = iterator.next();
//            System.out.println(p);
//        }
//
//        System.out.println("Borrar 2 elementos del linkedlist con iterator");
//        Iterator<Personas> iterator2 = listaPersonas.iterator();
//
//        while (iterator2.hasNext()) {
//            Personas persona = iterator2.next();
//
//            if (persona.getNombre().equals("Kevin") ||
//                    persona.getNombre().equals("Mario")) {
//                System.out.println("Borramos : " + persona.getNombre());
//                iterator2.remove();
//            }
//        }
//        System.out.println("Array con los 2 elementos borrados");
//        for (Personas a : listaPersonas) {
//            System.out.println(a);
//        }
//
//        System.out.println("Añadir nueva persona en mitad de la lista");
//        //Lo pondremos en la posicion 2 ya que solo tenemos la posicion 0, 1, 2 y 3 despues de haber borrado los otros 2
//        ListIterator<Personas> it = listaPersonas.listIterator(2);
//        it.add(new Personas("72000012X", "Nuevo", "Miembro"));
//        System.out.println("Recorremos los elementos necesarios");
//        for (Personas p : listaPersonas) {
//            System.out.println(p);
//        }
//        System.out.println("Mostramos la nueva lista");
//        Iterator<Personas> iterator3 = listaPersonas.iterator();
//        while (iterator3.hasNext()) {
//            Personas listapersona = iterator3.next();
//            System.out.println(listapersona);
//        }
//
//        System.out.println("Lista ordenada con compareTo");
//        listaPersonas.sort(null);
//        for (Personas p : listaPersonas) {
//            System.out.println(p);
//        }
//        System.out.println("Eliminar todos los valores del LinkedList");
//        listaPersonas.clear();
//        System.out.println(listaPersonas.size());
    }
}