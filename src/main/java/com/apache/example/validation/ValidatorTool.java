package com.apache.example.validation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;
import org.xml.sax.SAXException;

/**
 * @author emillan
 *
 * <p>The tool to use when validating beans using commons-validator. The 
 * behavior is to provide validation information, validate some bean and
 * obtain the error messages array or null if the validation is passed
 * correctly.</p>
 * 
 */
public class ValidatorTool {
    
    private static final String VALIDATOR_RULES = "validator-rules.xml";
    private static final String MSG_PREFIX = "Validator.";

    private List resourceList;
    private Locale locale;
    private ValidatorResources resources;
    private Validator validator;
    private boolean useDefaults;
    private boolean useActionMessages;
    private String hyphen;
    

    /**
     * 
     * @param useDefaults Indicates if we should use default validator rules, located 
     * in the same package as this class, and named <code>validator-rules.xml</code>.
     */
    public ValidatorTool(boolean useDefaults) {
    	this(null, useDefaults);
    }
    
    
    /**
	 * @param locale the Locale
	 * @param useDefaults indicates if this tool should use the default rule set
	 */
	public ValidatorTool(Locale locale, boolean useDefaults) {
		this.locale = locale;
		this.useDefaults = useDefaults;
		hyphen = "";
	}

	/**
     * @return Returns the locale.
     */
    public Locale getLocale() {
        return locale;
    }
    /**
     * @param locale The locale to set.
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    /**
     * Performs the validation. As no form is specified, the bean class name
     * is used. The message key retrieving works as follows:
     * <ul>
     *   <li>If the validating field has a message, its key is returned</li>
     *   <li>Else, the validator action message is returned</li>
     *   <li>Otherwise, a default message like "validator.(form).(propertyname)"
     *       is returned</li>
     * </ul>
     * @param bean the bean to be validated
     * @return an array of messages or null if the validation gets passed
     */
    public String[] perform(Object bean) {
        String packageName = bean.getClass().getPackage().getName();
        String className = bean.getClass().getName();
        
        String form = null;
        if (packageName.length() > 0) {
            form = className.substring(packageName.length() +1);
        } else {
            form = className;
        }
        
        return perform(bean, form);
    }
    
    /**
     * Performs the validation against the specified validation form
     * @param bean the bean to validate
     * @param form the form containing the ruleset
     * @return an array of messages or null if the validation gets passed
     */
    public String[] perform(Object bean, String form) {
    	
    	return perform(bean, form, 0);
    }
    
    
    /**
     * Performs the validation against the specified validation form
     * @param bean the bean to validate
     * @param form the form containing the ruleset
     * @param page the initial validation page (a zero value means to validate all pages)
     * @return an array of messages or null if the validation gets passed
     */
    public String[] perform(Object bean, String form, int page) {
        
        validator = new Validator(resources, form);
        validator.setParameter(Validator.BEAN_PARAM, bean);
        validator.setOnlyReturnErrors(true);
        validator.setPage(page);
        ValidatorResults results = null;
        try {
            results = validator.validate();
        } catch (ValidatorException e) {
            throw new RuntimeException(e);
        }
        
        return printResults(bean, results, resources, form);
    	
    }
    
    /**
     * Calculates the messages to be returned
     * @param bean the bean validated
     * @param results the validator results
     * @param res the validator resources
     * @param formName the form name
     * @return the messages array
     */
    private String[] printResults(Object bean, ValidatorResults results, 
            ValidatorResources res, String formName) {
        List messages = new ArrayList();

        Form form = resources.getForm(Locale.getDefault(), formName);
        Iterator propertyNames = results.getPropertyNames().iterator();
        
        while (propertyNames.hasNext()) {
            String propertyName = (String) propertyNames.next();
            Field field = form.getField(propertyName);
            ValidatorResult result = results.getValidatorResult(propertyName);
            
            Iterator keys = result.getActions();
            
            while (keys.hasNext()) {
                String actName = (String) keys.next();
                ValidatorAction action = resources.getValidatorAction(actName);
                
                if (!result.isValid(actName)) {
                    //First, the field message
                    String msgKey = null;
                    msgKey = field.getMsg(actName);
                    //Else, the action message
                    if (msgKey == null && isUseActionMessages()) {
                        msgKey = action.getMsg();
                    }
                    //Else the prefix,form name, property name and action name
                    if (msgKey == null) {
                        msgKey = MSG_PREFIX +form.getName() +"."+propertyName +"." +actName;
                    }
                    
                    //Add the message to the list
                    messages.add(msgKey);
                }
            }
        }
        
        if (messages.size() == 0) {
            return null;
        } else {
            return (String[]) messages.toArray(new String[messages.size()]);
        }
    }



    /**
	 * @return the resourceList
	 */
	public List getResourceList() {
		if (resourceList == null) {
			resourceList = new ArrayList();
		}
		return resourceList;
	}
	
	/**
	 * @param resourceList the resourceList to set
	 */
	public void setResourceList(List resourceList) {
		this.resourceList = resourceList;
	}

	/**
	 * Create the ValidatorResources object
	 *
	 */
    public void configure() {

        //Initialize locale
        if (locale == null) {
            locale = Locale.getDefault();
        }
        
    	//Add default validation rules
    	if (useDefaults) {
        	String vrPath = this.getClass().getPackage().getName().replace('.', '/');
        	vrPath = vrPath.concat("/").concat(VALIDATOR_RULES);
	        resourceList.add(vrPath);
        }

        try {
            InputStream[] ins = new InputStream[resourceList.size()];
            Iterator it = resourceList.iterator();
            for (int i = 0; i < resourceList.size(); i++) {
            	String res = (String) it.next();
                ins[i] = toInputStream(res);
            }
            
            resources = new ValidatorResources(ins);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }    	
    	
    }

    /**
     * Obtain an inputstream from the specified resource
     * @param res path to resource
     * @return an InputStream
     */
	private InputStream toInputStream(String res) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return classLoader.getResourceAsStream(res);
	}



	/**
	 * @return the useActionMessages
	 */
	public boolean isUseActionMessages() {
		return useActionMessages;
	}

	/**
	 * @param useActionMessages the useActionMessages to set
	 */
	public void setUseActionMessages(boolean useActionMessages) {
		this.useActionMessages = useActionMessages;
	}



	/**
	 * @return the hyphen
	 */
	public String getHyphen() {
		return hyphen;
	}



	/**
	 * @param hyphen the hyphen to set
	 */
	public void setHyphen(String hyphen) {
		this.hyphen = hyphen;
	}
    
    
    
}
