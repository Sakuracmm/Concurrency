package com.ll.concurrency.jvm.classloader;

public class MyTest15 {

    /**
     *  <p> {@code Class} objects for array classes are not created by class
     *  loaders, but are created automatically as required by the Java runtime.
     *  The class loader for an array class, as returned by {@link
     *  Class#getClassLoader()} is the same as the class loader for its element
     *  type; if the element type is a primitive type, then the array class has no
     *  class loader.
     * @param args
     */
    public static void main(String[] args) {

        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());    //null

        System.out.println("----------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());  //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        System.out.println("-----------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());       //null

        System.out.println("------------");
        Integer i =2;
        System.out.println(i.getClass().getClassLoader());  //null
    }
}
