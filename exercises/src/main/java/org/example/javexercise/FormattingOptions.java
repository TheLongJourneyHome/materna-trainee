package org.example.javexercise;

import java.io.PrintStream;
import java.util.Date;

public class FormattingOptions {
    public static void main(String[] args) {
        PrintStream o = System.out;


        int i = 123;

        o.printf("|%d|%d|%n", i, -i);      // |123|-123|

        o.printf("|%5d|%5d|%n", i, -i);      // |  123| -123|

        o.printf("|%-5d|%-5d|%n", i, -i);      // |123  |-123 |

        o.printf("|%+-5d|%+-5d|%n", i, -i);      // |+123 |-123 |

        o.printf("|%05d|%05d|%n%n", i, -i);      // |00123|-0123|


        o.printf("|%X|%x|%X|%n", 0xabc, 0xabc, -0xabc); // |ABC|abc|FFFFF544|

        o.printf("|%04x|%#x|%n%n", 0xabc, 0xabc); // |0abc|0xabc|


        double d = 12345.678;

        o.printf("|%f|%f|%n", d, -d);    // |12345,678000|-12345,678000|

        o.printf("|%+f|%+f|%n", d, -d);    // |+12345,678000|-12345,678000|

        o.printf("|% f|% f|%n", d, -d);    // | 12345,678000|-12345,678000|

        o.printf("|%.2f|%.2f|%n", d, -d);    // |12345,68|-12345,68|

        o.printf("|%,.2f|%,.2f|%n", d, -d);    // |12.345,68|-12.345,68|

        o.printf("|%(.2f|%(.2f|%n", d, -d);    // |12345,68|(12345,68)|

        o.printf("|%10.2f|%10.2f|%n", d, -d);    // |  12345,68| -12345,68|

        o.printf("|%010.2f|%010.2f|%n%n", d, -d);    // |0012345,68|-012345,68|


        String s = "Gobbledygook";

        o.printf("|%s|%n", s);                    // |Gobbledygook|

        o.printf("|%S|%n", s);                    // |GOBBLEDYGOOK|

        o.printf("|%20s|%n", s);                  // |        Gobbledygook|

        o.printf("|%-20s|%n", s);                 // |Gobbledygook        |

        o.printf("|%7s|%n", s);                   // |Gobbledygook|

        o.printf("|%.7s|%n", s);                  // |Gobbled|

        o.printf("|%20.7s|%n%n", s);              // |             Gobbled|


        Date t = new Date();

        o.printf("%tT%n", t);                     // 18:19:20

        o.printf("%tD%n", t);                     // 09/13/2

        // better use local date for dates

        // --> learned, use % before and there are more setting, see above!
    }
}
