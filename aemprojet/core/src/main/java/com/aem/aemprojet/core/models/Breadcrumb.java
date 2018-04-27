package com.aem.aemprojet.core.models;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class Breadcrumb extends WCMUsePojo{
	
	private String pagPath;
	private String pageProperty;
	private List<Page> parentList;
	private Page childrenPage;
	 
	
	@Override
	public void activate() throws Exception {
		
		pagPath = get("thisPage", String.class);
		parentList = getParentsPages(pagPath);
		childrenPage = getChildrenPages(pagPath);
	}
	
	public List<Page> getParentsPages(String path){
		Resource rs = getResourceResolver().getResource(path);
		Page page = rs.adaptTo(Page.class);
		int i=1;
		parentList = new ArrayList<Page>();
		while(page.getAbsoluteParent(i) != null )
		{
			parentList.add(page.getAbsoluteParent(i));
			i++;
		}
		
		return parentList;
	}
	
	public Page getChildrenPages(String path){
		
		Page tempPage;
		Resource rs = getResourceResolver().getResource(path);
		Page page = rs.adaptTo(Page.class);
		Iterator<Page> childrenList = page.listChildren();
		tempPage = childrenList.next();
		
		return tempPage;
	}
	
	public String getPagPath() {
		return pagPath;
	}

	public String getPageProperty() {
		return pageProperty;
	}

	public List<Page> getParentList() {
		return parentList;
	}

	public Page getChildrenPage() {
		return childrenPage;
	}


}
