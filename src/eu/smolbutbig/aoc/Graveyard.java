//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package eu.smolbutbig.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graveyard {
   public Graveyard() {
   }

   public static void d3(boolean partTwo) {
	      Scanner scan = loadFile("d3.txt");
	      LinkedList<String> list = new LinkedList<>();
	 
	      while (scan.hasNextLine()) {
	         String read = scan.nextLine();
	         list.addLast(read);
	      }
	 
	      int[] array = new int[list.get(0).length()];
	 
	      for (int i = 0; i < list.size(); i++) {
	         var string = list.get(i);
	         for (int j = 0; j < string.length(); j++) {
	            if (string.charAt(j) == '1') {
	               array[j] += 1;
	            }
	         }
	      }
	      String gamma = "";
	      String epsilon = "";
	 
	      for (int k = 0; k < array.length; k++) {
	         int count = array[k];
	         if (list.size() - count < count) {
	            gamma += "1";
	            epsilon += "0";
	         } else {
	            gamma += "0";
	            epsilon += "1";
	         }
	      }
	 
	      if (partTwo) {
	         ArrayList<String> oxy = new ArrayList<>();
	         ArrayList<String> co2 = new ArrayList<>();
	 
	         for (int i = 0; i < list.size(); i++) {
	            var string = list.get(i);
	            if (gamma.charAt(0) == string.charAt(0)) {
	               oxy.add(string);
	            } else {
	               co2.add(string);
	            }
	         }
	 
	         for (int j = 1; j < gamma.length(); j++) {
	 
	            int[] result = new int[2];
	            ArrayList<String> toRemove = new ArrayList<>();
	 
	            for (int i = 0; i < oxy.size(); i++) {
	               result[Integer.parseInt(String.valueOf(oxy.get(i).charAt(j)))] += 1;
	            }
	             log("oxy result 0 - " + result[0]);
	             log("oxy result 1 - " + result[1]);
	            if (result[1] >= result[0]) {
	               for (var oxyObj : oxy) {
	                  if (oxyObj.charAt(j) == '0') {
	                     toRemove.add(oxyObj);
	                  }
	               }
	            } else {
	               for (var oxyObj : oxy) {
	                  if (oxyObj.charAt(j) == '1') {
	                      toRemove.add(oxyObj);
	                  }
	               }
	            }
	            if (oxy.size() > 1) {
	                oxy.removeAll(toRemove);
	            }
	 
	            toRemove.clear();
	            result[0] = 0;
	            result[1] = 0;
	 
	            for (int i = 0; i < co2.size(); i++) {
	               result[Integer.parseInt(String.valueOf(co2.get(i).charAt(j)))] += 1;
	            }
	 
	             log("co2 result 0 - " + result[0]);
	             log("co2 result 1 - " + result[1]);
	 
	            if (result[0] > result[1]) {
	               for (var co2Obj : co2) {
	                  if (co2Obj.charAt(j) == '0') {
	                      toRemove.add(co2Obj);
	                  }
	               }
	            } else {
	               for (var co2Obj : co2) {
	                  if (co2Obj.charAt(j) == '1') {
	                      toRemove.add(co2Obj);
	                  }
	               }
	            }
	            if (co2.size() > 1) {
	                co2.removeAll(toRemove);
	            }
	         }
	         log("oxy - " + oxy.size() + " - " + oxy.get(0));
	         log("co2 - " + co2.size() + " - " + co2.get(0));
	 
	         log("p2 - " + Integer.parseInt(co2.get(0), 2) * Integer.parseInt(oxy.get(0), 2));
	      }
	 
	      log("p1 - " + Integer.parseInt(epsilon, 2) * Integer.parseInt(gamma, 2));
	   }
   
   
   public static void d2(boolean partTwo) {
       Scanner scan = loadFile("d2.txt");
       LinkedList<String> list = new LinkedList<>();

       while(scan.hasNextLine()) {
           String read = scan.nextLine();
           list.addLast(read);
       }

       int depth = 0;
       int horizontal = 0;
       int aim = 0;

       for (int i = 0; i < list.size(); i++){
           String[] command = list.get(i).split(" ");
           log(command[0] + ":" + command[1]);
           switch(command[0]){
               case "forward":
                   horizontal += Integer.parseInt(command[1]);
                   if (partTwo){
                       depth += aim * Integer.parseInt(command[1]);
                   }
                   break;
               case "down":
                   if (partTwo){
                       aim += Integer.parseInt(command[1]);
                   } else {
                       depth += Integer.parseInt(command[1]);
                   }
                   break;
               case "up":
                   if (partTwo){
                       aim -= Integer.parseInt(command[1]);
                   } else {
                       depth -= Integer.parseInt(command[1]);
                   }
                   break;
           }
       }
       log(Integer.toString(depth * horizontal));
   }

   public static void d1_1() {
      Scanner scan = loadFile("d1-1.txt");
      LinkedList<Integer> list = new LinkedList<>();

      int increased;
      while(scan.hasNextLine()) {
         increased = scan.nextInt();
         list.addLast(increased);
      }

      increased = 0;

      for(int i = 1; i < list.size(); ++i) {
         int current = (Integer)list.get(i);
         int previous = (Integer)list.get(i - 1);
         if (current > previous) {
            ++increased;
         }
      }

      log("Increased: " + increased);
   }

   public static void d1_2() {
      Scanner scan = loadFile("d1-1.txt");
      LinkedList<Integer> list = new LinkedList<>();

      int increased;
      while(scan.hasNextLine()) {
         increased = scan.nextInt();
         list.addLast(increased);
      }

      increased = 0;

      for(int i = 3; i < list.size(); ++i) {
         int current = list.get(i) + list.get(i - 1) + list.get(i - 2);
         int previous = list.get(i - 1) + list.get(i - 2) + list.get(i - 3);
         if (current > previous) {
            ++increased;
         }
      }

      log("Increased: " + increased);
   }

   public static ArrayList<Integer> parseFileInt(String file) {
      return Main.parseFileInt(file);
   }

   public static ArrayList<String> parseFileString(String file) {
      return Main.parseFileString(file);
   }

   public static void log(String s) {
      System.out.println(s);
   }

   public static void log(int s) {
      System.out.println(s);
   }

   public static Scanner loadFile(String name) {
      return Main.loadFile(name);
   }
}
