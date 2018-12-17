
public class Scommessa
{
    Corsa corsa;
    boolean vincente;

    public boolean gioca(Corsa c, int[] podio)throws Exception{
        Cavallo[] cavalli = c.avviaCorsa();
        for(int i=0; i<cavalli.length; i++){
            Cavallo h = cavalli[i];
            int ultimoPiazzato = h.getUltimoPiazzamento()-1;
            if(ultimoPiazzato < podio.length){
                if(!(podio[ultimoPiazzato] == h.getNumero()))
                    return false;
            }
        }
        return true;
    }
}
