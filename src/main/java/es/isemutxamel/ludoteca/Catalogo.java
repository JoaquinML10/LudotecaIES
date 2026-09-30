package es.isemutxamel.ludoteca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Catalogo {
    static Scanner teclado = new Scanner(System.in);
    private ArrayList<Videojuego> videojuegos;
    static Random aleatorio = new Random();

    public Catalogo() {
        videojuegos = new ArrayList<>();
        this.videojuegos = videojuegos;
    }

    public void aniadir(){
        boolean existe;
        int num = 0;
        System.out.println("Añadir videojuego");
        System.out.println("Nombre del juego?: ");
        String nombre = teclado.nextLine();
        System.out.println("Plataforma:? ");
        String plataforma = teclado.nextLine();
        System.out.println("Precio?: ");
        double precio = teclado.nextDouble();
        System.out.println("Stock:");
        int stock = teclado.nextInt();
        do {
            num = aleatorio.nextInt(0,1000000);
            existe = false;

            for (Videojuego juego : videojuegos){
                if (juego.getId() == num){
                    existe = true;
                    break;
                }
            }
        }while (existe);
        Videojuego videojuego = new Videojuego(num,nombre,plataforma,precio,stock);
        videojuegos.add(videojuego);
        System.out.println("Videojuego creado, ID del juego: " + num);
    }

    public void buscar(){
        System.out.println("Introduce la id del juego: ");
        int id = teclado.nextInt();
        for (Videojuego juego : videojuegos){
            if (juego.getId() == id){
                System.out.println("Tu juego es " + juego.getTitulo());
                break;
            }
        }
    }

    public void eliminar(){
        System.out.println("Introduce el id del juego que quieres eliminar");
        int id = teclado.nextInt();
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getId() == id){
                System.out.println("juego: " + videojuegos.get(i).getTitulo() + " ELIMINADO");
                videojuegos.remove(i);
                break;
            }
        }
    }

    public void almacenados(){
        System.out.println("Cuantos videojuegos hay almacenados?");
        System.out.println("Hay almacenados " + videojuegos.size() + " Videjuegos en la lista");
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
