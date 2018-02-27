
package cipher;


public class Cipher {
    


    public static void main(String[] args) {
        //Initialize all variables and objects
        boolean v1=false,v2=false,v3=false,v4=false,v5=false,filter=false;
        int n, a, a1, b,i;
        String keySh="",textSh="",encryptSh="",decryptSh="";
        String message,opc1="",opc2="",text="",writeRet="";
        String[] readRet=null;
 
        Object [] MainMenu= {"1. Affine cipher","2. Shift cipher","3. Exit"};
        Object [] AffineMenu= {"1. Encrypt file","2. Decrypt file","3. Return to the main menu","4. Exit"};
        Object [] ShiftMenu= {"1. Change key","2. Encrypt file","3. Decrypt file","4. Return to the main menu","5. Exit"};
        
        Shift sh = new Shift();
        System.out.println("\u00e1");
        do{ //While for the main menu
            do{
                opc1=Ventanas.seleccionS(MainMenu,"Select one option:", "Affine and Shift Cipher.",v1);
            }while(v1==true);
            if( opc1 == "1. Affine cipher" ){
            	do{     //While for the affine cipher
            		do{
            		    opc2=Ventanas.seleccionS(AffineMenu,"Select one option:", "Affine Cipher.",v2);
            		}while(v2==true);

            		if( opc2 == "1. Encrypt file" ){
            			n = Ventanas.entradaI("Enter the value of n");
	                    a = Ventanas.entradaI("Enter the value of a");
	
	                    a1 = Affine.verA(a, n);
	                    while (a1 == 0) {
	                        Ventanas.mensaje("The value " + a + " it is not allowed, try again.");
	                        a = Ventanas.entradaI("Enter the value of a");
	                        a1 = Affine.verA(a, n);
	                    }
	                    b = Ventanas.entradaI("Enter the value of b");

       					do{
       					     text = Ventanas.entradaS("Enter the filename of the text to encrypt.\nFor example: C:/text.txt");
       					     readRet = Files.readFile(text);
       					     if(readRet[0].length()>1){
       					         Ventanas.mensaje("An error occurred when opening your file. Try again.");
       					         System.out.println("Error: "+readRet[0]);
       					     }              
       					}while(readRet[0].length()>1);
       					message = readRet[1];
                                   	
         
       					          
	                    String cifMessage = "";
	                    for ( i = 0; i < message.length(); i++) {
	                        char letra = message.charAt(i);
	                        char cifLetra = Affine.cifrar(n, a, b, letra);
	                        if (letra == 32) {
	                            cifMessage = cifMessage + " ";
	                        } else {
	                            cifMessage = cifMessage + Character.toString(cifLetra);
	                        }
	                    }
                            System.out.println(cifMessage);
                            writeRet = Files.writeFile(text,"\n"+cifMessage);
                            if(writeRet.length()>1){
                                    Ventanas.mensaje("An error occurred writing your file. Try again.");
                                    System.out.println("Error: "+writeRet);
                            }
                            else
                                Ventanas.mensaje("Your file was sucessfully encrypt.");
	            	}
	            	if( opc2 == "2. Decrypt file" ){
	                    n = Ventanas.entradaI("Enter the value of n");
	                    a = Ventanas.entradaI("Enter the value of a");
	
	                    a1 = Affine.verA(a, n);
	                    while (a1 == 0) {
	                        Ventanas.mensaje("The value " + a + " it is not allowed, try again.");
	                        a = Ventanas.entradaI("Enter the value of a");
	                        a1 = Affine.verA(a, n);
	                    }
	
	                    b = Ventanas.entradaI("Enter the value of b");

       					do{
       					     text = Ventanas.entradaS("Enter the filename of the text to decrypt.\nFor example: C:/text.txt");
       					     readRet = Files.readFile(text);
       					     if(readRet[0].length()>1){
       					         Ventanas.mensaje("An error occurred when opening your file. Try again.");
       					         System.out.println("Error= "+readRet[0]);
       					     }              
       					}while(readRet[0].length()>1);
       					message = readRet[1];

	                    String descifMessage = "";
	                    for ( i = 0; i < message.length(); i++) {
	                        char letra = message.charAt(i);
	                        char decifLetra = Affine.descifrar(n, a1, b, letra);
	                        if (letra == 32) {
	                            descifMessage = descifMessage + " ";
	                        } else {
	                            descifMessage = descifMessage + Character.toString(decifLetra);
	                        }
	                    }
                            System.out.println(descifMessage);
	                    writeRet = Files.writeFile(text,descifMessage);
                            if(writeRet.length()>1){
                                    Ventanas.mensaje("An error occurred writing your file. Try again.");
                                    System.out.println("Error: "+writeRet);
                            }
                            else
                                Ventanas.mensaje("Your file was sucessfully encrypt.");
	            	}
	            	v3 = Ventanas.confirma("Continue?");
            	}while( opc2!="4. Exit" && opc2!="3. Return to the main menu" && v3==true );
            }                   
           	if(opc1 == "2. Shift cipher"){
                    do{  //While for the shift cipher
			       // Shift Cipher
            		if(keySh.length() < 1){	//If is the first time that the user uses the program
          			// Get the key from the user
			       		do{
			           		keySh = Ventanas.entradaS("Enter the key to encrypt:");
			           		v4 = Validate.repeatedChar(keySh);
			           		if (v4 == true)
			           		    Ventanas.mensaje("Your key should not have repeated characters, try again.");
			           		v5 = Validate.onlyLetters(keySh);
			           		if (v5 == false)
			           		    Ventanas.mensaje("Your key should have only letters, try again.");			           		
			       		}while(v4 == true || v5 == false);
			       		sh.applyKey(keySh.toUpperCase());
            		} 

           			do{
            		    opc2=Ventanas.seleccionS(ShiftMenu,"Select one option:", "Shift Cipher.",v2);
            		}while(v2==true);

            		if(opc2=="1. Change key"){	
          			// Get the key from the user
            			do{
			           		keySh = Ventanas.entradaS("Enter the key to encrypt:");
			           		v4 = Validate.repeatedChar(keySh);
			           		if (v4 == true)
			           		    Ventanas.mensaje("Your key should not have repeated characters, try again.");
			           		v5 = Validate.onlyLetters(keySh);
			           		if (v5 == false)
			           		    Ventanas.mensaje("Your key should have only letters, try again.");			           		
			       		}while(v4 == true || v5 == false);
			       		sh.applyKey(keySh.toUpperCase());
            		} 

			       if(opc2=="2. Encrypt file"){
			       		//Encrypt the file
			       		//Open the file
			       		do{
			       		     textSh = Ventanas.entradaS("Enter the filename of the text to encrypt.\nFor example: C:/text.txt");
			       		     readRet = Files.readFile(textSh);
			       		     if(readRet[0].length()>1){
			       		         Ventanas.mensaje("An error occurred when opening your file. Try again.");
			       		         System.out.println("Error= "+readRet[0]);
			       		 	}              
			       		}while(readRet[0].length()>1);
                                        filter = Ventanas.confirma("Do you want to filter NON LETTER character?");
			       		encryptSh = sh.encryptText(readRet[1].toUpperCase(),filter);
                                        System.out.println(encryptSh);
                                        writeRet = Files.writeFile(textSh,encryptSh);
                                            if(writeRet.length()>1){
                                                Ventanas.mensaje("An error occurred writing your file. Try again.");
                                                System.out.println("Error: "+writeRet);
                                            }
                                        Ventanas.mensaje("Your file was sucessfully encrypt.");
			       }
			       if(opc2=="3. Decrypt file"){
				       //Decrypt the text
				       //Open the file
				       do{
				            textSh = Ventanas.entradaS("Enter the filename of the text to decrypt.\nFor example: C:\\text.txt");
				            readRet = Files.readFile(textSh);
				            if(readRet[0].length()>1){
				                Ventanas.mensaje("An error occurred when opening your file. Try again.");
				                System.out.println("Error= "+readRet[0]);
				            }              
				       }while(readRet[0].length()>1);
				       decryptSh = sh.decryptText(readRet[1].toUpperCase());
                                       System.out.println(decryptSh);
                                       writeRet = Files.writeFile(textSh,decryptSh);
                                            if(writeRet.length()>1){
                                                Ventanas.mensaje("An error occurred writing your file. Try again.");
                                                System.out.println("Error: "+writeRet);
                                            }
				       Ventanas.mensaje("Your file was sucessfully encrypt.");
				}
	            	v3 = Ventanas.confirma("Continue?");
            	}while( opc2!="5. Exit" && opc2!="4. Return to the main menu" && v3==true );           		
           	}
        }while(opc1!="3. Exit." && opc2!="4. Exit" && opc2!="4. Exit" && v3==true);
    }
    
}
