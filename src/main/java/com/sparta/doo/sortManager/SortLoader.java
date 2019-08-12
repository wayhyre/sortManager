package com.sparta.doo.sortManager;

import com.sparta.doo.sorters.Sorter;

import java.lang.reflect.InvocationTargetException;

public class SortLoader {
    private String name;
    private static final String SRC = "/src/main/java/";

    {
        String classpath = Sorter.class.getName();
        name = classpath.substring(0, classpath.lastIndexOf('.'));
        System.out.println(getFullPathName());
    }

    public String getSortersLocation() {
        return getFullPathName();
    }

    public Sorter getSorter(String sortType) {
        try {
            String sorterName = name + "." + sortType.substring(0, sortType.lastIndexOf('.'));
            Class selectedSorter = Class.forName(sorterName);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFullPathName() {
        String classpathStr = System.getProperty("user.dir");
        return (classpathStr + SRC + name.replace('.', '/'));
    }


}

