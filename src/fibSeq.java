public class fibSeq {

    public static int fib(int n){
        if(n == 0){
            return 0;
        }else if( n == 1 ){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    public static int fibDynamic(int n){
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < n + 1; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];

    }

    public static void main(String[] args){
        int a = 3;
        int b = 8;
        int c = 3;
        System.out.println(fib(a));
        System.out.println(fib(b));
        System.out.println(fib(c));
    }
}
