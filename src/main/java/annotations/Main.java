package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sugamagarwal
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AnnotateMe me = new AnnotateMe();


        for (Method method : me.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Callable.class)) {
                method.setAccessible(true);
               method.invoke(me);
            }
        }
    }



}
