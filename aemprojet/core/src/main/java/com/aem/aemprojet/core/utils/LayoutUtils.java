package com.aem.aemprojet.core.utils;

	public abstract class LayoutUtils { 
		 
	    public static boolean isValidLayout(String layout) { 
	        if (layout == null) { 
	            return false; 
	        } 
	        if ("nil".equalsIgnoreCase(layout)) { 
	            return false; 
	        } 
	        if ("null".equalsIgnoreCase(layout)) { 
	            return false; 
	        } 
	        if ("none".equalsIgnoreCase(layout)) { 
	            return false; 
	        } 
	        return true; 
	    } 
	}



