// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListRec_Arr extends DesignatorListRec {

    private DesignatorListRec DesignatorListRec;
    private Expr Expr;

    public DesignatorListRec_Arr (DesignatorListRec DesignatorListRec, Expr Expr) {
        this.DesignatorListRec=DesignatorListRec;
        if(DesignatorListRec!=null) DesignatorListRec.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorListRec getDesignatorListRec() {
        return DesignatorListRec;
    }

    public void setDesignatorListRec(DesignatorListRec DesignatorListRec) {
        this.DesignatorListRec=DesignatorListRec;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorListRec!=null) DesignatorListRec.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListRec!=null) DesignatorListRec.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListRec!=null) DesignatorListRec.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListRec_Arr(\n");

        if(DesignatorListRec!=null)
            buffer.append(DesignatorListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListRec_Arr]");
        return buffer.toString();
    }
}
