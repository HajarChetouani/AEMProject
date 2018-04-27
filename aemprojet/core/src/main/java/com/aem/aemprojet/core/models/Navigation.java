package com.aem.aemprojet.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

public class Navigation extends WCMUsePojo{
    private List<Page> items = new ArrayList<Page>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    private Page rootPage;

    private String rootPath;
    @Inject
    private String parentpage;

    // Initializes the navigation
    @Override
    public void activate() throws Exception {
    	rootPath= getProperties().get("parentpage", getCurrentPage().getPath());
       rootPage = 	getPageManager().getPage(rootPath);

        
      Iterator<Page> childPages = rootPage.listChildren(new PageFilter(getRequest()));

	   while (childPages.hasNext()) {
		   Page pageTemp = childPages.next();
		   log.info("childPages:"+pageTemp.getName());	
		   items.add(pageTemp);
			
	   	}

	   
	   	   }

    public String getRootPath() {
		return rootPath;
	}

	// Returns the navigation items
    public List<Page> getItems() {
        return items;
    }
 
    // Returns the navigation root
    public Page getRoot() {
        return rootPage;
    }
}