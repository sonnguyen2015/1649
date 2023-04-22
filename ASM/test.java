public class test {
    public static void TestBIgO() {
        int n = 100;
        System.out.println("hello" + n);
        System.out.println("Morning" + n);

    }
    public static void TestBigO1(){
        int n=100;
        for (int i=1; i<n;i=i*2){
            System.out.println("print n"+ i);
        }
    }
    public static void TestBigO4(){
        int n=100;
        for (int i=1; i<n;i++){
                System.out.println("print n");
        }
    }

    public static void TestBigO2(){
        int n=100;
        for (int i=1; i<n;i++){
            for ( i=1 ;i<n;i++)
            System.out.println("print n"+ i);
        }
    }

    public static void TestBigO3(){
        int n=100;
        for (int i=1; i<=Math.pow(2,n);i++){
            System.out.println("print n"+ i);
        }
    }

    public static String[] TestBigO(int n){
        String[] array=new String[n];
        for (int i=0; i<n;i++){
            array[i]="print";
        }
        return array;
    }

}
