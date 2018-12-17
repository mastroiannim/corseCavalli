
public class Cavallo extends Thread
{
    String nickname;
    int numero, corsa;
    int [] forma = new int[3]; //ultimi piazzamenti [1,1,1]
    long partenza, arrivo, tempo;
    boolean cadutoUltimaCorsa;

    public Cavallo(String nickname, int numero){
        corsa = 0;
        this.nickname = nickname;
        this.numero = numero;
        cadutoUltimaCorsa = false;
    }

    public void run(){
        parte();
        if(corre()){
            tempo = arriva();
            System.out.println(this + " arriva dopo " + tempo + " ms");
            cadutoUltimaCorsa = false;
        }else{
            System.out.println(this + " è caduto");
            arrivo = Long.MAX_VALUE;
            tempo = arrivo - partenza;
            cadutoUltimaCorsa = true;
        }
    }

    private void parte(){
        partenza = System.currentTimeMillis();
    }

    private boolean corre(){
        try{
            double r = Math.random() * 1000;
            if(cadutoUltimaCorsa){
                r = r*1.2;
            }
            Thread.sleep(100 + (int)r);
            if(r < 100) throw new RuntimeException("caduto");
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
        if(corsa < forma.length){
            forma[corsa] = piazzamento;
            corsa++;
        }else{
            corsa = forma.length -1;
            System.arraycopy(forma, 1, forma, 0, forma.length-1);
            forma[corsa] = piazzamento;
        }
    }
    
    public String toString(){
        return nickname + java.util.Arrays.toString(forma); 
    }
}
