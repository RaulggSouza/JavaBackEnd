public class NamingConventions{
    public static boolean isFollowingConventional(String name, Convention convention){
        switch (convention){
            case VARIABLE:
                break;
            case CONSTANT:
                int i = 4;
                break;
            case CLASS:
                int j = 5;
                break;
            case METHOD:
                int h = 3;
                break;
        }
        return true;
    }
    public static String fromConstToVariable(String cons){
        return "";
    }
    public static String fromVariableToConst(String var){
        return "";
    }
    public static boolean isValidJavaIdentifier(String identifier){
        return true;
    }
}
