package com.xzy;

import java.util.HashSet;
import java.util.Set;

/**
 * 解释器模式
 * <p>
 * 意图：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 * <p>
 * 适用性：
 *      1. 该文法简单。对于复杂的发文，文法的类层次变得庞大而无法管理。
 *      2. 效率不是一个关键问题。最高效的解释器通常不是通过直接解释语法分析树实现的，而是首先将它们转换成另一种形式。
 */
public class InterpreterPattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.check("A区的开发人员");
        context.check("B区的调试人员");
        context.check("C区的测试人员");

        System.out.println("========分割线=============");

        context.check("D区的程序员");
        context.check("D区的测试员");
        context.check("C区的程序员");
    }
}


class Context {
    private String[] regions = {"A区", "B区", "C区"};
    private String[] persions = {"开发人员", "测试人员", "调试人员"};
    private NonterminalExpression nonterminal;

    public Context() {
        TerminalExpression region = new TerminalExpression(regions);
        TerminalExpression person = new TerminalExpression(persions);
        nonterminal = new NonterminalExpression(region, person);
    }

    public void check(String info) {
        boolean result = nonterminal.Interpret(info);
        if (result) {
            System.out.println("识别成功~");
        } else {
            System.out.println("识别失败~");
        }
    }
}


interface Expression {
    boolean Interpret(String info);
}


class NonterminalExpression implements Expression {
    private TerminalExpression region;
    private TerminalExpression person;

    public NonterminalExpression(TerminalExpression region, TerminalExpression person) {
        this.region = region;
        this.person = person;
    }

    @Override
    public boolean Interpret(String info) {
        String[] str = info.split("的");
        // B区鹅调试人员 --> str = {"B区","调试人员"};
        return region.Interpret(str[0]) && person.Interpret(str[1]);
    }
}


class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        for (String str : data) {
            set.add(str);
        }
    }

    @Override
    public boolean Interpret(String info) {
        return set.contains(info);
    }
}
