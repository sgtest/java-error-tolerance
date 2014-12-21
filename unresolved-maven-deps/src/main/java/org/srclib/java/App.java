package org.srclib.java;

// Fake imports from the dep that doesn't work.
import com.doesntexist.foo.Bar;
import com.doesntexist.foo.Qux;
import com.doesntexist.foo.ZazException;

// Imports from the dep that works.
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    // Reference the broken deps in such a way that anything
    // traversing the AST would encounter them before encounting some
    // working deps, to test that the grapher continues after errors.
    public Qux G(Bar x, CSVRecord c) throws IOException, ZazException {
        Qux q = new Qux(c);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(null);
        for (CSVRecord record : records) {
            String lastName = record.get("Last Name");
            String firstName = record.get("First Name");
            System.out.println(lastName + ", " + firstName + x.toString());
        }
        return q;
    }
}
