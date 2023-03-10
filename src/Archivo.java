
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcela
 */
public class Archivo implements Serializable{
    private String nombre;
    private String link;
    private String extension;
    private double tamanio;
    
    private static final long SerialVersionUID=777L;

    public Archivo() {
    }

    public Archivo(String nombre, String link, String extension, double tamanio) {
        this.nombre = nombre;
        this.link = link;
        this.extension = extension;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }
    
    public String crearLink(){
        String acum = "";
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt((90-65)+1)+65;
            int ramdom2 = new Random().nextInt((122-97)+1)+97;
            char x  = (char) ramdom2;
            acum += x;
        }
        String m = "dive.google.com/"+(String)acum;
        return m;
    }

    @Override
    public String toString() {
        return nombre + "\nLink-> " + link + "\nExtension-> " + extension + "\nTamanio-> " + tamanio ;
    }
    
    
    
    
}
