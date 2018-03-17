package cipher;
public class Affine {
    public static String abecedario="abcdefghijklmnopqrstuvwxyz\u00f1\u00e1\u00e9\u00ed\u00f3\u00fa\u00e0\u00e8\u00ec\u00f2\u00f9\u00f9\u00e2\u00ea\u00ee\u00f5\u00fb\u00e4\u00eb\u00ef\u00f6\u00fc\u0153\u00e6\u00e7\u00df";
    public static String aux_abc="";
    
    public static void setABCLength(int n){
        int i=0;
        for (i = 0 ; i < n ; i++ )
            aux_abc += abecedario.charAt(i);
    }
    public static int verA(int a, int n) {
        for (int i = 1; i < n; i++) {
            if ((a * i) % n == 1) {
                return i;
            }
        }
        return 0;
    }

    public static char cifrar(int n, int a, int b, char car) {
        char E = ' ';
        if(Validate.belongsToTheAlphabet(car, aux_abc)){
            int vCar = Shift.getPosition(car, aux_abc);
            E =aux_abc.charAt(((a * vCar) + b) % n);
        }
        else
            E=car;
        return E;
    }

    public static char descifrar(int n, int a1, int b, char car) {
        char M = ' ';
        if(Validate.belongsToTheAlphabet(car, aux_abc)){
            int vCar = Shift.getPosition(car, aux_abc);
            if ((vCar - b) < 0) 
                M =aux_abc.charAt(((n + (vCar - b)) * a1) % n) ;
             else 
                M =aux_abc.charAt(((vCar - b) * a1) % n);
        }
        else
            M=car;
        return M;
    }
}
