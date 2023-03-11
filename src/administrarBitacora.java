
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author marcela
 */
public class administrarBitacora {

    private ArrayList files = new ArrayList();
    private File archivo = null;

    public administrarBitacora(String path) {
        archivo = new File(path);
    }

    public void setUsuario(Object p) {
        this.files.add(p);
    }

    public ArrayList getFiles() {
        return files;
    }

    public void setFiles(ArrayList files) {
        this.files = files;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    //metodos de administracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Object t : files) {
                if (t instanceof Archivo) {
                    bw.write(((Archivo) t).getNombre() + ";");

                    bw.write(((Archivo) t).getExtension() + ";");
                    bw.write(((Archivo) t).getTamanio() + ";");
                    //bw.write(((Archivo) t).getLink() + "\n");
                } else if (t instanceof Carpeta) {
                    bw.write(((Carpeta) t).getNombre() + ";");
                    //bw.write(((Carpeta) t).getLink()+ "\n");

                }
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public ArrayList<Object> cargarArchivo() {
//        
        Object[] guardarS = null;
        if (archivo.exists()) {
            try {
                FileReader fr = new FileReader("./Bitacora.txt");
                BufferedReader br = new BufferedReader(fr);

                guardarS = br.lines().toArray();
                br.close();
                fr.close();
            } catch (IOException e) {

            }
            for (int i = 0; i < guardarS.length; i++) {
                String[] cambiar = String.valueOf(guardarS[i]).split(";");
                if (cambiar.length == 2) {
                    Archivo a = new Archivo(cambiar[0], cambiar[1], Integer.parseInt(cambiar[3]));
                    files.add(a);
                } else {
                    Carpeta c = new Carpeta(cambiar[0]);
                    files.add(c);
                }

            }
        }

        return files;
    }
}
