// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class StatementListRec_Yes extends StatementListRec {

    private StatementListRec StatementListRec;
    private Statement Statement;

    public StatementListRec_Yes (StatementListRec StatementListRec, Statement Statement) {
        this.StatementListRec=StatementListRec;
        if(StatementListRec!=null) StatementListRec.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementListRec getStatementListRec() {
        return StatementListRec;
    }

    public void setStatementListRec(StatementListRec StatementListRec) {
        this.StatementListRec=StatementListRec;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementListRec!=null) StatementListRec.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListRec!=null) StatementListRec.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListRec!=null) StatementListRec.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementListRec_Yes(\n");

        if(StatementListRec!=null)
            buffer.append(StatementListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementListRec_Yes]");
        return buffer.toString();
    }
}
