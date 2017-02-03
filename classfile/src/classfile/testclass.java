package classfile;

public class testclass {
	
	private int m;
	
	public int inc(){
		return m+1;
	}
}

/*
C:\Program Files\Java\jdk1.8.0_111\bin>javap -verbose c:\testclass.class
Classfile /c:/testclass.class
  Last modified 2017-2-1; size 373 bytes
  MD5 checksum 18be5bb86c5b86ad5966a599e99296ce
  Compiled from "testclass.java"
public class classfile.testclass
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Class              #2             // classfile/testclass
   #2 = Utf8               classfile/testclass
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               m
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Methodref          #3.#11         // java/lang/Object."<init>":()V
  #11 = NameAndType        #7:#8          // "<init>":()V
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Lclassfile/testclass;
  #16 = Utf8               inc
  #17 = Utf8               ()I
  #18 = Fieldref           #1.#19         // classfile/testclass.m:I
  #19 = NameAndType        #5:#6          // m:I
  #20 = Utf8               SourceFile
  #21 = Utf8               testclass.java
{
  public classfile.testclass();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #10                 // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lclassfile/testclass;

  public int inc();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: getfield      #18                 // Field m:I
         4: iconst_1
         5: iadd
         6: ireturn
      LineNumberTable:
        line 8: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       7     0  this   Lclassfile/testclass;
}
SourceFile: "testclass.java"
*/