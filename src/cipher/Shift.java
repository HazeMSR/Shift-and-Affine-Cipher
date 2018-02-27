
package cipher;


public class Shift {
    String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //Base alphabet
    String changed_abc="";                   //New alphabet from using the key
    int abc_len=26;                          //Length of the alphabet

    //Gets the position of a character at the selected alphabet
    public int getPosition(char k, String alphab){
        int i=0;
        for( i = 0; i < abc_len ; i++ )
            if( k == alphab.charAt(i))
                return i;
        return i-1;
    }
    
    //Subtitute the key at the alphabet
    public void applyKey(String key){
        //Initialize the variables
        String abc_aux="";
        int i=0,j=0,k=0;
        int key_len=key.length();
        int[] key_pos = new int[key_len];
        char aux_c, aux_key;
        boolean flag=false;

        //Go through the alphabet until it finish saving the 26 characters in the new alphabet (changed_abc)
        for( k = 0 , i = 0 ; k < abc_len; i++ , k++){
            //If the index it's 26, restart the index value to 0 to start again with the base alphabet
            if( i >= 26 + key_len ) 
                i=0;
            //If the index is not greater than the length of the key, then copy the elements of the key to the beginning of the new alphabet.
            if( i < key_len ){
                aux_key = key.charAt(i);
                abc_aux += aux_key;
                key_pos[i] = getPosition(aux_key,abc);
            }
            //If not, perform the following algorithm
            else{
                flag=false;
                //This for is to scroll through the characters of the key and verify that they are not repeated in the new alphabet
                for( j = 0 ; j < key_len && flag == false ; j++){
                    if( i < key_len ){  //If the index get restart, verify if the index number is the same as the key character of j position
                        if(key_pos[j] == i)
                            flag = true; 
                    }
                    else{   //Else, verify if the key character of j position it's the same as i. It's subtracted the key length because we add the key at the first of the new alphabet
                        if(key_pos[j] == i-key_len)
                            flag = true; 
                    }
                }
                //In the case that we reset the index and no character of the key coincides, it copies the base alphabet element.
                if( i < key_len && flag == false )
                    abc_aux += abc.charAt(i);
                else{
                    //In that the index and no character of the key coincides, it copies the base alphabet element at position i less key length, because we add the key at the beginning of the alphabet
                    if( flag == false )
                        abc_aux += abc.charAt(i-key_len);
                    else
                        k--; 
                    //  ^ In otherwise, we subtract from the index k so that the algorithm does not end             
                }        
            }
        }
        changed_abc=abc_aux;    //Return the new alphabet
    }
    //This is the encrypt algorithm
    public String encryptText(String cad,boolean filter){
        String ret="";
        int i=0;
        char aux;
        for( i = 0 ; i < cad.length() ; i++){ //Go through the changed alphabet and compare the position of the character of the text to be encrypted with the base alphabet to obtain the new character
            aux=cad.charAt(i);
            if (Character.isLetter(aux)){
                ret += changed_abc.charAt(getPosition(aux,abc));
                if(filter==true && i+1%4==0)
                    ret+=" ";
            }
            else{
                if(filter==false)
                    ret += aux;
            }
        }
        return ret;
    }
    //This is the decrypt algorithm
    public String decryptText(String cad){ ////Go through the base alphabet and compare the position of the character of the text to be encrypted with the changed alphabet to obtain the new character
        String ret="";
        int i=0;
        char aux;
        for( i = 0 ; i < cad.length() ; i++){
            aux=cad.charAt(i);
            if (Character.isLetter(aux))
                ret += abc.charAt(getPosition(aux,changed_abc));
            else
                ret += aux;
        }
        return ret;
    }
}