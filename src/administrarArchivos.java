
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcela
 */
public class administrarArchivos {
    private ArrayList<Archivo> listaArchivos = new ArrayList();
    private File archivo = null;
    
    public administrarArchivos( String path) {
        archivo = new File(path);
    }

    public ArrayList<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setArchivo(Archivo p) {
        this.listaArchivos.add(p);
    }
    
    public void cargarArchivo() {
        try {            
            listaArchivos = new ArrayList();
            Archivo temp;
            if (archivo.exists()) {
                  FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Archivo) objeto.readObject()) != null) {
                        listaArchivos.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            } //fin if           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Archivo t : listaArchivos) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
