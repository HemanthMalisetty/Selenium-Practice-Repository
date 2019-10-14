package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintUniqueNumbers
{
    public static void main(String args[])
    {
        Integer a[] = {7,4,1,3,4};
        Set set = new HashSet(Arrays.asList(a));
        Set set2 = new TreeSet(set);
        System.out.println(set);
        System.out.println(set2);
    }
}
