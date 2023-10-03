package Java_Fundamental;

public class String_JV {
    public static void main(String[] args) {
        String S1 = "Gaming";
        String S2 = new String("Hell Yeah Baby");
        //Make an array out of given string
        String[] s3 = S2.split(" ");
        System.out.println(s3[0]);
        System.out.println(s3[1]);
        System.out.println(s3[2]);
        System.out.println();
        //trim method remove the left and right spaces
        System.out.println(s3[1].trim());
        System.out.println();
        //print out the string array
        for (int s = 0; s < S2.length(); s++){
            System.out.println(S2.charAt(s));
        }


    }
}
