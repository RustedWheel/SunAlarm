# Customize dictionary settings
#-ignorewarning
-keep class com.wdullaer.**
-keep class com.bignerdranch.**
-keep class com.codetroopers.**
-keep class com.getbase.**
-keep class com.google.**
-keep class com.wrapp.**
-keep class com.android.**
-keep class android.arch.**
-keep class com.code-troopers.**
-keep class org.** 
-dontwarn org.apache.**
-dontwarn org.apache.http.**
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

-keep class javax.** { *; }
-keep class org.** { *; }
-keep class twitter4j.** { *; }

-dontwarn javax.management.**
-dontwarn java.lang.management.**
-dontwarn org.apache.log4j.**
-dontwarn org.apache.commons.logging.**
-dontwarn org.slf4j.**
-dontwarn org.json.**


-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep class javax.**
-keep class org.**
-keep class twitter4j.**
-keep interface org.apache.http.**
-keep class org.apache.commons.codec.binary.**
-keep interface org.apache.commons.codec.binary.**
-keep enum org.apache.commons.codec.binary.**
-keep class org.slf4j.**
-keep interface org.slf4j.**
-keep enum org.slf4j.**
-keep class com.sun.syndication.io.**
-keep interface com.sun.syndication.io.**
-keep enum com.sun.syndication.io.**
-keep class com.sun.syndication.feed.synd.**
-keep interface com.sun.syndication.feed.synd.**
-keep enum com.sun.syndication.feed.synd.**
-keep class com.wecaresoftware.elfone.libstartotherapp.rom.** { *; }

###-----------基本配置-不能被混淆的------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.app.Notification

#support.v4/v7包不混淆
-keep class android.support.** { *; }
-keep class android.support.v4.** { *; }
-keep public class * extends android.support.v4.**
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v7.** { *; }
-keep public class * extends android.support.v7.**
-keep interface android.support.v7.app.** { *; }
-dontwarn android.support.**    # 忽略警告
#保持注解继承类不混淆
-keep class * extends java.lang.annotation.Annotation {*;}

#保持Serializable实现类不被混淆
-keepnames class * implements java.io.Serializable

#保持Serializable不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#保持枚举enum类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#自定义组件不被混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}
#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
#StartOtherApp 反射#
-keep class com.wecaresoftware.elfone.libstartotherapp.rom.** { *; }

#####混淆保护自己项目的部分代码以及引用的第三方jar包library - start #######
-keep class org.dom4j.** { *; }
-dontwarn org.dom4j.**
-keep class com.sun.msv.datatype.** { *; }
-keep class org.relaxng.datatype.** { *; }
-keep class com.google.gson.** { *; }
-keep class org.gjt.xpp.** { *; }
-keep class java.beans.** { *; }
-keep class javax.xml.stream.** { *; }
-keep class javax.xml.bind.** { *; }
-keep class javax.swing.tree.** { *; }
-keep class javax.swing.table.** { *; }


-keep class com.sinovoice.hcicloudsdk.** { *; }
-keep class javax.sound.sampled.** { *; }
-dontwarn com.sinovoice.hcicloudsdk.**

-keep class okio.** { *; }
-keep class org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-keep class java.nio.file.** { *; }
-dontwarn okio.**

-keep class org.jaxen.** { *; }
-keep class nu.xom.** { *; }
-keep class org.jdom.** { *; }
-dontwarn org.jaxen.**

-keep class com.amap.** { *; }
-keep class com.ximalaya.ting.android.** { *; }
-keep class okhttp3.internal.** { *; }

-keep class org.codehaus.mojo.** { *; }
-keep class com.baidu.speech.VoiceRecognitionService
-keep class com.android.vending.licensing.ILicensingService
-keep class com.google.vending.licensing.ILicensingService

-keep interface org.w3c.dom.UserDataHandler
-keep interface org.w3c.dom.Node
-dontwarn org.w3c.dom.**

#libcocos2dx#
-keep class org.cocos2dx.lib.** {*;}
#IntelligentDecision#
-keepclasseswithmembers class * {
     public void setCallback(...);
     public void start(...);
}
-keep class com.wecaresoftware.elfone.staterun.* {
     public void setCallback(...);
     public void start(...);
}
#eventbus#
-keep class de.greenrobot.event.** {*;}
-keep class com.wecaresoftware.elfone.robotbus.** {*;}
-keep public class * extends com.wecaresoftware.elfone.robotbus.RobotBus{
     <methods>;
}
-keep class cn.smssdk.**{*;}
-dontwarn cn.smssdk.**

-keep class com.mob.**{*;}
-dontwarn com.mob.**

#glide#
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#gson解析相关类#
-keep class com.wecare.elfone.pet.PetInfo{
     <fields>;
}
-keep class com.wecare.elfone.pet.FamiliarUser{
     <fields>;
}
-keep class com.wecare.elfone.pet.PetPhoneAccount{
     <fields>;
}
-keep class com.wecaresoftware.elfone.dancelib.dance.Action{
     <fields>;
}
-keep class com.wecaresoftware.elfone.dancelib.dance.Dance{
     <fields>;
}
-keep class com.wecaresoftware.elfone.dancelib.dance.ElfoneDance{
     <fields>;
}
-keep class com.wecaresoftware.elfone.dancelib.dance.DanceToUI{
     <fields>;
}
-keep class com.wecaresoftware.elfone.dancelib.dance.Music{
     <fields>;
}

