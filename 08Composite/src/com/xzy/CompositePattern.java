package com.xzy;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
public class CompositePattern {
    public static void main(String[] args) {
        // 父类名 对象名 = new 子类名();
        AbstractFile root = new Folder("root");

        AbstractFile folderA = new Folder("folderA");
        AbstractFile folderB = new Folder("folderB");

        AbstractFile fileC = new File("fileC");
        AbstractFile fileD = new File("fileD");
        AbstractFile fileE = new File("fileE");

        root.Add(folderA);
        root.Add(folderB);
        root.Add(fileC);

        folderA.Add(fileD);
        folderA.Add(fileE);

        print(root);
    }

    static void print(AbstractFile file) {
        file.printName();

        List<AbstractFile> childrenList = file.getChildren();
        if (childrenList == null) {
            return;
        }

        for (AbstractFile children : childrenList) {
            print(children);
        }
    }
}


abstract class AbstractFile {
    protected String name;

    public void printName() {
        System.out.println(name);
    }

    public abstract boolean Add(AbstractFile file);

    public abstract boolean Remove(AbstractFile file);

    public abstract List<AbstractFile> getChildren();
}


class Folder extends AbstractFile {
    private List<AbstractFile> childrenList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public boolean Add(AbstractFile file) {
        return childrenList.add(file);
    }

    @Override
    public boolean Remove(AbstractFile file) {
        return childrenList.remove(file);
    }

    @Override
    public List<AbstractFile> getChildren() {
        return childrenList;
    }
}


class File extends AbstractFile {
    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean Add(AbstractFile filei) {
        return false;
    }

    @Override
    public boolean Remove(AbstractFile file) {
        return false;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}