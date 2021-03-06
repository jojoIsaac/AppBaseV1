package com.appsol.apps.applicationbase;


import java.util.List;

import com.amulyakhare.textdrawable.TextDrawable;
import com.appsol.apps.applicationbase.HeaderItem.HeaderNotSetException;
import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify.IconValue;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NavDrawerIdapter extends
		RecyclerView.Adapter<NavDrawerIdapter.ItemViewHolder> {
	private static final int TYPE_HEADER = 0; // Declaring Variable to
												// Understand which View is
												// being worked on
	// IF the view under inflation and population is header or Item
	private static final int TYPE_ITEM = 1;
	private static final int TYPE_ITEM_SECTION = 2;
	public NavMenuItem getNavMenuItem(Integer position) throws Exception 
	{
		
		
			position= position+showHeader;
		
		if(position==-1)
		{
			return null;
		}
		else
		
		return menuItems.get(position);
	}

	private String name; // String Resource for header View Name
	private String profile; // int Resource for header view profile picture
	private String email; // String Resource for header view email
	private Context context;
	private IconDrawable draws;
	List<NavMenuItem> menuItems;
	public static Integer iconColors;
	private Integer showHeader= -1;
	private String headerBackImage;
	private List<HeaderItem> multipleHeader;
	
	private HeaderItem headerDetails;

	public NavDrawerIdapter(List<NavMenuItem> menuItems,List<HeaderItem> multipleHeader,Context passedContext) { // NavDrawerIdapter Constructor with titles and icons
							// parameter
		// titles, icons, name, email, profile pic are passed from the main
		// activity as we
	    this.menuItems=  menuItems;
		this.multipleHeader= multipleHeader;
	
	               // here we assign those passed values to the values
							// we declared here
		// in adapter
		this.context = passedContext;
		showHeader=-1;
	
	}
	
	public NavDrawerIdapter(HeaderItem drawerContent,Context passedContext,boolean all) { // NavDrawerIdapter Constructor with titles and icons
		// parameter
// titles, icons, name, email, profile pic are passed from the main
// activity as we
this.menuItems=  drawerContent.getMenuItems();
this.headerDetails= drawerContent;

// here we assign those passed values to the values
		// we declared here
// in adapter
this.context = passedContext;
showHeader=-1;

}
	
	
	public NavDrawerIdapter(List<NavMenuItem> menuItems,HeaderItem header,Context passedContext) { // NavDrawerIdapter Constructor with titles and icons
		// parameter
// titles, icons, name, email, profile pic are passed from the main
// activity as we
this.menuItems=  menuItems;
this.headerDetails= header;

// here we assign those passed values to the values
		// we declared here
// in adapter
this.context = passedContext;
showHeader=-1;

}

	
	
	
	public NavDrawerIdapter(List<NavMenuItem> menuItems,Context passedContext) { // NavDrawerIdapter Constructor with titles and icons
							// parameter
		// titles, icons, name, email, profile pic are passed from the main
		// activity as we
	this.menuItems=  menuItems;
	showHeader=0;
		// in adapter
		this.context = passedContext;
	}
	
	@Override
	public NavDrawerIdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {

		if(showHeader<0)
		{
			if (viewType == TYPE_ITEM) {
				View v = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.item_row, parent, false); // Inflating the layout

				ItemViewHolder vhItem = new ItemViewHolder(v, viewType,context); // Creating
																	// ViewHolder
																	// and passing
																	// the object of
																	// type view

				return vhItem; // Returning the created object

				// inflate your layout and pass it to view holder

			} 
			else if (viewType == TYPE_ITEM_SECTION) {

				View v = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.list_item_section, parent, false); // Inflating the layout

				ItemViewHolder vhHeader = new ItemViewHolder(v, viewType,context); // Creating
																	// ViewHolder
																	// and passing
																	// the object of
																	// type view

				return vhHeader; // returning the object created

			}
			else if (viewType == TYPE_HEADER) {

				View v = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.header, parent, false); // Inflating the layout

				ItemViewHolder vhHeader = new ItemViewHolder(v, viewType,context); // Creating
																	// ViewHolder
																	// and passing
																	// the object of
																	// type view

				return vhHeader; // returning the object created

			}
			
			
		}
		else
		{
//			View v = LayoutInflater.from(parent.getContext()).inflate(
//					R.layout.item_row, parent, false); // Inflating the layout
//
//			ItemViewHolder vhItem = new ItemViewHolder(v, viewType,context); // Creating
//																// ViewHolder
//																// and passing
//																// the object of
//																// type view
//
//			return vhItem; // Returning the created object
//
//			// inflate your layout and pass it to view holder
			
			
			if (viewType == TYPE_ITEM) {
				View v = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.item_row, parent, false); // Inflating the layout

				ItemViewHolder vhItem = new ItemViewHolder(v, viewType,context); // Creating
																	// ViewHolder
																	// and passing
																	// the object of
																	// type view

				return vhItem; // Returning the created object

				// inflate your layout and pass it to view holder

			} 
			else if (viewType == TYPE_ITEM_SECTION) {

				View v = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.list_item_section, parent, false); // Inflating the layout

				ItemViewHolder vhHeader = new ItemViewHolder(v, viewType,context); // Creating
																	// ViewHolder
																	// and passing
																	// the object of
																	// type view

				return vhHeader; // returning the object created

			}
		}
		
		
		return null;

	}
	

	// Next we override a method which is called when the item in a row is
	// needed to be displayed, here the int position
	// Tells us item at which position is being constructed to be displayed and
	// the holder id of the holder object tell us
	// which view type is being created 1 for item row
	@Override
	public void onBindViewHolder(NavDrawerIdapter.ItemViewHolder holder, int position) {
		if (holder.Holderid == 1) { // as the list view is going to be called
									// after the header view so we decrement the
			// position by 1 and pass it to the holder while setting the text
			// and image
			
			NavMenuItem menuItem= menuItems.get(position +showHeader);
			
			if(!menuItem.isSectionDivider())
			{
				
				if(menuItem.showCounter() && menuItem.getCounterValue()>0)
				{
					holder.counter.setText("+"+ menuItem.getCounterValue()+"");
					holder.counter.setVisibility(View.VISIBLE);
					Log.e("counter", menuItem.getCounterValue()+"");
				}
				else
				{
					holder.counter.setVisibility(View.GONE);
					Log.e("counters", menuItem.getCounterValue()+"");
				}
				
				holder.sectionLayout.setVisibility(View.GONE);
				holder.imageView.setVisibility(View.VISIBLE);
				holder.textView.setVisibility(View.VISIBLE);
			    String text= menuItem.getTitle();
			    holder.textView.setText(text); // Setting the
																// Text with the
																// array of our
				
			
			// Titles
			IconDrawable draws= null;
					
					if(menuItem.getIconColor()==null && menuItem.getTextColor()==null )
					{
						draws= 	new IconDrawable
						
						(context, menuItem.getIcon())
				          .color(Color.GRAY)
						   .actionBarSize();
						holder.textView.setTextColor(Color.GRAY);
					}
					else if(menuItem.getIconColor()!=null && menuItem.getTextColor()==null )
					{
						draws= 	new IconDrawable
						
						(context, menuItem.getIcon())
				          .color(menuItem.getIconColor())
						   .actionBarSize();
						holder.textView.setTextColor(menuItem.getIconColor());
					}
					else if(menuItem.getIconColor()==null && menuItem.getTextColor()!=null )
					{
						draws= 	new IconDrawable
						
						(context, menuItem.getIcon())
				          .color(menuItem.getTextColor())
						   .actionBarSize();
						holder.textView.setTextColor(menuItem.getTextColor());
					}
					else
					{
						draws= 	new IconDrawable
								
								(context, menuItem.getIcon())
						          .color(menuItem.getIconColor())
								   .actionBarSize();
						holder.textView.setTextColor(menuItem.getTextColor());
					}
			
			
			
			//IconicsDrawable icon=		new IconicsDrawable(context, mIcons[position - 1] ).color(Color.RED);
			
			holder.imageView.setImageDrawable(draws);
		
			Log.d("Items", menuItem.getTitle());
			
			if(showHeader>=0)
			{
				if(position==0)
				{
				
				}
			}
			
			
			}
			
			else
			{
				holder.imageView.setVisibility(View.GONE);
				holder.textView.setVisibility(View.GONE);
				holder.sectionLayout.setVisibility(View.VISIBLE);
				holder.counter.setVisibility(View.GONE);
				holder.list_item_section_text.setText(menuItem.getTitle());
				if(menuItem.getTextColor()!=null)
				holder.list_item_section_text.setTextColor(menuItem.getTextColor());
			}
		} else {

			//holder.profile.setImageResource(profile); // Similarly we set the
														// resources for header
														// view
			
			if(showHeader<0)
			{
				HeaderItem item=null;
				if(multipleHeader!=null&&multipleHeader.size()>0)
				{
					item= multipleHeader.get(0);
					if(item==null)
						try {
							throw  new HeaderItem.HeaderNotSetException();
						} catch (HeaderNotSetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					else
					{
						profile= item.getImagePath();
						name= item.getDisplayName();
						email= item.getEmailAddress();
					}
				}
				else
				{
					if(headerDetails!=null)
					{
						profile= headerDetails.getImagePath();
						name= headerDetails.getDisplayName();
						email= headerDetails.getEmailAddress();
					}
				}
				

				TextDrawable drawable =null;

				if(TextUtils.isEmpty(name))
					drawable = TextDrawable.builder().buildRound(
							"A",
							Color.RED);
					else
					{
						drawable = TextDrawable.builder().buildRound(
								name.substring(0, 1),
								Color.RED);
					}
					
				
				
				draws = new IconDrawable(context, IconValue.fa_user).color(
						Color.GRAY).actionBarSize();
				
				if (!TextUtils.isEmpty(profile)&&!profile.equalsIgnoreCase("null")) {

					
					Picasso.with(context)
					  .load(
							
						 profile)
				      .resize(40,40)
					  .centerCrop()
					  .transform(new CircleTransform())
					  .error(draws)
					 .placeholder(draws)
					 .memoryPolicy(MemoryPolicy.NO_CACHE)
					  .into( holder.profile);
					
					Toast.makeText(context, profile, Toast.LENGTH_LONG).show();
				} else {
					holder.profile.setImageDrawable(drawable);
				}
				if(TextUtils.isEmpty(name))
				{
					holder.Name.setVisibility(View.GONE);
				}
				
				if(TextUtils.isEmpty(email))
				{
					holder.email.setVisibility(View.GONE);
				}
				
				
				holder.Name.setText(name);
				holder.email.setText(email);
			}
			else
			{
				holder.Name.setVisibility(View.GONE);
				holder.email.setVisibility(View.GONE);
			}
			
		}
	}

	// This method returns the number of items present in the list
	@Override
	public int getItemCount() {
		if(showHeader<0)
		return menuItems.size()+1; // the number of items in the list will be
										// +1 the titles including the header
										// view.
		else
		{
			return menuItems.size();
		}
	}

	// Witht the following method we check what type of view is being passed
	@Override
	public int getItemViewType(int position) {
		if (isPositionHeader(position) )
			return TYPE_HEADER;

		return TYPE_ITEM;
	}

	private boolean isPositionHeader(int position) {
		
		return position == 0 && showHeader<0;
	}

	public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		int Holderid;

		TextView textView;
		ImageView imageView;
		ImageView profile;
		TextView Name;
		TextView email,counter;
		TextView list_item_section_text;
		LinearLayout sectionLayout;
		private Context contxt;

		public ItemViewHolder(View arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}

		public ItemViewHolder(View itemView,int ViewType,Context c) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);
            contxt = c;
           itemView.setClickable(true);
          // itemView.setOnClickListener(this);
           // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

           if(ViewType == TYPE_ITEM) {
               textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
               imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
               Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
               sectionLayout=(LinearLayout) itemView.findViewById(R.id.sectionLayout);
               sectionLayout.setClickable(false);
               sectionLayout.setOnClickListener(null);
               sectionLayout.setOnLongClickListener(null);
               sectionLayout.setLongClickable(false);
               list_item_section_text=(TextView) itemView.findViewById(R.id.list_item_section_text);
               list_item_section_text.setClickable(false);
               list_item_section_text.setOnClickListener(null);
               list_item_section_text.setOnLongClickListener(null);
               list_item_section_text.setLongClickable(false);
               counter=(TextView) itemView.findViewById(R.id.counter);
           
           }
           else  if(ViewType == TYPE_ITEM_SECTION) {
               textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
               imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
               Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
           }
           else{


               Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
               email = (TextView) itemView.findViewById(R.id.email);       // Creating Text View object from header.xml for email
               profile = (ImageView) itemView.findViewById(R.id.circleView);// Creating Image view object from header.xml for profile pic
               Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
           
           email.setOnClickListener(this);
           }


           
       }
		@Override
        public void onClick(View v) {

			if(v.getId()== R.id.email)
			{
				if(multipleHeader!=null&&multipleHeader.size()>0)
				{
				 toggleAccount();
				 Toast.makeText(contxt,"The Item Clicked is: ",Toast.LENGTH_SHORT).show();

			        
				}
			}
			
         
 		}

       

	}

	
	
	private OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	public static class CircleTransform implements Transformation {
	    @Override
	    public Bitmap transform(Bitmap source) {
	        int size = Math.min(source.getWidth(), source.getHeight());
	 
	        int x = (source.getWidth() - size) / 2;
	        int y = (source.getHeight() - size) / 2;
	 
	        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
	        if (squaredBitmap != source) {
	            source.recycle();
	        }
	 
	        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
	 
	        Canvas canvas = new Canvas(bitmap);
	        Paint paint = new Paint();
	        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
	        paint.setShader(shader);
	        paint.setAntiAlias(true);
	 
	        float r = size/2f;
	        canvas.drawCircle(r, r, r, paint);
	 
	        squaredBitmap.recycle();
	        return bitmap;
	    }
	 
	    @Override
	    public String key() {
	        return "circle";
	    }
	}
	
	
	private void toggleAccount()
	{
		
		if(multipleHeader!=null&&multipleHeader.size()>0)
		{
			String[] items =  new String[multipleHeader.size()] ;

			    for (int i = 0; i < multipleHeader.size(); i++) {
					items[i]= multipleHeader.get(i).getEmailAddress();
				}
			
	           AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
	           builder.setTitle("Select Account");
	           builder.setItems(items, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int item) {
	                   // Do something with the selection
	                 
	               }
	           })
	           .setCancelable(false)
	           ;

	           AlertDialog alert = builder.create();
	           alert.show();
		}
	       
	}
}
