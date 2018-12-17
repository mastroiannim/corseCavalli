public class Ippodromo
{
    private Cavallo[] cavalli = Scuderia.creaCavalli();

    private static Thread[] creaCorsa(Cavallo[] cavalli){
        Thread[] corsa = new Thread[cavalli.length];
        for(int i = 0; i<corsa.length; i++){
            corsa[i] = new Thread(cavalli[i]);
        }
        return corsa;
    }

    public void avviaCorsa() throws Exception{
        System.out.println("--------- PARTITI ---------");
        Thread[] corsa = creaCorsa(cavalli);
        for(int i=0; i<corsa.length; i++){
            corsa[i].start();
        }

        for(int i=0; i<corsa.length; i++){
            corsa[i].join();
        } 
        aggiornaForma(cavalli);
    }

    private void aggiornaForma(Cavallo[] cavalli){
        java.util.Arrays.sort(cavalli, new java.util.Comparator<Cavallo>() 
            {
                @Override
                public int compare(Cavallo a, Cavallo b) { 
                    return (int) (a.getTempo() - b.getTempo()); 
                }
            }
        ); 
        for(int i=0; i<cavalli.length; i++){
            cavalli[i].setForma(i+1);
        } 
    }
}
