package com.spring.gwt.shared;

public class Config {
	public static final String TEXT_EMPTY = "";
	public static final long LONG_NULL = -1;
	public static final int INT_NULL = -1;
	
	public static final int STATUS_DELETED = -1;
	public static final int STATUS_PRIVATE = 0;
	public static final int STATUS_PUBLIC = 1;
	public static final int STATUS_OPEN = 2;
	public static final int STATUS_TEST = 3;
	public static final int STATUS_EDITED = 4;
	
	public static final int GENDER_UNSET = -1;
	public static final int GENDER_MALE = 0;
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_OTHOR = 2;
	
	public static final int COMMENT_DATA_TYPE_DOCUMENT = 1;
	public static final int COMMENT_DATA_TYPE_IMAGE = 2;
	public static final int COMMENT_DATA_TYPE_VIDEO = 3;
	public static final int COMMENT_DATA_TYPE_OTHER = 4;
	
	public static final int USER_LIKE_TYPE_COMMENT = 0;
	public static final int USER_LIKE_TYPE_MEAL = 1;
	public static final int USER_LIKE_TYPE_OTHER = 2;
	
	public static final int USER_LIKE_STATUS_LIKE = 0;
	public static final int USER_LIKE_STATUS_UNLIKE = 1;

	public static boolean isFileNameImage(String fileName){
		if(fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".png")
			|| fileName.toLowerCase().endsWith(".gif") || fileName.toLowerCase().endsWith(".jpeg")
			|| fileName.toLowerCase().endsWith(".svg")){
			return true;
		}
		return false;
	}
	
	public static boolean isFileNameDocument(String fileName){
		if(fileName.toLowerCase().endsWith(".pdf") || fileName.toLowerCase().endsWith(".docx") || fileName.toLowerCase().endsWith(".doc")
			|| fileName.toLowerCase().endsWith(".xlsx") || fileName.toLowerCase().endsWith(".xls")
			|| fileName.toLowerCase().endsWith(".ppt") || fileName.toLowerCase().endsWith(".pptx") 
			|| fileName.toLowerCase().endsWith(".ppsx")){
			return true;
		}
		return false;
	}
	
	public static boolean isFileNameSound(String fileName){
		if(fileName.toLowerCase().endsWith(".mp3") || fileName.toLowerCase().toLowerCase().contains("wav")){
			return true;
		}
		return false;
	}
	
	public static boolean isFileNameVideo(String fileName){
		fileName.toLowerCase();
		if(fileName.endsWith(".mp4") ){
			return true;
		}
		return false;
	}
}
