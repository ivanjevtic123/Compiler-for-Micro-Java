// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStat_ActPars extends DesignatorStatement {

    private Designator Designator;
    private MayActPars MayActPars;

    public DesignatorStat_ActPars (Designator Designator, MayActPars MayActPars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.MayActPars=MayActPars;
        if(MayActPars!=null) MayActPars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public MayActPars getMayActPars() {
        return MayActPars;
    }

    public void setMayActPars(MayActPars MayActPars) {
        this.MayActPars=MayActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(MayActPars!=null) MayActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(MayActPars!=null) MayActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(MayActPars!=null) MayActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStat_ActPars(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MayActPars!=null)
            buffer.append(MayActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStat_ActPars]");
        return buffer.toString();
    }
}
