package com.ravi.vagabond;

public class Dmmp {

    public static void main(String[] args) {

        int row = 3;
        int column = 3;

        int i =0;
        int j=0;

        boolean isValid = true;

        while (isValid) {

            if (i == 0 && j <=2 ) {
                System.out.println("*  (" + i + "," + j + ")");
                if(j!=2) j = i + 1;
            } else if (j == 2 && i <= 2) {
                System.out.println("+  (" + i + "," + j + ")");
                if (i!=2) i = i + 1;
            } else if (j == 2 && i > 0) {
                System.out.println("$  (" + i + "," + j + ")");
                i = i-1;
            }else {
                isValid = false;
            }

        }


    }
}
