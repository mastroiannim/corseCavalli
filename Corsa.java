import java.util.*;

public class Corsa
{
    private Cavallo[] cavalli = Scuderia.creaCavalli();

    public Cavallo[] avviaCorsa() throws Exception{
        System.out.println("--------- PARTITI ---------");
        Thread[] corsa = new Thread[cavalli.length];
        for(int i = 0; i<corsa.length; i++){
            corsa[i] = new Thread(cavalli[i]);
        }
        for(int i=0; i<corsa.length; i++){
            corsa[i].start();
        }
        for(int i=0; i<corsa.length; i++){
            corsa[i].join();
        } 
        aggiornaForma(cavalli);
        return cavalli;
    }

    private void aggiornaForma(Cavallo[] cavalli){
        Arrays.sort(cavalli); 
        for(int i=0; i<cavalli.length; i++){
            cavalli[i].setForma(i+1);
        } 
    }
}
