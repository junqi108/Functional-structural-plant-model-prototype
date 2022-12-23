package fspm.util;

import RGGUtils;

public class Utility {
    /**
     * Prints line to GroIMP console.<p>
     * Necessary middle-man method to remove the need to import RGGUtils separately
     * (due to differences between importing .java and .rgg).
     * Instead, classes can simply import the util package to access this method.
     * @param s
     */
    public static void println(String s) {
        RGGUtils.print(s);
    }
}
