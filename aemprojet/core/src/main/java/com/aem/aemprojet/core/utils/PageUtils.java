 package com.aem.aemprojet.core.utils;

import java.util.ArrayList;

import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.scribe.utils.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.LanguageManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

/**
 * @author Fabrice Hong
*/
public class PageUtils {

    public static final int ROOT_PAGE_DEPTH = 3;

    protected static final Logger logger = LoggerFactory.getLogger(PageUtils.class);

    // TODO: change this strategy
    public static Page getLanguageRootPage(LanguageManager languageManager, Page referencePage) {

        Page homepage = languageManager.getLanguageRoot(referencePage.getContentResource());
        if (homepage == null) {
            logger.error(String.format("warning, impossible to get the root page. Failing back to depth strategy " +
                    "(depth=%d)", ROOT_PAGE_DEPTH));
            homepage = referencePage.getAbsoluteParent(ROOT_PAGE_DEPTH);
            if (homepage == null) {
                throw new IllegalStateException(String.format("Impossible to get the languageRoot with the depth " +
                        "strategy failback (depth=%d)", ROOT_PAGE_DEPTH));
            }
        } else if (homepage.getDepth() != ROOT_PAGE_DEPTH) {
            logger.error(String.format("warning, the the rootpage should be at depth (expected depth is %d ",
                    ROOT_PAGE_DEPTH));
        }
        return homepage;
    }

    public static boolean isPageEqualOrChildOf(Page pageToTest, Page parent) {
        if (pageToTest==null) {
            return false;
        }
        if (pageToTest.equals(parent)) {
            return true;
        }

        return isPageEqualOrChildOf(pageToTest.getParent(), parent);
    }

    public static Page getPage(PageManager pageManager, Resource resource, boolean findInHierarchy) {
        Preconditions.checkNotNull(resource, "Trying to get the page from a null resource");
        Page containingPage = pageManager.getContainingPage(resource);
        if (containingPage!=null) {
            return containingPage;
        }
        if (findInHierarchy) {
            Resource parent = resource.getParent();
            Preconditions.checkNotNull(parent, String.format("The parent of '%s' doesn't exists", resource));
            return getPage(pageManager, parent, findInHierarchy);
        }
        return null;
    }
    
    /**
     * Allows the developer to directly get a page property from a page object (Supports null parameters).
     *
     * @param page         AEM page object
     * @param propertyName Property name
     * @return The property value or a blank string if the property is not present.
     */
    public static String getPageProperty(Page page, String propertyName) {
        String pageProperty="jcr:title";
        if (page != null) {
            ValueMap pageProperties = page.getProperties();
            if ((pageProperties != null) && (propertyName != null)) {
                pageProperty = pageProperties.get(propertyName,"jcr:title");
            }
        }
        return pageProperty;

    }
    /**
    *
    * @param page This is a Page
    * @return navigationTitle This is the page title
    */
    public static String getNavigationTitle(Page page) {
    	
        String navigationTitle = null;
        if (null != page) {
            navigationTitle = page.getNavigationTitle();
            if (null == navigationTitle) {
                navigationTitle = page.getPageTitle() == null ? page.getTitle() : page.getPageTitle();
            }
        }
        return navigationTitle;
    }
    /**
     * Get CQ Tags set on the page.
     *
     * @param pageContent This is a map of page content
     * @return keywords This is the comma separated list of CQ tags
     */
    public static String getTags(Map<String, Object> pageContent) {
        String keywords = "";
        if (pageContent.get("cq:tags") != null) {
            ArrayList<?> tags = (ArrayList<?>) pageContent.get("cq:tags");
            if (tags != null) {
                for (Object obj : tags) {
                    String value = obj.toString();
                    if (keywords != null && keywords.length() > 0) {
                        keywords += ", ";
                    }
                    keywords += value;
                }
            }
        }
        return keywords;
    }
                                                          
}
