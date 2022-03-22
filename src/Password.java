
/**
 *
 * @author kevin
 */
public final class Password {
    
    private final static int largo_defecto=8;
    
    private int longitud;
    private String contrasena;
            
    
    
  
    public int get_longitud(){
        return longitud;
    }
    public void set_longitud(int longitud){
        this.longitud = longitud;
    }
    
    public String get_contrasena(){
        return contrasena;
    }
    
    public String generarPassword(){
        String password="";
        for (int i=0;i<longitud;i++){
            
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
                char minusculas=(char)((int)Math.floor(Math.random()*(123-97)+97));
                password+=minusculas;
            }else{
                if(eleccion==2){
                    char mayusculas=(char)((int)Math.floor(Math.random()*(91-65)+65));
                    password+=mayusculas;
                }else{
                    char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
                    password+=numeros;
                }
            }
        }
        return password;
    }
    
    public boolean esFuerte(){
        int Cnumeros=0;
        int Cminusculas=0;
        int Cmayusculas=0;
        for (int i=0;i<contrasena.length();i++){
           if (contrasena.charAt(i)>=97 && contrasena.charAt(i)<=122){
                    Cminusculas+=1;
                }else{
                    if (contrasena.charAt(i)>=65 && contrasena.charAt(i)<=90){
                        Cmayusculas+=1;
                }else{
                    Cnumeros+=1;
                    }
                }
        }
            if (Cnumeros>=5 && Cminusculas>=1 && Cmayusculas>=2){
            return true;
        }else{
            return false;
        }
    }
   
    
   public Password(int longitud){
       this.longitud=longitud;
       contrasena=generarPassword();
       System.out.println("La contrasena generada es:"+contrasena);
       if(esFuerte()==true){
           System.out.println("La contrasena generada es fuerte");
       }else{
           System.out.println("La contrasena generada es debil");
       }
   }
   public Password(){
       this(largo_defecto);
   }
    
   
}
