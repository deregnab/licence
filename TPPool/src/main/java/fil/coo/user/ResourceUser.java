package fil.coo.user;

import fil.coo.Resource.Resource;

public class ResourceUser<R extends Resource> {
	   protected R resource;
	    protected String name;
	    
	    public ResourceUser(String name) {
	    	this.name = name;
		}

	    /**
	     * @return the name of the user
	     */
	    public String getName(){
	    	return this.name;
	    }
	    
	    /**
	     * @return the resource
	     */
		public R getResource() {
	            return resource;
	    }

		/**
		 * set the resource of the user
		 * @param resource to set
		 */
	    public void setResource(R resource) {
	            this.resource = resource;
	    }
	    /**
	     * set the resource of the user to null
	     */
	    public void resetResource() {
	            this.resource = null;
	    }
	}
