package com.aem.aemprojet.core.utils;


import java.util.HashSet;
import java.util.Set;

import org.apache.felix.scr.annotations.Component;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.cm.ConfigurationException;

import com.day.cq.commons.Externalizer;
import com.day.cq.wcm.api.AuthoringUIMode;
import com.day.cq.wcm.api.WCMMode;

import aQute.bnd.annotation.ProviderType;


@ProviderType
@Component(immediate = true)
@SuppressWarnings("squid:S1118")
public final class ModeUtil {

    private static boolean isAuthor = false;

    private static boolean isPublish = false;

    private static Set<String> runmodes = new HashSet<String>();

    /**
     * Is AEM runmode author.
     * 
     * @return true if runmode author is present
     */
    public static boolean isAuthor() {
        return isAuthor;
    }

    /**
     * Is AEM runmode publish.
     * 
     * @return true if runmode publish is present
     */
    public static boolean isPublish() {
        return isPublish;
    }

    /**
     * Helper method to check for given runmode.
     * 
     * @param mode
     *            the mode to check
     * @return true if the specified mode is present
     */
    public static boolean isRunmode(String mode) {
        return runmodes.contains(mode);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#ANALYTICS}
     * 
     * @param request
     *            request to check
     * @return true if the request is in analytics mode
     */
    public static boolean isAnalytics(SlingHttpServletRequest request) {
        return WCMMode.ANALYTICS == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#DESIGN}
     * 
     * @param request
     *            request to check
     * @return true if the request is in design mode
     */
    public static boolean isDesign(SlingHttpServletRequest request) {
        return WCMMode.DESIGN == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#DISABLED}
     * 
     * @param request
     *            request to check
     * @return true if the request is in disabled mode
     */
    public static boolean isDisabled(SlingHttpServletRequest request) {
        return WCMMode.DISABLED == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#EDIT}
     * 
     * @param request
     *            request to check
     * @return true if the request is in edit mode
     */
    public static boolean isEdit(SlingHttpServletRequest request) {
        return WCMMode.EDIT == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#PREVIEW}
     * 
     * @param request
     *            request to check
     * @return true if the request is in preview mode
     */
    public static boolean isPreview(SlingHttpServletRequest request) {
        return WCMMode.PREVIEW == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in mode {@link WCMMode#READ_ONLY}
     * 
     * @param request
     *            request to check
     * @return true if the request is in read-only mode
     */
    public static boolean isReadOnly(SlingHttpServletRequest request) {
        return WCMMode.READ_ONLY == WCMMode.fromRequest(request);
    }

    /**
     * Checks if the request is in {@link AuthoringUIMode#CLASSIC}
     * 
     * @param request
     *            request to check
     * @return true if the request is in Classic authoring mode
     */
    public static boolean isClassic(SlingHttpServletRequest request) {
        return AuthoringUIMode.CLASSIC == AuthoringUIMode.fromRequest(request);
    }

    /**
     * Checks if the request is in {@link AuthoringUIMode#TOUCH}
     * 
     * @param request
     *            request to check
     * @return true if the request is in Touch authoring mode
     */
    public static boolean isTouch(SlingHttpServletRequest request) {
        return AuthoringUIMode.TOUCH == AuthoringUIMode.fromRequest(request);
    }

    public static synchronized void configure(SlingSettingsService slingSettings) throws ConfigurationException {

        runmodes = slingSettings.getRunModes();
        isAuthor = runmodes.contains(Externalizer.AUTHOR);
        isPublish = runmodes.contains(Externalizer.PUBLISH);
        if (isAuthor && isPublish) {
            throw new ConfigurationException(null,
                    "Either 'author' or 'publish' run modes may be specified, not both.");
        }
    }

}