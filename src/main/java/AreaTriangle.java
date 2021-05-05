public class AreaTriangle {

    public static int GetAreaTriangle(int a, int b, int c) throws ExceptionForMinus {
        if(a<=0 || b<=0 || c<=0) throw new ExceptionForMinus();
        int p = (a + b + c) / 2;
        return Math.abs(p * (p - a) * (p - b) * (p - c));
    }
}





