����   : 9  classInheritance/StudentManager  classInheritance/UserManager <init> ()V Code
  	   LineNumberTable LocalVariableTable this !LclassInheritance/StudentManager; getList (LclassInheritance/User;)V	    java/lang/System   out Ljava/io/PrintStream;  java/lang/StringBuilder  Course List: 
     (Ljava/lang/String;)V
     classInheritance/User ! " getFirstName ()Ljava/lang/String;
  $ % & append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
  ( ) " toString
 + - , java/io/PrintStream .  println user LclassInheritance/User; selectCourse 3 Course Selected :
  5 6 " 	getCourse 
SourceFile StudentManager.java !               /     *� �    
                           R     � � Y� +� � #� '� *�    
   
                      / 0   1      R     � � Y2� +� 4� #� '� *�    
   
    	  
                / 0   7    8