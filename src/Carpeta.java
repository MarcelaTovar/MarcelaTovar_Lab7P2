
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcela
 */
public class Carpeta implements Serializable{
    private String nombre;
    private String link;
    private ArrayList<Archivo> archivos = new ArrayList();
    private ArrayList<Carpeta> carpetas = new ArrayList();
    private boolean destacado;
    private boolean papelera;
    
    private static final long SerialVersionUID=467L;

    public Carpeta() {
    }

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.destacado = false;
        this.papelera = false;
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

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public ArrayList<Carpeta> getCarpetas() {
        return carpetas;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public boolean isPapelera() {
        return papelera;
    }

    public void setPapelera(boolean papelera) {
        this.papelera = papelera;
    }
    
    

    public void setCarpetas(ArrayList<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }
    
    public String crearLinkCarpeta(){
        String acum = "";
        for (int i = 0; i < 5; i++) {
            char x;
            int random = new Random().nextInt((90-65)+1)+65;
            int ramdom2 = new Random().nextInt((122-97)+1)+97;
            if (i%2 == 0) {
                 x  = (char) ramdom2;
            }else{
                 x  = (char) random;
            }
            
            acum += x;
        }
        String m = "dive.google.com/"+this.nombre+"/"+(String)acum;
        return m;
    }

    @Override
    public String toString() {
        return  "Carpeta-> "+nombre +"\nArchivos-> "+archivos.toString()+"\nCarpetas-> "+carpetas.toString();
    }
    
    
    
}
