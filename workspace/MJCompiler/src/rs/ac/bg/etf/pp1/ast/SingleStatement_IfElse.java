// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class SingleStatement_IfElse extends SingleStatement {

    private Condition Condition;
    private Statement Statement;
    private MayElseStatement MayElseStatement;

    public SingleStatement_IfElse (Condition Condition, Statement Statement, MayElseStatement MayElseStatement) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.MayElseStatement=MayElseStatement;
        if(MayElseStatement!=null) MayElseStatement.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public MayElseStatement getMayElseStatement() {
        return MayElseStatement;
    }

    public void setMayElseStatement(MayElseStatement MayElseStatement) {
        this.MayElseStatement=MayElseStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(MayElseStatement!=null) MayElseStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(MayElseStatement!=null) MayElseStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(MayElseStatement!=null) MayElseStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatement_IfElse(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MayElseStatement!=null)
            buffer.append(MayElseStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatement_IfElse]");
        return buffer.toString();
    }
}
