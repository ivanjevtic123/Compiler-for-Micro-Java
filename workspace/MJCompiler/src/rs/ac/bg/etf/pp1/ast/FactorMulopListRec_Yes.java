// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class FactorMulopListRec_Yes extends FactorMulopListRec {

    private FactorMulopListRec FactorMulopListRec;
    private MullOp MullOp;
    private Factor Factor;

    public FactorMulopListRec_Yes (FactorMulopListRec FactorMulopListRec, MullOp MullOp, Factor Factor) {
        this.FactorMulopListRec=FactorMulopListRec;
        if(FactorMulopListRec!=null) FactorMulopListRec.setParent(this);
        this.MullOp=MullOp;
        if(MullOp!=null) MullOp.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public FactorMulopListRec getFactorMulopListRec() {
        return FactorMulopListRec;
    }

    public void setFactorMulopListRec(FactorMulopListRec FactorMulopListRec) {
        this.FactorMulopListRec=FactorMulopListRec;
    }

    public MullOp getMullOp() {
        return MullOp;
    }

    public void setMullOp(MullOp MullOp) {
        this.MullOp=MullOp;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorMulopListRec!=null) FactorMulopListRec.accept(visitor);
        if(MullOp!=null) MullOp.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorMulopListRec!=null) FactorMulopListRec.traverseTopDown(visitor);
        if(MullOp!=null) MullOp.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorMulopListRec!=null) FactorMulopListRec.traverseBottomUp(visitor);
        if(MullOp!=null) MullOp.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorMulopListRec_Yes(\n");

        if(FactorMulopListRec!=null)
            buffer.append(FactorMulopListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MullOp!=null)
            buffer.append(MullOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorMulopListRec_Yes]");
        return buffer.toString();
    }
}
