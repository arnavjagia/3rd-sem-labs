public class ascii {
    public static void main(String[] args) {
        for(int i = 0; i <= 255; i++) {
            System.out.print(i + " - " + (char) i + "\t");
            if (i%10==0) System.out.println();
        }
    }
}
