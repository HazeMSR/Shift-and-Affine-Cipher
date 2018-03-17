
package cipher;

public class Validate {
    //Validate if a String has repeated characters in itself
    public static boolean repeatedChar(String cad){
        int i=0,j=0;
        int cad_len=cad.length();
        for( i = 0 ; i < cad_len ; i++ ){
            for( j = i+1 ; j < cad_len ; j++ )
                if( cad.charAt(i) == cad.charAt(j) )
                    return true;
        }
        return false;
    }
    //Validate if a String has only letters
    public static boolean onlyLetters(String cad){
        int i=0;
        for( i = 0 ; i < cad.length() ; i++ ){
            if( Character.isLetter(cad.charAt(i)) != true )
                return false;
        }
        return true;
    }
    //Return if the character belong to the alphabet
    public static boolean belongsToTheAlphabet(char c,String alphab){ 
        boolean ret=false;
        int i = 0 , n = alphab.length();

        //Go through the base alphabet and compare the position of the character and returns true or false
        for( i = 0 ; i < n && ret == false ; i++ ){
            if( c == alphab.charAt(i) )
                ret=true;
        }
        return ret;
    }
}