-keep class com.wecaresoftware.elfone.robotutils.** {*;}
-dontwarn com.wecaresoftware.elfone.robotutils.**

#-keep class elfone.wecare.com.updateprocedures.** {*;}
#-dontwarn elfone.wecare.com.updateprocedures.**

#-keep class com.wecaresoftware.elfone.basedriver.** {*;}
#-dontwarn com.wecaresoftware.elfone.basedriver.**

-keep class org.apache.commons.net.** {*;}
-dontwarn org.apache.commons.net.**

-keep class org.apache.oro.** {*;}
-dontwarn org.apache.oro.**

-keep class com.wecaresoftware.elfone.share.Head{
     <fields>;
}
-keep class com.wecaresoftware.elfone.share.Res{
     <fields>;
}
-keep class com.wecaresoftware.elfone.utils.Face{
     <fields>;
}
-keep class com.wecaresoftware.elfone.utils.Header{
     <fields>;
}
-keep class com.wecaresoftware.elfone.utils.Params{
     <fields>;
}
-keep class com.wecaresoftware.elfone.utils.Res{
     <fields>;
}
-keep class com.wecaresoftware.elfone.utils.ScoreUtils{
     <fields>;
}
-keep class com.wecaresoftware.elfone.libadvert.AdFromWeb{
     <fields>;
}
-keep class com.wecaresoftware.elfone.libadvert.Advert{
     <fields>;
}
-keep class com.wecaresoftware.elfone.libadvert.AdUtils{
     <fields>;
}

-dontwarn  org.apache.http.**
-keep class org.apache.http.**{ *;}
-dontwarn  com.loopj.android.http.**
-keep class  com.loopj.android.http.**{ *;}
-dontwarn  com.wecaresoftware.elfone.libcloudclient.**
-keep class com.wecaresoftware.elfone.libcloudclient.**{ *;}

######第三方分享sdk######
-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.WebView
-dontwarn com.umeng.**
-dontwarn com.tencent.weibo.sdk.**
-dontwarn com.facebook.**
-keep public class javax.**
-keep public class android.webkit.**
-dontwarn android.support.v4.**
-keep enum com.facebook.**
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keep public interface com.facebook.**
-keep public interface com.tencent.**
-keep public interface com.umeng.socialize.**
-keep public interface com.umeng.socialize.sensor.**
-keep public interface com.umeng.scrshot.**
-keep class com.android.dingtalk.share.ddsharemodule.** { *; }
-keep public class com.umeng.socialize.* {*;}

-keep class com.facebook.**
-keep class com.facebook.** { *; }
-keep class com.umeng.scrshot.**
-keep public class com.tencent.** {*;}
-keep class com.umeng.socialize.sensor.**
-keep class com.umeng.socialize.handler.**
-keep class com.umeng.socialize.handler.*
-keep class com.umeng.weixin.handler.**
-keep class com.umeng.weixin.handler.*
-keep class com.umeng.qq.handler.**
-keep class com.umeng.qq.handler.*
-keep class UMMoreHandler{*;}
-keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.modelmsg.** implements   com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
-keep class im.yixin.sdk.api.YXMessage {*;}
-keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
-keep class com.tencent.mm.sdk.** {
     *;
}
-keep class com.tencent.mm.opensdk.** {
    *;
}
-dontwarn twitter4j.**
-keep class twitter4j.** { *; }

-keep class com.tencent.** {*;}
-dontwarn com.tencent.**
-keep public class com.umeng.com.umeng.soexample.R$*{
      public static final int *;
}
-keep public class com.linkedin.android.mobilesdk.R$*{
      public static final int *;
}

-keep class com.tencent.open.TDialog$*
-keep class com.tencent.open.TDialog$* {*;}
-keep class com.tencent.open.PKDialog
-keep class com.tencent.open.PKDialog {*;}
-keep class com.tencent.open.PKDialog$*
-keep class com.tencent.open.PKDialog$* {*;}

-keep class com.sina.** {*;}
-dontwarn com.sina.**
-keep class  com.alipay.share.sdk.** {
       *;
}
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-keep class com.linkedin.** { *; }
######第三方分享sdk######

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------

##---------------Begin: proguard configuration for Gson ----------
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}

-keepattributes Signature
-keepattributes *Annotation*
-keep public class com.project.mocha_patient.login.SignResponseData { private *; }

##---------------End: proguard configuration for Gson ----------
-keep class com.project.mocha_patient.login.FindForgotInfoActivity$ForgetResponse {*;}
-keep class com.project.mocha_patient.account_setting.ChangePasswordActivity$ChangePasswordResponse {*;}
-keep class com.google.gson.examples.android.model.** { *; }

# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.gson.** { *;}
#这句非常重要，主要是滤掉 com.bgb.scan.model包下的所有.class文件不进行混淆编译
-keep class com.bgb.scan.model.** {*;}
-keepclassmembers enum * { *; }
