package com.appsol.apps.applicationbase;

import java.util.List;
import java.util.Set;

public class HeaderItem {
   private String displayName;
   private String emailAddress;
   private String imagePath;
   private String userHeaderBackgroundImage;
   private Integer userHeaderBackgroundColor;
   private List<NavMenuItem> menuItems;
   
   
   public HeaderItem setMenuItem(List<NavMenuItem> menuItems) {
	this.menuItems = menuItems;
	return this;
}
   public List<NavMenuItem> getMenuItems() {
	return menuItems;
}
   
   public HeaderItem setDisplayName(String displayName) {
	this.displayName = displayName;
	return this;
}
   public String getDisplayName() {
	return displayName;
}
   public HeaderItem setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
	return this;
}
   public String getEmailAddress() {
	return emailAddress;
}
   
   public HeaderItem setImagePath(String imagePath) {
	this.imagePath = imagePath;
	return this;
}
   public String getImagePath() {
	return imagePath;
}
   public HeaderItem setUserHeaderBackgroundColor(Integer userHeaderBackgroundColor) {
	this.userHeaderBackgroundColor = userHeaderBackgroundColor;
	return this;
}
   
   public HeaderItem setUserHeaderBackgroundImage(String userHeaderBackgroundImage) {
	this.userHeaderBackgroundImage = userHeaderBackgroundImage;
	return this;
}
   
   public Integer getUserHeaderBackgroundColor() {
	return userHeaderBackgroundColor;
}
   public String getUserHeaderBackgroundImage() {
	return userHeaderBackgroundImage;
}
   
   public static Exception HeaderNotSet()
   {
	   Exception e= new Exception("Header Not Set");
	return e;
	   
   }
   
   public static class HeaderNotSetException extends Exception
   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Header Not Set";
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	   
   }
   
}
