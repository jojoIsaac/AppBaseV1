
package com.appsol.apps.applicationbase;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


@SuppressLint("NewApi") public abstract class ApplicationBaseLeftNavDrawer extends AppCompatActivity  {

	
Toolbar toolbar;
	
	//
	private View drawerView;
	 RecyclerView mRecyclerView;                           // Declaring RecyclerView
	 NavDrawerIdapter mAdapter;                        // Declaring Adapter For Recycler View
	    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
	    DrawerLayout Drawer;                                  // Declaring DrawerLayout
	 
	    ActionBarDrawerToggle mDrawerToggle;
		private int y=0;
		String mTitles="My Opinion";

		
		LinearLayout webMediaplayer;
		LinearLayout menu_linearView;
	public boolean showHeader=false;
	private static Integer drawerBackgroundColor=Color.LTGRAY;
	private boolean backfromresource=false;
	
	public void setDrawerBackgroundColor(Integer drawerBackgroundColor) {
		ApplicationBaseLeftNavDrawer.drawerBackgroundColor = drawerBackgroundColor;
	}
	
	public void setDrawerBackgroundColorFromResouce(Integer drawerBackgroundColorResourceID) {
		ApplicationBaseLeftNavDrawer.drawerBackgroundColor = drawerBackgroundColorResourceID;
		backfromresource=true;
	}
	
	public static Integer getDrawerItemBackground()
	{
		return drawerBackgroundColor;
	}
private List<HeaderItem> multipleHeader;
	
	private HeaderItem headerDetails;

	private List<NavMenuItem> menuObjItems;
	
	
	public void setNavMenuItems(List<NavMenuItem> menuLabelItems)
	{
		menuObjItems= menuLabelItems;
	}
	ActionBar actionBar;


	
	
