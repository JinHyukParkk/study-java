package com.example.javatest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final long THRESHOLD = 1000L;

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = getStore(context);

        store.put("START_TIME", System.currentTimeMillis());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = getStore(context);
        String testMethodName = context.getRequiredTestMethod().getName();

        long startTime = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - startTime;

        if (duration > THRESHOLD) {
            System.out.printf("Please consider mark method [%s] with Slow Tag.\n", testMethodName);
        }
    }

    private Store getStore(ExtensionContext context) {
        String testClassName = context.getRequiredTestClass().getName();
        String testMethodName = context.getRequiredTestMethod().getName();
        return context.getStore(
                ExtensionContext.Namespace.create(testClassName, testMethodName));
    }
}
