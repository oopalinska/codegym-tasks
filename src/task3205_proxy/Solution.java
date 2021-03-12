package task3205_proxy;

/*
Creating a proxy object

This is a basic example of implementing a proxy pattern.
In the "Task conditions" file I added my step-by-step instruction how to do it.
*/

import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* Expected output:
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethodsImpl obj = new SomeInterfaceWithMethodsImpl();
        ClassLoader objClassLoader = obj.getClass().getClassLoader();
        Class[] interfaces = obj.getClass().getInterfaces();
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(objClassLoader, interfaces, new CustomInvocationHandler(obj));
    }
}

