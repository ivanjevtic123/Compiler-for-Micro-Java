// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class ActPars_Comma extends ActPars {

    private ActPars ActPars;
    private ActPar ActPar;

    public ActPars_Comma (ActPars ActPars, ActPar ActPar) {
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
        this.ActPar=ActPar;
        if(ActPar!=null) ActPar.setParent(this);
    }

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
    }

    public ActPar getActPar() {
        return ActPar;
    }

    public void setActPar(ActPar ActPar) {
        this.ActPar=ActPar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActPars!=null) ActPars.accept(visitor);
        if(ActPar!=null) ActPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
        if(ActPar!=null) ActPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        if(ActPar!=null) ActPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars_Comma(\n");

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPar!=null)
            buffer.append(ActPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars_Comma]");
        return buffer.toString();
    }
}
