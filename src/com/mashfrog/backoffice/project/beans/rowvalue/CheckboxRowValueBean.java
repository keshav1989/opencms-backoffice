package com.mashfrog.backoffice.project.beans.rowvalue;

public class CheckboxRowValueBean extends TitledRowValueBean {

	private static final long serialVersionUID = 5631967478434279954L;

	protected boolean checked;
    protected String value;

    public CheckboxRowValueBean(){
    	this(false, null);
    }

    public CheckboxRowValueBean(boolean checked, String value){
    	super();
    	type = "checkbox";
    	setChecked(checked);
    	setValue(value);
    }

    public boolean getChecked(){
        return checked;
    }

    public String getValue(){
        return value;
    }

    public void setChecked(boolean checked){
    	this.checked = checked;
    }

    public void setValue(String value){
    	this.value = value;
    }

}