package org.example.javaxercise.chap5.stringbuilder;

// stringbuilder
// delete
// break
// static final variable
// lastIndexOf
public class CompressSpace {
    public static void main(String[] args) {
//        System.out.println("Will     you shut up,   man!     This is the way!".length()); // 49
        System.out.println(compressSpace(new StringBuilder("Will     you shut up,   man!     This is the way!"))); // -> "Will you shut up, man! This is the way!"
    }

    public static StringBuilder compressSpace(StringBuilder string) {
//        System.out.println(string.length()); // 49
        System.out.print(string + " -> ");
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
//                if (string.charAt(i+1) == ' ') {
//                    string.delete(i, i+1);
//                }
                int spaces = 0; // amount of spaces found
                for (int j = i; j < string.length(); j++) { // start at the current space found position
                    if (string.charAt(j) != ' ') { // only when it's a space we count up
                        break; // escape this loop and continue checking
                    }
                    spaces++;
                }

//                System.out.println(spaces);
                if (spaces > 1) { // only delete spaces when amount of spaces is bigger than 1
                    string.delete(i+1, i + spaces); // delete from the index where 1 or more space(s) too many
                }
            }
        }

        return string;
    }
}

// solution
/*
public class CompressSpace {

    //tag::solution[]
    public static final String TWO_SPACES = "  ";

    static String compressSpace( String string ) {
        return compressSpace( new StringBuilder( string ) ).toString();
    }

    static StringBuilder compressSpace( StringBuilder string ) {
        int index = string.lastIndexOf( TWO_SPACES );

        while ( index >= 0 ) {
            string.deleteCharAt( index );
            index = string.lastIndexOf( TWO_SPACES );
        }
        return string;
    }
    //end::solution[]

    public static void main( String[] args ) {
        String s = compressSpace( "Will  you  shut  up,  man!    This is the way!" );
        System.out.println( s );
    }
}*/
