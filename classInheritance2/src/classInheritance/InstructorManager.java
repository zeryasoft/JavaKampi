����   : 9  "classInheritance/InstructorManager  classInheritance/UserManager <init> ()V Code
  	   LineNumberTable LocalVariableTable this $LclassInheritance/InstructorManager; getList (LclassInheritance/User;)V	    java/lang/System   out Ljava/io/PrintStream;  java/lang/StringBuilder  Student Selected: 
     (Ljava/lang/String;)V
     classInheritance/User ! " getFirstName ()Ljava/lang/String;
  $ % & append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
  ( ) " toString
 + - , java/io/PrintStream .  println user LclassInheritance/User; 	addCourse 3 Course Added :
  5 6 " 	getCourse 
SourceFile InstructorManager.java !               /     *� �    
                           R     � � Y� +� � #� '� *�    
   
                      / 0   1      R     � � Y2� +� 4� #� '� *�    
   
    	  
                / 0   7    8