
public class Cavallo extends Thread
{
    String nickname;
    int numero, corsa;
    int [] forma; //ultimi 10 piazzamenti [1,1,1,1,1,1,1,1,1,1]
    long partenza, arrivo, tempo;
    
    public Cavallo(String nickname, int numero){
        corsa = 0;
        this.nickname = nickname;
        this.numero = numero;
        forma = new int[10];
    }
    
    public void run(){
        parte();
        if(corre()){
            tempo = arriva();
            System.out.println("il cavallo " + nickname + " arriva dopo " + tempo + " ms");
        }else{
            System.out.println("il cavallo " + nickname + " è caduto");
        }
    }
    
    private void parte(){
        corsa++;
        partenza = System.currentTimeMillis();
    }
    
    private boolean corre(){
        try{
            double r = Math.random() * 1000;
            Thread.sleep(100 + (int)r);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    private long arriva(){
        arrivo = System.currentTimeMillis();
        return arrivo - partenza;
    }
    
    public long getTempo(){
        return tempo;
    }
    
    public void setForma(int piazzamento){
        forma[corsa] = piazzamento;
    }
    
    
}
