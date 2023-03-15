package test.util;

// Unique import method for .rgg files which do not belong to any package
import RGGUtils;

/**
 * Utility is a necessary middle-man method to remove the need to 
 * import RGGUtils separately (due to differences between importing 
 * .java and .rgg).
 * <p>
 * Instead, classes can simply import the util package to access these methods.
 * 
 * @author Ou-An Chuang
 */
public class Utility {
    /**
     * Prints line to GroIMP console.
     * 
     * @param s The String to output to the GroIMP console.
     */
    public static void println(String s) {
        RGGUtils.print(s);
    }

    /**
     * Explicitly calls toString() on the given object and prints line to GroIMP console
     * with {@link #println(String s)}.
     * <p>
     * Safeguards against objects which cannot be implicitly converted to Strings.
     * 
     * @param s The String to output to the GroIMP console.
     */
    public static void println(Object obj) {
        Utility.println(obj.toString());
    }
}
