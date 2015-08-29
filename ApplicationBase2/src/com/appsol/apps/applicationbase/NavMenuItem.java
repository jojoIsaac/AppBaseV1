package com.appsol.apps.applicationbase;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.graphics.Color;

import com.joanzapata.android.iconify.Iconify.IconValue;

public class NavMenuItem {
private String title;
private IconValue icon;
private Integer iconColor;
private Integer textColor;
private String iconValue;
private Integer itemID;
private boolean isSectionDivider=false;
private Integer counterValue=0;
private boolean showCounter=false;

public boolean showCounter() {
	return showCounter;
}
public NavMenuItem setShowCounter(boolean showCounter) {
	this.showCounter = showCounter;
	return this;
}

public NavMenuItem setCounterValue(Integer counterValue) {
	this.counterValue = counterValue;
	return this;
}
public Integer getCounterValue() {
	return counterValue;
}

public boolean isSectionDivider() {
	return isSectionDivider;
}
 public NavMenuItem setSectionDivider(boolean isSectionDivider) {
	this.isSectionDivider = isSectionDivider;
	return this;
}



public Integer getItemID() {
	return itemID;
}
public IconValue getIcon() {
	return icon;
}
public Integer getIconColor() {
	return iconColor;
}
public String getIconValue() {
	return iconValue;
}
public String getTitle() {
	return title;
}

public Integer getTextColor() {
	return textColor;
}

public NavMenuItem() {
	// TODO Auto-generated constructor stub
}
public NavMenuItem(Integer itemID,String title) {
	// TODO Auto-generated constructor stub
	this.title= title;
	this.itemID= itemID;
	
}
public NavMenuItem(Integer itemID,String title,boolean isSectionDivider) {
	// TODO Auto-generated constructor stub

	this.title= title;
	this.itemID= itemID;
	this.isSectionDivider = isSectionDivider;
}
public NavMenuItem(Integer itemID,String title,Integer sectionTextColor,boolean isSectionDivider) {
	// TODO Auto-generated constructor stub

	this.title= title;
	this.itemID= itemID;
	this.isSectionDivider = isSectionDivider;
	this.textColor= sectionTextColor;
}
public NavMenuItem(Integer itemID,String title,IconValue icon) {
	// TODO Auto-generated constructor stub
	this.title= title;
	this.icon= icon;
	this.itemID= itemID;
}
public NavMenuItem(Integer itemID,String title,IconValue icon,Integer iconColors,Integer textColors) {
	// TODO Auto-generated constructor stub
	this.title= title;
	this.icon= icon;
	this.textColor= textColors;
	this.iconColor= iconColors;
	this.itemID= itemID;
	
}
//public NavMenuItem(String title,IconValue icon,Color iconColors,Color textColors) {
//	// TODO Auto-generated constructor stub
//	this.title= title;
//	this.icon= icon;
//	this.textColor= textColors;
//	this.iconColor= iconColors;
//	
//}

public NavMenuItem(Integer itemID,String title,IconValue icon,Integer textColors,boolean isfalse) {
	// TODO Auto-generated constructor stub
	this.title= title;
	this.icon= icon;
	this.textColor= textColors;
	this.itemID= itemID;
	
}
public NavMenuItem(Integer itemID,String title,IconValue icon,Integer iconColor) {
	// TODO Auto-generated constructor stub
	this.title= title;
	this.icon= icon;
	this.iconColor= iconColor;
	this.itemID= itemID;
}


public List<NavMenuItem> getMenuPropertiesfromResources
               (String [] title,IconValue[] iconValues,Integer [] iconColors,Integer [] texColors)
               {
	List<NavMenuItem> items =  new ArrayList<NavMenuItem>();
	
	    for (int i = 0; i < title.length; i++) {
	    	if(title[i]!=null&&iconValues[i]!=null  )
	    	{
	    		Integer iconcolors,textColor;
	    		if(iconColors[i]==null && texColors[i]!=null  )
	    		{
	    			iconcolors = iconColors[i];
	    			NavMenuItem menu = new NavMenuItem(i,title[i], iconValues[i], iconColors[i]);
	    			items.add(menu);
	    		}
	    		else if(iconColors[i]!=null && texColors[i]==null  )
	    		{
	    			textColor=  texColors[i];
	    			NavMenuItem menu = new NavMenuItem(i,title[i], iconValues[i], texColors[i],true);
	    			items.add(menu);
	    		}
	    		else
	    		{
	    			NavMenuItem menu = new NavMenuItem(i,title[i], iconValues[i], iconColors[i], texColors[i]);
	    			items.add(menu);
	    		}
	    	}
	    	else
	    	{
	    		items= null;
	    	}
	    		
		}
	
	return items;
               }

}
