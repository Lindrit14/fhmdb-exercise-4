package at.ac.fhcampuswien.fhmdb.Factory;

import javafx.util.Callback;

public class MyFactory implements Callback<Class<?>, Object> {
    private Object instance;

    @Override
    public Object call(Class<?> aClass) {
        if (instance == null) {
            try {
                instance = aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}