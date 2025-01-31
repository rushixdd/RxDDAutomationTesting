package core;

public enum TestContextHolder {
    CONTEXT_HOLDER;
    private final ThreadLocal<TestContext> context = ThreadLocal.withInitial(TestContext::new);

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
