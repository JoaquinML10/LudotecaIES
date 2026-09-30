package es.iesmutxamel.ludoteca;

import es.isemutxamel.ludoteca.Catalogo;
import es.isemutxamel.ludoteca.Videojuego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        int opcion = -1;

        do {
            System.out.println("===========================");
            System.out.println("   LUDOTECA - MENu");
            System.out.println("===========================");
            System.out.println("1. Mostrar todos los videojuegos");
            System.out.println("2. Añadir un videojuego");
            System.out.println("3. Mostrar un resumen del catálogo");
            System.out.println("4. Consultar videojuegos con pocas unidades");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");


                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("--- LISTA DE VIDEOJUEGOS ---");
                        if (catalogo.getVideojuegos().isEmpty()) {
                            System.out.println("El catálogo está vacio.");
                        } else {
                            for (Videojuego juego : catalogo.getVideojuegos()) {
                                System.out.println(juego);
                            }
                        }
                        break;

                    case 2:
                        catalogo.aniadir();

                    case 3:
                        double totalunidades = 0;
                        for (Videojuego juego : catalogo.getVideojuegos()){
                            totalunidades += juego.getPrecio()*juego.getStock();
                        }
                        int totalUnidades = 0;
                        for (Videojuego juego : catalogo.getVideojuegos()) {
                            totalUnidades += juego.getStock();
                        }
                        System.out.println("--- RESUMEN DEL CATÁLOGO ---");
                        System.out.println("- Numero de videojuegos diferentes: " + catalogo.getVideojuegos().size());
                        System.out.println("- Numero total de unidades disponibles: " + totalUnidades);
                        System.out.println("- Valor total del stock: " + totalunidades + " €");
                        break;

                    case 4:
                        System.out.println("--- CONSULTAR POCAS UNIDADES ---");
                        System.out.print("Introduce la cantidad máxima de stock: ");
                        int limite = teclado.nextInt();
                        teclado.nextLine();

                        if (limite < 0) {
                            System.out.println("Error: El limite no puede ser negativo");
                            break;
                        }

                        for (Videojuego juego : catalogo.getVideojuegos()){
                            if (juego.getStock() < limite){
                                System.out.println(juego.getTitulo() + " necesita reponerse");
                            }
                        }
                        break;

                    case 0:
                        System.out.println("BAY BAY");
                        break;


                    default:
                        System.out.println("Opción incorrecta. Elige un número entre 0 y 4.");
                }
        } while (opcion != 0);
    }
}
