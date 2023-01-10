package org.example.javaxercise.chap5.stringbuilder;

// stringbuilder
// capacity
public class ABCZ {
/*    Ändere die Methode abcz(), sodass der String dynamisch über eine Schleife generiert wird.

    Ergänze eine Methode String abcz(char start, char end), die einen String mit allen Symbolen generiert, die zwischen dem Anfangsbuchstaben start und dem Endbuchstaben end liegen; das Endezeichen ist inklusiv und gehört mit zum String.

    Schreibe dann die Methode String abcz(char start, int length), die length Zeichen ab start liefert. Lässt sich eine der Methoden auf die andere abbilden?

    Überlege, wie mit fehlerhaften Parametern umzugehen ist, wenn etwa der Endindex vor dem Startindex liegt.*/
    public static void main(String[] args) {
        System.out.println('A');
        System.out.println((char)('A'+5));
        System.out.println();
        System.out.println(abcz());
        abcz('C','I');
        abcz('B', 5);
    }

    static String abcz() {
        String alphabet;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            result.append(alphabet.charAt(i));
        }

        return result.toString();
    }

    public static String abcz(char start, char end) {

        if (start >= 'A' && start <= 'Z' && end >= 'A' && end <= 'Z') {
            if (start > end) {
                System.out.println("Begin with the smaller character first!");
                return "";
            }

            StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            int startIndex = alphabet.indexOf(String.valueOf(start));
            int endIndex = alphabet.indexOf(String.valueOf(end)) + 1; // end should be inclusive

            String result = alphabet.substring(startIndex, endIndex);
            System.out.println(result);
            return result;
        } else {
            System.out.println("Please only use characters between A-Z");
            return "";
        }
    }

    public static String abcz(char start, int length) {
        char end = (char)(start + length);
        return abcz(start, end);
    }
}

// solution
/*public class ABCZ {

    //tag::solution[]
    static String abcz() {
        StringBuilder result = new StringBuilder();

        for ( char c = 'A'; c <= 'Z'; c++ )
            result.append( c );

        return result.toString();
    }

    static String abcz( char start, char end ) {

        if ( end < start )
            return "";

        StringBuilder result = new StringBuilder( end - start + 1 );
        for ( char c = start; c <= end; c++ )
            result.append( c );

        return result.toString();
    }

    static String abcz( char start, int length ) {
        return abcz( start, (char) (start + length - 1) );
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( abcz() );
        System.out.println( abcz( 'a', 'g' ) );
        System.out.println( abcz( 'a', 'a' ) );
        System.out.println( abcz( 'z', 'g' ) );
        System.out.println( abcz( 'a', 2 ) );
    }
}*/
