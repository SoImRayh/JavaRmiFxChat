package misc;

public class ConsolePrinter {
    private static final String BASE_STRING = "%s[%s] -> %s%s\n";

    public static void ERROR(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_RED, who, ConsoleColors.ANSI_RESET, text);
    }

    public static void WARNING(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_YELLOW, who, ConsoleColors.ANSI_RESET, text);
    }

    public static void INFO(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_BLUE, who, ConsoleColors.ANSI_RESET, text);
    }


    public static void custom(String pattern, String... strings){
        System.out.format(pattern.concat("\n"),(Object[]) strings);
    }
    public static void clean(){
        System.out.flush();
    }


}
