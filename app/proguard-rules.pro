# Customize dictionary settings

-ignorewarnings
-keep class com.wdullaer.**
-keep class com.bignerdranch.**
-keep class com.codetroopers.**
-keep class com.getbase.**
-keep class com.google.**
-obfuscationdictionary proguard_dic.txt
-classobfuscationdictionary proguard_dic2.txt
-packageobfuscationdictionary proguard_dic3.txt
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-dontshrink
-dontoptimize
-flattenpackagehierarchy app
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int d(...);
    public static int e(...);
    public static int w(...);
}