package com.insightfullogic.java8.examples.chapter8.lambdabehave.example;

import com.insightfullogic.java8.examples.chapter8.lambdabehave.Description;
import com.insightfullogic.java8.examples.chapter8.lambdabehave.Specification;
import com.insightfullogic.java8.examples.chapter8.lambdabehave.Suite;
import com.insightfullogic.java8.examples.chapter8.lambdabehave.expectations.Expect;

import java.util.Stack;

import static com.insightfullogic.java8.examples.chapter8.lambdabehave.Lets.describe;

// BEGIN StackSpec
public class StackSpec {
    {

        describe("a stack",
                new Suite() {
                    @Override
                    public void specifySuite(Description description) {
                        // 1.
                        description.should("be empty when created",
                                new Specification() {
                                    @Override
                                    public void specifyBehaviour(Expect expect) {
                                        expect.that(new Stack()).isEmpty();
                                    }
                                });

                        // 2.
                        description.should("push new elements onto the top of the stack", new Specification() {
                            @Override
                            public void specifyBehaviour(Expect expect) {
                                Stack<Integer> stack = new Stack<>();
                                stack.push(1);

                                expect.that(stack.get(0)).isEqualTo(1);
                            }
                        });

                        // 3.
                        description.should("pop the last element pushed onto the stack", new Specification() {
                            @Override
                            public void specifyBehaviour(Expect expect) {
                                Stack<Integer> stack = new Stack<>();
                                stack.push(2);
                                stack.push(1);

                                expect.that(stack.pop()).isEqualTo(2);
                            }
                        });

                    }

                }
        );

    }
}
// END StackSpec
