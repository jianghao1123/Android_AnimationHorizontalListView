package com.example.android_animationhorizontallistview;

import org.jh.widget.AnimationHorizontalListView;
import org.jh.widget.AnimationHorizontalListView.Manipulator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			AnimationHorizontalListView listView = (AnimationHorizontalListView) rootView
					.findViewById(android.R.id.list);
			listView.setAdapter(new MyAdapter(getActivity()));
			listView.manipulate(new Manipulator<MyAdapter>() {

				@Override
				public void manipulate(MyAdapter adapter) {
					for (int i = 1; i < 10; i++) {
						adapter.add();
					}
				}
			});
			return rootView;
		}

		class MyAdapter extends BaseAdapter {

			private LayoutInflater mInflater = null;

			private int mCount = 0;

			public MyAdapter(Context context) {
				mInflater = LayoutInflater.from(context);
			}

			public void add() {
				mCount++;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mCount;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView == null) {
					convertView = mInflater.inflate(R.layout.item_layout, null);
				}
				return convertView;
			}
		}

	}

}
