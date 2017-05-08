package engineRule.rules;

public class Mapping {
	String jc;
	String c;
	String cc;
	String uid;
	String exp;
	String priority;

	
	public Mapping(String jc, String c, String cc, String uid, String exp, String priority) {
		super();
		this.jc = jc;
		this.c = c;
		this.cc = cc;
		this.uid = uid;
		this.exp = exp;
		this.priority = priority;
	}


	public String getJc() {
		return jc;
	}


	public void setJc(String jc) {
		this.jc = jc;
	}


	public String getC() {
		return c;
	}


	public void setC(String c) {
		this.c = c;
	}


	public String getCc() {
		return cc;
	}


	public void setCc(String cc) {
		this.cc = cc;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


}
