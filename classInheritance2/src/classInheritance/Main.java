����   : ^  classInheritance/Main  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this LclassInheritance/Main; main ([Ljava/lang/String;)V  classInheritance/User
  	  Ali
     setFirstName (Ljava/lang/String;)V  C#
     	setCourse  Ahmet ! Java # Ayşe % React ' classInheritance/UIManager
 & )  * (LclassInheritance/User;)V , "classInheritance/InstructorManager
 + 	
 & / 0 1 makeProcess !(LclassInheritance/UserManager;)V	 3 5 4 java/lang/System 6 7 out Ljava/io/PrintStream;
  9 : ; getFirstName ()Ljava/lang/String;
 = ? > java/io/PrintStream @  println B classInheritance/StudentManager
 A 	
 A E F * selectCourse
 + H I * 	addCourse args [Ljava/lang/String; user1 LclassInheritance/User; user2 user3 lists [LclassInheritance/User; 
uiManagers LclassInheritance/UIManager; list studentManager !LclassInheritance/StudentManager; instructorManager $LclassInheritance/InstructorManager; StackMapTable K Q 
SourceFile 	Main.java !               /     *� �    
                    	      �  
   �� Y� L+� +� � Y� M,� , � � Y� N-"� -$� � Y+SY,SY-S:� &Y+� (:� +Y� -� .Y:	�66� 	2:� 2� 8� <���� AY� C:-� D� +Y� -:+� G�    
   R      	  
     "  (  0  6  <  N  X  d  y  �  � ! � " � $ � % � (    \ 	   � J K    � L M   � N M  0 } O M  N _ P Q  X U R S  y  T M  �  U V  �  W X  Y   " � r 
 Z    [ &  [    \    ]