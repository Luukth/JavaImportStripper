package org.example;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String getPackage(String _import) {
        if (!_import.contains(".")) return _import;

        String[] split;
        String result = _import;
        do {
            result = result.substring(0, result.lastIndexOf("."));
            split = result.split("\\.");
        } while (Character.isUpperCase(split[split.length - 1].charAt(0)));

        return result;
    }
}
