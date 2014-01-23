package org.teamone.domain.Role;

public class RoleName {
    private String roleName;
    
    public String getRoleName(){
        return roleName;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    
    public String toString(){
        return "roleName";
    }
	
	@Override
	public boolean equals(Object obj){
		if(obj == null ||!(obj instanceof RoleName)) return false;
		
		RoleName other = (RoleName) obj;
		if (!other.getRoleName().equals(this.getRoleName())) return false;
		
		return true;
	}
}
