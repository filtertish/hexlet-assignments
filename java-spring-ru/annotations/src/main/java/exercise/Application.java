package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var methodName = method.getName();
                var returnType = String.valueOf(method.getReturnType()).split("\\.");
                System.out.printf("Method %s returns a value of type %s%n", methodName, returnType[returnType.length - 1]);
            }
        }
        // END
    }
}
