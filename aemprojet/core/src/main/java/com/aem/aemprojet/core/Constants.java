package com.aem.aemprojet.core;

public class Constants {
    //general
    public static final String SLING_FOLDER = "sling:Folder";
    public static final String SLING_RESOURCE_TYPE = "sling:resourceType";
    public static final String SLING_RESOURCE_SUPER_TYPE = "sling:resourceSuperType";
    public static final String FOUNDATION_IMAGE_COMPONENT_RESOURCE_TYPE = "foundation/components/image";
    public static final String CONTENT_ROOT = "/content";
    public static final String APPS_ROOT = "/apps";
    public static final String JCR_CONTENT = "jcr:content";
    public static final String JCR_DESCRIPTION = "jcr:description";
    public static final String JCR_CREATED = "jcr:created";
    public static final String ETC = "etc";
    public static final String PATH_DETAILS_LIST_PATH_PROPERTY_NAME = "path";
    public static final String PATH_DETAILS_LIST_PATHS_PROPERTY_NAME = "paths";
    //Global properties
    public static final String GLOBAL_DIALOG_PATH = "/components/page/htmlbase/global_dialog";
    public static final String GLOBAL_DIALOG_PATH_TOUCH = "/components/page/htmlbase/cq:global_dialog";
    public static final String GLOBAL_DIALOG_PATH_PROPERTY_KEY = "globalDialogPath";
    public static final String GLOBAL_PATH = "/global";
    public static final String GLOBAL_PATH_PROPERTY_KEY = "globalPath";
    public static final String APP_NAME_PROPERTY_KEY = "appName";
    //Renditions & image transform stuff
    public static final String DEFAULT_RENDITION_NAME = "xk_defaultRenditionName";
    public static final String DEFAULT_SECOND_IMAGE_RENDITION_NAME = "xk_defaultSecondImageRenditionName";
    public static final String AVAILABLE_RENDITIONS = "xk_availableRenditions";
    public static final String IMAGE_RENDITION_PROPERTY_NAME = "imageRenditionName";
    public static final String TRANSFORM_SELECTOR = ".transform";
    //Asset spooling
    public static final String DAM_ROOT = CONTENT_ROOT + "/dam";
    public static final String ASSET_SELECTOR = "asset";
    public static final String ASSET_EXTENSION = "spool";
    public static final String ASSET_DATA = "assetData";
    public static final String ASSET_MIME_TYPE = "assetMimeType";
    public static final String RENDITIONS_NODE = "renditions";
    public static final String DEFAULT_RENDITION = "original";
    //Sling models
    public static final String SLING_MODEL_PROPERTIES_KEY = "model";
    public static final String SLING_MODELS_CONFIG_PROPERTY_NAME = "xk_slingModels";
    //Categories
    public static final String SLING_MODELS_CATEGORY = "slingModelData";
    public static final String STRUCTURE_RESOURCES_CATEGORY = "structureResources";


}