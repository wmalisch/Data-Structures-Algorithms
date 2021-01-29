public class stringCompress {

    public static int compress(char[] chars){

        int anchor = 0, write = 0;

        for(int read = 0; read < chars.length; read++){
            if((read + 1) == chars.length || (read + 1) != chars[anchor]){
                chars[write++] = chars[anchor];
                if(read > anchor){
                    for(char c : ("" + (read - anchor)).toCharArray()){
                        chars[write++] = c;
                    }

                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args){
        char[] chars = {'a','a','b','b','b','c','c','c','c'};
        char[] more = {'d'};
        int write = 0;
        System.out.println(compress(chars));

    }
}
