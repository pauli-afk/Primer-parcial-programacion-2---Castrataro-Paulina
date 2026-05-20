/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author CGDELL
 */
public class Podcast extends Contenido implements Publicitable {
    private TipoPodcast tipoPodcast;

    public Podcast(String titulo, int duracion, String nombreArtista, String apellidoArtista, String paisArtista, TipoPodcast tipoPodcast) {
        super(titulo, duracion, nombreArtista, apellidoArtista, paisArtista);
        this.tipoPodcast = tipoPodcast;
    }

    @Override
    public int getDuracionConPublicidad() {
        if (this.tipoPodcast == TipoPodcast.TECNOLOGIA) {
            return this.duracion + 60;
        } else if (this.tipoPodcast == TipoPodcast.ENTRETENIMIENTO) {
            return this.duracion + 45;
        } else {
            return this.duracion + 20;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Podcast) {
            Podcast otro = (Podcast) obj;
            return super.equals(otro) && this.tipoPodcast == otro.tipoPodcast;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo podcast: " + this.tipoPodcast
                + "\nDuracion con publicidad: " + this.getDuracionConPublicidad();
    }
}
