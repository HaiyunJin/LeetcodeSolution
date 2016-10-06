public class Solution {

    static public void main(String Argv[]){
        int x;
        x = 1;
        //x = 3999;
        String y ="";
        for ( int i = 0 ; i < 1000000 ; ++i) {
            //y = intToRoman(x);
            y = intToRomanplus(x);
        }
        System.out.println(y);
        //System.out.println(intToRoman(x));
        //System.out.println(intToRomanplus(x));
    }

    static public String intToRoman(int num) {
        // String roman = "";
        StringBuilder roman = new StringBuilder();
        int bits;
        int remainder;
        /** Add M*/
        bits = num/1000;
        remainder = num%1000;
        for (int i = 0 ; i < bits ; ++i ) 
            roman.append("M");
        
        bits = remainder/100;
        remainder %= 100;
        switch (bits) {
            case 1: roman.append("C");
                    break;
            case 2: roman.append("CC");
                    break;
            case 3: roman.append("CCC");
                    break;
            case 4: roman.append("CD");
                    break;
            case 5: roman.append("D");
                    break; 
            case 6: roman.append("DC");
                    break;
            case 7: roman.append("DCC");
                    break;
            case 8: roman.append("DCCC");
                    break;
            case 9: roman.append("CM");
                    break;
            case 0: break;
        }
        bits = remainder/10;
        remainder %= 10;
        switch (bits) {
            case 1: roman.append("X");
                    break;
            case 2: roman.append("XX");
                    break;
            case 3: roman.append("XXX");
                    break;
            case 4: roman.append("XL");
                    break;
            case 5: roman.append("L");
                    break; 
            case 6: roman.append("LX");
                    break;
            case 7: roman.append("LXX");
                    break;
            case 8: roman.append("LXXX");
                    break;
            case 9: roman.append("XC");
                    break;
            case 0: break;
        }        
        bits = remainder;
        switch (bits) {
            case 1: roman.append("I");
                    break;
            case 2: roman.append("II");
                    break;
            case 3: roman.append("III");
                    break;
            case 4: roman.append("IV");
                    break;
            case 5: roman.append("V");
                    break;
            case 6: roman.append("VI");
                    break;
            case 7: roman.append("VII");
                    break;
            case 8: roman.append("VIII");
                    break;
            case 9: roman.append("IX");
                    break;
            case 0: break;
        }
        return roman.toString();
    }
    
    static public String intToRomanplus(int num) {
        String roman = "";
        int bits;
        
        bits = num%10;
        switch (bits) {
            case 1: roman = "I" + roman;
                    break;
            case 2: roman = "II"+ roman;
                    break;
            case 3: roman = "III"+ roman;
                    break;
            case 4: roman = "IV"+ roman;
                    break;
            case 5: roman = "V"+ roman;
                    break; 
            case 6: roman = "VI"+ roman;
                    break;
            case 7: roman = "VII"+ roman;
                    break;
            case 8: roman = "VIII"+ roman;
                    break;
            case 9: roman = "IX"+ roman;
                    break;
            case 0: if (num < 10 ) return roman;
                    break;
        }

        bits = num%100/10;
        switch (bits) {
            case 1: roman = "X"+ roman;
                    break;
            case 2: roman = "XX"+ roman;
                    break;
            case 3: roman = "XXX"+ roman;
                    break;
            case 4: roman = "XL"+ roman;
                    break;
            case 5: roman = "L"+ roman;
                    break; 
            case 6: roman = "LX"+ roman;
                    break;
            case 7: roman = "LXX"+ roman;
                    break;
            case 8: roman = "LXXX"+ roman;
                    break;
            case 9: roman = "XC"+ roman;
                    break;
            case 0: if (num < 100 ) return roman;
                    break;
        }        

        bits = num%1000/100;
        switch (bits) {
            case 1: roman = "C"+ roman;
                    break;
            case 2: roman = "CC"+ roman;
                    break;
            case 3: roman = "CCC"+ roman;
                    break;
            case 4: roman = "CD"+ roman;
                    break;
            case 5: roman = "D"+ roman;
                    break; 
            case 6: roman = "DC"+ roman;
                    break;
            case 7: roman = "DCC"+ roman;
                    break;
            case 8: roman = "DCCC"+ roman;
                    break;
            case 9: roman = "CM"+ roman;
                    break;
            case 0: if (num < 1000 ) return roman;
                    break;
        }

        /* Add M*/
        bits = num/1000;
        for (int i = 0 ; i < bits ; ++i ) 
            roman = "M"+ roman;
        
        return roman;
    }
}
