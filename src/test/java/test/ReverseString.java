package test;

public class ReverseString
{
    public static void main(String args[])
    {
        String str = "This is our country";
        char c[] = str.toCharArray();
        for(int i = c.length-1 ; i>=0 ; i--)
        {
            System.out.print(c[i]);
        }
    }
}
