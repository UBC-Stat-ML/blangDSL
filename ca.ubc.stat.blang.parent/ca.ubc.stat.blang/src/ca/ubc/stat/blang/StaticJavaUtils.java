package ca.ubc.stat.blang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import blang.core.ModelBuilder;

public class StaticJavaUtils
{
  public static void callRunner(Class<? extends ModelBuilder> modelBuilderClass, String [] args) throws 
      ClassNotFoundException, 
      NoSuchMethodException, 
      SecurityException, 
      IllegalAccessException, 
      IllegalArgumentException, 
      InvocationTargetException {
    Class<?> runnerClass = Class.forName("blang.runtime.Runner");
    Method mainMethod = runnerClass.getMethod("main", String[].class);
    String [] modifiedArgs = new String[args.length + 2];
    for (int i = 0; i < args.length; i++) {
      modifiedArgs[i] = args[i];
    }
    modifiedArgs[args.length] = "--model";
    modifiedArgs[args.length + 1] = modelBuilderClass.getName();
    mainMethod.invoke(null, modifiedArgs);
  }
  
  public static Class<?> STRING_ARRAY = String[].class;
}