	public boolean setUpHeader(HeaderItem headerItem) // Called to set the header View Content
	{
		headerDetails= headerItem;
		
		if(headerItem.getMenuItems().size()>0)
		{
			menuObjItems = headerItem.getMenuItems();
		    showHeader=true;
		    setContentView(R.layout.activity_library_base_celsoft);
		    return true;
		}
		else
		{
			return false;
		}
	}
	public boolean setUpHeaders(List<HeaderItem> headerItems)  // Called to set the list of headers View Content
	{
		if(headerItems.size()>0&&headerItems.get(0).getMenuItems().size()>0)
		{
			menuObjItems = headerItems.get(0).getMenuItems();
		    multipleHeader= headerItems;
		    showHeader=true;
		    setContentView(R.layout.activity_library_base_celsoft);
		    return true;
		}
		else
		{
			return false;
		}
	}
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title)
	{
		
	      
		 if(multipleHeader.size()>0  && headerDetails==null )
		 {
			 return false;
		 }
		 else
		 {
			 setupUI(savedInstanceState, baseFragment);
		 }
		 
	
			
			return false;
	        
	}
	
	
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(HeaderItem navMenuModelItem,final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title)
	{
		 
	      
		 if(setUpHeader(navMenuModelItem) )
		 {
			 setupUI(savedInstanceState, baseFragment);
			 return true;
		 }
		 else
		 {
			return false;
		 }
		 
	
			
			
	}
	
	
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(HeaderItem navMenuModelItem,List<NavMenuItem> menuItems,final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title)
	{
		 
	      navMenuModelItem.setMenuItem(menuItems);
		 if(setUpHeader(navMenuModelItem) )
		 {
			 setupUI(savedInstanceState, baseFragment);
			 return true;
		 }
		 else
		 {
			return false;
		 }
		 
	
			
			
	}
	
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(List<HeaderItem> headerList,List<NavMenuItem> menuItems,final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title)
	{
		 
		
		 showHeader=true;
		    setContentView(R.layout.activity_library_base_celsoft);
	    multipleHeader= headerList;
	    menuObjItems= menuItems;
	    setupUI(savedInstanceState, baseFragment);
			 return true;
		 
	
			
			
	}
	
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(List<HeaderItem> headerItems,final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title)
	{
		
	      
		 if(setUpHeaders(headerItems))
		 {
			 setupUI(savedInstanceState, baseFragment);
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	
			
			
	        
	}
	
	
	@SuppressLint("NewApi") 
	public boolean buildApplicationBase(List<NavMenuItem> menuObjItems,final Context context,Bundle savedInstanceState,Fragment baseFragment,final String title,boolean noHeader)
	{
		 if(!showHeader)
	        {
			 setContentView(R.layout.activity_library_base_celsoft_nohead);
	        }
		 else
		 {
			 setContentView(R.layout.activity_library_base_celsoft);
		 }
	      
		   this.menuObjItems= menuObjItems;
		   
		   
		   setupUI(savedInstanceState, baseFragment);
			
			return false;
	        
	}
	// This method takes charge of setting up the Application layout and its components
	private void setupUI(Bundle savedInstanceState,Fragment baseFragment)
	{  
		
		
		mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViews); // Assigning the RecyclerView Object to the xml View
        
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
 
        if(!backfromresource)
         mRecyclerView.setBackgroundColor(drawerBackgroundColor);
        else
         mRecyclerView.setBackgroundResource(drawerBackgroundColor);
        
        
        if(showHeader)
        {
        	if(multipleHeader!=null&&multipleHeader.size()>0)
        	mAdapter = new NavDrawerIdapter(menuObjItems,multipleHeader,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        	else
        	{
        		mAdapter = new NavDrawerIdapter(menuObjItems,headerDetails,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
	        	
        	}
        }
           else
        	 mAdapter = new NavDrawerIdapter(menuObjItems,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
         
        	// And passing the titles,icons,header view name, header view email,
                                                                         // and header view profile picture
 
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
 
        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
 
        mRecyclerView.setLayoutManager(mLayoutManager);   
       
        // Setting the layout Manager
 
 
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){
 
        

			@SuppressLint("NewApi") public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitles);
				drawerView=view;
				y=0;
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			@SuppressLint("NewApi") public void onDrawerOpened(View drawerViews) {
			getSupportActionBar().setTitle(mTitles);
				drawerView=drawerViews;
				y=-1;
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
		
			}
 
 
 
    }; // Drawer Toggle Object Made
        
    
    Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        Drawer.post(new Runnable() {
            @Override
            public void run() {
                // To display hamburger icon in toolbar
            	mDrawerToggle.syncState(); 
            	//Toast.makeText(context, title, Toast.LENGTH_LONG).show();
            }
        });
        
                      // Finally we set the drawer toggle sync State
 
        
        
        NavItemClick();
       
        
        if (savedInstanceState == null) {
			
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.frame_container, baseFragment).commit();
			// changeFragment(1,0);
		}
		
		
        //getActionBar().setDisplayHomeAsUpEnabled(true);
		
        setToolbar();
	}
	
   
    @Override
  	public void onConfigurationChanged(Configuration newConfig) {
  		super.onConfigurationChanged(newConfig);
  		// Pass any configuration change to the drawer toggls
  		mDrawerToggle.onConfigurationChanged(newConfig);
  	}
    
    
  //this function handles the Navigation Drawer item click
  	void NavItemClick()
  	{
  		 //Handling the drawer Menu Item Clicks
      	final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
      		 
              @Override public boolean onSingleTapUp(MotionEvent e) {
                  return true;
              }

          });
          
          mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
              @Override
              public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                  View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                  if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                     
                      int index= recyclerView.getChildPosition(child);
                      //Toast.makeText(ApplicationBaseLeftNavDrawer.this, index+"", Toast.LENGTH_LONG).show();
                      NavMenuItem navItem = null;
					try {
						if(index>=0)
						navItem = mAdapter.getNavMenuItem(index);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                      
                      if(navItem!=null && !navItem.isSectionDivider())
                      {
                    	  Drawer.closeDrawers();
                        	displayView(navItem);
                        	//Toast.makeText(ApplicationBaseLeftNavDrawer.this,index+"",Toast.LENGTH_SHORT).show();
                            
                      }
                    
                      
                      return true;

                  }

                  return false;
              }

              @Override
              public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

              }

  			@Override
  			public void onRequestDisallowInterceptTouchEvent(boolean arg0) {
  				// TODO Auto-generated method stub
  				
  			}
          });
  	}

	public abstract void displayView(NavMenuItem menuItem) ;
	 void manipulateDrawer()
		{
			if(y==0)
			{
				  Drawer.openDrawer(Gravity.LEFT);
			 y=-1;
			}
			else 
			{
				  Drawer.closeDrawer(Gravity.LEFT);
				y=0;
			}
			
		}
	public void setToolbar() {
		 toolbar= (Toolbar) findViewById(R.id.toolbar);
		 
	        
	    if (toolbar != null) {
	    	setSupportActionBar(toolbar);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	               Drawer.openDrawer(Gravity.LEFT);
	            }
	        });
	    }
	}
	public void setToolBarBackgroundDrawerble(Drawable toolBarDrawable) throws Exception
	{
		 toolbar= (Toolbar) findViewById(R.id.toolbar);
		 
	        
		 if (toolbar != null) {
		    	toolbar.setBackground(toolBarDrawable);
		    }
	}
	
	public void setToolBarColor(Integer toolBarColor) throws Exception
	{
		 toolbar= (Toolbar) findViewById(R.id.toolbar);
		 
	        
		 if (toolbar != null) {
		    	toolbar.setBackgroundColor(toolBarColor);
		    }
	}
	public void setToolBarColorfromResources(Integer toolBarColor) throws Exception
	{
		 toolbar= (Toolbar) findViewById(R.id.toolbar);
		 
	        
		    if (toolbar != null) {
		    	toolbar.setBackgroundResource(toolBarColor);
		    }
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

	    if (keyCode == KeyEvent.KEYCODE_MENU) {

	       //View drawerView = findViewById(R.id.navigation_drawer); // child drawer view

	        if (!Drawer.isDrawerOpen(drawerView)) {
	        	Drawer.openDrawer(mRecyclerView);
	        } else if (Drawer.isDrawerOpen(drawerView)) {
	        	Drawer.closeDrawer(mRecyclerView);
	        }
	        Toast.makeText(this, "Menu Clicked", Toast.LENGTH_LONG).show();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	public void setUpHeader(String userName,String email,String imageLocation,String backImageLocation)
	{
		
	}
	
	
	public void updateMenuItemAt(Integer index)
	{
		if(index>-1)
		{
			if(showHeader)
			mAdapter.notifyItemChanged(index+1);
			else
				mAdapter.notifyItemChanged(index);
		}
		  
	}
	
	public void removeMenuItemAt(Integer index)
	{
		if(index>-1)
		{
			if(showHeader)
			mAdapter.notifyItemRemoved(index+1);
			else
				mAdapter.notifyItemRemoved(index);
		}
		  
	}
	
	public void changeMenuItemAt(Integer index) {
		// TODO Auto-generated method stub
		updateMenuItemAt(index);
	}
}
