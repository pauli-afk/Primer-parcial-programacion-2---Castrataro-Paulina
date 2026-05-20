/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Random;

public abstract class Contenido implements Comparable<Contenido> {
    protected Artista artista;
    protected String titulo;
    protected int duracion;
    protected int likes;
    protected static Random generadorLikes;

    static {
        Contenido.generadorLikes = new Random();
    }

    public Contenido(String titulo, int duracion, Artista artista) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = artista;
        this.likes = 0;
    }

    public Contenido(String titulo, int duracion, String nombreArtista, String apellidoArtista, String paisArtista) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = new Artista(nombreArtista, apellidoArtista, paisArtista);
        this.likes = 0;
    }

    public int getLikes() {
        if (this.likes == 0) {
            this.likes = Contenido.generadorLikes.nextInt(1000000) + 1;
        }
        return this.likes;
    }

    private static String mostrar(Contenido contenido) {
        return "Titulo: " + contenido.titulo
                + "\nArtista: " + contenido.artista.getArtista()
                + "\nDuracion: " + contenido.duracion
                + "\nLikes: " + contenido.getLikes();
    }

    public static boolean sonIguales(Contenido c1, Contenido c2) {
        return c1.titulo.equals(c2.titulo)
                && Artista.sonIguales(c1.artista, c2.artista);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Contenido) {
            return Contenido.sonIguales(this, (Contenido) obj);
        }
        return false;
    }

    @Override
    public String toString() {
        return Contenido.mostrar(this);
    }

    @Override
    public int compareTo(Contenido otro) {
        int resultado = this.artista.getApellido().compareTo(otro.artista.getApellido());

        if (resultado == 0) {
            resultado = this.artista.getNombre().compareTo(otro.artista.getNombre());
        }

        if (resultado == 0) {
            resultado = this.titulo.compareTo(otro.titulo);
        }

        return resultado;
    }
}
