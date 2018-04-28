# Customize dictionary settings

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