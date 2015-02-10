package com.example.screenslide;


import java.util.ArrayList;

import com.example.screenslide.fragment.Fragment1;
import com.example.screenslide.fragment.Fragment2;
import com.example.screenslide.fragment.Fragment3;
import com.example.screenslide.fragment.Fragment4;

import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends Activity {
	
	 /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;
    

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mViewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mFragmentPagerAdapter;
    
    private ActionBar actionBar;
    private ArrayList<Fragment> mFragmentsList;
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Instantiate a ViewPager and a PagerAdapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
        mFragmentPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());

        //FragmentPagerAdapter¶}©l°õ¦æinstantiateItem
        mViewPager.setAdapter(mFragmentPagerAdapter);
        
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				super.onPageSelected(position);
				actionBar.setSelectedNavigationItem(position);
			}
        	
        });
        
        setActionBar();
	}
	
	private void setActionBar() {

		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setHomeButtonEnabled(false);
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};
		actionBar.addTab(actionBar.newTab().setText("Fragment1")
				.setTabListener(tabListener));
		actionBar.addTab(actionBar.newTab().setText("Fragment2")
				.setTabListener(tabListener));
		actionBar.addTab(actionBar.newTab().setText("Fragment3")
				.setTabListener(tabListener));
		actionBar.addTab(actionBar.newTab().setText("Fragment4")
				.setTabListener(tabListener));

	}
	
	 private class ScreenSlidePagerAdapter extends FragmentPagerAdapter
	 {

		public ScreenSlidePagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			mFragmentsList = new ArrayList<Fragment>();
			
			Fragment fragment1 = new Fragment1();
			Fragment fragment2 = new Fragment2();
			Fragment fragment3 = new Fragment3();
			Fragment fragment4 = new Fragment4();
			
			mFragmentsList.add(fragment1);
			mFragmentsList.add(fragment2);
			mFragmentsList.add(fragment3);
			mFragmentsList.add(fragment4);
			
			Bundle args = new Bundle();
			args.putInt("pageNumber", arg0);
			fragment1.setArguments(args);
		    fragment2.setArguments(args);
		    fragment3.setArguments(args);
		    fragment4.setArguments(args);
		      
			return mFragmentsList.get(arg0);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			return super.instantiateItem(container, position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}

		 
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
