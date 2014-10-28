/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs
 * Class: Utilities
 * Created: 10/28/14 11:38 AM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs;

public class Utilities {

    public static Boolean isNullOrEmpty(String text) {
        if(text == null || text.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
