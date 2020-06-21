package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;

public class StaffMemberRepository {

	private static List<AbsStaffMember> members=new ArrayList<>();
	
	public StaffMemberRepository(){
		
	}
	
	public List<AbsStaffMember> getAllMembers(){
		return new ArrayList<>(members);
	}
	
	
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	public void removeAllMembers() {
		this.members.removeAll(this.members);
	}
}
