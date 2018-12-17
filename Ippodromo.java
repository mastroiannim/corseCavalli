public class Ippodromo
{
    Cavallo[] cavalli = Scuderia.creaCavalli();
    
     public static Thread[] creaCorsa(Cavallo[] cavalli){
        Thread[] corsa = new Thread[cavalli.length];
        for(int i = 0; i<corsa.length; i++){
            corsa[i] = new Thread(cavalli[i]);
        }
        return corsa;
    }
    
    public void avviaCorsa1() throws Exception{
        Thread[] corsa1 = creaCorsa(cavalli);
        int arrivati = 0;
        for(int i=0; i<corsa1.length; i++){
            corsa1[i].start();
        }
        
        for(int i=0; i<corsa1.length; i++){
            corsa1[i].join();
        } 
        aggiornaForma(cavalli);
    }
    
    class OrdinaPerTempo implements java.util.Comparator<Cavallo> 
    { 
        public int compare(Cavallo a, Cavallo b) 
        { 
            return (int) (a.getTempo() - b.getTempo()); 
        } 
    } 
    
    private void aggiornaForma(Cavallo[] cavalli){
        
        java.util.List colList = new java.util.ArrayList(java.util.Arrays.asList(cavalli));
        java.util.Collections.sort(colList, new OrdinaPerTempo());
        cavalli = colList.toArray(new Cavallo[cavalli.length]);
        for(int i=0; i<cavalli.length; i++){
            cavalli[i].setForma(i+1);
        } 
    }
}
