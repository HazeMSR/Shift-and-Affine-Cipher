package cipher;
public class Affine {
    
    public static int verA(int a, int n) {
        for (int i = 1; i < n; i++) {
            if ((a * i) % n == 1) {
                return i;
            }
        }
        return 0;
    }

    public static char cifrar(int n, int a, int b, char car) {
        char E = 0;
        if (car > 96 && car < 123) {
            int vCar = (int) car - 97;
            int Affine = (((a * vCar) + b) % n) + 97;
            E = (char) Affine;
        } else if (car > 64 && car < 191) {
            int vCar = (int) car - 65;
            int Affine = (((a * vCar) + b) % n) + 65;
            E = (char) Affine;
        }
        //System.out.println("M = " + car + "\t E = " + E + "\tLetra = "+ vCar + "\tAffine = " + Affine);
        return E;
    }

    public static char descifrar(int n, int a1, int b, char car) {
        char M = 0;
        if (car > 96 && car < 123) {
            int vCar = (int) car - 97;
            int Affine;
            if ((vCar - b) < 0) {
                Affine = (((n + (vCar - b)) * a1) % n) + 97;
                M = (char) Affine;
            } else {
                Affine = (((vCar - b) * a1) % n) + 97;
                M = (char) Affine;
            }

        } else if (car > 64 && car < 191) {
            int vCar = (int) car - 65;
            int Affine;
            if ((vCar - b) < 0) {
                Affine = (((n + (vCar - b)) * a1) % n) + 65;
                M = (char) Affine;
            } else {
                Affine = (((vCar - b) * a1) % n) + 65;
                M = (char) Affine;
            }
        }
        //System.out.println("M = " + car + "\t E = " + E + "\tLetra = "+ vCar + "\tAffine = " + Affine);
        return M;
    }
}
