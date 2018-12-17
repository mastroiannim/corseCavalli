public class Scuderia
{
    public static Cavallo[] creaCavalli(){
        Cavallo[] c = new Cavallo[5];
        c[0] = new Cavallo("MakerHawk", 1);
        c[1] = new Cavallo("Carbide", 2);
        c[2] = new Cavallo("MotorDriver", 3);
        c[3] = new Cavallo("ServoDriver", 4);
        c[4] = new Cavallo("MicroPython", 5);
        return c;
    }
}
