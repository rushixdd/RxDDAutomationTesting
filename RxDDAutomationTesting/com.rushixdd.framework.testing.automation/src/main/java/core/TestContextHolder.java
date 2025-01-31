package core;

public class TestContextHolder {

    private ThreadLocal<TestContext> context = ThreadLocal.withInitial(TestContext::new);

    public TestContext getContext() {
        return context.get();
    }

    public void setContext(TestContext testContext) {
        context.set(testContext);
    }

    public void removeContext() {
        context.remove();
    }
}
