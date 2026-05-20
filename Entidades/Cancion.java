/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author CGDELL
 */
public class Cancion extends Contenido implements Publicitable {
    private GeneroMusical generoMusical;
    private CalidadAudio calidadAudio;

    public Cancion(String titulo, int duracion, Artista artista, GeneroMusical generoMusical, CalidadAudio calidadAudio) {
        super(titulo, duracion, artista);
        this.generoMusical = generoMusical;
        this.calidadAudio = calidadAudio;
    }

    @Override
    public int getDuracionConPublicidad() {
        if (this.calidadAudio == CalidadAudio.BAJA) {
            return this.duracion + 30;
        } else if (this.calidadAudio == CalidadAudio.MEDIA) {
            return this.duracion + 20;
        } else {
            return this.duracion;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Cancion) {
            Cancion otra = (Cancion) obj;
            return super.equals(otra) && this.generoMusical == otra.generoMusical;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nGenero musical: " + this.generoMusical
                + "\nCalidad audio: " + this.calidadAudio
                + "\nDuracion con publicidad: " + this.getDuracionConPublicidad();
    }
}
