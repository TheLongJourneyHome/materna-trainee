package org.example.javexercise.chap5;

// Zeichenketten
public class HtmlBuilder {
    public static void main(String[] args) {
        System.out.println(htmlElement( "strong", "strong is bold" )); // → "<strong>strong is bold</strong>"

        System.out.println(strong( emphasized( "strong + emphasized" ) )); // → "<strong><em>strong + emphasized</em></strong>"

        System.out.println(htmlElement("span", null)); // → "<span></span>"

        System.out.println(htmlElement("", "no")); // → "no"

        System.out.println(htmlElement(null, "not strong")); // → "not strong"

        System.out.println(htmlElement(null, null)); // → ""
    }

    public static String htmlElement (String tag, String body) {
        String newString;
        String startTag;
        String endTag;
        String newBody = body;

        if (body == null) {
            newBody = "";
        }


        if (tag == null || tag.isBlank()) {
            return newBody;
        }

        startTag = "<" + tag + ">";
        endTag = "</" + tag + ">";
        newString = startTag + newBody + endTag;

//        System.out.println(newString);

        return newString;
    }

    public static String strong (String body) {
        return htmlElement("strong",body);
    }

    public static String emphasized(String body) {
        return htmlElement("em", body);
    }
}


// solution
/*
//tag::solution[]
public static String htmlElement( String tag, String body ) {
    if ( tag == null )
        tag = "";
    if ( body == null )
        body = "";
    if ( tag.isEmpty() )
        return body;
    else
        return "<" + tag + ">" + body + "</" + tag + ">";
}

    public static String strong( String body ) {
        return htmlElement( "strong", body );
    }

    public static String emphasized( String body ) {
        return htmlElement( "em", body );
    }
    //end::solution[]

    public static void main( String[] args ) {
        System.out.println( htmlElement( "strong", "strong is bold" ) );
        System.out.println( strong( emphasized( "strong + emphasized" ) ) );
        System.out.println( htmlElement( "span", null ) );
        System.out.println( htmlElement( "", "no" ) );
        System.out.println( htmlElement( null, "not bold" ) );
        System.out.println( htmlElement( null, null ) );
    }*/
