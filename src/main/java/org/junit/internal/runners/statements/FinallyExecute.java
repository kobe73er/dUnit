package org.junit.internal.runners.statements;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class FinallyExecute extends Statement {

    private final Statement next;

    private final List<FrameworkMethod> finallys;

    private final Object target;

    public FinallyExecute(Statement next, List<FrameworkMethod> finallys,
            Object target) {
        super();
        this.next = next;
        this.finallys = finallys;
        this.target = target;
    }

    @Override
    public void evaluate() throws Throwable {
        next.evaluate();
        for (FrameworkMethod before : finallys) {
            before.invokeExplosively(target);
        }

        System.out.println("finally execute statment...");

    }

}
