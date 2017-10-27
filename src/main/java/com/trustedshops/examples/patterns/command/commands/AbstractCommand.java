package com.trustedshops.examples.patterns.command.commands;

import com.trustedshops.examples.patterns.command.io.FileSystemApi;

public abstract class AbstractCommand implements Command {
    private Command successor;
    private Command ancestor;

    public Command getSuccessor() {
        return successor;
    }

    public void setSuccessor(Command successor) {
        this.successor = successor;
        successor.setAncestor(this);
    }

    public Command getAncestor() {
        return ancestor;
    }

    public void setAncestor(Command ancestor) {
        this.ancestor = ancestor;
    }

    @Override
    public void execute(FileSystemApi api) {
        doExecute(api);
        if(hasSuccessor())  {
            getSuccessor().execute(api);
        }
    }

    @Override
    public void undo(FileSystemApi api) {
        doUndo(api);
        if(hasAncestor()) {
            getAncestor().undo(api);
        }
    }

    protected abstract void doExecute(FileSystemApi api);

    protected abstract void doUndo(FileSystemApi api);
}
