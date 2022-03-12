// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class SingleStatement_Print extends SingleStatement {

    private Expr Expr;
    private MayNumConst MayNumConst;

    public SingleStatement_Print (Expr Expr, MayNumConst MayNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MayNumConst=MayNumConst;
        if(MayNumConst!=null) MayNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MayNumConst getMayNumConst() {
        return MayNumConst;
    }

    public void setMayNumConst(MayNumConst MayNumConst) {
        this.MayNumConst=MayNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(MayNumConst!=null) MayNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MayNumConst!=null) MayNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MayNumConst!=null) MayNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatement_Print(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MayNumConst!=null)
            buffer.append(MayNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatement_Print]");
        return buffer.toString();
    }
}
