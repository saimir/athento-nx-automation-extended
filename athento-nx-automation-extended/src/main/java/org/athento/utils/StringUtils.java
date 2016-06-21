package org.athento.utils;
/**
 * 
 */


import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.athento.nuxeo.operations.AthentoDocumentUpdateOperation;

/**
 * @author athento
 *
 */
public class StringUtils {

	public static final String AND_WITH_SPACES = " AND ";
	public static final String BLANK = " ";
	public static final String COMMA = ",";
	public static final String EMPTY = "";
	public static final String EQUALS_WITH_SPACES = " = ";
	public static final String OR_WITH_SPACES = " OR ";
	public static final String SINGLE_QUOTE = "'";
	public static final String NULL = "null";
	public static final String IS_WITH_SPACES = " is ";
	public static final String PARENTHESIS_LEFT = "(";
	public static final String PARENTHESIS_RIGHT = ")";
	
	public static String getLastField (String path, String delimiter){
		String[] pieces = path.split(delimiter);
		if (pieces.length > 0) {
			return pieces[pieces.length-1];
		}
		return path;
	}
	
	public static String getValue(Serializable value) {
		if (value != null) return value.toString();
		return null;
	}

	public static String getPath(String path) {
		String rtn = "";
		String[] pieces = path.split("/");
		int i = 0;
		while (i < pieces.length-1) {
			rtn += pieces[i];
		}
		return rtn;
	}

    public static boolean isNullOrEmpty (String s) {
    	if (s == null) return true;
    	return s.isEmpty();
    }
    
    public static boolean isIncludedIn (String value, String chain, String delimiter) {
        try {
            String[] pieces = chain.split(delimiter);
            for (int i=0; i < pieces.length; i++) {
                String s = pieces[i].trim();
                if (s.equals(value)) {
                    return true;
                }
            }
        } catch (Throwable t) {
            _log.error("Invalid values for processing: " + t.getMessage());
            _log.error(" value: " + value);
            _log.error(" chain: " + chain);
            _log.error(" delimiter: " + delimiter);
        }
        return false;
    }
    private static final Log _log = LogFactory.getLog(StringUtils.class);
}
