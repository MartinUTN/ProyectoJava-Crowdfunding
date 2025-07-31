package app;

import repositorio.*;
import modelo.*;

public class Main {
    public static void main(String[] args) {

    }
}

/*
package app;

import modelo.*;
import repositorio.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PaisDAO dao = new PaisDAO();
            List<Pais> lista = dao.obtenerTodos();
            System.out.println("Paises encontrados:");
            for (Pais p : lista) {
                System.out.println(p.getIdPais() + " - " + p.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
