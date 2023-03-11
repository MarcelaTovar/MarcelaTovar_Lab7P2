
import javax.swing.JProgressBar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcela
 */
public class HiloProgressBar extends Thread{
    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;
    int tamanio;

    public HiloProgressBar(JProgressBar barra) {
        this.barra = barra;
        avanzar = true;
        vive = true;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    

    @Override
    public void run() {
        while (vive) {
            if (avanzar) {
                barra.setValue(barra.getValue() + 10);
                if (barra.getValue() == tamanio) {
                    vive = false;
                }
            } 

            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {

            }
        }
    }
}
