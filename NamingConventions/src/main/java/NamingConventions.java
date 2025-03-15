public class NamingConventions {
    public static boolean isFollowingConvetion(String name, Convention convention){
        return true;
    }

    public static String fromConstToVariable(String name){
        return "";
    }

    public static String fromVariableToConst(String name){
        return "";
    }

    public static boolean isValidJavaIdentifier(String identifier){
        if (identifier.isEmpty()) return false;
        if (!identifier.startsWith("$") && !identifier.startsWith("_") && !Character.isLetter(identifier.charAt(0))) return false;
        return !identifier.contains(" ");
    }
}
