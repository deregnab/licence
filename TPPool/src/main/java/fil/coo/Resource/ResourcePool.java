package fil.coo.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



public abstract class ResourcePool <R extends Resource> {

	List<R> availableList=new ArrayList<R>();
	List<R> unavailableList=new ArrayList<R>();
	public ResourcePool(int n){
		for(int i=0; i<n; i++){
			availableList.add(this.createResource());
		}
		
	}
	
	public abstract R createResource();
	
	public R provideResource(){
		if(availableList.isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			R tmp=this.availableList.remove(0);
			return tmp;
		}
	}
	
	public boolean freeResource(R res){
		
		for (int i=0;i<unavailableList.size();i++){
			
			if(unavailableList.get(i)==res){
				return true;
			
			}
				throw new IllegalArgumentException();
		
		}
		return false;
	}
}
