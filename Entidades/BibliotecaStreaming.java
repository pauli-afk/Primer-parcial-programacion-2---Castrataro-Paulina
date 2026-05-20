/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author CGDELL
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BibliotecaStreaming {
    private int capacidad;
    private Collection<Contenido> contenidos;

    public BibliotecaStreaming() {
        this.capacidad = 3;
        this.contenidos = new ArrayList<>();
    }

    public BibliotecaStreaming(int capacidad) {
        this.capacidad = capacidad;
        this.contenidos = new ArrayList<>();
    }

    private boolean sonIguales(Contenido c) {
        for (Contenido contenido : this.contenidos) {
            if (contenido.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Contenido contenido) {
        if (this.contenidos.size() >= this.capacidad) {
            System.out.println("No hay lugar en la biblioteca.");
        } else if (this.sonIguales(contenido)) {
            System.out.println("El contenido ya se encuentra en la biblioteca.");
        } else {
            this.contenidos.add(contenido);
            System.out.println("Contenido agregado.");
        }
    }

    private int getDuracionContenido(TipoContenido tipoContenido) {
        if (tipoContenido == TipoContenido.CANCIONES) {
            return this.getDuracionCanciones();
        } else if (tipoContenido == TipoContenido.PODCASTS) {
            return this.getDuracionPodcasts();
        } else {
            return this.getDuracionTotal();
        }
    }

    private int getDuracionCanciones() {
        int total = 0;

        for (Contenido contenido : this.contenidos) {
            if (contenido instanceof Cancion) {
                total += ((Cancion) contenido).getDuracionConPublicidad();
            }
        }

        return total;
    }

    private int getDuracionPodcasts() {
        int total = 0;

        for (Contenido contenido : this.contenidos) {
            if (contenido instanceof Podcast) {
                total += ((Podcast) contenido).getDuracionConPublicidad();
            }
        }

        return total;
    }

    private int getDuracionTotal() {
        int total = 0;

        for (Contenido contenido : this.contenidos) {
            if (contenido instanceof Publicitable) {
                total += ((Publicitable) contenido).getDuracionConPublicidad();
            }
        }

        return total;
    }

    private void ordenar() {
        Collections.sort((ArrayList<Contenido>) this.contenidos);
    }

    @Override
    public String toString() {
        this.ordenar();

        String texto = "Cantidad de contenidos: " + this.contenidos.size() + "\n\n";

        for (Contenido contenido : this.contenidos) {
            texto += contenido.toString() + "\n-\n";
        }

        texto += "Duracion canciones: " + this.getDuracionContenido(TipoContenido.CANCIONES) + "\n";
        texto += "Duracion podcasts: " + this.getDuracionContenido(TipoContenido.PODCASTS) + "\n";
        texto += "Duracion total: " + this.getDuracionContenido(TipoContenido.TODOS) + "\n";

        return texto;
    }
}