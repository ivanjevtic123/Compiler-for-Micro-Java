package rs.ac.bg.etf.pp1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	
	public int getMainPc(){
		return mainPc;
	}
	
	
	@Override
	public void visit(MethName methName) {
		if(methName.getI1().equalsIgnoreCase("main")) {
			mainPc = Code.pc;
		}
		methName.obj.setAdr(Code.pc);
		Code.put(Code.enter); 
		Code.put(methName.obj.getLevel());
		Code.put(methName.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(SingleStatement_Print singleStatement_Print) {
		if(singleStatement_Print.getMayNumConst() instanceof MayNumConst_Yes) {
			Code.loadConst(((MayNumConst_Yes)singleStatement_Print.getMayNumConst()).getN1());
		}
		else if(singleStatement_Print.getMayNumConst() instanceof MayNumConst_No) {
			Code.loadConst(0);
		}
		
		if(singleStatement_Print.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
		/*
		Code.loadConst(((MayNumConst_Yes)singleStatement_Print.getMayNumConst()).getN1());
		//adr, pomeraj
		Code.put(Code.aload); // m_
		Code.loadConst(5);  //SIRINA ISPISA
		Code.put(Code.print);
		*/
	}
	
	@Override
	public void visit(SingleStatement_Read singleStatement_Read) {
		Obj des = singleStatement_Read.getDesignator().obj;
		if(des.getKind() == Struct.Char) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(des);
	}
	
	@Override
	public void visit(Factor_Num factor_Num ) {
		Code.loadConst(factor_Num.getN1()); 
	}
	
	@Override
	public void visit(Factor_Char factor_Char ) {
		Code.loadConst(factor_Char.getC1()); 
	}
	
	@Override
	public void visit(Factor_Bool factor_Bool) {
		Code.loadConst(factor_Bool.getB1());
	}
	
	@Override
	public void visit(Factor_DesignatorVar factor_DesignatorVar) {
		Code.load(factor_DesignatorVar.getDesignator().obj);
	}
	
	@Override
	public void visit(Factor_NewArray factor_NewArray) {
		Code.put(Code.newarray);
		if(factor_NewArray.getType().struct.equals(Tab.charType)) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}
	
	@Override
	public void visit(DesignatorStat_AssignExpr designatorStat_AssignExpr) {
		Code.store(designatorStat_AssignExpr.getDesignator().obj); 
	}
	
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}
	
	@Override
	public void visit(DesignatorStat_Inc designatorStat_Inc) { //INC
		if(designatorStat_Inc.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(designatorStat_Inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorStat_Inc.getDesignator().obj);
		
	}
	
	@Override
	public void visit(DesignatorStat_Dec designatorStat_Dec) { //DEC
		if(designatorStat_Dec.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(designatorStat_Dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorStat_Dec.getDesignator().obj);
	}
	
	@Override
	public void visit(MayMinus mayMinus) { //nepotrebno
		if(mayMinus instanceof MayMinus_Yes) {
			Obj val = null;
			Code.store(val);
			Code.load(val);
			Code.load(val);
			Code.put(Code.sub);
			Code.load(val);
			Code.put(Code.sub);
			
		}
	}
	
	@Override
	public void visit(Factor factor) {
		if(factor.getMayMinus() instanceof MayMinus_Yes) {
			Code.put(Code.neg);
		}
		/*
		Code.fixup(ifskok);
		Code.put(Code.inc);
		Code.put(1);
		Code.put(1);
		
		Code.put(Code.jmp);
		Code.put2(beginWhilePc - (Code.pc - 1));
		Code.fixup(jumpAdressPc);
		
		Code.put(Code.load_2); //M 5_  
		*/
	}
	
	@Override
	public void visit(AddOp_Plus addOp_Plus) {
		//Code.put(Code.add);
	}
	
	@Override
	public void visit(AddOp_Minus addOp_Minus) {
		/*FactorMulopListRec help = ((AddOpTermListRec_Yes)addOp_Minus.getParent()).getTerm().getFactorMulopListRec();
		FactorSub fctSub = ((FactorMulopListRec_First)help).getFactor().getFactorSub();
		if(fctSub instanceof Factor_Num) {
			Code.loadConst(((Factor_Num)fctSub).getN1());
		}
		Code.put(Code.sub);
		Obj dummy = new Obj(Obj.Var, "dummy", null);
		Code.store(dummy);*/
	}
	
	/*@Override
	public void visit(AddOpTermListRec_Firt addOpTermListRec_Firt) {
		Code.load(addOpTermListRec_Firt.getTerm().getFactorMulopListRec().)
		
		//NE RADI
		Code.loadConst(0);
		Code.put(Code.store_1);  //1_
		Code.load(f.getDes().obj);
		Code.put(Code.dup);
		Code.put(Code.arraylength);
		Code.put(Code.store_3);
		//Code.put(Code.dup);
		Code.loadConst(0);
		Code.put(Code.aload);
		Code.put(Code.store_2); //M
		
		
		Code.load(fct.getDesignator().obj); //addr
		Code.put(Code.load_1);  //i
		Code.put(Code.aload);
		Code.put(Code.store_2); //M//4_
		
	}*/

	@Override
	public void visit(AddOpTermListRec_Yes addOpTermListRec_Yes) {
		if(addOpTermListRec_Yes.getAddOp() instanceof AddOp_Plus) { //ADD
			Code.put(Code.add);
		} else if(addOpTermListRec_Yes.getAddOp() instanceof AddOp_Minus) { //SUB
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(FactorMulopListRec_Yes factorMulopListRec_Yes) {
		if(factorMulopListRec_Yes.getMullOp() instanceof MullOp_Times) { //MUL
			Code.put(Code.mul);
		} else if(factorMulopListRec_Yes.getMullOp() instanceof MullOp_Divide) { //DIV
			Code.put(Code.div);
		} else if(factorMulopListRec_Yes.getMullOp() instanceof MullOp_Percent) { //REM
			Code.put(Code.rem);
		}
	}
	
	
	private Map<String, Integer> stmtLabels = new HashMap<>();
	private Map<String, List<Integer>> gotoAdrs = new HashMap<>();
	
	@Override
	public void visit(Label label) {
		if(label.getParent() instanceof StatementSingleLabel) {
			stmtLabels.put(label.getI1(), Code.pc);
			if(gotoAdrs.containsKey(label.getI1()))
				while(gotoAdrs.get(label.getI1()).size() > 0)
					Code.fixup(gotoAdrs.get(label.getI1()).remove(0));
		}
	}
	
	
	@Override
	public void visit(SingleStatement_GoTo singleStatement_GoTo) {
		if(stmtLabels.containsKey(singleStatement_GoTo.getLabel().getI1())) {
			Code.putJump(stmtLabels.get(singleStatement_GoTo.getLabel().getI1()));
		}
		else {
			Code.putJump(0);  
			int wrongAdr = Code.pc - 2;
			List<Integer> l;
			if(gotoAdrs.containsKey(singleStatement_GoTo.getLabel().getI1())) {
				l = gotoAdrs.get(singleStatement_GoTo.getLabel().getI1());
			}
			else {
				l = new ArrayList<>();
				gotoAdrs.put(singleStatement_GoTo.getLabel().getI1(), l);
				
			}
			l.add(wrongAdr);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
